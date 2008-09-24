package com.gwtextux.client.widgets.form;

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


public class Spinner extends ComboBox {

    public Spinner() {
    }


    public String getXType() {
        return "uxspinner";
    }



    //-- config options --
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.form.Spinner(config);
    }-*/;


	/**
	 * The name of field used to store checked state. It is automatically added to existing fields.
	 * Change it only if it collides with your normal field.
	 *
	 * @param checkField the field use to store checked field
	 */
	public void setStrategy(SpinnerStrategy strategy)  {
        setAttribute("strategy", strategy.getJsObj(), true, true);
    }

}