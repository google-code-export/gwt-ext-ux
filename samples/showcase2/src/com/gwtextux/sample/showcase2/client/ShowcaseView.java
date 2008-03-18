/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.DataView;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;

public class ShowcaseView extends Panel {

    private ScreenManager screenManager;

    public ShowcaseView(ScreenManager screenManager) {
        this.screenManager = screenManager;
        setBorder(false);
        setLayout(new FitLayout());
        setAutoScroll(true);
    }

    protected void afterRender() {
        final Store store = ScreenManager.getStore();

        XTemplate template = new XTemplate(new String[]{
                "<tpl for='.'>",
                "<tpl if='thumbnail'>",
                "<div id={id}-dv class='thumb-wrap'>",
                "<div class='thumb'><img src='{thumbnail}' ext:qtip='{title}'></div>",
                "<span class='x-editable' ext:qtip='{title}'>{shortTitle}</span></div>",
                "</tpl>",
                "</tpl>",
                "<div class='x-clear'></div>"
        });

        Panel panel = new Panel();
        panel.setId("showcase-view");
        panel.setAutoWidth(true);
        panel.setAutoScroll(true);
        panel.setCollapsible(true);
        panel.setLayout(new FitLayout());
        panel.setTitle("GWT-Ext User Extenstions (UX) Showcase");

        final DataView dataView = new DataView("div.thumb-wrap") {
            public void prepareData(Data data) {
                data.setProperty("shortTitle", Format.ellipsis(data.getProperty("title"), 15));
            }
        };

        dataView.addListener(new DataViewListenerAdapter() {

            public void onClick(DataView source, int index, Element node, EventObject e) {
                String id = DOMUtil.getID(node);
                String screenName = id.substring(0, id.length() - 3);
                Record[] records = store.query("id", screenName);
                Record record = records[0];
                final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");
                if (panel != null) {
                    String title = record.getAsString("title");
                    String icon = record.getAsString("icon");
                    screenManager.showScreen(panel, title, icon, screenName);
                }
            }
        });


        dataView.setTpl(template);
        dataView.setAutoWidth(true);
        dataView.setAutoHeight(true);
        dataView.setMultiSelect(false);
        dataView.setOverCls("x-view-over");
        dataView.setEmptyText("No Images to display");
        panel.add(dataView);

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                dataView.setStore(store);
                dataView.refresh();
            }
        });
        add(panel);
    }

}