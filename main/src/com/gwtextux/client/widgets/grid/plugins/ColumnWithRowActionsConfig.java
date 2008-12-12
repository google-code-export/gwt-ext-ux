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
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.GridEditor;
import com.gwtext.client.widgets.grid.Renderer;

/**
 * The Grid Column with row actions configuration. This is specific class that though it extends {@code ColumnConfig} 
 * some of the {@code ColumnConfig}'s attributes don't work. For example you can set 'dataIndex'  attribute for but 
 * it will not work as the original JavaScript plugin is configured to work in a column without contents, only icons 
 * are there. As a result formating or rendering will not work either for such configured column.
 * 
 * See http://rowactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Krzysztof (Gwt-Ext-Ux wrapper author)
 *
 */
public class ColumnWithRowActionsConfig extends ColumnConfig {
	
	/**
	 * Array holding records of clicked group. This is used in JSNI code.
	 */
	protected static Record[] returnedRecords;
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	protected JavaScriptObject actionListener = JavaScriptObjectHelper.createObject();
	protected JavaScriptObject globalRowListener = JavaScriptObjectHelper.createObject();

	/**
	 * Class constructor.
	 */
	public ColumnWithRowActionsConfig() {
		jsObj = null;
	}

	/**
	 * Creates a new ColumnWithRowActionsConfig.
	 * 
	 * @param header the column header
	 */
	public ColumnWithRowActionsConfig(String header) {
		jsObj = null;
		
		JavaScriptObjectHelper.setAttribute(configJS, "header", header);
	}
	
	/**
	 * Creates a new ColumnWithRowActionsConfig
	 * 
	 * @param header
	 * @param width the column width
	 */
	public ColumnWithRowActionsConfig(String header, int width){
		jsObj = null;
		
		JavaScriptObjectHelper.setAttribute(configJS, "header", header);
	    JavaScriptObjectHelper.setAttribute(configJS, "width", width);
	}

	/**
	 * Creates a new ColumnWithRowActionsConfig
	 * 
	 * @param header
	 * @param width the column width
	 * @param renderer a renderer to allow custom formating of cells of this column
	 */
	public ColumnWithRowActionsConfig(String header, int width, Renderer renderer){
		jsObj = null;
		
		JavaScriptObjectHelper.setAttribute(configJS, "header", header);
	    JavaScriptObjectHelper.setAttribute(configJS, "width", width);
	    this.setRenderer(renderer);
	}
	
	public void setHeader(String header){
		JavaScriptObjectHelper.setAttribute(configJS, "header", header);
	}
	
	public String getHeader(){
		return JavaScriptObjectHelper.getAttribute(configJS, "header");
	}
	
	public void setWidth(int width){
		JavaScriptObjectHelper.setAttribute(configJS, "width", width);
	}
	
	public int getWidth(){
		return JavaScriptObjectHelper.getAttributeAsInt(configJS, "width");
	}
	
	public void setRenderer(Renderer renderer){
		this.setRenderer(configJS, renderer);
	}
	
	public void setRenderer(String renderer){
		JavaScriptObjectHelper.setAttribute(configJS, "renderer", renderer);
	}
	
	/**
     * True to make the column width fixed.
     *
     * @param fixed true for fixed width
     */
    public void setFixed(boolean fixed) {
        JavaScriptObjectHelper.setAttribute(configJS, "fixed", fixed);
    }

