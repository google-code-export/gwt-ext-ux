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
import com.gwtextux.client.widgets.MultiMonthCalendar;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

/**
 * ComboBox with paging dropdown.
 */
public class MultiMonthCalendarSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/widgets/MultiMonthCalendar.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            Panel q = new Panel();
            q.setWidth(600);
            q.setTitle("Multi Calendars");

            Date[] eventDates = new Date[10];
            for (int i = 0; i < eventDates.length; i++)
                eventDates[i] = DateUtil.add(new Date(107, 9, 1), DateUtil.DAY, 5 * i);

            final MultiMonthCalendar mmc = new MultiMonthCalendar();
            mmc.setMinDate(new Date(107, 8, 12));
            mmc.setMaxDate(new Date(108, 2, 2));
//            mmc.setMonthNames(new String[]{"A", "B", "C","A", "B", "C","A", "B", "C","A", "B", "C"});
//            mmc.setDayNames(new String[]{"Q", "W", "E","R", "T", "Y", "u"});
            mmc.setEventDates(eventDates);
            mmc.setDisabledDays(new int[] { 1, 5 });
            mmc.setNoOfMonth(6);
            mmc.setNoOfMonthPerRow(3);
            mmc.setValue(new Date(107, 9, 1));

            Panel r = new Panel();
            r.setBorder(false);
            r.add(mmc);
            q.add(new PaddedPanel(r, 10));
            panel.add(q);
            panel.setBorder(false);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This is an example of a multi month calendar..</p>";
    }
}