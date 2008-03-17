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
	                var message = data.response.message;
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadSuccess(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;Ljava/lang/String;)(uploadDialogJ, filename, message);
	            }
	    );
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('uploaderror',
	            function(source,filename,data) {
	                var message = data.response.message;
	                listener.@com.gwtextux.client.widgets.upload.UploadDialogListener::onUploadError(Lcom/gwtextux/client/widgets/upload/UploadDialog;Ljava/lang/String;Ljava/lang/String;)(uploadDialogJ, filename, message);
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

    
    public native void startUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.startUpload();
    }-*/;
    
    public native void stopUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.stopUpload();
	}-*/;
    
    public native String getUrl() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getUrl();
	}-*/;

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

    public native boolean getUploadAutostart() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getUploadAutostart();
	}-*/;
	
	public native void setUploadAutostart(boolean autostart) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setUploadAutostart(autostart);
	}-*/;
	
	
    public native boolean getAllowCloseOnUpload() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getAllowCloseOnUpload();
	}-*/;
	
	public native void setAllowCloseOnUpload(boolean allowCloseOnUpload) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setAllowCloseOnUpload(allowCloseOnUpload);
	}-*/;
	
    public native boolean getResetOnHide() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return w.getResetOnHide();
	}-*/;
	
	public native void setResetOnHide(boolean resetonhide) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    w.setResetOnHide(resetonhide);
	}-*/;
	
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
    
    public String[] getPermittedExtensions() {
        JavaScriptObject exts = getPermittedExtensions(getJsObj());
        return JavaScriptObjectHelper.convertToJavaStringArray(exts);
    }

    private native JavaScriptObject getPermittedExtensions(JavaScriptObject dialog)/*-{
		return dialog.getPermittedExtensions();
    }-*/;

    public native boolean isUploading()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.isUploading();
	}-*/;
    
    public native boolean isNotEmptyQueue()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.isNotEmptyQueue();
	}-*/;
    
    public native int getQueuedCount()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.getQueuedCount();
	}-*/;
    
    public native boolean hasUnuploadedFiles()/*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return w.hasUnuploadedFiles();
	}-*/;
    
    public void setPostVarName(String varname){
    	JavaScriptObjectHelper.setAttribute(getJsObj(), "post_var_name", varname);
    }
}
