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
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Window;

/**
 * This is a wrapper class for the UploadDialog user extension created
 * by MaximGB.  This window is used to upload files to the server.
 * @author mlim1972
 *
 */
public class UploadDialog extends Window {
    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.ux.UploadDialog.Dialog();
        @com.gwtextux.client.widgets.upload.UploadDialog::configPrototype = c.initialConfig;
    }-*/;
    
    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "uploaddialog";
    }

    /**
     * Create a new upload dialog.
     */
    public UploadDialog() {
    }
    
    /**
     * Create a new upload dialog.
     *
     * @param title the title
     */
    public UploadDialog(String title) {
        setTitle(title);
    }

    /**
     * Create a new upload dialog.
     *
     * @param title  the title
     * @param width  the width
     * @param height the height
     */
    public UploadDialog(String title, int width, int height) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Create a new upload dialog.
     *
     * @param title     the title
     * @param modal     true for modal
     * @param resizable true for resizable
     */
    public UploadDialog(String title, boolean modal, boolean resizable) {
        setTitle(title);
        setModal(modal);
        setResizable(resizable);
    }

    /**
     * Create a new Window.
     *
     * @param title     the title
     * @param width  the width
     * @param height the height
     * @param modal     true for modal
     * @param resizable true for resizable
     */
    public UploadDialog(String title, int width, int height, boolean modal, boolean resizable) {
        super(title, width, height, modal,resizable);
    }

    public UploadDialog(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static UploadDialog instance(JavaScriptObject jsObj) {
        return new UploadDialog(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.UploadDialog.Dialog(config);
    }-*/;
    
    /**
     * Adds listeners to the dialog to handle the different events
     * @param listener the listener implementation
     */
    public native void addListener(UploadDialogListener listener) /*-{
	    this.@com.gwtext.client.widgets.Window::addListener(Lcom/gwtext/client/widgets/event/WindowListener;)(listener);
	    var uploadDialogJ = this;
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('filetest',
	            function(source,filename) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onBeforeAdd(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;)(uploadDialogJ, filename);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('fileadd',
	            function(source,filename) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onFileAdd(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;)(uploadDialogJ, filename);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('fileremove',
	            function(source,filename) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onFileRemove(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;)(uploadDialogJ, filename);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('resetqueue',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onResetQueue(Lcom/gwtextux/client/widgets/upload/UploadDialog;)(uploadDialogJ);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('fileuploadstart',
	            function(source,filename) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onFileUploadStart(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;)(uploadDialogJ, filename);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploadsuccess',
	            function(source,filename,data) {	                
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadSuccess(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(uploadDialogJ, filename, data); 
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploaderror',
	            function(source,filename,data) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadError(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(uploadDialogJ, filename, data); 
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploadfailed',
	            function(source,filename) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadFailed(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;)(uploadDialogJ, filename);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploadstart',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadStart(Lcom/gwtextux/client/widgets/upload/UploadDialog;)(uploadDialogJ);
	            }
	    );
	
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploadstop',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadStop(Lcom/gwtextux/client/widgets/upload/UploadDialog;)(uploadDialogJ);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploadcomplete',
	            function(source) {
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadComplete(Lcom/gwtextux/client/widgets/upload/UploadDialog;)(uploadDialogJ);
	            }
	    );
	
	}-*/;

    /**
     * Starts the upload programmatically
     */
    public native void startUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.startUpload();
    }-*/;
    
    /**
     * Stops the upload process
     */
    public native void stopUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.stopUpload();
	}-*/;
    
    /**
     * returns the URL where the files are posted
     * @return the String URL where files are posted
     */
    public native String getUrl() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getUrl();
	}-*/;

    /**
     * sets the URL to post the files
     * @param url the String URL where files are posted
     */
    public native void setUrl(String url) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setUrl(url);
	}-*/;
    
    /**
     * Url params which are to be sent as parameters on any HTTP request.
     *
     * @param baseParams the base params
     */
    public void setBaseParams(UrlParam[] baseParams) {
        if(!isCreated()) {
             if (baseParams != null && baseParams.length > 0) {
                JavaScriptObject paramObj = UrlParam.getJsObj(baseParams);
                JavaScriptObjectHelper.setAttribute(configPrototype, "base_params", paramObj);
            }
        } else {
            setBaseParamsCreated(baseParams);
        }
    }
    
    /**
     * Base params which are to be sent as parameters on any HTTP request. Used only for Http based proxies.
     *
     * @param baseParams the base params
     */
    private native void setBaseParamsCreated(UrlParam[] baseParams) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var baseParamsJS = @com.gwtext.client.core.NameValuePair::getJsObj([Lcom/gwtext/client/core/NameValuePair;)(baseParams);
        w.base_params = baseParamsJS;
    }-*/;
    
    /**
     * Return the base params.
     *
     * @return the base params                      
     */
    public UrlParam[] getBaseParams() {
        JavaScriptObject baseParamsNative = getBaseParams(getJsObj());

        JavaScriptObject[] urlParamsJ = JavaScriptObjectHelper.toArray(baseParamsNative);
        UrlParam[] baseParams = new UrlParam[urlParamsJ.length];
        for (int i = 0; i < urlParamsJ.length; i++) {
            UrlParam urlParam = new UrlParam(urlParamsJ[i]);
            baseParams[i] = urlParam;
        }
        return baseParams;
    }

    private native JavaScriptObject getBaseParams(JavaScriptObject dialog) /*-{
        var params = new Array();
        var i = 0;
        var o = dialog.base_params;
        for(var key in o){
            var ov = o[key];
            var param = @com.gwtext.client.core.UrlParam::instance(Ljava/lang/String;Ljava/lang/String;)(key, ov);
            params[i] = param.@com.gwtext.client.core.JsObject::getJsObj()();
            i++;
        }
        return params;
    }-*/;

    /**
     * gets if auto start is enable or not
     * @return true or false if auto start is enabled
     */
    public native boolean getUploadAutostart() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getUploadAutostart();
	}-*/;
	
    /**
     * set the auto start so that files are uploaded as they are added to the dialog
     * @param autostart true or false to enable auto start
     */
	public native void setUploadAutostart(boolean autostart) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setUploadAutostart(autostart);
	}-*/;
	
	/**
	 * gets true or false if it is allowed to close the dialog during upload
	 * @return true or false if closing of the dialog is allowed while uploading
	 */
    public native boolean getAllowCloseOnUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getAllowCloseOnUpload();
	}-*/;
	
	/**
	 * sets true or false if it is allowed to close the dialog during upload
	 * @param allowCloseOnUpload true or false if closing of the dialog is allowed while uploading
	 */
	public native void setAllowCloseOnUpload(boolean allowCloseOnUpload) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setAllowCloseOnUpload(allowCloseOnUpload);
	}-*/;
	
	/**
	 * true or false if the queue should be reset when the dialog is hidden
	 * @return true or false if the queue should be reset when the dialog is hidden
	 */
    public native boolean getResetOnHide() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getResetOnHide();
	}-*/;
	
    /**
     * sets true or false if the queue should be reset when the dialog is hidden
     * @param resetonhide true or false if the queue should be reset when the dialog is hidden
     */
	public native void setResetOnHide(boolean resetonhide) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setResetOnHide(resetonhide);
	}-*/;
	
	/**
	 * extensions permitted.  This allow to filter files that are accepted by the server
	 * @param exts extensions allowed to upload (ie. "gif", "jpeg").  Right now, it is 
	 * case sensitive so JPEG and jpeg are treated differently.
	 */
    public void setPermittedExtensions(String[] exts) {
        JavaScriptObject[] strs = new JavaScriptObject[exts.length];
        JavaScriptObject nativeStrArray = JavaScriptObjectHelper.convertToJavaScriptArray(strs);
        
        for (int i = 0; i < exts.length; i++) {
            String ext = exts[i];
            JavaScriptObjectHelper.setArrayValue(nativeStrArray, i, ext);
        }
        
        setPermittedExtensions(getJsObj(), nativeStrArray);
    }

    private native void setPermittedExtensions(JavaScriptObject dialog, JavaScriptObject nativeStringArray)/*-{
		dialog.setPermittedExtensions(nativeStringArray);
    }-*/;
    
    /**
     * gets the permitted extensions
     * @return the array of permitted extensions
     */
    public String[] getPermittedExtensions() {
        JavaScriptObject exts = getPermittedExtensions(getJsObj());
        return JavaScriptObjectHelper.convertToJavaStringArray(exts);
    }

    private native JavaScriptObject getPermittedExtensions(JavaScriptObject dialog)/*-{
		return dialog.getPermittedExtensions();
    }-*/;

    /**
     * returns true or false depending if the uploading is in progress
     * @return true or false if upload is happening
     */
    public native boolean isUploading()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.isUploading();
	}-*/;
    
    /**
     * returns true or false depending if the queue is not empty
     * @return true or false depending if the queue is not empty
     */
    public native boolean isNotEmptyQueue()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.isNotEmptyQueue();
	}-*/;
    
    /**
     * gets the queue count
     * @return the queue count
     */
    public native int getQueuedCount()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.getQueuedCount();
	}-*/;
    
    /**
     * returns true or false if there are files in the queue that are not uploaded yet
     * @return true or false if there are files in the queue that are not uploaded yet
     */
    public native boolean hasUnuploadedFiles()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.hasUnuploadedFiles();
	}-*/;
    
    /**
     * sets the name of the variable to use for the files uploaded to the server. By default it is "file"
     * @param varname name of the variable to use for the files uploaded to the server. By default it is "file"
     */
    public void setPostVarName(String varname){
    	JavaScriptObjectHelper.setAttribute(getJsObj(), "post_var_name", varname);
    }
}
