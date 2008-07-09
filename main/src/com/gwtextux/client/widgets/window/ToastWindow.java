/**
 * 
 */
package com.gwtextux.client.widgets.window;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Window;

/**
 * @author Ammar Belakhel
 *
 */
public class ToastWindow extends Window {

	private static JavaScriptObject configPrototype;
	
	static {
        init();
    }

	/**
	 * 
	 */
    private static native void init()/*-{
        var c = new $wnd.Ext.ux.ToastWindow();
        @com.gwtextux.client.widgets.window.ToastWindow::configPrototype = c.initialConfig;
    }-*/;
    
    /**
     * @return
     */
    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    /**
     * Retuns the xtype of this component.
     * @return
     */
    public String getXType() {
        return "toastwindow";
    }
    
    /**
     * 
     */
    public ToastWindow() {
    }
    
    /**
     * @param title
     */
    public ToastWindow(String title) {
    	super(title);
    }
    
    /**
     * @param title
     * @param msg
     */
    public ToastWindow(String title, String msg) {
    	super(title);
    	setMessage(msg);
    }
    
    /**
     * @param jsObj
     */
    public ToastWindow(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * @param jsObj
     * @return
     */
    public static ToastWindow instance(JavaScriptObject jsObj) {
        return new ToastWindow(jsObj);
    }

    /**
     * Creates a native ToastWindow object.
     * @param config
     * @return
     */
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.ToastWindow(config);
    }-*/;
    
    /**
     * Sets the title and the iconCls of this Window instance.
     * @param title
     * @param iconCls
     */
    public native void setTitle(String title, String iconCls) /*-{
    	var twJS = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	twJS.setTitle(title, iconCls);
    }-*/;
    
    /**
     * Displays a message.
     * @param msg
     */
    public void setMessage(String msg) {
    	setHtml(msg);
    }
    
    /**
     * Shows the ToastWindow.
     */
    public native void show()  /*-{
    	var twJS = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	twJS.show($doc);
    }-*/;
}
