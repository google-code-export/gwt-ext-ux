/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.client.widgets.upload;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * 
 * @author mlim1972
 *
 */
public class SwfUploadPanel extends GridPanel {
    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.ux.UploadDialog.Dialog();
        @com.gwtextux.client.widgets.upload.SwfUploadPanel::configPrototype = c.initialConfig;
    }-*/;
    
    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "swfuploadpanel";
    }

    /**
     * Create a new upload dialog.
     */
    public SwfUploadPanel() {
    }
    
    /**
     * Create a new upload dialog.
     *
     * @param store       the Grid's data store
     * @param columnModel the Grid's column model
     */
    public SwfUploadPanel(Store store, ColumnModel columnModel) {
        setStore(store);
        setColumnModel(columnModel);
    }

    /**
     * Create a new upload dialog.
     *
     * @param id          the Grid ID
     * @param width       the Grid width
     * @param height      the Grid height
     * @param store       the Grid's data store
     * @param columnModel the Grid's column model
     */
    public SwfUploadPanel(String id, int width, int height, Store store, ColumnModel columnModel) {
        setId(id);
        setWidth(width);
        setHeight(height);
        setStore(store);
        setColumnModel(columnModel);
    }


    public SwfUploadPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static SwfUploadPanel instance(JavaScriptObject jsObj) {
        return new SwfUploadPanel(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.SwfUploadPanel(config);
    }-*/;
    
    public void show(){
    	super.show();
    	getOrCreateJsObj();
    }
    /**
     * Adds listeners to the dialog to handle the different events
     * @param listener the listener implementation
     */
    public native void addListener(SwfUploadPanelListener listener) /*-{
	    this.@com.gwtext.client.widgets.grid.GridPanel::addGridCellListener(Lcom/gwtext/client/widgets/grid/event/GridCellListener;)(listener);
	    var swfUploadPanelJ = this;
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('fileQueued',
	            function(source,file) {
	                listener.@com.gwtextux.client.widgets.upload.SwfUploadPanelListener::onFileQueued(Lcom/gwtextux/client/widgets/upload/SwfUploadPanel;Ljava/lang/String;)(swfUploadPanelJ, file.name);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('queueUploadComplete',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.SwfUploadPanelListener::onQueueUploadComplete(Lcom/gwtextux/client/widgets/upload/SwfUploadPanel;)(swfUploadPanelJ);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('fileUploadComplete',
	            function(source,file, response) {
	                var res = (response === undefined || response == null) ? null : response;
	                listener.@com.gwtextux.client.widgets.upload.SwfUploadPanelListener::onFileUploadComplete(Lcom/gwtextux/client/widgets/upload/SwfUploadPanel;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(swfUploadPanelJ, file.name, res);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('swfUploadLoaded',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.SwfUploadPanelListener::onSwfUploadLoaded(Lcom/gwtextux/client/widgets/upload/SwfUploadPanel;)(swfUploadPanelJ);
	            }
	    );

	}-*/;

    /**
     * Single file select.  By default this is set to false
     * @param singleSelect true if selectability is only for one file
     */
    public void setSingleSelect(boolean singleSelect){
        setAttribute("single_select", singleSelect, true);
    }
    
    /**
     * Get if the SwfUploadPanel is setup for single select or not
     * @return true if it is single select; otherwise, it returns false
     */
    public boolean getSingleSelect(){
        return getAttributeAsBoolean("single_select");
    }
    
    /**
     * File types to allow
     * @param fileTypes the file types separated by comma
     */
    public void setFileTypes(String fileTypes){
        setAttribute("file_types", fileTypes, true);
    }
    
    /**
     * returns the list of file types allowed
     * @return the list of file types allowed
     */
    public String getFileTypes(){
        return getAttribute("file_types");
    }
    
    /**
     * Sets the description shown when the dialog to select files is opened
     * @param desc the description to show.  By default the description is 
     * "All Files".
     */
    public void setFileTypesDescription(String desc){
        setAttribute("file_types_description", desc, true);
    }
    
    /**
     * gets the file type description
     * @return
     */
    public String getFileTypesDescription(){
        return getAttribute("file_types_description");
    }
    
    /**
     * sets the file size limit for uploading.
     * @param limit the size limit.  By default it is 102400 (100MB)
     */
    public void setFileSizeLimit(int limit){
        setAttribute("file_size_limit", limit, true);
    }
    
    /**
     * gets the file size limit
     * @return the file size limit
     */
    public int getFileSizeLimit(){
        return getAttributeAsInt("file_size_limit");
    }
    
    /**
     * Sets the file upload limit
     * @param limit the limit for files to be uploade. Default 0.
     */
    public void setFileUploadLimit(int limit){
        setAttribute("file_upload_limit", limit, true);
    }
    
    /**
     * Gets the file upload limit
     * @return the current file upload limit
     */
    public int getFileUploadLimit(){
        return getAttributeAsInt("file_upload_limit");
    }
    
    /**
     * Sets the file post name.  The name received at the server side.
     * @param name the name for the file uploaded.  By default it is "Filedata"
     */
    public void setFilePostName(String name){
        setAttribute("file_post_name", name, true);
    }
    
    /**
     * Gets the file post name
     * @return the name for the file to upload
     */
    public String getFilePostName(){
        return getAttribute("file_post_name");
    }
    
    /**
     * The URL for the flash file (swfupload_f9.swf)
     * @param url the relative URL of swfupload_f9.swf
     */
    public void setFlashUrl(String url){
        setAttribute("flash_url", url, true);
    }
    
    /**
     * Gets the relative URL for swfupload_f9.swf
     * @return the URL for swfupload_f9.swf
     */
    public String getFlashUrl(){
        return getAttribute("flash_url");
    }
    
    /**
     * The URL to upload the file
     * @param url URL to upload the file
     */
    public void setUploadUrl(String url){
        setAttribute("upload_url", url, true);
    }
    
    /**
     * Gets the URL where to upload the file
     * @return the URL where the file is uploaded
     */
    public String getUploadUrl(){
        return getAttribute("upload_url");
    }
    

    /**
     * Add extra post-parameters to the request.  This method can only be
     * called after SfwUpload is initialized (i.e. create a listener for
     * onSwfUploadLoaded and call this method in there).
     * @param name name of the post parameter
     * @param value the value of the post parameter
     */
    public native void addPostParam(String name, String value) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.addPostParam(name,value);
    }-*/;
    
    
    /**
     * Set if it only accept single selections
     * @param singleFileSelect boolean setting if it select single
     */
    public void setSingleFileSelect(boolean singleFileSelect){
        setAttribute("single_file_select", singleFileSelect, true);
    }
    
    /**
     * Returns true or false if the panel is configured to do single file selection
     * @return true or false for single file selection
     */
    public boolean getSingleFileSelect(){
        return getAttributeAsBoolean("single_file_select");
    }
    
    /**
     * Set if there should be a confirmation when files are deleted from the queue
     * @param confirm true or false if the file can be deleted with a confirmation dialog
     */
    public void setConfirmDelete(boolean confirm){
        setAttribute("confirm_delete", confirm, true);
    }
    
    /**
     * Returns true or false if the delete confirmation is set
     * @return true or false for delete confirmation
     */
    public boolean getConfirmDelete(){
        return getAttributeAsBoolean("confirm_delete");
    }
    
    /**
     * set debug statements
     * @param debug debug statements
     */
    public void setDebug(String debug){
        setAttribute("debug", debug, true);
    }
    
    /**
     * gets the debug statements
     * @return gets the debug statements
     */
    public String getDebug(){
        return getAttribute("debug");
    }
}
