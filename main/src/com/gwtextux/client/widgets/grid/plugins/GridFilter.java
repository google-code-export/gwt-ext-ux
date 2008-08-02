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
import com.gwtext.client.data.Record;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

public class GridFilter extends ComponentPlugin {
	
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	
	public GridFilter(String dataIndex){
		super();
		
		setDataIndex(dataIndex);
	}
	
	public GridFilter(){
		super();
	}
	public GridFilter(JavaScriptObject jsO){
		jsObj = jsO;
	}
	
	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}
	
	public void init(Component component) {
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.Filter(configJS);
	}-*/;
	
    public native void addListener(GridFilterListener listener) /*-{
	    var filterJ = this;
	
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('activate',
	            function(filter) {
	                listener.@com.gwtextux.client.widgets.grid.plugins.GridFilterListener::onActivate(Lcom/gwtextux/client/widgets/grid/plugins/GridFilter;)(filterJ);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('deactivate',
	            function(filter) {
	                listener.@com.gwtextux.client.widgets.grid.plugins.GridFilterListener::onDeactivate(Lcom/gwtextux/client/widgets/grid/plugins/GridFilter;)(filterJ);
	            }
	    );

	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('update',
	            function(filter) {
	                listener.@com.gwtextux.client.widgets.grid.plugins.GridFilterListener::onUpdate(Lcom/gwtextux/client/widgets/grid/plugins/GridFilter;)(filterJ);
	            }
	    );

//	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('serialize',
//	            function(array, filter) {
//	                listener.@com.gwtextux.client.widgets.grid.plugins.GridFilterListener::onSerialize(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/gwtextux/client/widgets/grid/plugins/GridFilter;)(array, filterJ);
//	            }
//	    );

	}-*/;
    
	public void setDataIndex(String index) {
		JavaScriptObjectHelper.setAttribute(configJS, "dataIndex", index);
	}
	
	/**
	 * Returns true if the filter has enough configuration information to be activated.
	 * 
	 * @return true if the filter can be activated; otherwise, it is false
	 */
//	public native boolean isActivatable() /*-{
//		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
//		return gf.isActivatable();
//	)-*/;
	
	public native void setActive(boolean active, boolean suppressEvent) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gf.setActive(active, suppressEvent);
	}-*/;
	
	public native boolean validateRecord(Record rec) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.validateRecord(rec);	
	}-*/;
}
