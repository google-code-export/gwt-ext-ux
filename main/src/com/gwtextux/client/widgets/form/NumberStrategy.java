package com.gwtextux.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class NumberStrategy extends SpinnerStrategy {

	protected native JavaScriptObject create()/*-{
        return new $wnd.Ext.ux.form.Spinner.NumberStrategy({});
    }-*/;

	/**
	 * Allow Decimals?
	 *
	 * @param allowDecimals default is true
	 */
	public void setAllowDecimals(boolean allowDecimals)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowDecimals", allowDecimals);
    }

	/**
	 * Set the decimal precision.
	 *
	 * @param decimalPrecision  default is 2
	 */
	public void setAllowDecimals(int decimalPrecision)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "decimalPrecision", decimalPrecision);
    }

}
