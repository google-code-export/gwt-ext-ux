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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;
import com.gwtext.client.widgets.grid.ColumnConfig;

/**
 * This plugin is created from configured column with row expander. You need to first create the column and then 
 * this plugin. This is specific plugin and some attributes don't work. For example you can set 'header' attribute but 
 * it will not work as the original JavaScript plugin is configured to work in a column without header, only expanding 
 * icons are there. 
 * 
 * @author Krzysztof (ExtJs JavaScript code and Gwt-Ext-Ux wrapper code author)
 *
 */
public class RowExpanderPlugin extends ComponentPlugin {
	
	/**
	 * Constructor for {@code RowExpanderPlugin}. It builds the expander from configured column.
	 * 
	 * @param columnConfig
	 */
	public RowExpanderPlugin(ColumnWithRowExpander columnConfig){
		this.setColumnWithRowExpander(columnConfig);
	}
	
	/**
	 * Sets configured expander for this plugin.
	 * 
	 * @param columnConfig
	 */
	public void setColumnWithRowExpander(ColumnWithRowExpander columnConfig){
		this.jsObj = columnConfig.getJsObj();
	}
	
	/* (non-Javadoc)
	 * @see com.gwtext.client.widgets.ComponentPlugin#init(com.gwtext.client.widgets.Component)
	 */
	public void init(Component component) {
		// TODO Auto-generated method stub

	}

	public JavaScriptObject getJsObj() {
        return jsObj;
    }
	
	/**
	 * Call this to expand particular row.
	 * 
	 * @param rowIndex
	 */
	public native void expandRow(int rowIndex)/*-{
		var expander = this.@com.gwtextux.client.widgets.grid.plugins.RowExpanderPlugin::getJsObj()();
		expander.expandRow(rowIndex);
	}-*/;
	
	/**
	 * Call this to collapse particular row.
	 * 
	 * @param rowIndex
	 */
	public native void collapseRow(int rowIndex)/*-{
		var expander = this.@com.gwtextux.client.widgets.grid.plugins.RowExpanderPlugin::getJsObj()();
		expander.collapseRow(rowIndex);
	}-*/;
	
	/**
	 * Call this to expand all rows. If you have large grid with many rows it may take a lot of time to expand 
	 * all rows because it creates a new component for each expanded row. Be careful with using this method.
	 * 
	 */
	public native void expandAll()/*-{
		var expander = this.@com.gwtextux.client.widgets.grid.plugins.RowExpanderPlugin::getJsObj()();
		expander.expandAll();
	}-*/;
	
	/**
	 * Call this to collapse all expanded rows.
	 */
	public native void collapseAll()/*-{
		var expander = this.@com.gwtextux.client.widgets.grid.plugins.RowExpanderPlugin::getJsObj()();
		expander.collapseAll();
	}-*/;
}
