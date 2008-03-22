package com.gwtextux.sample.showcase2.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.fileupload.FileItemIterator;
//import org.apache.commons.fileupload.FileItemStream;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.fileupload.util.Streams;
import org.json.JSONObject;

public class UploadSvcImpl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * The following commented code uses Apache Commons Upload
		 */
		/*
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload();

		try{
		// Parse the request
		FileItemIterator iter = upload.getItemIterator(req);
		while (iter.hasNext()) {
		    FileItemStream item = iter.next();
		    String name = item.getFieldName();
		    InputStream stream = item.openStream();
		    if (item.isFormField()) {
		        System.out.println("Form field " + name + " with value "
		            + Streams.asString(stream) + " detected.");
		    } else {
		        System.out.println("File field " + name + " with file name "
		            + item.getName() + " detected.");
		        // Process the input stream here
		        InputStream uploadedStream = item.openStream();
		        // save to file system now...
		        File uploadedFile = new File("c:/temp/image.jpg");
		        FileOutputStream fos = new FileOutputStream(uploadedFile);
		        byte[] myarray = new byte[500];
		        int i = 0;
		        while((i = uploadedStream.read(myarray))!=-1){
		        	fos.write(myarray, 0, i);	        	
		        }
		        fos.flush();
		        fos.close();
		        uploadedStream.close();
		    }
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		*/


		JSONObject response = null;
		try {
			response = new JSONObject();
			response.put("success", true);
			response.put("error", "uploaded successfully");
			response.put("code", "232");
		} catch (Exception e) {

		}

		Writer w = new OutputStreamWriter(resp.getOutputStream());
		w.write(response.toString());
		System.out.println(response.toString());
		w.close();
		resp.setStatus(HttpServletResponse.SC_OK);
	}

}
