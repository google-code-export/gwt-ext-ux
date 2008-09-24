package com.gwtextux.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

public class TimeStrategy extends DateStrategy {

	protected native JavaScriptObject create()/*-{
        return new $wnd.Ext.ux.form.Spinner.TimeStrategy({});
    }-*/;

	/**
	 * Default date.
	 *
	 * @param defaultValue defaults to current date
	 */
	public void setDefaultValue(Date defaultValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultValue", defaultValue);
    }

	/**
	 * The date format.
	 *
	 * @param format default is H:i (eg 17:00)
	 */
	public void setFormat(String format)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "format", format);
    }

	/**
	 * The increment constant.
	 *
	 * ms - milli, s  - second, mi - minute, d - day, mo - month, y - year
	 *
	 *
	 * @param incrementConstant defaults to minute (m)
	 */
	public void setIncrementConstant(String incrementConstant)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "incrementConstant", incrementConstant);
    }

	/**
	 * Alternate increment value.
	 *
	 * @param alternateIncrementValue defaults to 1
	 */
	public void setAlternateIncrementValue(int alternateIncrementValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "alternateIncrementValue", alternateIncrementValue);
    }

	/**
	 * The alternate increment constant.
	 *
	 * ms - milli, s  - second, mi - minute, d - day, mo - month, y - year
	 *
	 *
	 * @param incrementConstant defaults to hour (h)
	 */
	public void setAlternateIncrementConstant(String alternateIncrementConstant)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "alternateIncrementConstant", alternateIncrementConstant);
    }		
}