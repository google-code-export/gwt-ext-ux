package com.gwtextux.client.widgets.combo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.core.SortDir;


public class LovCombo extends ComboBox {

    public static final String DATA_FIELD_DISPLAY = "display";

    public static final String DATA_FIELD_VALUE = "value";

    public static final String DEFAULT_DELIMITER = ",";

    public LovCombo() {
    }


    public String getXType() {
        return "lovcombo";
    }

	/**
	 * Deselects all items. Synonym for clearValue
	 */
	public native void deselectAll() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.deselectAll();
	}-*/;

	/**
	 * Selects all items
	 */
	public native void selectAll() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.selectAll();
	}-*/;

    //-- config options --
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.form.LovCombo(config);
    }-*/;


	/**
	 * The name of field used to store checked state. It is automatically added to existing fields.
	 * Change it only if it collides with your normal field.
	 *
	 * @param checkField the field use to store checked field
	 * @throws IllegalArgumentException
	 */
	public void setCheckField(String checkField) throws IllegalArgumentException {
        setAttribute("checkField", checkField, true);
    }


	/**
	 * The separator to use between values and texts
	 * @param separator the separator to use between values and texts
	 * @throws IllegalArgumentException
	 */
	public void setSeprator(String separator) throws IllegalArgumentException {
        setAttribute("separator", separator, true);
    }

	public void setHideOnSelect(boolean hideOnSelect) throws IllegalArgumentException {
        setAttribute("hideOnSelect", hideOnSelect, true);
    }



}