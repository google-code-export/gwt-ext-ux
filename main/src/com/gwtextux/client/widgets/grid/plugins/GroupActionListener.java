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
 * This interface defines listener for row group actions in a {@code GridRowListener} plugin.
 * 
 * See http://rowactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Krzysztof (Gwt-Ext-Ux wrapper author)
 *
 */
public interface GroupActionListener {

	/**
	 * The listener method for grid cell action
	 * 
	 * @param grid the {@code GridPanel} this plugin is defined for
	 * @param records Array of records in this group 
	 * @param {String} action Identifies the action icon clicked. Equals to icon css class name. 
	 * @param {String} groupId Identifies the group clicked 
	 * @return this return value is only useful when you specify 'beforegroupaction' listener, In other cases it is ignored.
	 */
	public boolean execute(GridPanel grid, Record[] records, String action, String groupId);
}
