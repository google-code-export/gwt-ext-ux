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
