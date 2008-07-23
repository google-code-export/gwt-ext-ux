package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * This class is a plugin for the Grid widget.
 * This plugin allows filtering on the different
 * columns in the grid.
 * @author mlim1972
 *
 */
public class GridFilterPlugin extends ComponentPlugin {
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	private GridFilter[] filters = null;

	/**
	 * empty constructor... does not do anything but call the super class
	 */
	public GridFilterPlugin(){
		super();
	}
	
	public GridFilterPlugin(GridFilter[] filters){
		super();
		setFilters(filters);
	}
	
	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}

	public JavaScriptObject create(JavaScriptObject configJS){
		if(filters != null && filters.length > 0){
			for (int i = 0; i < filters.length; i++) {
				filters[i].getJsObj();
			}
		}
		return createJ(configJS);
	}
	
	private native JavaScriptObject createJ(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.GridFilters(configJS);
	}-*/;
	
	public void init(Component component) {
	}

	public void setFilters(GridFilter[] filters){
		this.filters = filters;
		JavaScriptObject filterArray = JavaScriptObjectHelper.createJavaScriptArray();
		for (int i = 0; i < filters.length; i++) {
			JavaScriptObjectHelper.setArrayValue(filterArray, i, filters[i].getJsObj());
		}
		JavaScriptObjectHelper.setAttribute(configJS, "filters", filterArray);
	}
	
	// configuration
	
	/**
	 * Number of millisecond to defer store updates since the last filter change.
	 * @param buffer milliseconds to update store; Default: 500
	 */
	public void setUpdateBuffer(int buffer){
		JavaScriptObjectHelper.setAttribute(configJS, "updateBuffer", buffer);
	}
	
	/**
	 * Number of millisecond to defer store updates since the last filter change.
	 * @return milliseconds to update store
	 */
	public int getUpdateBuffer(){
		return JavaScriptObjectHelper.getAttributeAsInt(configJS, "updateBuffer");
	}
	
	/**
	 * Set the url parameter prefix for the filters.
	 * @param paramPrefix prefix for the filters
	 */
	public void setParamPrefix(String paramPrefix){
		JavaScriptObjectHelper.setAttribute(configJS, "paramPrefix", paramPrefix);
	}
	
	/**
	 * Get the url parameter prefix for the filters.
	 * @return url parameter prefix for the filters.
	 */
	public String getParamPrefix(){
		return JavaScriptObjectHelper.getAttribute(configJS, "paramPrefix");
	}
	
	/**
	 * The css class to be applied to column headers that active filters. Defaults to 'ux-filterd-column'
	 * @param fitlerCls 
	 */
	public void setFitlerCls(String fitlerCls){
		JavaScriptObjectHelper.setAttribute(configJS, "fitlerCls", fitlerCls);
	}
	
	/**
	 * Get The css class to be applied to column headers that active filters.
	 * @return The css class to be applied to column headers that active filters.
	 */
	public String getFitlerCls(){
		return JavaScriptObjectHelper.getAttribute(configJS, "fitlerCls");
	}
	
	/**
	 * Set True to use Store filter functions instead of server side filtering.
	 * @param local 
	 */
	public void setLocal(boolean local){
		JavaScriptObjectHelper.setAttribute(configJS, "local", local);
	}
	
	/**
	 * Get True to use Store filter functions instead of server side filtering.
	 * @return True to use Store filter functions instead of server side filtering.
	 */
	public boolean getLocal(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "local");
	}
	
	/**
	 * Set True to automagicly reload the datasource when a filter change happens.
	 * @param autoReload 
	 */
	public void setAutoReload(boolean autoReload){
		JavaScriptObjectHelper.setAttribute(configJS, "autoReload", autoReload);
	}
	
	/**
	 * Get True to automagicly reload the datasource when a filter change happens.
	 * @return True to automagicly reload the datasource when a filter change happens.
	 */
	public boolean getAutoReload(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "autoReload");
	}
	
	
	/**
	 * Set the name of the Store value to be used to store state information.
	 * @param stateId 
	 */
	public void setStateId(String stateId){
		JavaScriptObjectHelper.setAttribute(configJS, "stateId", stateId);
	}
	
	/**
	 * Get the name of the Store value to be used to store state information.
	 * @return The name of the Store value to be used to store state information.
	 */
	public String getStateId(){
		return JavaScriptObjectHelper.getAttribute(configJS, "stateId");
	}
	
	/**
	 * Set True to show the filter menus
	 * @param showMenu 
	 */
	public void setShowMenu(boolean showMenu){
		JavaScriptObjectHelper.setAttribute(configJS, "showMenu", showMenu);
	}
	
	/**
	 * Get True to show the filter menus
	 * @return True to show the filter menus
	 */
	public boolean getShowMenu(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "showMenu");
	}
	
	/**
	 * Set text for the menu filter.  By Default: "Filters"
	 * @param menuFilterText 
	 */
	public void setMenuFilterText(String menuFilterText){
		JavaScriptObjectHelper.setAttribute(configJS, "menuFilterText", menuFilterText);
	}
	
	/**
	 * Get text for the menu filter. 
	 * @return text for the menu filter. 
	 */
	public String getMenuFilterText(){
		return JavaScriptObjectHelper.getAttribute(configJS, "menuFilterText");
	}

	
	// methods
	public native void addFilter(GridFilter filter) /*-{
		var gfp = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gfp.addFilter(filter);
	}-*/;
	
	public GridFilter getFilter(String dataIndex) {
		return new GridFilter(getFilterJ(dataIndex));
	}
	
	private native JavaScriptObject getFilterJ(String dataIndex) /*-{
		var gfp = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gfp.getFilter(dataIndex);
	}-*/;
	
	public native void clearFilters() /*-{
		var gfp = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gfp.clearFilters();
	}-*/;
}
