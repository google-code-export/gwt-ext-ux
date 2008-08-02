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

import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Grid Cell action configuration.
 * 
 * See http://cellactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Mariusz Pala (GWT-Ext wrapper author)
 * 
 */
public class GridCellAction extends JsObject {

	/**
	 * Creates new GridCellAction
	 */
	public GridCellAction() {
		jsObj = JavaScriptObjectHelper.createObject();
	}

	/**
	 * Creates new GridCellAction
	 * @param iconCls
	 * icon CSS class
	 */
	public GridCellAction(String iconCls) {
		this();
		setIconCls(iconCls);
	}

	/**
	 * Creates new GridCellAction
	 * @param iconCls
	 * icon CSS class
	 * @param tooltip
	 * icon tooltip
	 * @param callback
	 * icon callback functin
	 */
	public GridCellAction(String iconCls, String tooltip, Function callback) {
		this();
		setIconCls(iconCls);
		if (tooltip != null) {
			setTooltip(tooltip);
		}
		if (callback != null) {
			setCallback(callback);
		}

	}

	public void setCallback(Function callback) {
		JavaScriptObjectHelper.setAttribute(jsObj, "callback", callback);
	}

	/**
	 * Icon index. Optional, however either iconIndex or iconCls must be
	 * configured. Field name of the field of the grid store record that
	 * contains css class of the icon to show. If configured, shown icons can
	 * vary depending of the value of this field.
	 * 
	 * @param iconIndex
	 * icon field name
	 */
	public void setIconIndex(String iconIndex) {
		JavaScriptObjectHelper.setAttribute(jsObj, "iconIndex", iconIndex);
	}

	/**
	 * CSS class of the icon to show. It is ignored if iconIndex is configured.
	 * Use this if you want static icons that are not base on the values in the
	 * record.
	 * 
	 * @param iconCls
	 * icon CSS class
	 */
	public void setIconCls(String iconCls) {
		JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
	}

	/**
	 * Tooltip text to use as icon tooltip. It is ignored if qtipIndex is
	 * configured. Use this if you want static tooltips that are not taken from
	 * the store.
	 * @param qtip
	 * Tooltip text
	 */
	public void setTooltip(String qtip) {
		JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
	}

	/**
	 * Field name of the field of the grid store record that contains tooltip
	 * text. If configured, the tooltip texts are taken from the store.
	 * @param qtipIndex
	 * tooltip field name
	 */
	public void setTooltipIndex(String qtipIndex) {
		JavaScriptObjectHelper.setAttribute(jsObj, "qtipIndex", qtipIndex);
	}

	/**
	 * Style to apply to action icon container.
	 * @param style
	 * style to apply
	 */
	public void setStyle(String style) {
		JavaScriptObjectHelper.setAttribute(jsObj, "style", style);
	}

}
