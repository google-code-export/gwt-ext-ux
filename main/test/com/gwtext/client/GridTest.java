/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.utils.EventUtils;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.grid.*;

public class GridTest extends GWTTestCase {

    public String getModuleName() {
        return "com.gwtext.Test";
    }

    public void testGrid() {
        MemoryProxy proxy = new MemoryProxy(SampleData.getArrayGridData());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia")
                }
        );

        //sample test
        Record record = recordDef.createRecord(new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am"});
        ArrayReader reader = new ArrayReader(recordDef);
        //Store store = new Store(proxy, reader, new UrlParam[]{new UrlParam("foo", "1"), new UrlParam("bar", "baz")}, null, false);
        UrlParam[] urlParams = {new UrlParam("foo", "1"), new UrlParam("bar", "baz")};
        Store store = new Store(proxy, reader);
        store.setBaseParams(urlParams);

        UrlParam[] baseParams = store.getBaseParams();
        store.load();


        Record rec1 = store.getAt(0);
        rec1.set("company", "i2");

        Record rec5 = store.getAt(4);
        rec5.set("company", "SAP");

        Record[] modified = store.getModifiedRecords();

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setDataIndex("company");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Price");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("price");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                return null;
                            }

                            public String render(Object value, Record record, int rowIndex, int colNum) {
                                return "$" + value;
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("change");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("% Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("pctChange");
                    }
                }
        });

        GridPanel grid = new GridPanel("grid-example1", 600, 300, store, columnModel);

        EventUtils.sendFocusEvent(grid);
        //store.load();

        Window window = new Window();
        window.add(grid);

        delayTestFinish(10000);
        finishTest();
    }
}
