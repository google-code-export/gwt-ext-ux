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
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.ColumnConfig;

/**
* The Grid Column with row expander configuration. This is specific class that though it extends {@code ColumnConfig} 
* some of the {@code ColumnConfig}'s attributes don't work. For example you can set 'header' attribute but 
* it will not work as the original JavaScript plugin is configured to work in a column without header, only expanding 
* icons are there. As a result formating or rendering will not work either for such configured column. You can get errors
* when you try to set some of the {@code ColumnConfig} attributes. You have been warned. This plugin uses lazy loading for 
* creating expanded content through the use of {@code RowExpanderListener} and caches created component so it is not created
* with every expand action. But is also monitors underlying store object and whenever it is changed then the expanded 
* component is recreated.
* 
* @author Krzysztof (ExtJs JavaScript code and Gwt-Ext-Ux wrapper code author)
*
*/
public class ColumnWithRowExpander extends ColumnConfig {
	
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	protected Store store;
	
	
	/**
	 * Class constructor.
	 */
	public ColumnWithRowExpander(){
		this.jsObj = null;
	}
	
	/**
	 * Creates row expanding column and sets listener that will be called when a row is expanded. You can use it to
	 * load asynchronously data into the component that will be created after expanding row.
	 * 
	 * @param listener
	 */
	public ColumnWithRowExpander(RowExpanderListener listener){
		this.jsObj = null;
		this.setRowExpanderListener(listener);
	}
	
	/**
	 * Sets {@code RowExpanderListener} that will be called when a row is expanded.
	 * 
	 * @param listener
	 */
	public void setRowExpanderListener(RowExpanderListener listener){
		this.addRowExpanderListener(configJS,listener);
	}
	
	/**
	 * Use it if you want to disable caching of the components created when user expanded row. Default value is false 
	 * meaning the component once created when expanded will be reused but if the underlying store which is used by this
	 * expander changes the component is automatically recreated so you don't have to disable caching if the store changes 
	 * frequently in your application.  
	 *  
	 * @param enableCaching true to enable caching (default)
	 */
	public void setEnableCaching(boolean enableCaching){
		JavaScriptObjectHelper.setAttribute(configJS, "enableCaching", enableCaching);
	}
	
	/**
	 * Returns whether caching is enabled.
	 * 
	 * @return
	 */
	public boolean getEnableCaching(){
		return JavaScriptObjectHelper.getAttributeAsBoolean(configJS, "enableCaching");
	}
	
	/**
	 * Sets {@code Store} object that will be used by the expander when expanding. The record object to the listener
	 * will be taken from this store. If you don't specify the store here it will be taken from {@code GridPanel} this
	 * plugin is attached to.
	 * 
	 * @param store
	 */
	public void setStore(Store store){
		JavaScriptObjectHelper.setAttribute(configJS, "store", store.getJsObj());
		this.store = store;
	}
	
	/**
	 * Returns the {@code Store} object that is used by this expander plugin.
	 * 
	 * @return store
	 */
	public Store getStore(){
		if(this.store != null) {
			return this.store;
		} else {
			JavaScriptObject storeJS = JavaScriptObjectHelper.getAttributeAsJavaScriptObject(configJS, "store");
        	return storeJS == null ? null : new Store(storeJS);
		}
	}
	
	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			this.jsObj = create(this.configJS);
		}
		return this.jsObj;
	}

	protected native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.RowExpander(configJS);
	}-*/;
	
	/**
	 * An utility method that sets {@code RowExpanderListener} in order to enable underlying JavaScript to call it.
	 * 
	 * @param config
	 * @param listener
	 */
	protected native void addRowExpanderListener(JavaScriptObject config, RowExpanderListener listener)/*-{
		config['createExpandingRowPanelItems'] = function(grid, store, record, rowIndex){
			var g = @com.gwtext.client.widgets.grid.GridPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(grid);
			var r = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var s = @com.gwtextux.client.widgets.grid.plugins.ColumnWithRowExpander::createStore(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
			
			var component = listener.@com.gwtextux.client.widgets.grid.plugins.RowExpanderListener::onExpand(Lcom/gwtext/client/widgets/grid/GridPanel;Lcom/gwtext/client/data/Store;Lcom/gwtext/client/data/Record;I)(g,s,r,rowIndex); 
			
			return component.@com.gwtext.client.widgets.Component::getOrCreateJsObj()(); 
		}
	}-*/;
	
	protected static Store createStore(JavaScriptObject jsObj){
		return new Store(jsObj);
	}
}
