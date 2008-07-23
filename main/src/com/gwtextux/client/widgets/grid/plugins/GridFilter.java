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
