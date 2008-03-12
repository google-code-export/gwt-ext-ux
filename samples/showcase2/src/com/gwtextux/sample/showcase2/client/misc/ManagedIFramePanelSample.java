/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.misc;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtextux.client.widgets.ManagedIFramePanel;
import com.gwtextux.sample.showcase2.client.SampleData;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class ManagedIFramePanelSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/misc/ManagedIFramePanelSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new FitLayout());

            TabPanel tabPanel = new TabPanel();
            tabPanel.setActiveTab(0);

            final ManagedIFramePanel google = new ManagedIFramePanel("http://www.google.com");

            Panel googlePanel = new Panel("Google");
            googlePanel.setLayout(new FitLayout());
            googlePanel.add(google);
            googlePanel.setTopToolbar(new ToolbarButton("Refresh", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                	google.refresh();
                }
            }));

            Panel staticPanel = new Panel();
            staticPanel.setTitle("News");
            staticPanel.setAutoScroll(true);
            staticPanel.setHtml(SampleData.getBogusMarkup());

            tabPanel.add(googlePanel);
            tabPanel.add(staticPanel);

            panel.add(tabPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This TabPanel demonstrates:</p>" +
                "    <p>" +
                "        - Adding a IFrame Panel to a Tab<br>" +
                "    </p>";
    }
}