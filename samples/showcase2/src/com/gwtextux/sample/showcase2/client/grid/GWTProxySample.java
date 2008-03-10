/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import java.io.Serializable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.ObjectFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtextux.client.data.GWTProxy;
import com.gwtextux.sample.showcase2.client.GwtProxySvc;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class GWTProxySample extends ShowcasePanel {

    public static class MyData implements Serializable{
        public String[][] data;
        public int totalRecords;

        public MyData(String[][] data, int totalRecords) {
            this.data = data;
            this.totalRecords = totalRecords;
        }

        public MyData() {
        }
    }

    public static class GWTProxyImpl extends GWTProxy {
        public void load(int start, int limit, String sort, String dir, final JavaScriptObject o) {
            GwtProxySvc.Util.getInstance().gimmeData(start, limit, sort, dir, new AsyncCallback() {
                public void onFailure(Throwable caught) {
                    loadResponse(o, false, 0, (JavaScriptObject) null);
                }

                public void onSuccess(Object result) {
                    MyData response = (MyData) result;
                    loadResponse(o, true, response.totalRecords, response.data);
                }
            });
        }
    }

    public String getSourceUrl() {
        return null;
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            RecordDef recordDef = new RecordDef(new FieldDef[] { new ObjectFieldDef("number_field"),
                    new ObjectFieldDef("string_field"), new ObjectFieldDef("date_field") });

            final Store store = new Store(new GWTProxyImpl(), new ArrayReader(recordDef), true);

            ColumnModel colModel = new ColumnModel(new ColumnConfig[]{
                    new ColumnConfig("Number", "number_field", 140, true),
                    new ColumnConfig("String", "string_field", 140, true),
                    new ColumnConfig("Date", "date_field", 140, true)
                    });
            
            GridPanel grid = new GridPanel(store, colModel);
            grid.setWidth(500);
            grid.setHeight(400);
            grid.setTitle("Grid that uses GWTProxy to load data from server");

            final PagingToolbar pagingToolbar = new PagingToolbar(store);
            pagingToolbar.setPageSize(15);
            pagingToolbar.setDisplayInfo(true);
            pagingToolbar.setDisplayMsg("Displaying records {0} - {1} of {2}");
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
            store.load(0, pagingToolbar.getPageSize());

            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates loading a Grid with remote data using GWTProxy.";
    }
}