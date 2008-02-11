/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;


import com.gwtextux.sample.showcase2.client.SampleData;
import com.gwtextux.sample.showcase2.client.SampleGrid;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtextux.client.data.PagingMemoryProxy;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.core.EventObject;

public class LocalPagingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/LocalPagingSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            PagingMemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyDataLarge());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("company"),
                            new FloatFieldDef("price"),
                            new FloatFieldDef("change"),
                            new FloatFieldDef("pctChange"),
                            new DateFieldDef("lastChanged", "n/j h:ia"),
                            new StringFieldDef("symbol"),
                            new StringFieldDef("industry")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader, true);


            final GridPanel grid = new SampleGrid();
            grid.setStore(store);
            grid.setWidth(600);
            grid.setHeight(250);
            grid.setTitle("Grid that pages Local / In-Memory data");
            grid.setAutoExpandColumn("pctChange");

            final PagingToolbar pagingToolbar = new PagingToolbar(store);
            pagingToolbar.setPageSize(5);
            pagingToolbar.setDisplayInfo(true);
            pagingToolbar.setDisplayMsg("Displaying companies {0} - {1} of {2}");
            pagingToolbar.setEmptyMsg("No records to display");

            NumberField pageSizeField = new NumberField();
            pageSizeField.setWidth(40);
            pageSizeField.setSelectOnFocus(true);
            pageSizeField.addListener(new FieldListenerAdapter() {
                public void onSpecialKey(Field field, EventObject e) {
                    if (e.getKey() == EventObject.ENTER) {
                        int pageSize = Integer.parseInt(field.getValueAsString());
                        pagingToolbar.setPageSize(pageSize);
                    }
                }
            });

            ToolTip toolTip = new ToolTip("Enter page size");
            toolTip.applyTo(pageSizeField);

            pagingToolbar.addField(pageSizeField);
            grid.setBottomToolbar(pagingToolbar);
            store.load(0, 5);

            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates loading a Grid with local array data and local paging. It also demonstrates how to change " +
                "the page size dymanically. Enter a value in number field on the Paging Toolbar and hit Enter.";
    }
}