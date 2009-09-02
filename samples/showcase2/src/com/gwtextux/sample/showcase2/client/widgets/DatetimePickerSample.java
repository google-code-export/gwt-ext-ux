/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.widgets;


import java.util.Date;

import com.gwtext.client.util.DateUtil;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtextux.client.widgets.DatetimePicker;
import com.gwtextux.client.widgets.MultiMonthCalendar;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
/**
 * A DatetimePicker Sample
 * 
 * by Henry Chan
 * hchan@apache.org
 * Sep/2009
 */
public class DatetimePickerSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/widgets/DatetimePicker.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
          
            panel.add(new DatetimePicker());
            panel.setBorder(false);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This is an example of a DatetimePicker</p>";
    }
}