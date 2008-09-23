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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * The action to use for row. 
 * 
 * See http://rowactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Krzysztof (Gwt-Ext-Ux wrapper author)
 */
public class RowAction extends JsObject {
	
	/**
	 * Creates new RowAction
	 */
	public RowAction() {
		jsObj = JavaScriptObjectHelper.createObject();
	}

	/**
	 * Creates new RowAction
	 * @param iconCls
	 * icon CSS class
	 */
	public RowAction(String iconCls) {
		this();
		setIconCls(iconCls);
	}

	/**
	 * Constructor that builds statically defined row action. Use it if you want to specify actions 
	 * that will be defined as per cell.
	 * 
	 * @param iconCls icon CSS class
	 * @param tooltip
	 */
	public RowAction(String iconCls, String tooltip) {
		this();
		setIconCls(iconCls);
		if (tooltip != null) {
			setTooltip(tooltip);
		}
	}
	
	
	/**
	 * Constructor that takes {@code RowActionListener} listener. Use it if you want to specify statically 
	 * defined actions that will be defined as per cell.
	 *  
	 * @param iconCls icon CSS class
	 * @param tooltip 
	 * @param listener 
	 */
	public RowAction(String iconCls, String tooltip, RowActionListener listener) {
		this();
		setIconCls(iconCls);
		if (tooltip != null) {
			setTooltip(tooltip);
		}
		if (listener != null) {
			setRowActionListener(listener);
		}

	}

	/**
	 * Constructor that takes {@code RowActionListener} listener. Use it if you want to specify statically 
	 * defined actions that will be defined per as per cell. 
	 * @param listener
	 */
	public RowAction(RowActionListener listener) {
		this();
		if (listener != null) {
			setRowActionListener(listener);
		}
	}
	
	/**
	 * Sets the listener to call if the action icon is clicked in a cell.
	 * This listener works for statically defined actions. Set
	 * global grid row listener configuration option in {@code RowActionsPlugin} 
	 * for dynamic store bound actions. This listener won't work if you set 
	 * dynamic icons and dynamic tooltip for this cell.
	 * 
	 * @param listener the listener to call when an icon is clicked
	 */
	public native void setRowActionListener(RowActionListener listener) /*-{
	var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
		config['callback'] = function(grid, record, action, rowIndex, colIndex) {
			var g = @com.gwtextux.client.widgets.grid.plugins.RowAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			
			var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);

            return listener.@com.gwtextux.client.widgets.grid.plugins.RowActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;II)(g,r,action,rowIndex,colIndex);
        }
	}-*/;
	
	/**
	 * An utility method that is used by the {@code setRowActionListener} to create {@code Grid} from 
	 * JavaScript response. 
	 *  
	 * @param jsObj the JavaScript object representing {@code GridPanel} that was returner from RowActionPlugin. 
	 * @return {@code GridPanel}
	 */
	private static GridPanel createGrid(JavaScriptObject jsObj){
		return new GridPanel(jsObj);
	}

	
	private RowAction(JavaScriptObject jsObj){
		super(jsObj);
	}
	
	/**
	 * Icon index. Optional, however either iconIndex or iconCls must be
	 * configured. Field name of the field of the grid store record that
	 * contains css class of the icon to show. If configured, icons shown can
	 * vary depending of the value of this field.
	 * 
	 * @param iconIndex
	 * icon field name
	 */
	public void setIconIndex(String iconIndex) {
		JavaScriptObjectHelper.setAttribute(jsObj, "iconIndex", iconIndex);
	}

	public String getIconIndex(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "iconIndex");
	}
	
	/**
	 * CSS class of the icon to show. It is ignored if iconIndex is configured.
	 * Use this if you want static icons that are not based on the values in the
	 * record.
	 * 
	 * @param iconCls icon CSS class
	 */
	public void setIconCls(String iconCls) {
		JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
	}

	public String getIconCls(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "iconCls");
	}
	
	/**
	 * Tooltip text to use as icon tooltip. It is ignored if qtipIndex is
	 * configured. Use this if you want static tooltips that are not taken from
	 * the store.
	 * 
	 * @param qtip Tooltip text
	 */
	public void setTooltip(String qtip) {
		JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", qtip);
	}

	public String getTooltip(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "tooltip");
	}
	
	/**
	 * Field name of the field of the grid store record that contains tooltip
	 * text. If configured, the tooltip texts are taken from the store.
	 * 
	 * @param qtipIndex tooltip field name
	 */
	public void setTooltipIndex(String qtipIndex) {
		JavaScriptObjectHelper.setAttribute(jsObj, "qtipIndex", qtipIndex);
	}

	public String getTooltipIndex(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "qtipIndex");
	}
	
	/**
	 * Text to display on the right side of the icon. Use this if you want static text that 
	 * is not taken from record. Ignored if textIndex is set. 
	 * 
	 * @param text
	 */
	public void setText(String text){
		JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
	}
	
	public String getText(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "text");
	}
	
	/**
	 * 
	 * Field name of the field of the grids store record that contains text to display on the 
	 * right side of the icon. If configured, the text shown is taken from record.
	 * 
	 * @param textIndex 
	 */
	public void setTextIndex(String textIndex){
		JavaScriptObjectHelper.setAttribute(jsObj, "textIndex", textIndex);
	}
	
	public String getTextIndex(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "textIndex");
	}
	
	/**
	 * Style to apply to action icon container.
	 * 
	 * @param style style to apply
	 */
	public void setStyle(String style) {
		JavaScriptObjectHelper.setAttribute(jsObj, "style", style);
	}

	public String getStyle(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "style");
	}
	
	/**
	 * True to hide this action while still have a space in the grid column allocated to it. 
	 * IMO, it doesn't make too much sense, use hideIndex instead.
	 * 
	 * @param hide
	 */
	public void setHide(boolean hide){
		JavaScriptObjectHelper.setAttribute(jsObj, "hide", hide);
	}
	
	public boolean getHide(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "hide");
	}
	
	/**
	 * Field name of the field of the grid store record that contains hide flag 
	 * (false [null, '', 0, false, undefined] to show, anything else to hide).
	 * 
	 * @param hideIndex
	 */
	public void setHideIndex(String hideIndex){
		JavaScriptObjectHelper.setAttribute(jsObj, "hideIndex", hideIndex);
	}
	
	public String getHideIndex(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "hideIndex");
	}
}
