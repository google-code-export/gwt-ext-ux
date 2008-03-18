/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.DateUtil;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.event.FieldListenerAdapter;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.Renderer;
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
        public void load(int start, int limit, String sort, String dir, final JavaScriptObject o, UrlParam[] baseParams) {
            String[][] params = new String[baseParams.length][];
            for (int i = 0; i < baseParams.length; i++)
                params[i] = new String[] { baseParams[i].getName(), baseParams[i].getValue() };
            GwtProxySvc.Util.getInstance().gimmeData(start, limit, sort, dir, params, new AsyncCallback() {
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

			FieldDef[] fieldDefs = new FieldDef[] { new IntegerFieldDef("number_field"), new StringFieldDef("string_field"), new DateFieldDef("date_field", "Y-m-d H:i:s") };
            RecordDef recordDef = new RecordDef(fieldDefs);
            
            final Store store = new Store(new GWTProxyImpl(), new ArrayReader(recordDef), true);
            store.setBaseParams(new UrlParam[]{new UrlParam("paramName", "paramValue")});

            ColumnModel colModel = new ColumnModel(new ColumnConfig[]{
                    new ColumnConfig("Number", "number_field", 140, true),
                    new ColumnConfig("String", "string_field", 140, true),
                    new ColumnConfig("Date", "date_field", 140, true,new Renderer() {
                        public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                            return DateUtil.format((Date) value, "d.m.y H:i");
                        }
                    })
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