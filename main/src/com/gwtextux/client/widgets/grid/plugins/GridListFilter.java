/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class GridListFilter extends GridFilter {
	
	public GridListFilter(String dataIndex, String[] options){
		super(dataIndex);
		JavaScriptObject jso = JavaScriptObjectHelper.convertToJavaScriptArray(options);
		JavaScriptObjectHelper.setAttribute(configJS, "options", jso);
	}
	
	public GridListFilter(){
		super();
	}
	
	public GridListFilter(JavaScriptObject jsO){
		super(jsO);
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.ListFilter(configJS);
	}-*/;
	
	/**
	 * Set the text for 'labelField'.  Default 'text'
	 * @param labelField
	 */
	public void setLabelField(String labelField) {
		JavaScriptObjectHelper.setAttribute(configJS, "labelField", labelField);
	}
	
	public String getLabelField() {
		return JavaScriptObjectHelper.getAttribute(configJS, "labelField");
	}
	
	/**
	 * Set the text for 'loadingText'
	 * @param loadingText
	 */
	public void setLoadingText(String loadingText) {
		JavaScriptObjectHelper.setAttribute(configJS, "loadingText", loadingText);
	}
	
	/**
	 * Get the test for loadingText.  By default 'Loading...'
	 * @return
	 */
	public String getLoadingText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "loadingText");
	}
	
	public void setLoadOnShow(boolean loadOnShow){
		JavaScriptObjectHelper.setAttribute(configJS, "loadOnShow", loadOnShow);
	}
	
	public boolean getLoadOnShow(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "loadOnShow");
	}
	
	public void setValue(String[] values){
		JavaScriptObject jso = JavaScriptObjectHelper.convertToJavaScriptArray(values);
		setValueJ(jso);
	}
	
	private native void setValueJ(JavaScriptObject val) /*-{
	    $wnd.alert("val = " + val);
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		$wnd.alert("gf = " + gf);
		gf.setValue(val);
	}-*/;

	public String[] getValue(){
		return JavaScriptObjectHelper.convertToJavaStringArray(getValueJ());
	}
	
	private native JavaScriptObject getValueJ() /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.getValue();
	}-*/;
}
