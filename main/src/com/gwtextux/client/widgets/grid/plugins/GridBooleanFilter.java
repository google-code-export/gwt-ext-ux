package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class GridBooleanFilter extends GridFilter {
	
	public GridBooleanFilter(String dataIndex){
		super(dataIndex);
	}
	
	public GridBooleanFilter(){
		super();
	}
	
	public GridBooleanFilter(JavaScriptObject jsO){
		super(jsO);
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.BooleanFilter(configJS);
	}-*/;
	
	/**
	 * Set the text for 'yes'
	 * @param yesText
	 */
	public void setYesText(String yesText) {
		JavaScriptObjectHelper.setAttribute(configJS, "yesText", yesText);
	}
	
	public String getYesText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "yesText");
	}
	
	/**
	 * Set the text for 'No'
	 * @param noText
	 */
	public void setNoText(String noText) {
		JavaScriptObjectHelper.setAttribute(configJS, "noText", noText);
	}
	
	public String getNoText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "noText");
	}
	
	public void useDefaultValue(boolean defaultValue){
		JavaScriptObjectHelper.setAttribute(configJS, "defaultValue", defaultValue);
	}
	
	public boolean isDefaultValue(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "defaultValue");
	}
	
	public native void setValue(boolean val) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gf.setValue(val);
	}-*/;

	public native boolean getValue() /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.getValue();
	}-*/;
}
