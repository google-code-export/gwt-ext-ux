/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;

import java.util.Date;

/**
 * @author Michal Bergmann
 * 
 */
public class MultiMonthCalendar extends Component {

    public String getXType() {
        return "mmcalendar";
    }

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
            var c = new $wnd.Ext.ux.MultiMonthCalendar();
            @com.gwtextux.client.widgets.MultiMonthCalendar::configPrototype = c.initialConfig;
        }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
           return new $wnd.Ext.ux.MultiMonthCalendar(config);
       }-*/;

    public void setNoOfMonth(int noOfMonth) {
        setAttribute("noOfMonth", noOfMonth, false);
    }

    public void setValue(Date value) {
        setValueNative(value.getTime());
    }

    private native void setValueNative(double value)/*-{
            var c = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
            c.setValue(new $wnd.Date(value));
        }-*/;

    public Date getValue() {
        return new Date((long)getValueNative());
    }

    private native double getValueNative()/*-{
            var val = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()().getValue();
            return (val == '' || val == null || val === undefined)? -1 : val.getTime();
        }-*/;

    public void setEventDates(Date[] eventDates) {
        setAttribute("eventDates", JavaScriptObjectHelper.convertToJavaScriptArray(eventDates), false);
    }

    /**
     * 
     * @param disabledDays An array of days to disable, 0-based. For example, [0, 6] disables Sunday and Saturday (defaults to null).
     */
    public void setDisabledDays(int[] disabledDays) {
        setAttribute("disabledDays", JavaScriptObjectHelper.convertToJavaScriptArray(disabledDays), false);
    }
    
    /**
     * 
     * @return An array of days to disable, 0-based. For example, [0, 6] disables Sunday and Saturday (defaults to null).
     */
    public int[] getDisabledDays(){
        return JavaScriptObjectHelper.convertToJavaIntArray(getAttributeAsJavaScriptObject("disabledDays"));
    }

    /**
     * @param date Minimum allowable date (JavaScript date object, defaults to null)
     */
    public void setMinDate(Date date) {
        setAttribute("minDate", date, false);
    }

    /**
     * 
     * @param date Maximum allowable date (JavaScript date object, defaults to null)
     */
    public void setMaxDate(Date date) {
        setAttribute("maxDate", date, false);
    }

    protected Date getAttributeAsDate(String attribute) {
        if (isCreated())
            return JavaScriptObjectHelper.getAttributeAsDate(getJsObj(), attribute);
        return JavaScriptObjectHelper.getAttributeAsDate(config, attribute);
    }

    /**
     * 
     * @return Minimum allowable date (JavaScript date object, defaults to null)
     */
    public Date getMinDate() {
        return getAttributeAsDate("minDate");
    }

    /**
     * 
     * @return Maximum allowable date (JavaScript date object, defaults to null)
     */
    public Date getMaxDate() {
        return getAttributeAsDate("maxDate");
    }
    
    /**
     * 
     * @return The error text to display if the minDate validation fails (defaults to "This date is before the minimum date")
     */
    public String getMinText(){
        return getAttribute("minText");
    }
    
    /**
     * 
     * @param minText The error text to display if the minDate validation fails (defaults to "This date is before the minimum date")
     */
    public void setMinText(String minText){
        setAttribute("minText", minText, false);
    }
    
    /**
     * 
     * @return The error text to display if the maxDate validation fails (defaults to "This date is after the maximum date")
     */
    public String getMaxText(){
        return getAttribute("maxText");
    }
    
    /**
     * 
     * @param maxText The error text to display if the maxDate validation fails (defaults to "This date is after the maximum date")
     */
    public void setMaxText(String maxText){
        setAttribute("maxText", maxText, false);
    }
    
    /**
     * 
     * @return The default date format string which can be overriden for localization support.  The format must be valid according to {@link com.gwtext.client.util.DateUtil#parseDate} (defaults to 'm/d/y').
     */
    public String getFormat(){
        return getAttribute("format");
    }
    
    /**
     *     
     * @param format The default date format string which can be overriden for localization support.  The format must be valid according to {@link com.gwtext.client.util.DateUtil#parseDate} (defaults to 'm/d/y').
     */
    public void setFormat(String format){
        setAttribute("format", format, false);
    }
    
    /**
     * 
     * @return The tooltip to display when the date falls on a disabled day (defaults to "")
     */
    public String getDisabledDaysText(){
        return getAttribute("disabledDaysText");
    }
    
    /**
     * 
     * @param disabledDaysText The tooltip to display when the date falls on a disabled day (defaults to "")
     */
    public void setDisabledDaysText(String disabledDaysText){
        setAttribute("disabledDaysText", disabledDaysText, false);
    }
    
    public static native JavaScriptObject createRE(String regexp) /*-{
        return new $wnd.RegExp(regexp);
    }-*/;    
    
    /**
     * 
     * @param disabledDatesRE JavaScript regular expression used to disable a pattern of dates (defaults to null)
     */
    public void setDisabledDatesRE(String disabledDatesRE){
        setAttribute("disabledDatesRE", createRE(disabledDatesRE), false);
    }
    
    /**
     * 
     * @param disabledDatesText The tooltip text to display when the date falls on a disabled date (defaults to "")
     */
    public void setDisabledDatesText(String disabledDatesText){
        setAttribute("disabledDatesText", disabledDatesText, false);
    }
    
    /**
     * 
     * @return The tooltip text to display when the date falls on a disabled date (defaults to "")
     */
    public String getDisabledDatesText(){
        return getAttribute("disabledDatesText");
    }
    
    /**
     * 
     * @param constrainToViewport True to constrain the date picker to the viewport (defaults to true)
     */
    public void setConstrainToViewport(boolean constrainToViewport){
        setAttribute("constrainToViewport", constrainToViewport, false);
    }
    
    /**
     * 
     * @return True to constrain the date picker to the viewport (defaults to true)
     */
    public boolean isConstrainToViewport(){
        return getAttributeAsBoolean("constrainToViewport");
    }
    
    /**
     * 
     * @param monthNames An array of textual day names which can be overriden for localization support (defaults to Date.dayNames)
     */
    public void setMonthNames(String[] monthNames) {
        setAttribute("monthNames", JavaScriptObjectHelper.convertToJavaScriptArray(monthNames), false);
    }
    
    /**
     * 
     * @return An array of textual day names which can be overriden for localization support (defaults to Date.dayNames)
     */
    public String[] getMonthNames() {
        return JavaScriptObjectHelper.convertToJavaStringArray(getAttributeAsJavaScriptObject("monthNames"));
    }
    
    
    /**
     * 
     * @param dayNames An array of textual day names which can be overriden for localization support (defaults to Date.dayNames)
     */
    public void setDayNames(String[] dayNames) {
        setAttribute("dayNames", JavaScriptObjectHelper.convertToJavaScriptArray(dayNames), false);
    }
    
    /**
     * 
     * @return An array of textual day names which can be overriden for localization support (defaults to Date.dayNames)
     */
    public String[] getDayNames() {
        return JavaScriptObjectHelper.convertToJavaStringArray(getAttributeAsJavaScriptObject("dayNames"));
    }    
    
    /**
     * 
     * @param nextText The next month navigation button tooltip (defaults to 'Next Month (Control+Right)')
     */
    public void setNextText(String nextText){
        setAttribute("nextText", nextText, false);
    }
    
    /**
     * 
     * @return The next month navigation button tooltip (defaults to 'Next Month (Control+Right)')
     */ 
    public String getNextText(){
        return getAttribute("nextText");
    }
    
    
    /**
     * 
     * @param prevText The previous month navigation button tooltip (defaults to 'Previous Month (Control+Left)')
     */
    public void setPrevText(String prevText){
        setAttribute("prevText", prevText, false);
    }
    
    /**
     * 
     * @return The previous month navigation button tooltip (defaults to 'Previous Month (Control+Left)')
     */ 
    public String getPrevText(){
        return getAttribute("prevText");
    }
    
    /**
     * 
     * @param startDay Day index at which the week should begin, 0-based (defaults to 0, which is Sunday)
     */
    public void setStartDay(int startDay){
        setAttribute("startDay", startDay, false);
    }
    
    /**
     * 
     * @return Day index at which the week should begin, 0-based (defaults to 0, which is Sunday)
     */
    public int getStartDay(){
        return getAttributeAsInt("startDay");
    }
    
    /**
     * 
     * @param noOfMonthPerRow No. Of Month to be displayed in a row
     */
    public void setNoOfMonthPerRow(int noOfMonthPerRow){
        setAttribute("noOfMonthPerRow", noOfMonthPerRow, false);
    }
    
    /**
     * 
     * @return No. Of Month to be displayed in a row
     */
    public int getNoOfMonthPerRow(){
        return getAttributeAsInt("noOfMonthPerRow");
    }
}
