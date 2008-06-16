package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * See http://cellactions.extjs.eu/ Requires ext-ux-grid-cellactions.js
 * @author Jozef Sakalos (Original Ext component author)
 * @author Mariusz Pala (GWT-Ext wrapper author)
 */
public class GridCellActionsPlugin extends ComponentPlugin {

	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();

	/**
	 * Constructs a new GridCellActionsPlugin.
	 */
	public GridCellActionsPlugin() {
	}

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
	 * 'click')
	 * @param actionEvent
	 * Event to trigger actions
	 */
	public void setActionEvent(String event) {
		JavaScriptObjectHelper.setAttribute(configJS, "event", event);
	}
}
