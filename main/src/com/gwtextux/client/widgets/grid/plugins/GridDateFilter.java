package com.gwtextux.client.widgets.grid.plugins;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class GridDateFilter extends GridFilter {
	
	public GridDateFilter(String dataIndex){
		super(dataIndex);
	}
	
	public GridDateFilter(){
		super();
	}
	
	public GridDateFilter(JavaScriptObject jsO){
		super(jsO);
	}
	
	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.filter.DateFilter(configJS);
	}-*/;
	
	/**
	 * Set the date format to use.  By Default: 'm/d/Y'
	 * @param dateFormat the format to use
	 */
	public void setDateFormat(String dateFormat) {
		JavaScriptObjectHelper.setAttribute(configJS, "dateFormat", dateFormat);
	}
	
	/**
	 * Get the date format
	 * @return
	 */
	public String getDateFormat() {
		return JavaScriptObjectHelper.getAttribute(configJS, "dateFormat");
	}
	
    /**
     * Maximum allowable date.
     *
     * @param maxDate the max date
     */
    public void setMaxDate(Date maxDate){
        JavaScriptObjectHelper.setAttribute(configJS, "maxDate", maxDate);
    }

    /**
     * Maximum allowable date.
     *
     * @return the max date
     */
    public Date getMaxDate() {
        return JavaScriptObjectHelper.getAttributeAsDate(configJS, "maxDate");
    }
    
    /**
     * Minimum allowable date.
     *
     * @param minDate the min date
     */
    public void setMinDate(Date minDate){
    	JavaScriptObjectHelper.setAttribute(configJS, "minDate", minDate);
    }

    /**
     * Minimum allowable date.
     *
     * @return the min date
     */
    public Date getMinDate() {
        return JavaScriptObjectHelper.getAttributeAsDate(configJS, "minDate");
    }
    
	/**
	 * Set the text for 'beforeText'. By default 'Before'
	 * @param beforeText
	 */
	public void setBeforeText(String beforeText) {
		JavaScriptObjectHelper.setAttribute(configJS, "beforeText", beforeText);
	}
	
	public String getNoText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "beforeText");
	}
	
	/**
	 * Set the text for 'afterText'. By default 'After'
	 * @param afterText
	 */
	public void setAfterText(String afterText) {
		JavaScriptObjectHelper.setAttribute(configJS, "afterText", afterText);
	}
	
	public String getAfterText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "afterText");
	}
	
	/**
	 * Set the text for 'onText'. By default 'On'
	 * @param onText
	 */
	public void setOnText(String onText) {
		JavaScriptObjectHelper.setAttribute(configJS, "onText", onText);
	}
	
	public String getOnText() {
		return JavaScriptObjectHelper.getAttribute(configJS, "onText");
	}
	
	public native void setValue(Date val) /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		gf.setValue(val);
	}-*/;

	public native Date getValue() /*-{
		var gf = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return gf.getValue();
	}-*/;
}
