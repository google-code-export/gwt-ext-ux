package com.gwtextux.sample.showcase2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileTreeSvcImpl extends HttpServlet {

	private HashMap directories = new HashMap();
	private HashMap files = new HashMap();
	
	public void init(ServletConfig config) throws ServletException{
		initTree();
	}
	
	public void initTree(){
		directories.clear();
		files.clear();
		
		directories.put("root", new String[]{"images"});
		directories.put("root/images", new String[]{"silk", "flags"});
		
		files.put("root", new String[]{"test.txt"});
		files.put("root/images", new String[]{"captcha.jpg"});
		files.put("root/images/silk", new String[]{"database_add.gif", "database_delete.gif"});
		files.put("root/images/flags", new String[]{"au.gif","br.gif","ca.gif","ch.gif"});
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String response = null;
		String resetTree = req.getParameter("reset");
		
		if(resetTree != null){
			initTree();
			resp.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		if(req.getContentType().indexOf("multipart") != -1){
			// file upload
			response = doFileUpload(req);

		}
		else{
			String cmd = req.getParameter("cmd");
			String path = req.getParameter("path");
			
			if(cmd == null && path != null){
				cmd = "get";
			}else if(cmd == null){
				try {
					JSONObject jo = new JSONObject();
					jo.put("success", false);
					jo.put("error", "unknown action");
					response = jo.toString();
				} catch (Exception e) {
				}
			}
			
			if(cmd == null){
				try {
					JSONObject jo = new JSONObject();
					jo.put("success", false);
					jo.put("error", "unknown command");
					response = jo.toString();
				} catch (Exception e) {
				}
			}else{
				if(cmd.equals("get")){
					response = doGetCmd(path);
				}else if(cmd.equals("rename")){
					String newname = req.getParameter("newname");
					String oldname = req.getParameter("oldname");
					response = doRenameCmd(newname, oldname);
				}else if(cmd.equals("newdir")){
					String newdir = req.getParameter("dir");
					response = doNewDirCmd(newdir);
				}else if(cmd.equals("delete")){
					String file = req.getParameter("file");
					response = doDeleteCmd(file);
				}				
			}
		}
			
		Enumeration en = req.getParameterNames();
		while (en.hasMoreElements()) {
			String elem = (String) en.nextElement();
			System.out.print("name = " + elem);
			System.out.println("; value = " + req.getParameterValues(elem)[0]);
		}
		

		Writer w = new OutputStreamWriter(resp.getOutputStream());
		w.write(response);
		System.out.println(response.toString());
		w.close();
		resp.setStatus(HttpServletResponse.SC_OK);
	}
	
	private String doFileUpload(HttpServletRequest req){
		String path = null;
		String cmd = null;
		Vector filesV = new Vector();
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload();

		// Parse the request
		FileItemIterator iter;
		try {
			iter = upload.getItemIterator(req);
			while (iter.hasNext()) {
			    FileItemStream item = iter.next();
			    String name = item.getFieldName();
			    InputStream stream = item.openStream();
			    if (item.isFormField()) {
			    	if(name.equals("path")){
			    		path = Streams.asString(stream);
			    	}
			    	if(name.equals("cmd")){
			    		cmd = Streams.asString(stream);
			    	}
			    } else {
			    	String filename = item.getName();
			    	int slash = filename.lastIndexOf('/');
			    	
			    	if(slash == -1) slash = filename.lastIndexOf('\\');	    	
			    	filesV.add(filename.substring(slash+1));
			    }
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String retval = "{\"success\":false,\"errors\":{\"filename\":\"File upload error.\"}}";
		if(cmd.equals("upload")){
			String fileList[] = (String[])files.get(path);
			if(fileList == null)
				fileList = new String[0];
			if(filesV.size() > 0){
				String newList[] = new String[fileList.length + filesV.size()];
				filesV.copyInto(newList);
				for (int i = 0; i < fileList.length; i++) {
					newList[filesV.size() + i] = fileList[i];
				}
				files.remove(path);
				files.put(path, newList);
			}
			retval = "{\"success\":true}";
		}
		return retval;
	}
	
	private String doDeleteCmd(String file){
		String retval = "{\"success\":false,\"error\":\"Cannot delete file/directory\"}";
		int lastSlash = file.lastIndexOf('/');
		
		if(lastSlash != -1){
			String path = file.substring(0, lastSlash);
			String toDelete = file.substring(lastSlash + 1);
			
			if(files.containsKey(path)){
				String allFiles[] = (String[])files.get(path);
				if(allFiles.length > 0) {
					String newDirFiles[] = new String[allFiles.length - 1];
					int j = 0;
					boolean found = false;
					for (int i = 0; i < allFiles.length; i++) {
						if(allFiles[i].equals(toDelete)){
							found = true; 
						}else{
							if(newDirFiles.length > j)
								newDirFiles[j++] = allFiles[i];
							else
								break;
						}
					}
					
					if(found){
						files.put(path, newDirFiles);
						return "{\"success\":true}";
					}					
				}
			}
			
			if(directories.containsKey(path)){
				Iterator iter = directories.keySet().iterator();
				HashMap newDir = new HashMap();
				while (iter.hasNext()) {
					String curDir = (String) iter.next();
					String subDirs[] = (String[])directories.get(curDir);
					
					if(curDir.equals(path)){
						String newSubDirs[] = new String[subDirs.length-1];
						int j = 0;
						
						for (int i = 0; i < subDirs.length; i++) {
							if(!subDirs[i].equals(toDelete)){
								newSubDirs[j++] = subDirs[i];
							}
						}
						newDir.put(curDir, newSubDirs);
					}else if (curDir.startsWith(file)){
						// to remove it...
					}else{
						newDir.put(curDir, subDirs);
					}
				}
				directories = newDir;
				
				iter = files.keySet().iterator();
				HashMap newFiles = new HashMap();
				while (iter.hasNext()) {
					String curDir = (String) iter.next();
					String dirFiles[] = (String[])files.get(curDir);
					
					if(!curDir.startsWith(file)){
						newFiles.put(curDir, dirFiles);
					}
				}
				files = newFiles;
			}
			retval = "{\"success\":true}";
		}
		
		return retval;
	}
	
	private String doNewDirCmd(String newdir){
		String retval = "{\"success\":false,\"error\":\"Cannot create directory\"}";
		int lastSlash = newdir.lastIndexOf('/');
		
		if(lastSlash != -1){
			String path = newdir.substring(0, lastSlash);
			String newDirName = newdir.substring(lastSlash + 1);
			
			if(directories.containsKey(path)){
				String subdirs[] = (String[])directories.get(path);
				String newsubdirs[] = new String[subdirs.length + 1];
				
				int i = 0;
				for (i = 0; i < subdirs.length; i++) {
					newsubdirs[i] = subdirs[i];
				}
				newsubdirs[i] = newDirName;
				directories.put(path, newsubdirs);
			}else{
				directories.put(path, new String[]{newDirName});
			}
			retval = "{\"success\":true}";
		}
		
		return retval;
	}
	
	private String doRenameCmd(String newname, String oldname){
		String retval = null;
		
		int lastSlash = newname.lastIndexOf('/');
		if(lastSlash == -1){
			retval = "{\"success\":false,\"error\":\"Cannot rename root\"}";
		}else{
			String path = newname.substring(0, lastSlash);
			if(!oldname.startsWith(path)){
				retval = "{\"success\":false,\"error\":\"path does not match\"}";
			}else{
				String itemNewName = newname.substring(lastSlash+1);
				String itemOldName = oldname.substring(lastSlash+1);
				
				//let's check if it is a file that needs changing...
				if(files.containsKey(path)){
					String listOfFiles[] = (String[]) files.get(path);
					for (int i = 0; i < listOfFiles.length; i++) {
						if(listOfFiles[i].equals(itemOldName)){
							listOfFiles[i] = itemNewName;
							retval = "{\"success\":true}";
							return retval;
						}
					}
				}
				
				//let's check if it is a dir
				if(directories.containsKey(path)){
					HashMap newDirectories = new HashMap();
					Iterator iter = directories.keySet().iterator();
					while (iter.hasNext()) {
						String curDir = (String) iter.next();
						String subDirs[] = (String[])directories.get(curDir);
						
						if(curDir.equals(path)){
							String newSubDirs[] = new String[subDirs.length];
							
							for (int i = 0; i < subDirs.length; i++) {
								if(subDirs[i].equals(itemOldName)){
									newSubDirs[i] = itemNewName;
								}else{
									newSubDirs[i] = subDirs[i];
								}
							}
							newDirectories.put(curDir, newSubDirs);	
						}else if (curDir.startsWith(oldname)){
							String leftPath = curDir.substring(oldname.length());
							
							newDirectories.put(path+"/"+itemNewName+"/"+leftPath, subDirs);
						}else{
							newDirectories.put(curDir, subDirs);
						}
					}
					directories = newDirectories;
						
					// do files now
					HashMap newFiles = new HashMap();
					iter = files.keySet().iterator();
					while (iter.hasNext()) {
						String curDir = (String) iter.next();
						String dirFiles[] = (String[])files.get(curDir);
						
						if(curDir.equals(oldname)){
							newFiles.put(path+"/"+itemNewName, dirFiles);	
						}else if (curDir.startsWith(oldname)){
							String leftPath = curDir.substring(oldname.length());
							newFiles.put(path+"/"+itemNewName+"/"+leftPath, dirFiles);
						}else{
							newFiles.put(curDir, dirFiles);
						}
					}
					files = newFiles;
					
					retval = "{\"success\":true}";
				}
					
					
				if(retval == null)
					retval = "{\"success\":false,\"error\":\"Cannot rename file this file or directory\"}";
			}
		}
		
		return retval;
	}
	
	private String doGetCmd(String path){
		JSONArray ja = new JSONArray();

		// find all dirs
		if(directories.containsKey(path)){
			String subdirs[] = (String[])directories.get(path);
			
			for (int i = 0; i < subdirs.length; i++) {
				try {
					JSONObject jo = new JSONObject();
					jo.put("text", subdirs[i]);
					jo.put("iconCls", "folder");
					jo.put("disable", false);
					
					if(directories.containsKey(path+"/"+subdirs[i]) ||
						files.containsKey(path+"/"+subdirs[i])){
						jo.put("leaf", false);
					}else{
						jo.put("leaf", true);
					}
					ja.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// find all files
		if(files.containsKey(path)){
			String fls[] = (String[])files.get(path);
			
			for (int i = 0; i < fls.length; i++) {
				try {
					JSONObject jo = new JSONObject();
					jo.put("text", fls[i]);
					if(fls[i].indexOf('.') != -1){
						String ext = fls[i].substring(fls[i].indexOf('.')+1);
						jo.put("iconCls", "file-" + ext);
					}else{
						jo.put("iconCls", "file-txt");
					}
					jo.put("disable", false);
					jo.put("leaf", true);
					jo.put("qtip", "sample qtip for file: " + fls[i]);
					ja.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ja.toString();
	}
}
