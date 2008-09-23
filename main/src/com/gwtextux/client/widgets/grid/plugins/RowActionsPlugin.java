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

import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * This plugin is created from configured column with row actions. You need to first create the column and then 
 * this plugin. This is specific plugin and some attributes don't work. For example you can set 'dataIndex' 
 * attribute for {@code ColumnWithCellActionsConfig} but it will not work as the original JavaScript plugin is
 * configured to work in a column without contents, only icons are there.
 * 
 * See http://rowactions.extjs.eu/ Requires Ext.ux.grid.RowActions.js and Ext.ux.grid.RowActions.css.
 * @author Jozef Sakalos (Original Ext component author)
 * @author Krzysztof (Gwt-Ext-Ux wrapper author)
 */
public class RowActionsPlugin extends ComponentPlugin {
	
	/**
	 * Constructor for {@code RowActionsPlugin} builds this row action from configured column.
	 * 
	 * @param columnConfig the column with configured row actions.
	 */
	public RowActionsPlugin(ColumnWithRowActionsConfig columnConfig) {
		this.setColumnWithRowActions(columnConfig);
	}

	public void init(Component component) {
	}

	/**
	 * Sets column with configured rows for this plugin.
	 * 
	 * @param columnConfig
	 */
	public void setColumnWithRowActions(ColumnWithRowActionsConfig columnConfig){
		jsObj = columnConfig.getJsObj();
	}
}
