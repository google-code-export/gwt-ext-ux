package com.gwtextux.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.TreePanel;

public class FileTreePanel extends TreePanel {
    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.ux.FileTreePanel();
        @com.gwtext.client.widgets.Panel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "uploadpanel";
    }

    /**
     * Create a new Panel.
     */
    public FileTreePanel() {
    }

    /**
     * Construct a new Panel with the given title.
     *
     * @param title the title
     */
    public FileTreePanel(String title) {
        setTitle(title);
    }

    public FileTreePanel(String title, String html) {
        setTitle(title);
        setHtml(html);
    }

    public FileTreePanel(String title, int width, int height) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
    }

    protected FileTreePanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     *
     * @param element the element
     */
    public FileTreePanel(Element element) {
        super(element);
    }
    
    public void setOpenAction(FileTreePanelOpenAction oaction){
    	setAttribute("opennodepath", setJsOpenAction(oaction), true);
    }
    
    private native JavaScriptObject setJsOpenAction(FileTreePanelOpenAction oaction) /*-{
        var fileTreePanelJ = this;
        return function(source, treenode, path, mode) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                return oaction.@com.gwtextux.client.widgets.tree.FileTreePanelOpenAction::onOpenNodePath(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, nodeJ, path, mode);
	            };
    }-*/;

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.FileTreePanel(config);
    }-*/;
    
    public void show(){
    	super.show();
    	getOrCreateJsObj();
    }

    /**
     * Adds listeners to the dialog to handle the different events
     * @param listener the listener implementation
     */
    public native void addListener(FileTreePanelListener listener) /*-{
	    this.@com.gwtext.client.widgets.tree.TreePanel::addListener(Lcom/gwtext/client/widgets/tree/event/TreePanelListener;)(listener);
	    var fileTreePanelJ = this;
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeopen',
	            function(source,filename,url,mode) {
	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeOpen(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, filename, url, mode);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('open',
	            function(source,filename,url,mode) {
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onOpen(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, filename, url, mode);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforerename',
	            function(source,treenode,newpath,oldpath) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeRename(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, nodeJ, newpath, oldpath);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('rename',
	            function(source,treenode,newpath,oldpath) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onRename(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, nodeJ, newpath, oldpath);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('renamefailure',
	            function(source,treenode,newpath,oldpath) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onRenameFailure(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;Ljava/lang/String;Ljava/lang/String;)(fileTreePanelJ, nodeJ, newpath, oldpath);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforedelete',
	            function(source,treenode) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeDelete(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(fileTreePanelJ, nodeJ);
	            }
	    );	

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('delete',
	            function(source,path) {
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onDelete(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Ljava/lang/String;)(fileTreePanelJ, path);
	            }
	    );	

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('deletefailure',
	            function(source,treenode) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onDeleteFailure(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(fileTreePanelJ, nodeJ);
	            }
	    );	

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforenewdir',
	            function(source,treenode) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeNewDir(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(fileTreePanelJ, nodeJ);
	            }
	    );	

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('newdir',
	            function(source,treenode) {
	                var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(treenode);
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onNewDir(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/widgets/tree/TreeNode;)(fileTreePanelJ, nodeJ);
	            }
	    );	

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('newdirfailure',
	            function(source,path) {
	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onNewDirFailure(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Ljava/lang/String;)(fileTreePanelJ, path);
	            }
	    );
	    

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforefileadd',
	            function(source,elem) {
	                var elemJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeFileAdd(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/core/ExtElement;)(fileTreePanelJ, elemJ);
	            }
	    );
	    
//	    var ftp = this.@com.gwtext.client.widgets.Component::getJsObject()();
//    	ftp.uploadPanel.on({
//			 'beforefileadd':{fn:function(source,elem) {
//			        var elemJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
//	                return listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeFileAdd(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Lcom/gwtext/client/core/ExtElement;)(fileTreePanelJ, elemJ);
//	            }
//	         }
//			,allfinished:{function(source,path) {
//	                listener.@com.gwtextux.client.widgets.tree.FileTreePanelListener::onBeforeFileAdd(Lcom/gwtextux/client/widgets/tree/FileTreePanel;Ljava/lang/String;)(fileTreePanelJ, path);
//	            }
//	        }
//		});

	}-*/;

	/**
	 * Request properties which specify HTTP parameters to be passed to each request for child nodes.
	 *
	 * @param params the request params
	 */
	public void setBaseParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
	    JavaScriptObjectHelper.setAttribute(config, "baseParams", paramObj);
    }

	
    /**
     * Sets the confirmText Text to display as title of confirmation message box
     * @param confirmText Text to display as title of confirmation message box 
     * (defaults to "Confirm")
     */
    public void setConfirmText(String confirmText){
    	setAttribute("confirmText", confirmText, false);
    }
    
    /**
     * gets the confirmText Text to display as title of confirmation message box
     * @return confirmText Text to display as title of confirmation message box
     */
    public String getConfirmText(){
    	String text = getAttribute("confirmText");
    	if(text==null || text.length() == 0)
    		text = "Confirm";
    	return text;
    }

    /**
     * 
     * @param containerScroll  true to register 
	 * this container with ScrollManager (defaults to true)
     */
    public void setContainerScroll(boolean containerScroll){
    	setAttribute("containerScroll", containerScroll, false);
    }
    
    /**
     * 
     * @return containerScroll if it is register or not with 
     * ScrollManager
     */
    public boolean getContainerScroll(){
    	return getAttributeAsBoolean("containerScroll");
    }
    
    /**
     * Sets the deleteText Text (for message box title or other displayed texts)
     * @param confirmText Text (for message box title or other displayed texts)
     * (defaults to "Delete")
     */
    public void setDeleteText(String deleteText){
    	setAttribute("deleteText", deleteText, false);
    }
    
    /**
     * gets the deleteText Text (for message box title or other displayed texts)
     * @return deleteText Delete text (for message box title or other displayed texts)
     */
    public String getDeleteText(){
    	String text = getAttribute("deleteText");
    	if(text==null || text.length() == 0)
    		text = "Delete";
    	return text;
    }
    

    /**
     * 
     * @param deleteUrl deleteUrl URL to use when deleting; 
     * this.url is used if not set (defaults to undefined)
     */
    public void setDeleteUrl(String deleteUrl){
    	setAttribute("deleteUrl", deleteUrl, false);
    }
    

    /**
     * 
     * @return deleteUrl deleteUrl URL to use when deleting.  Returns
     * null if not set.
     */
    public String getDeleteUrl(){
    	String text = getAttribute("deleteUrl");
    	if(text==null || text.length() == 0 || text.equals("undefined"))
    		text = null;
    	return text;
    }
    
    /**
     * 
     * @param downloadUrl URL to use when downloading; 
     * this.url is used if not set (defaults to undefined)
     */
    public void setDownloadUrl(String downloadUrl){
    	setAttribute("downloadUrl", downloadUrl, false);
    }
    

    /**
     * 
     * @return downloadUrl downloadUrl URL to use when downloading.  Returns
     * null if not set.
     */
    public String getDownloadUrl(){
    	String text = getAttribute("downloadUrl");
    	if(text==null || text.length() == 0 || text.equals("undefined"))
    		text = null;
    	return text;
    }
    
    
    /**
     * 
     * @param enableDD true to enable drag & drop of files and folders (defaults to true)
     */
    public void setEnableDD(boolean enableDD){
    	setAttribute("enableDD", enableDD, false);
    }
    
    /**
     * 
     * @return enableDD true to enable drag & drop of files and folders
     */
    public boolean getEnableDD(){
    	return getAttributeAsBoolean("enableDD");
    }
    
    /**
     * 
     * @param enableDelete true to enable to delete files and directories. 
	 * If false context menu item is not shown (defaults to true)
     */
    public void setEnableDelete(boolean enableDelete){
    	setAttribute("enableDelete", enableDelete, false);
    }
    
    /**
     * 
     * @return enableDelete true to enable to delete files and directories. 
     */
    public boolean getEnableDelete(){
    	return getAttributeAsBoolean("enableDelete");
    }
    
    /**
     * 
     * @param enableNewDir true to enable to create new directory. 
	 * If false context menu item is not shown (defaults to true)
     */
    public void setEnableNewDir(boolean enableNewDir){
    	setAttribute("enableNewDir", enableNewDir, false);
    }
    
    /**
     * 
     * @return enableNewDir true to enable to create new directory. 
     */
    public boolean getEnableNewDir(){
    	return getAttributeAsBoolean("enableNewDir");
    }
    
    /**
     * 
     * @param enableOpen true to enable open submenu
	 * If false context menu item is not shown (defaults to true)
     */
    public void setEnableOpen(boolean enableOpen){
    	setAttribute("enableOpen", enableOpen, false);
    }
    
    /**
     * 
     * @return enableOpen true to enable open submenu.
     */
    public boolean getEnableOpen(){
    	return getAttributeAsBoolean("enableOpen");
    }
    
    /**
     * 
     * @param enableProgress true to enable querying server for progress information
	 * Passed to underlying uploader.
     */
    public void setEnableProgress(boolean enableProgress){
    	setAttribute("enableProgress", enableProgress, false);
    }
    
    /**
     * 
     * @return enableProgress true to enable querying server for progress information
	 * Passed to underlying uploader.
     */
    public boolean getEnableProgress(){
    	return getAttributeAsBoolean("enableProgress");
    }
    
    /**
     * 
     * @param enableRename true to enable to rename files and directories. 
	 * If false context menu item is not shown (defaults to true)
     */
    public void setEnableRename(boolean enableRename){
    	setAttribute("enableRename", enableRename, false);
    }
    
    /**
     * 
     * @return enableRename true to enable to rename files and directories. 
     */
    public boolean getEnableRename(){
    	return getAttributeAsBoolean("enableRename");
    }
    
    /**
     * 
     * @param enableSort true to enable sorting of tree. (defaults to true)
     * @see folderSort
     */
    public void setEnableSort(boolean enableSort){
    	setAttribute("enableSort", enableSort, false);
    }
    
    /**
     * 
     * @return enableSort true to enable sorting of tree.
     */
    public boolean getEnableSort(){
    	return getAttributeAsBoolean("enableSort");
    }
    
    /**
     * 
     * @param enableUpload true to enable to upload files. 
	 * If false context menu item is not shown (defaults to true)
     */
    public void setEnableUpload(boolean enableUpload){
    	setAttribute("enableUpload", enableUpload, false);
    }
    
    /**
     * 
     * @return enableUpload true to enable to upload files. 
	 * If false context menu item is not shown 
     */
    public boolean getEnableUpload(){
    	return getAttributeAsBoolean("enableUpload");
    }

    /**
     * 
     * @param errorText Text to display for an error (defaults to "Error")
     */
    public void setErrorText(String errorText){
    	setAttribute("errorText", errorText, false);
    }
    

    /**
     * 
     * @return errorText Text to display for an error.  Returns
     * null if not set.
     */
    public String getErrorText(){
    	String text = getAttribute("errorText");
    	if(text==null || text.length() == 0)
    		text = "Error";
    	return text;
    }
    
    /**
     * 
     * @param existsText Text to display in message box if file exists 
     * (defaults to "File <b>{0}</b> already exists")
     */
    public void setExistsText(String existsText){
    	setAttribute("existsText", existsText, false);
    }
    

    /**
     * 
     * @return existsText Text to display in message box if file exists
     */
    public String getExistsText(){
    	String text = getAttribute("existsText");
    	if(text==null || text.length() == 0)
    		text = "File <b>{0}</b> already exists";
    	return text;
    }
    
    /**
     * 
     * @return true to expand root node on FileTreePanel render (defaults to true)
     */
    public boolean getExpandOnRender(){
    	return getAttributeAsBoolean("expandOnRender");
    }
    
    /**
     * 
     * @param true to expand root node on FileTreePanel render
     */
    public void setExpandOnRender(boolean expandOnRender){
    	setAttribute("expandOnRender", expandOnRender, false);
    }
    
    /**
     * sets fileCls class prefix to add to nodes. "-extension" is appended to
	 * this prefix to form filetype class, for example: file-odt, file-pdf. These classes
	 * are used to display correct filetype icons in the tree. css file and icons must
	 * exist of course.
	 * 
     * @param fileCls class prefix to add to nodes. 
     */
    public void setFileCls(String fileCls){
    	setAttribute("fileCls", fileCls, false);
    }
    

    /**
     * 
     * @return fileCls class prefix to add to nodes. 
     */
    public String getFileCls(){
    	String text = getAttribute("fileCls");
    	if(text==null || text.length() == 0)
    		text = "file";
    	return text;
    }
    
    /**
     * @param fileText
     */
    public void setFileText(String fileText){
    	setAttribute("fileText", fileText, false);
    }
    

    /**
     * 
     * @return fileText
     */
    public String getFileText(){
    	String text = getAttribute("fileText");
    	if(text==null || text.length() == 0)
    		text = "File";
    	return text;
    }
    
    /**
     * 
     * @return focusPopup true to focus new browser popup window for 'popup' openMode
	 * (defaults to true)
     */
    public boolean getFocusPopup(){
    	return getAttributeAsBoolean("focusPopup");
    }
    
    /**
     * 
     * @param focusPopup true to focus new browser popup window for 'popup' openMode
     */
    public void setFocusPopup(boolean focusPopup){
    	setAttribute("focusPopup", focusPopup, false);
    }
    
    /**
     * 
     * @return folderSort true to place directories at the top of the tree (defaults to true)
     */
    public boolean getFolderSort(){
    	return getAttributeAsBoolean("folderSort");
    }
    
    /**
     * 
     * @param folderSort true to place directories at the top of the tree 
     */
    public void setFolderSort(boolean folderSort){
    	setAttribute("folderSort", folderSort, false);
    }
    
    /**
     * @param hrefPrefix Text to prepend before file href for file open command. 
	 * (defaults to '')
     */
    public void setHrefPrefix(String hrefPrefix){
    	setAttribute("hrefPrefix", hrefPrefix, false);
    }
    

    /**
     * 
     * @return hrefPrefix Text to prepend before file href for file open command.
     */
    public String getHrefPrefix(){
    	String text = getAttribute("hrefPrefix");
    	if(text==null || text.length() == 0)
    		text = "";
    	return text;
    }
    
    /**
     * @param hrefSuffix Text to append to file href for file open command. 
	 * (defaults to '')
     */
    public void setHrefSuffix(String hrefSuffix){
    	setAttribute("hrefSuffix", hrefSuffix, false);
    }
    

    /**
     * 
     * @return hrefSuffix Text to append to file href for file open command. 
     */
    public String getHrefSuffix(){
    	String text = getAttribute("hrefSuffix");
    	if(text==null || text.length() == 0)
    		text = "";
    	return text;
    }
    
    //set/get layout is implemented in super class
    
    /**
     * @param maxFileSize Maximum upload file size in bytes
	 * This config property is propagated down to uploader for convenience
     */
    public void setMaxFileSize(String maxFileSize){
    	setAttribute("maxFileSize", maxFileSize, false);
    }
    
    /**
     * 
     * @return maxFileSize Maximum upload file size in bytes
     */
    public String getMaxFileSize(){
    	String text = getAttribute("maxFileSize");
    	if(text==null || text.length() == 0)
    		text = "524288";
    	return text;
    }
    
    /**
     * @param maxMsgLen Maximum message length for message box (defaults to 2000).
	 * If message is longer Ext.util.Format.ellipsis is used to truncate it and append ...
     */
    public void setMaxMsgLen(String maxMsgLen){
    	setAttribute("maxMsgLen", maxMsgLen, false);
    }
    
    /**
     * 
     * @return maxMsgLen Maximum message length for message box 
     */
    public String getMaxMsgLen(){
    	String text = getAttribute("maxMsgLen");
    	if(text==null || text.length() == 0)
    		text = "2000";
    	return text;
    }
    
    /**
     * @param method Method to use when posting to server. Other valid value is 'get'
	 * (defaults to 'post')
     */
    public void setMethod(String method){
    	setAttribute("method", method, false);
    }
    
    /**
     * 
     * @return method Method to use when posting to server. Other valid value is 'get'
     */
    public String getMethod(){
    	String text = getAttribute("method");
    	if(text==null || text.length() == 0)
    		text = "post";
    	return text;
    }
    
    /**
     * @param newdirText Default name for new directories (defaults to 'New Folder')
     */
    public void setNewDirText(String newdirText){
    	setAttribute("newdirText", newdirText, false);
    }
    
    /**
     * 
     * @return newdirText Default name for new directories
     */
    public String getNewDirText(){
    	String text = getAttribute("newdirText");
    	if(text==null || text.length() == 0)
    		text = "New Folder";
    	return text;
    }
    
    /**
     * @param newdirUrl URL to use when creating new directory; 
	 * this.url is used if not set (defaults to undefined)
     */
    public void setNewDirUrl(String newdirUrl){
    	setAttribute("newdirUrl", newdirUrl, false);
    }
    
    /**
     * 
     * @return newdirUrl URL to use when creating new directory. If undefined,
     * this method returns null;
     */
    public String getNewDirUrl(){
    	String text = getAttribute("newdirUrl");
    	if(text==null || text.length() == 0 || text.equals("undefined"))
    		text = null;
    	return text;
    }
    
    /**
     * @param openMode Default file open mode. This mode is used when user dblclicks 
	 * a file. Other valid values are '_self', '_blank' and 'download' (defaults to 'popup')
     */
    public void setOpenMode(String openMode){
    	setAttribute("openMode", openMode, false);
    }
    
    /**
     * 
     * @return openMode Default file open mode. 
     */
    public String getOpenMode(){
    	String text = getAttribute("openMode");
    	if(text==null || text.length() == 0)
    		text = "popup";
    	return text;
    }
    
    /**
     * @param overwriteText Text to use in overwrite confirmation message box 
     * (defaults to 'Do you want to overwrite it?')
     */
    public void setOverwriteText(String overwriteText){
    	setAttribute("overwriteText", overwriteText, false);
    }
    
    /**
     * 
     * @return overwriteText Text to use in overwrite confirmation message box . 
     */
    public String getOverwriteText(){
    	String text = getAttribute("overwriteText");
    	if(text==null || text.length() == 0)
    		text = "Do you want to overwrite it?";
    	return text;
    }
    
    /**
     * @param popupFeatures Features for new browser window opened by popup open mode
	 * (defaults to 'width=800,height=600,dependent=1,scrollbars=1,resizable=1,toolbar=1')
     */
    public void setPopupFeatures(String popupFeatures){
    	setAttribute("popupFeatures", popupFeatures, false);
    }
    
    /**
     * 
     * @return popupFeatures Features for new browser window opened by popup open mode. 
     */
    public String getPopupFeatures(){
    	String text = getAttribute("popupFeatures");
    	if(text==null || text.length() == 0)
    		text = "width=800,height=600,dependent=1,scrollbars=1,resizable=1,toolbar=1";
    	return text;
    }
    
    /**
     * @param openMode Default file open mode. This mode is used when user dblclicks 
	 * a file. Other valid values are '_self', '_blank' and 'download' (defaults to 'popup')
     */
    public void setReadOnly(boolean readOnly){
    	setAttribute("readOnly", readOnly, false);
    }
    
    /**
     * 
     * @return openMode Default file open mode. 
     */
    public boolean getReadOnly(){
    	return getAttributeAsBoolean("readOnly");
    }
    
    /**
     * @param reallyWantText Text to display for that question
	 * (defaults to 'Do you really want to')
     */
    public void setReallyWantText(String reallyWantText){
    	setAttribute("reallyWantText", reallyWantText, false);
    }
    
    /**
     * 
     * @return reallyWantText Text to display for that question. 
     */
    public String getReallyWantText(){
    	String text = getAttribute("reallyWantText");
    	if(text==null || text.length() == 0)
    		text = "Do you really want to";
    	return text;
    }
    
    /**
     * @param renameUrl URL to use when renaming. (defaults to undefined)
     */
    public void setRenameUrl(String renameUrl){
    	setAttribute("renameUrl", renameUrl, false);
    }
    
    /**
     * 
     * @return renameUrl URL to use when renaming; null is used if not set. 
     */
    public String getRenameUrl(){
    	String text = getAttribute("renameUrl");
    	if(text==null || text.length() == 0 || text.equals("undefined"))
    		text = null;
    	return text;
    }
    
    /**
     * @param rootPath Relative path pointing to the directory that is root of this tree (defaults to 'root')
     */
    public void setRootPath(String rootPath){
    	setAttribute("rootPath", rootPath, false);
    }
    
    /**
     * 
     * @return rootPath Relative path pointing to the directory that is root of this tree
     */
    public String getRootPath(){
    	String text = getAttribute("rootPath");
    	if(text==null || text.length() == 0)
    		text = "root";
    	return text;
    }
    
    /**
     * @param rootText Text to display for root node (defaults to 'Tree Root')
     */
    public void setRootText(String rootText){
    	setAttribute("rootText", rootText, false);
    }
    
    /**
     * 
     * @return rootText Text to display for root node. 
     */
    public String getRootText(){
    	String text = getAttribute("rootText");
    	if(text==null || text.length() == 0)
    		text = "Tree Root";
    	return text;
    }
    
    /**
     * @param selectOnEdit true to select the edited text on edit start (defaults to true)
     */
    public void setSelectOnEdit(boolean selectOnEdit){
    	setAttribute("selectOnEdit", selectOnEdit, false);
    }
    
    /**
     * 
     * @return selectOnEdit true to select the edited text on edit start. 
     */
    public boolean getSelectOnEdit(){
    	return getAttributeAsBoolean("selectOnEdit");
    }
    
    /**
     * @param singleUpload true to upload files in one form, false to upload one by one
	 * This config property is propagated down to uploader for convenience
     */
    public void setSingleUpload(boolean singleUpload){
    	setAttribute("singleUpload", singleUpload, false);
    }
    
    /**
     * 
     * @return singleUpload true to upload files in one form, false to upload one by one
	 * This config property is propagated down to uploader for convenience
     */
    public boolean getSingleUpload(){
    	return getAttributeAsBoolean("singleUpload");
    }
    
    /**
     * @param topMenu true to create top toolbar with menu in addition to contextmenu
     */
    public void setTopMenu(boolean topMenu){
    	setAttribute("topMenu", topMenu, false);
    }
    
    /**
     * 
     * @return topMenu true to create top toolbar with menu in addition to contextmenu. 
     */
    public boolean getTopMenu(){
    	return getAttributeAsBoolean("topMenu");
    }
    
    /**
     * @param url URL to use when communicating with server (defaults to filetree.php)
     */
    public void setUrl(String url){
    	setAttribute("url", url, false);
    }
    
    /**
     * 
     * @return url URL to use when communicating with server. 
     */
    public String getUrl(){
    	String text = getAttribute("url");
    	if(text==null || text.length() == 0)
    		text = "filetree.php";
    	return text;
    }
}
