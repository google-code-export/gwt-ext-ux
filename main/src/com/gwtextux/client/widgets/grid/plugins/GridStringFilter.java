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
