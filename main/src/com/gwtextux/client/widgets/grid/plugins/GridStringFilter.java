package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class GridStringFilter extends GridFilter {
	
	public GridStringFilter(String dataIndex){
		super(dataIndex);
	}
	
	public GridStringFilter(){
		super();
	}
	
	public GridStringFilter(JavaScriptObject jsO){
		super(jsO);
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.StringFilter(configJS);
	}-*/;
	
	public void setUpdateBuffer(int updateBuffer) {
		JavaScriptObjectHelper.setAttribute(configJS, "updateBuffer", updateBuffer);
	}
	
	public int getUpdateBuffer(int updateBuffer) {
		return JavaScriptObjectHelper.getAttributeAsInt(configJS, "updateBuffer");
	}
	
	/**
	 * icon.  by Default: 'ux-gridfilter-text-icon'
	 * @param icon
	 */
	public void setIcon(String icon) {
		JavaScriptObjectHelper.setAttribute(configJS, "icon", icon);
	}
	
	public String getIcon() {
		return JavaScriptObjectHelper.getAttribute(configJS, "icon");
	}
	
	public native void setValue(String val) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gf.setValue(val);
	}-*/;

	public native String getValue() /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.getValue();
	}-*/;
}
