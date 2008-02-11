/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.form;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.form.DateField;

import java.util.Date;

public class FieldTest extends GWTTestCase {
    public String getModuleName() {
        return "com.gwtext.Test";
    }

    public void testDateFieldSetValue() {
        DateField dateField = new DateField();
        dateField.setDisabledDates(new String[]{"0", "4"});
        dateField.setFieldLabel("Sample Date");

        RootPanel.get().add(dateField);

        //Date date = new Date(2007,2 ,3, 4, 5, 6);
        Date date = new Date(2007, 2, 3, 0, 0, 0);
        dateField.setValue(date);

        Date dateVal = dateField.getValue();

        assertEquals(date.getTime(), dateVal.getTime());
    }
}
