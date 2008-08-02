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


public interface GridFilterListener {
	/**
	 * Fires when a inactive filter becomes active
	 * @param filter the GridFilter that it belongs to
	 */
    public void onActivate(GridFilter filter);
    
	/**
	 * Fires when a active filter becomes inactive
	 * @param filter the GridFilter that it belongs to
	 */
    public void onDeactivate(GridFilter filter);

	/**
	 * Fires when a filter configuration has changed
	 * @param filter the GridFilter that it belongs to
	 */
    public void onUpdate(GridFilter filter);

}
