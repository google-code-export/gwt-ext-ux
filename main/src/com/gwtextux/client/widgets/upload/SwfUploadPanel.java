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

    private static SwfUploadPanel instance(JavaScriptObject jsObj) {
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
     * 
     * @param singleSelect
     */
    public void setSingleSelect(boolean singleSelect){
        setAttribute("single_select", singleSelect, true);
    }
    
    public boolean getSingleSelect(){
        return getAttributeAsBoolean("single_select");
    }
    
    public void setFileTypes(String fileTypes){
        setAttribute("file_types", fileTypes, true);
    }
    
    public String getFileTypes(){
        return getAttribute("file_types");
    }
    
    public void setFileTypesDescription(String desc){
        setAttribute("file_types_description", desc, true);
    }
    
    public String getFileTypesDescription(){
        return getAttribute("file_types_description");
    }
    
    public void setFileSizeLimit(int limit){
        setAttribute("file_size_limit", limit, true);
    }
    
    public int getFileSizeLimit(){
        return getAttributeAsInt("file_size_limit");
    }
    
    public void setFileUploadLimit(int limit){
        setAttribute("file_upload_limit", limit, true);
    }
    
    public int getFileUploadLimit(){
        return getAttributeAsInt("file_upload_limit");
    }
    
    public void setFilePostName(String name){
        setAttribute("file_post_name", name, true);
    }
    
    public String getFilePostName(){
        return getAttribute("file_post_name");
    }
    
    public void setFlashUrl(String url){
        setAttribute("flash_url", url, true);
    }
    
    public String getFlashUrl(){
        return getAttribute("flash_url");
    }
    
    public void setUploadUrl(String url){
        setAttribute("upload_url", url, true);
    }
    
    public String getUploadUrl(){
        return getAttribute("upload_url");
    }
    
    //TODO: need to know what params are...
    public void setPostParams(String params){
        setAttribute("post_params", params, true);
    }
    
    public String getPostParams(){
        return getAttribute("post_params");
    }
    
    public void setSingleFileSelect(boolean singleFileSelect){
        setAttribute("single_file_select", singleFileSelect, true);
    }
    
    public boolean getSingleFileSelect(){
        return getAttributeAsBoolean("single_file_select");
    }
    
    public void setConfirmDelete(boolean confirm){
        setAttribute("confirm_delete", confirm, true);
    }
    
    public boolean getConfirmDelete(){
        return getAttributeAsBoolean("confirm_delete");
    }
    
    public void setDebug(String debug){
        setAttribute("debug", debug, true);
    }
    
    public String getDebug(){
        return getAttribute("debug");
    }
}
