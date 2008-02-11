/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.combo;


import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtextux.sample.showcase2.client.SampleData;

/**
 * ComboBox with paging dropdown.
 */
public class ComboBoxPagingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/ComboBoxPagingSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            MemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyDataLarge());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("company"),
                            new FloatFieldDef("price"),
                            new FloatFieldDef("change"),
                            new FloatFieldDef("pctChange"),
                            new DateFieldDef("lastChanged", "n/j h:ia")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            ComboBox cb = new ComboBox();
            cb.setMinChars(1);
            cb.setFieldLabel("Company");
            cb.setStore(store);
            cb.setDisplayField("company");
            cb.setMode(ComboBox.REMOTE);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Enter company");
            cb.setLoadingText("Searching...");
            cb.setTypeAhead(true);
            cb.setSelectOnFocus(true);
            cb.setWidth(250);
            cb.setPageSize(10);

            FormPanel form = new FormPanel();
			form.setLabelWidth(70);
			form.setBorder(false);
            form.add(cb);

            panel.add(form);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>In this sample the entries in ComboBox dropdown provide paging capabilities. The page size and display of the entries are fully customizable.</p>" +
                "<p>Data for the CombBox is loaded from a Store which can be populated using local or remote data.</p>";
    }
}