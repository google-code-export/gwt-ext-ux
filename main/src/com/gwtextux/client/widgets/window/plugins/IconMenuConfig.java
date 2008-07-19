/**
 * 
 */
package com.gwtextux.client.widgets.window.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.Item;

/**
 * @author Ammar Belakhel
 */
public class IconMenuConfig extends JsObject {

	/**
	 * Creates a new instance of IconMenuConfig class.
	 */
	public IconMenuConfig() {
		 jsObj = JavaScriptObjectHelper.createObject();
		 init();
	}
	
	/**
	 * Initializes this component.
	 * @return
	 */
	private native JavaScriptObject init() /*-{
		var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
		if (typeof iconMenuConfigJS['customItems'] == 'undefined') {
			iconMenuConfigJS['customItems'] = new $wnd.Array();
		}
	}-*/;
	
	/**
	 * Attaches a tooltip to the IconMenu instance.
	 * @param toolTipText
	 */
	public native void setTooltip(String toolTipText) /*-{
		var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
		iconMenuConfigJS['qtip'] = toolTipText;
	}-*/;
	
	/**
	 * Adds a separator to the IconMenu instance.
	 */
	public native void addSeparator() /*-{
		var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
		iconMenuConfigJS['customItems'].push('separator');
	}-*/;
	
	/**
	 * Adds a new item to the IconMenu instance.
	 */
	public native void addCustomItem(Item item) /*-{
		if (item != null) {
			var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
			var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
			iconMenuConfigJS['customItems'].push(itemJS);
		}
	}-*/;
	
	/**
	 * 
	 * @param minimizeText
	 */
	public native void setMinimizeText(String minimizeText) /*-{
		if (minimizeText != null && minimizeText != '') {
			var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
			iconMenuConfigJS['minimizeText'] = minimizeText;
		}
	}-*/;
	
	/**
	 * 
	 * @param maximizeText
	 */
	public native void setMaximizeText(String maximizeText) /*-{
		if (maximizeText != null && maximizeText != '') {
			var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
			iconMenuConfigJS['maximizeText'] = maximizeText;
		}
	}-*/;
	
	/**
	 * 
	 * @param restoreText
	 */
	public native void setRestoreText(String restoreText) /*-{
		if (restoreText != null && restoreText != '') {
			var iconMenuConfigJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
			iconMenuConfigJS['restoreText'] = restoreText;
		}
	}-*/;
}