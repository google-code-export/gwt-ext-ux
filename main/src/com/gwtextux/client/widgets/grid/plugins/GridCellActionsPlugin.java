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
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * See http://cellactions.extjs.eu/ Requires ext-ux-grid-cellactions.js
 * @author Jozef Sakalos (Original Ext component author)
 * @author Mariusz Pala (GWT-Ext wrapper author)
 * 
 * @author Krzysztof (enhancements author) 
 */
public class GridCellActionsPlugin extends ComponentPlugin {

	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	protected JavaScriptObject actionListener = JavaScriptObjectHelper.createObject();
	protected JavaScriptObject globalGridCellListener = JavaScriptObjectHelper.createObject();

	/**
	 * Constructs a new GridCellActionsPlugin.
	 */
	public GridCellActionsPlugin() {
	}

	/**
	 * Constructor for this class
	 * 
	 * @param align Align Set to 'left' to put action icons before the cell text. (defaults
	 * to undefined, meaning right). Possible options: 'left/right'
	 * @param actionWidth Width of action icon in pixels. Has effect only if align:'left'
	 */
	public GridCellActionsPlugin(String align, String actionWidth) {
		if (align != null) {
			setAlign(align);
		}
		if (actionWidth != null) {
			setActionWidth(actionWidth);
		}
	}

	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}

	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.CellActions(configJS);
	}-*/;

	public void init(Component component) {
	}

	/**
	 * Width of action icon in pixels. Has effect only if align:'left'
	 * @param actionWidth
	 */
	public void setActionWidth(String actionWidth) {
		JavaScriptObjectHelper.setAttribute(configJS, "actionWidth", actionWidth);
	}

	/**
	 * Align Set to 'left' to put action icons before the cell text. (defaults
	 * to undefined, meaning right)
	 * @param align
	 * left/right
	 */
	public void setAlign(String align) {
		JavaScriptObjectHelper.setAttribute(configJS, "align", align);
	}

	/**
	 * Event to trigger actions, e.g. click, dblclick, mouseover (defaults to
	 * 'click'). When user clicks icon the action is invoked, you can change to mouseover, dblcick, etc.
	 * 
	 * @param actionEvent Event to trigger actions
	 */
	public void setActionEvent(String event) {
		JavaScriptObjectHelper.setAttribute(configJS, "actionEvent", event);
	}
	
	/**
	 * Sets global grid cell action dynamic icon listener. It is fired when the user clicks dynamically set icon
	 * and the icon name configured in GridPanel store matches {@code cellValue} parameter. This feature can be
	 * used to set changing icons, and implement something like toggle button.
	 *  
	 * @param cellValue the name of the dynamic icon that the plugin takes form store 
	 * @param listener the listener to launch it the icon with this name will be cliked.
	 */
	public void addGlobalGridCellListener(String cellValue, GridCellActionListener listener){
		this.addGlobalCallback(globalGridCellListener, cellValue, listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "callbacks", globalGridCellListener);
	}
	
	/**
	 * Adds global 'action' listener, meaning that whatever icon in the grid you click this listener along 
	 * with the cell specific listener defined for the clicked icon will be invoked. It is recommended 
	 * to use this global listener instead of cell specific listener. 
	 * 
	 * @param listener
	 */
	public void addActionListener(GridCellActionListener listener){
		this.addGridCellListener(actionListener, "action", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}
	
	/**
	 * Adds global 'beforeaction' listener, meaning that whatever icon in the grid you click this listener along 
	 * with the cell specific listener defined for the clicked cell will be invoked. But this listener will be 
	 * invoked before 'action' listener. If you return false from the execute() method of this listener then 
	 * 'action' listener will be canceled. 
	 * 
	 * @param listener
	 */
	public void addBeforeactionListener(GridCellActionListener listener){
		this.addGridCellListener(actionListener, "beforeaction", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}

	/**
	 * An utility native method that sets 'action' or 'beforeaction' listener.
	 * 
	 * @param action this plugin instance
	 * @param event the type of event, 'action'/'beforeaction'
	 * @param listener the listener that will be invoked
	 */
	private native void addGridCellListener(JavaScriptObject action, String event, GridCellActionListener listener)/*-{
		action[event] = function(grid, record, action, value, dataIndex, rowIndex, colIndex) {
			var g = @com.gwtextux.client.widgets.grid.plugins.GridCellAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			
			var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var v = (value  == null || value === undefined || value == '') ? null : $wnd.GwtExt.convertToJavaType(value);

            return listener.@com.gwtextux.client.widgets.grid.plugins.GridCellActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;II)(g,r,action,v,dataIndex,rowIndex,colIndex);
		}
	}-*/;
	
	/**
	 * An utility native method that sets cell value that will be listened if it was clicked.
	 * 
	 * @param action this plugin instance
	 * @param cellValue the icon's name that will be matched
	 * @param listener the listener that will be invoked if there is a match
	 */
	private native void addGlobalCallback(JavaScriptObject action, String cellValue, GridCellActionListener listener)/*-{
	action[cellValue] = function(grid, record, action, value, dataIndex, rowIndex, colIndex) {
		var g = @com.gwtextux.client.widgets.grid.plugins.GridCellAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
		
		var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
		var v = (value  == null || value === undefined || value == '') ? null : $wnd.GwtExt.convertToJavaType(value);

        return listener.@com.gwtextux.client.widgets.grid.plugins.GridCellActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;II)(g,r,action,v,dataIndex,rowIndex,colIndex);
	}
}-*/;

}
