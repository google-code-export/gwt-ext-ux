package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;

public class GridNumericFilter extends GridFilter {
	
	public GridNumericFilter(String dataIndex){
		super(dataIndex);
	}
	
	public GridNumericFilter(){
		super();
	}
	
	public GridNumericFilter(JavaScriptObject jsO){
		super(jsO);
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.NumericFilter(configJS);
	}-*/;
	
	
	public native void setValue(int val) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gf.setValue(val);
	}-*/;

	public native int getValue() /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.getValue();
	}-*/;
}