	public boolean getFixed() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "fixed");
	}

	/**
     * False to disable column resizing. Defaults to true.
     *
     * @param resizable false to disable column resizing
     */
    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(configJS, "resizable", resizable);
    }

	public boolean getResizable() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "resizable");
	}
	
	/**
     * True if sorting is to be allowed on this column. Defaults to false
     *
     * @param sortable false to disable sorting
     */
    public void setSortable(boolean sortable) {
        JavaScriptObjectHelper.setAttribute(configJS, "sortable", sortable);
    }

	public boolean getSortable() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "sortable");
	}
	
	/**
	 * Sets the editor for a column.
     *
     * @param editor the column editor
     */
    public void setEditor(GridEditor editor) {
        JavaScriptObjectHelper.setAttribute(configJS, "editor", editor.getJsObj());
    }

	/**
     * Assigning id to ColumnConfig results in the column dom element having that ID.
     * This is useful to apply custom css to the entire column. (e.g. .x-grid-col-topic b { color:#333 }) .
     *
     * @param id the column ID
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(configJS, "id", id);
    }

	public String getId() {
		return JavaScriptObjectHelper.getAttribute(configJS, "id");
	}

	/**
     * A text string to use as the column header's tooltip. If Quicktips are enabled, this value will be used as the text
     * of the quick tip, otherwise it will be set as the header's HTML title attribute. Defaults to ''.
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        JavaScriptObjectHelper.setAttribute(configJS, "tooltip", tooltip);
    }

	public String getTooltip() {
		return JavaScriptObjectHelper.getAttribute(configJS, "tooltip");
	}

	/**
     * Sets teh CSS class for the column,
     *
     * @param css the CSS class
     */
    public void setCss(String css) {
        JavaScriptObjectHelper.setAttribute(configJS, "css", css);
    }

	public String getCss() {
		return JavaScriptObjectHelper.getAttribute(configJS, "css");
	}

	/**
     * True to hide the column. Defaults to false.
     *
     * @param hidden true to hide column
     */
    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(configJS, "hidden", hidden);
    }

	public boolean getHidden() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "hidden");
	}

	/**
	 * How to hide hidden icons. Valid values are: visibility and display 
	 * (defaults to visibility). 
	 * 
	 * @param hideMode
	 */
	public void setHideMode(String hideMode){
		JavaScriptObjectHelper.setAttribute(configJS, "hideMode", hideMode);
	}
	
	public String getHideMode(){
		return JavaScriptObjectHelper.getAttribute(configJS, "hideMode");
	}
	
	/**
     * The name of the field in the grid's {@link com.gwtext.client.data.Store}'s {@link com.gwtext.client.data.Record} definition
     * from which to draw the column's value. If not specified, the column's index is used as an index into the Record's data array.
     *
     * @param dataIndex the data index
     */
    public void setDataIndex(String dataIndex) {
//        JavaScriptObjectHelper.setAttribute(configJS, "dataIndex", dataIndex);
    }

	public String getDataIndex() {
		return JavaScriptObjectHelper.getAttribute(configJS, "dataIndex");
	}
	
	/**
	 * Sets the row actions for a column.
	 * 
	 * @param actions
	 */
	public void setRowActions(RowAction[] actions) {
		JavaScriptObject[] config = new JavaScriptObject[actions.length];
		for (int i = 0; i < actions.length; i++) {
			RowAction column = actions[i];
			config[i] = column.getJsObj();
		}
		JavaScriptObject configJSO = JavaScriptObjectHelper.convertToJavaScriptArray(config);
		JavaScriptObjectHelper.setAttribute(this.configJS, "actions", configJSO);
	}

	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}

	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.RowActions(configJS);
	}-*/;
	
	/**
	 * Disables menu for this column.
	 * 
	 * @param menuDisabled
	 */
	public void setMenuDisabled(boolean menuDisabled){
		JavaScriptObjectHelper.setAttribute(configJS, "menuDisabled", menuDisabled);
	}
	
	public boolean getMenuDisabled(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "menuDisabled");
	}
	
	/**
	 * Set true to calculate field width for iconic actions only. Defaults to true.
	 * 
	 * @param autoWidth
	 */
	public void setAutoWidth(boolean autoWidth) {
		JavaScriptObjectHelper.setAttribute(configJS, "autoWidth", autoWidth);
	}

	public boolean getAutoWidth(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "autoWidth");
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
	
	public String getActionEvent(){
		return JavaScriptObjectHelper.getAttribute(configJS, "actionEvent");
	}
	
	/**
	 * Sets group actions for a grouping grid. These actions support static icons, texts and tooltips
	 * same way as actions.
	 * 
	 * @param actions
	 */
	public void setGroupRowActions(GroupAction[] actions){
		JavaScriptObject[] config = new JavaScriptObject[actions.length];
		for (int i = 0; i < actions.length; i++) {
			GroupAction column = actions[i];
			config[i] = column.getJsObj();
		}
		JavaScriptObject configJS = JavaScriptObjectHelper.convertToJavaScriptArray(config);
		JavaScriptObjectHelper.setAttribute(this.configJS, "groupActions", configJS);
	}
	
	/**
	 * Sets global grid row action dynamic icon listener. It is fired when the user clicks dynamically set icon
	 * and the icon name configured in GridPanel store matches {@code cellValue} parameter. This feature can be
	 * used to set changeable icons, and implement something like toggle button.
	 *  
	 * @param cellValue the name of the dynamic icon that the plugin takes form store 
	 * @param listener the listener to launch if the icon with this name will be cliked.
	 */
	public void addGlobalRowListener(String cellValue, RowActionListener listener){
		this.addGlobalCallback(globalRowListener, cellValue, listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "callbacks", globalRowListener);
	}
	
	/**
	 * Adds global 'groupaction' listener, meaning that whatever group icon in the grid you click this listener, 
	 * along with the specific group listener defined will be invoked. It is recommended 
	 * to use this global listener instead of specific group listener. 
	 * 
	 * @param listener
	 */
	public void addGroupActionListener(GroupActionListener listener){
		this.addGroupListener(actionListener, "groupaction", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}
	
	
	/**Adds global 'beforegroupaction' listener, meaning that whatever group icon in the grid you click this listener along 
	 * with the specific group listener defined for the clicked icon will be invoked. But this listener will be 
	 * invoked before 'groupaction' listener. If you return false from the execute() method of this listener then 
	 * 'groupaction' listener will be canceled.
	 * 
	 * @param listener  
	 */
	public void addBeforeGroupActionListener(GroupActionListener listener){
		this.addGroupListener(actionListener, "beforegroupaction", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}
	
	/**
	 * Adds global 'action' listener, meaning that whatever row icon in the grid you click this listener along 
	 * with the row specific listener defined for the clicked icon will be invoked. It is recommended 
	 * to use this global listener instead of cell specific listener. 
	 * 
	 * @param listener
	 */
	public void addActionListener(RowActionListener listener){
		this.addRowListener(actionListener, "action", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}
	
	/**
	 * Adds global 'beforeaction' listener, meaning that whatever row icon in the grid you click this listener along 
	 * with the row specific listener defined for the clicked icon will be invoked. But this listener will be 
	 * invoked before 'action' listener. If you return false from the execute() method of this listener then 
	 * 'action' listener will be canceled. 
	 * 
	 * @param listener
	 */
	public void addBeforeactionListener(RowActionListener listener){
		this.addRowListener(actionListener, "beforeaction", listener);
		
		JavaScriptObjectHelper.setAttribute(configJS, "listeners", actionListener);
	}

	/**
	 * An utility method for setting renderer for this column.
	 * 
	 * @param config the {@code JavaScriptObject} holding configuration options
	 * @param renderer the renderer
	 */
	private native void setRenderer(JavaScriptObject config, Renderer renderer)/*-{
		config['renderer'] = function(val, cell, r, rowIndex, colNum, store) {
            var valJ = (val  == null || val === undefined || val === '') ? null : $wnd.GwtExt.convertToJavaType(val);
            var recJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            var cellJ = @com.gwtext.client.widgets.grid.ColumnModel::createCellMetadata(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
            var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/Object;Lcom/gwtext/client/widgets/grid/CellMetadata;Lcom/gwtext/client/data/Record;IILcom/gwtext/client/data/Store;)(valJ, cellJ, recJ, rowIndex, colNum, storeJ);
        }
	}-*/;
	
	/**
	 * An utility native method that sets 'action' or 'beforeaction' listener.
	 * 
	 * @param action instance of {@code JavaScriptObject} storing listeners for this plugin instance
	 * @param event the type of event, 'action'/'beforeaction'
	 * @param listener the listener that will be invoked
	 */
	private native void addRowListener(JavaScriptObject action, String event, RowActionListener listener)/*-{
		action[event] = function(grid, record, action, rowIndex, colIndex) {
			var g = @com.gwtextux.client.widgets.grid.plugins.RowAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			
			var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);

            return listener.@com.gwtextux.client.widgets.grid.plugins.RowActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;II)(g,r,action,rowIndex,colIndex);
		}
	}-*/;
	
	/**
	 * An utility native method that sets 'groupaction' or 'beforegroupaction' listener.
	 * 
	 * @param action instance of {@code JavaScriptObject} storing listeners for this plugin instance
	 * @param event the type of event, 'groupaction'/'beforegroupaction'
	 * @param listener the listener that will be invoked
	 */
	private native void addGroupListener(JavaScriptObject action, String event, GroupActionListener listener) /*-{
		action[event] = function(grid, records, action, groupId) {
			var g = @com.gwtextux.client.widgets.grid.plugins.GroupAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			
			@com.gwtextux.client.widgets.grid.plugins.ColumnWithRowActionsConfig::createRecordArray(I)(records.length);
			
			for(var i=0; i<records.length; i++){
				var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
				@com.gwtextux.client.widgets.grid.plugins.ColumnWithRowActionsConfig::setRecord(ILcom/gwtext/client/data/Record;)(i,r);
			}
			
			recordArray = @com.gwtextux.client.widgets.grid.plugins.ColumnWithRowActionsConfig::returnedRecords;
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
	 * An utility native method that sets cell value that will be listened if it was clicked.
	 * 
	 * @param action instance of {@code JavaScriptObject} storing global listeners for this plugin instance
	 * @param cellValue the icon's name that will be matched
	 * @param listener the listener that will be invoked if there is a match
	 */
	private native void addGlobalCallback(JavaScriptObject action, String cellValue, RowActionListener listener)/*-{
	action[cellValue] = function(grid, record, action, rowIndex, colIndex) {
		var g = @com.gwtextux.client.widgets.grid.plugins.RowAction::createGrid(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
		
		var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);

       return listener.@com.gwtextux.client.widgets.grid.plugins.RowActionListener::execute(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Record;Ljava/lang/String;II)(g,r,action,rowIndex,colIndex);
	}
  }-*/;
}
