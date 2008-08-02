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
