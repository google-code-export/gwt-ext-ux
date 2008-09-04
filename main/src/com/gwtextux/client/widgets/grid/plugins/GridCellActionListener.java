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
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * This interface defines listener to cell actions in a {@code GridCellAction} plugin.
 * 
 * @author Krzysztof
 */
public interface GridCellActionListener {
	
	/**
	 * The listener method for grid cell action
	 * 
	 * @param grid the {@code GridPanel} that this action is defined for
	 * @param record {@code Record} containing data of clicked cell
	 * @param action Action clicked (equals iconCls);
	 * @param value Value of the clicked cell
	 * @param dataIndex as specified in column model
	 * @param rowIndex Index of row clicked
	 * @param colIndex Index of col clicked
	 * @return this return value is only useful when you specify 'beforeaction' listener, In other cases it is ignored.
	 */
	public boolean execute(GridPanel grid, Record record, String action, Object value, 
			String dataIndex, int rowIndex, int colIndex);

}
