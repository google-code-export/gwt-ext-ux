package com.gwtextux.client.widgets.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.core.SortDir;


public class MultiSelect extends Field {

    public static final String DATA_FIELD_DISPLAY = "display";

    public static final String DATA_FIELD_VALUE = "value";

    public MultiSelect() {
    }
    
    public MultiSelect(String fieldLabel) {
        setFieldLabel(fieldLabel);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

     public MultiSelect(String fieldLabel, String name) {
        setFieldLabel(fieldLabel);
        setName(name);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

     public MultiSelect(String fieldLabel, String name, int width) {
        setFieldLabel(fieldLabel);
        setName(name);
        setWidth(width);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

     public MultiSelect(String fieldLabel, String name, int width,
           Object[][] data) {
        setFieldLabel(fieldLabel);
        setName(name);
        setWidth(width);
        setData(data);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

     public MultiSelect(String fieldLabel, String name, int width, int height) {
        setFieldLabel(fieldLabel);
        setName(name);
        setWidth(width);
        setHeight(height);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

     public MultiSelect(String fieldLabel, String name, int width, int height,
           Object[][] data) {
        setFieldLabel(fieldLabel);
        setName(name);
        setWidth(width);
        setHeight(height);
        setData(data);

        setDataFields(new String[] { DATA_FIELD_VALUE, DATA_FIELD_DISPLAY });
        setValueField(DATA_FIELD_VALUE);
        setDisplayField(DATA_FIELD_DISPLAY);
     }

    public String getXType() {
        return "multiselect";
    }

    public native String getValue(String valueField) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = field.getValue(valueField);
		return val === undefined || val == null ? null : val.toString();
	}-*/;

    public native String getValue() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = field.getValue();
		return val === undefined || val == null ? null : val.toString();
	}-*/;

    public native void setValue(String values) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.setValue(values);
	}-*/;

    public native void reset() /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        field.reset();
	}-*/;

    //-- config options --
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.Multiselect(config);
    }-*/;


    public void setStore(Store store) throws IllegalArgumentException {
        setAttribute("store", store.getJsObj(), true);
    }

    public void setDataFields(String[] dataFields) throws IllegalArgumentException {
        setAttribute("dataFields", dataFields, true);
    }

    public void setData(Object[][] data) throws IllegalArgumentException {
        setAttribute("data", JavaScriptObjectHelper.convertToJavaScriptArray(data), true);
    }

    public void setDisplayField(int displayField) throws IllegalArgumentException {
        setAttribute("displayField", displayField, true);
    }

    public void setDisplayField(String displayField) throws IllegalArgumentException {
        setAttribute("displayField", displayField, true);
    }

    public void setValueField(int valueField) throws IllegalArgumentException {
        setAttribute("valueField", valueField, true);
    }

    public void setValueField(String valueField) throws IllegalArgumentException {
        setAttribute("valueField", valueField, true);
    }

    public void setAllowBlank(boolean allowBlank) throws IllegalArgumentException {
        setAttribute("allowBlank", allowBlank, true);
    }

    public void setMinLength(int minLength) throws IllegalArgumentException {
        setAttribute("minLength", minLength, true);
    }

    public void setMaxLength(int maxLength) throws IllegalArgumentException {
        setAttribute("maxLength", maxLength, true);
    }

    public void setBlankText(String blankText) throws IllegalArgumentException {
        setAttribute("blankText", blankText, true);
    }

    public void setMinLengthText(String minLengthText) throws IllegalArgumentException {
        setAttribute("minLengthText", minLengthText, true);
    }

    public void setMaxLengthText(String maxLengthText) throws IllegalArgumentException {
        setAttribute("maxLengthText", maxLengthText, true);
    }

    public void setCopy(boolean copy) throws IllegalArgumentException {
        setAttribute("copy", copy, true);
    }

    public void setAllowDup(boolean allowDup) throws IllegalArgumentException {
        setAttribute("allowDup", allowDup, true);
    }

    public void setAllowTrash(boolean allowTrash) throws IllegalArgumentException {
        setAttribute("allowTrash", allowTrash, true);
    }

    public void setLegend(String legend) throws IllegalArgumentException {
        setAttribute("legend", legend, true);
    }

    public void setFocusClass(String focusClass) throws IllegalArgumentException {
        setAttribute("focusClass", focusClass, true);
    }

    public void setDelimiter(String delimiter) throws IllegalArgumentException {
        setAttribute("delimiter", delimiter, true);
    }

    public void setDragGroup(String dragGroup) throws IllegalArgumentException {
        setAttribute("dragGroup", dragGroup, true);
    }

    public void setDropGroup(String dropGroup) throws IllegalArgumentException {
        setAttribute("dropGroup", dropGroup, true);
    }

    public void setToolbar(Toolbar toolbar) throws IllegalArgumentException {
        setAttribute("tbar", toolbar.getOrCreateJsObj(), true);
    }

    public void setAppendOnly(boolean appendOnly) throws IllegalArgumentException {
        setAttribute("appendOnly", appendOnly, true);
    }

    public void setSortField(String sortField) throws IllegalArgumentException {
        setAttribute("sortField", sortField, true);
    }

    public void setSortDir(SortDir sortDir) throws IllegalArgumentException {
        setAttribute("sortDir", sortDir.getDirection(), true);
    }
    
    private String getDelimiter() throws IllegalArgumentException {
    	return getAttribute("delimiter");
    }
    
    public List getValueAsList() {
       List ret = new ArrayList();
       String value = getValue();
       if (value != null && "".equals(value) == false) {
          String[] arr = value.split(getDelimiter());
          return Arrays.asList(arr);
       }
       return ret;
    }


}
