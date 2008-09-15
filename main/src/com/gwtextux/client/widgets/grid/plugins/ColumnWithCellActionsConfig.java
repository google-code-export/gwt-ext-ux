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
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.widgets.grid.plugins.GridCellAction;

/**
 * The Grid Column with cell actions configuration.
 * 
 * See http://cellactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Mariusz Pala (GWT-Ext wrapper author)
 * 
 */
public class ColumnWithCellActionsConfig extends ColumnConfig {

	public ColumnWithCellActionsConfig() {
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex) {
		super(header, dataIndex);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width) {
		super(header, dataIndex, width, false);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable) {
		super(header, dataIndex, width, sortable, null);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 * @param renderer
	 * a renderer to allow custom formating of cells of this column
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable, Renderer renderer) {
		super(header, dataIndex, width, sortable, renderer, null);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 * @param renderer
	 * a renderer to allow custom formating of cells of this column
	 * @param id
	 * the grid ID
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable, Renderer renderer, String id) {
		super(header, dataIndex, width, sortable, renderer, id);
	}

	/**
	 * Disables menu for this column.
	 * 
	 * @param menuDisabled
	 */
	public void setMenuDisabled(boolean menuDisabled){
		JavaScriptObjectHelper.setAttribute(jsObj, "menuDisabled", menuDisabled);
	}
	
	/**
	 * Sets the cell actions for a column.
	 * @param actions
	 */
	public void setCellActions(GridCellAction[] actions) {
		JavaScriptObject[] config = new JavaScriptObject[actions.length];
		for (int i = 0; i < actions.length; i++) {
			GridCellAction column = actions[i];
			config[i] = column.getJsObj();
		}
		JavaScriptObject configJS = JavaScriptObjectHelper.convertToJavaScriptArray(config);
		JavaScriptObjectHelper.setAttribute(jsObj, "cellActions", configJS);
	}

}
