package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * See http://extjs.com/forum/showthread.php?t=21331.
 * Requires Ext.ux.grid.GridSummary.js and Ext.ux.grid.GridSummary.css
 * 
 * @author tinker (Original Ext component author)
 * @author mystix (Enhanced Ext component author)
 * @author Matthew Lieder (GWT-Ext wrapper author)
 */
public class GridSummaryPlugin extends ComponentPlugin {
	
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	
	public GridSummaryPlugin() {
	}
	
	public void init(Component component) {
	}

	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}

	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.GridSummary(configJS);
	}-*/;
	
    public native void toggleSummary() /*-{
	    var plugin = this.@com.gwtext.client.core.JsObject::getJsObj()();
	    plugin.toggleSummary();
	}-*/;
    
    public native void toggleSummary(boolean enable) /*-{
	    var plugin = this.@com.gwtext.client.core.JsObject::getJsObj()();
	    plugin.toggleSummary(enable);
	}-*/;
	
}
