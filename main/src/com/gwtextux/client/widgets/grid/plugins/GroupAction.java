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
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.GridPanel;

/**
 * 
 * The action to use for group headers of grouping grids. These actions support static icons, texts 
 * and tooltips same way as standard actions.
 * 
 * See http://rowactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Krzysztof (Gwt-Ext-Ux wrapper author)
 *
 */
public class GroupAction extends JsObject {
	
	/**
	 * Array holding records of clicked group. This is used in JSNI code.
	 */
	private static Record[] returnedRecords;
	
	/**
	 * Creates new GroupAction
	 */
	public GroupAction() {
		jsObj = JavaScriptObjectHelper.createObject();
	}

	/**
	 * Creates new GroupAction
	 * 
	 * @param iconCls
	 * icon CSS class
	 */
	public GroupAction(String iconCls) {
		this();
		setIconCls(iconCls);
	}

	/**
	 * Constructor that builds statically defined group action. Use it if you want to specify actions 
	 * that will be defined as per group.
	 * 
	 * @param iconCls icon CSS class
	 * @param tooltip
	 */
	public GroupAction(String iconCls, String tooltip) {
		this();
		setIconCls(iconCls);
		if (tooltip != null) {
			setTooltip(tooltip);
		}
	}
	
	
	/**
	 * Constructor that takes {@code GroupRowActionListener} listener. Use it if you want to specify statically 
	 * defined actions that will be defined as per group.
	 *  
	 * @param iconCls icon CSS class
	 * @param tooltip 
	 * @param listener 
	 */
	public GroupAction(String iconCls, String tooltip, GroupActionListener listener) {
		this();
		setIconCls(iconCls);
		if (tooltip != null) {
			setTooltip(tooltip);
		}
		if (listener != null) {
			setGroupActionListener(listener);
		}

	}

	/**
	 * Constructor that takes {@code GroupRowActionListener} listener. Use it if you want to specify statically 
	 * defined actions that will be defined per as per group. 
	 * 
	 * @param listener
	 */
	public GroupAction(GroupActionListener listener) {
		this();
		if (listener != null) {
			setGroupActionListener(listener);
		}
	}
	
	/**
	 * Sets the listener to call if the action icon is clicked in a cell.
	 * This listener works for statically defined actions. Set
	 * global grid cell listener configuration option in {@code GroupRowActionsPlugin} 
	 * for dynamic store bound actions. This listener won't work if you set 
	 * dynamic icons and dynamic tooltip for this cell.
	 * 
	 * @param listener the listener to call when an icon is clicked
	 */
	public native void setGroupActionListener(GroupActionListener listener) /*-{
	var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
		config['callback'] = function(grid, records, action, groupId) {
			var g = @com.gwtextux.client.widgets.grid.plugins.GroupAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			
			@com.gwtextux.client.widgets.grid.plugins.GroupAction::createRecordArray(I)(records.length);
			
			for(var i=0; i<records.length; i++){
				var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
				@com.gwtextux.client.widgets.grid.plugins.GroupAction::setRecord(ILcom/gwtext/client/data/Record;)(i,r);
			}
			
			recordArray = @com.gwtextux.client.widgets.grid.plugins.GroupAction::returnedRecords;
            return listener.@com.gwtextux.client.widgets.grid.plugins.GroupActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;[Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/String;)(g,recordArray,action,groupId);
        }
	}-*/;
		
	/**
	 * An utility method used to create Java Record array from JavaScript array.
	 * 
	 * @param length the length of an array that was returned from plugin
	 */
	private static void createRecordArray(int length){
		returnedRecords = new Record[length];
	} 
	
	/**
	 * An utility method used to set Java Record array elements from JavaScript array.
	 * 
	 * @param position
	 * @param record
	 */
	private static void setRecord(int position, Record record){
		returnedRecords[position] = record;
	}
	
	/**
	 * Icon index. Optional, however either iconIndex or iconCls must be
	 * configured. Field name of the field of the grid store record that
	 * contains css class of the icon to show. If configured, shown icons can
	 * vary depending of the value of this field in the underlying store.
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
	 * Use this if you want static icons that are not base on the values in the
	 * record.
	 * 
	 * @param iconCls
	 * icon CSS class
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
	 * @param qtip
	 * Tooltip text
	 */
	public void setTooltip(String qtip) {
		JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
	}

	public String getTooltip(){
		return JavaScriptObjectHelper.getAttribute(jsObj , "qtip");
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

	public String getTooltipIndex(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "qtipIndex");
	}
	/**
	 * Text to display on the right side of the icon. Use this 
	 * if you want static text that are not taken from record. Ignored if textIndex is set.
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
	 * Field name of the field of the grids store record 
	 * that contains text to display on the right side of the icon. If configured, the text 
	 * shown is taken from record. 
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
	 * @param style
	 * style to apply
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
	
	/**
	 * Set it to 'left' to place action icon next to the group header text.
	 * (defaults to undefined = icons are placed at the right side of the group header.
	 * 
	 * @param align
	 */
	public void setAlign(TextAlign align){
		JavaScriptObjectHelper.setAttribute(jsObj, "align", align.getPosition());
	}
	
	public String getAlign(){
		return JavaScriptObjectHelper.getAttribute(jsObj, "align");
	}
	
	/**
	 * An utility method that is used by the {@code setGroupRowActionListener} to create {@code Grid} from 
	 * JavaScript response. 
	 *  
	 * @param jsObj the JavaScript object representing {@code GridPanel} that was returner from GroupRowActionPlugin. 
	 * @return {@code GridPanel}
	 */
	private static GridPanel createGrid(JavaScriptObject jsObj){
		return new GridPanel(jsObj);
	}

	
	private GroupAction(JavaScriptObject jsObj){
		super(jsObj);
	}

}
