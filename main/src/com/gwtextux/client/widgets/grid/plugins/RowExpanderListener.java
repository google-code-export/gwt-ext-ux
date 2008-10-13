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

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * The listener that will be called when user expands row. Here you create {@code Component} that will be placed
 * in expanded place. You can create panels, grids and other components with static data taken from underlying grid's
 * store or you can even load data asynchronously and populate the component with this data.
 * 
 * @author Krzysztof (ExtJs JavaScript code and Gwt-Ext-Ux wrapper code author)
 *
 */
public interface RowExpanderListener {

	/**
	 * The method that will be called when used expands a row.
	 * 
	 * @param grid the {@code GridPanel} that this expander is attached to.
	 * @param store the underlying store object that this expander is bound to 
	 * @param record the record from the bound store object that was clicked.
	 * @param rowIndex the row index that was clicked.
	 * 
	 * @return the {@code Component} that will be placed on expanded row.
	 */
	public Component onExpand(GridPanel grid, Store store, Record record, int rowIndex);
}
