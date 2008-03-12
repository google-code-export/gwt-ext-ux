package com.gwtextux.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.*;

/**
 * See http://extjs.com/forum/showthread.php?t=16590.
 * Requires ext-ux-miframe.js
 * 
 * @author Doug Hendricks (Ext component author)
 * @author Matthew Lieder (GWT-Ext wrapper author)
 */
public class ManagedIFramePanel extends Panel {
	
	private static JavaScriptObject configPrototype;

    static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.ux.ManagedIframePanel();
        @com.gwtextux.client.widgets.ManagedIFramePanel::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "iframepanel";
	}
	
	public ManagedIFramePanel() {
		setClosable(false);
	}
	
	public ManagedIFramePanel(String defaultSrc) {
		this();
		setDefaultSrc(defaultSrc);
	}
	
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.ManagedIframePanel();
	}-*/;
    
    public void setDefaultSrc(String defaultSrc) throws IllegalStateException {
        setAttribute("defaultSrc", defaultSrc, false);
    }
    
    public void setSrc(String srcUrl) {
    	setSrc(srcUrl, true);
    }
    
    public native void setSrc(String srcUrl, boolean discardUrl) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.setSrc(srcUrl, discardUrl);
	}-*/;
    
    public void setLoadMask(boolean loadMask) throws IllegalStateException {
        setAttribute("loadMask", loadMask, false);
    }
    
    /**
     * Refreshes the iframe based on the current defaultSrc value
     */
    public void refresh() {
    	setSrc(null, true);
    }
    
}
