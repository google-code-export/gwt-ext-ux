/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.tree;


import com.gwtext.client.core.Connection;
import com.gwtext.client.core.ConnectionConfig;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.RequestParam;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtextux.client.widgets.tree.FileTreePanel;
import com.gwtextux.client.widgets.tree.FileTreePanelListenerAdapter;
import com.gwtextux.client.widgets.tree.FileTreePanelOpenAction;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;


/**
 * Example that illustrates FileTreePanel to handle files with a tree
 * interface.  It needs a corresponding server side to handle requests.
 * @author mlim1972
 */
public class FileTreePanelSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tree/FileTreePanelSample.java.html";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FileTreePanel ftp = new FileTreePanel();
            ftp.setWidth(240);
            ftp.setId("ftp");
            ftp.setHeight(400);
            ftp.setTitle("FileTreePanel");
            ftp.setTopMenu(true);
            ftp.setAutoScroll(true);
            ftp.setRootPath("root");
            ftp.setUrl("FileTreeSvc");
            UrlParam baseParams[]=new UrlParam[2];
            baseParams[0] = new UrlParam("name1", "value1");
            baseParams[1] = new UrlParam("name2", "value2");
            ftp.getLoader().setBaseParams(baseParams);
            ftp.addListener(new FileTreePanelListenerAdapter(){
            	public boolean onBeforeDelete(FileTreePanel fileTreePanel,
            			TreeNode treeNode) {
            		log(EVENT, "onBeforeDelete. treeNode=" + treeNode.getPath("text"));
            		
            		if(treeNode.getPath("text").startsWith("Tree Root/images"))
            			return false;
            		return true;
            	}

            	public boolean onBeforeNewDir(FileTreePanel fileTreePanel,
            			TreeNode treeNode) {
            		log(EVENT, "onBeforeNewDir. treeNode=" + treeNode.getPath("text"));
            		if(treeNode.getPath("text").startsWith("Tree Root/images"))
            			return false;
            		return true;
            	}

            	public boolean onBeforeOpen(FileTreePanel fileTreePanel, String filename,
            			String url, String mode) {
            		log(EVENT, "onBeforeOpen. Filename=" + filename);
            		log(EVENT, "onBeforeOpen: Url: " + url);
            		log(EVENT, "onBeforeOpen: mode: " + mode);
            		return true;
            	}

            	public boolean onBeforeRename(FileTreePanel fileTreePanel,
            			TreeNode treeNode, String newName, String oldName) {
            		log(EVENT, "onBeforeRename: treeNode: " + treeNode.getPath("text"));
            		log(EVENT, "onBeforeRename: newName: " + newName);
            		log(EVENT, "onBeforeRename: oldName: " + oldName);
            		if(treeNode.getPath("text").startsWith("Tree Root/images"))
            			return false;
            		return true;
            	}

            	public void onDelete(FileTreePanel fileTreePanel, String path) {
            		log(EVENT, "onDelete: path: " + path);
            	}

            	public void onDeleteFailure(FileTreePanel fileTreePanel,
            			TreeNode treeNode) {
            		log(EVENT, "onDeleteFailure: " + treeNode.getPath("text"));
            	}

            	public void onNewDir(FileTreePanel fileTreePanel, TreeNode treeNode) {
            		log(EVENT, "onNewDir: " + treeNode.getPath("text"));
            	}

            	public void onNewDirFailure(FileTreePanel fileTreePanel, String path) {
            		log(EVENT, "onNewDirFailure: " + path);
            	}

            	public void onOpen(FileTreePanel fileTreePanel, String filename,
            			String url, String mode) {
            		log(EVENT, "onOpen: filename: " + filename);
            		log(EVENT, "onOpen: url: " + url);
            		log(EVENT, "onOpen: mode: " + mode);
            	}

            	public void onRename(FileTreePanel fileTreePanel,
            			TreeNode treeNode, String newName, String oldName) {
            		log(EVENT, "onRename: treeNode: " + treeNode.getPath("text"));
            		log(EVENT, "onRename: newName: " + newName);
            		log(EVENT, "onRename: oldName: " + oldName);
            	}

            	public void onRenameFailure(FileTreePanel fileTreePanel,
            			TreeNode treeNode, String newName, String oldName) {
            		log(EVENT, "onRenameFailure: treeNode: " + treeNode.getPath("text"));
            		log(EVENT, "onRenameFailure: newName: " + newName);
            		log(EVENT, "onRenameFailure: oldName: " + oldName);
            	}
            	
            	public boolean onBeforeFileAdd(FileTreePanel fileTreePanel, ExtElement element){
            		log(EVENT, "onBeforeFileAdd: element: " + element.toString());
            		return true;
            	}
            	
            	public String onOpenNodePath(FileTreePanel fileTreePanel, TreeNode treeNode, 
            			String path, String mode){
            		log(EVENT, "onOpenNodePath: path: " + path);
            		return path.substring(5);
            	}
            	
            	public void onClick(TreeNode node, EventObject e) {
            		log(EVENT, "onClick: node: " + node.getPath("text"));
                }
            });
            ftp.setOpenAction(new FileTreePanelOpenAction(){
            	public String onOpenNodePath(FileTreePanel fileTreePanel, TreeNode treeNode, String path, String mode){
            		return path.substring(5);
            	}
            });
            ftp.show();
            panel.add(ftp);
            
            Button resetTree = new Button("Reset Tree", new ButtonListenerAdapter(){
                public void onClick(Button button, EventObject e) {
                      ConnectionConfig conCfg = new ConnectionConfig();
                      conCfg.setUrl("FileTreeSvc");
                      conCfg.setMethod(Connection.POST);

                      UrlParam[] arrParam2 = { new UrlParam("reset", true) };
                      RequestParam reqParam = new RequestParam();
                      reqParam.setParams(arrParam2);

                      Connection con = new Connection(conCfg);
                      con.request(reqParam);
                      
                      AsyncTreeNode aNode =null;// new AsyncTreeNode(ftp.getRootNode().getJsObj());
                      aNode.reload();
                }
            });
            
            panel.add(resetTree);
        }


        return panel;
    }

    protected boolean showEvents() {
        return true;
    }
    
    public String getIntro() {
        return "<p>This is an example illustrating the FileTreePanel. " +
        "This TreePanel handles files actions like rename, delete, move, and upload.  " +
        "This panel will not allow changes in /Root Tree/images/* since the images there " +
        "can be opened by double-clicking or context-menu|open.  Other files that you upload " +
        "will not download/open since they are not really stored.  The tree is kept in memory " +
        "at the server side without an actually saving any uploaded files.  Please read the " +
        "readme file in the /js/filetree direcotry since the code original code was changed to " +
        "accommodate better integration with gwt-ext." +
        "</p><p>This sample and widget was added by <b>Mario Lim</b></p>";
    }
}