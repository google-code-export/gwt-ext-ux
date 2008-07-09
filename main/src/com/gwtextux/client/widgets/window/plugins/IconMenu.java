/**
 * 
 */
package com.gwtextux.client.widgets.window.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * @author Ammar Belakhel
 *
 */
public class IconMenu extends ComponentPlugin {

	/**
	 * 
	 */
	public IconMenu() {
		jsObj = create();
	}
	
	/**
	 * 
	 * @param iconMenuConfig
	 */
	public IconMenu(IconMenuConfig iconMenuConfig) {
		jsObj = create(iconMenuConfig.getJsObj());
	}
	
	/**
	 *
	 * @return
	 */
	protected native JavaScriptObject create() /*-{
		return new $wnd.Ext.ux.IconMenu();
	}-*/;
	
	/**
	 * 
	 * @param cfg
	 * @return
	 */
	protected native JavaScriptObject create(JavaScriptObject cfg) /*-{
		return new $wnd.Ext.ux.IconMenu(cfg);
	}-*/;
	
	/**
	 * @param component
	 */
	@Override
	public void init(Component component) {
	}
}