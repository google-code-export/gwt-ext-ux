/**
 * 
 */
package com.gwtextux.client.widgets.window.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * @author Ammar Belakhel
 */
public class IconMenu extends ComponentPlugin {

	/**
	 * Creates a new Instance of IconMenu class with default items ['restore', 'minimize', 'maximize', 'separator, 'close'].
	 */
	public IconMenu() {
		jsObj = create();
	}
	
	/**
	 * Creates a new instance of IconMenu class with custom configuration.
	 * @param iconMenuConfig
	 */
	public IconMenu(IconMenuConfig iconMenuConfig) {
		jsObj = create(iconMenuConfig.getJsObj());
	}
	
	/**
	 * Creates a native IconMenu object.
	 * @return
	 */
	protected native JavaScriptObject create() /*-{
		return new $wnd.Ext.ux.IconMenu();
	}-*/;
	
	/**
	 * Creates a native IconMenu object.
	 * @param cfg
	 * @return
	 */
	protected native JavaScriptObject create(JavaScriptObject cfg) /*-{
		return new $wnd.Ext.ux.IconMenu(cfg);
	}-*/;
	
	/**
	 * Returns the xtype of this plugin.
	 * @return
	 */
	public String getXType() {
		return "iconmenu";
	}
	
	/**
	 * @param component
	 */
	@Override
	public void init(Component component) {
	}
}