/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;


import java.util.Date;

import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SortState;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.DateUtil;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.data.BufferedJsonReader;
import com.gwtextux.client.data.BufferedStore;
import com.gwtextux.client.widgets.BufferedGridToolbar;
import com.gwtextux.client.widgets.grid.BufferedGridView;
import com.gwtextux.client.widgets.grid.BufferedRowSelectionModel;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class LiveGridSample extends ShowcasePanel {

    public String getSourceUrl() {
        return null;
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            FieldDef[] fieldDefs = new FieldDef[] { new IntegerFieldDef("number_field"),
                    new StringFieldDef("string_field"), new StringFieldDef("date_field") };
            RecordDef recordDef = new RecordDef(fieldDefs);

            BufferedJsonReader reader = new BufferedJsonReader("response.value.items", recordDef);
            reader.setVersionProperty("response.value.version");
            reader.setTotalProperty("response.value.total_count");
            reader.setId("id");

            BufferedStore store = new BufferedStore(reader);
            store.setAutoLoad(true);
            store.setBufferSize(300);
            store.setSortInfo(new SortState("number_field", SortDir.ASC));
            store.setUrl("LiveGridDataProxy");

            BufferedGridView view = new BufferedGridView();
            view.setLoadMask("Wait ...");
            view.setNearLimit(100);

            BufferedGridToolbar toolbar = new BufferedGridToolbar(view);
            toolbar.setDisplayInfo(true);

            BufferedRowSelectionModel brsm = new BufferedRowSelectionModel();

            GridPanel grid = new GridPanel(store, createColModel());
            grid.setEnableDragDrop(false);
            grid.setSelectionModel(brsm);
            grid.setView(view);
            grid.setBottomToolbar(toolbar);
            grid.setWidth(400);
            grid.getView().setAutoFill(true);
            grid.getView().setForceFit(true);

            panel.add(grid);
        }

        return panel;
    }
    
    private static String ns(int n, int d){
    	String s=Integer.toString(n);
    	while(s.length()<d)
    		s="0"+s;
    	return s;
    }
    
    private static String formatDate(Date d){
    	return ns(d.getDate(), 2)+"."+ns(d.getMonth() + 1, 2)+"."+ns(d.getYear() + 1900, 4)+" "+ns(d.getHours(), 2)+ ":"+ns(d.getMinutes(), 2); 
    }

    static ColumnModel createColModel() {
        ColumnConfig columnConfig3 = new ColumnConfig("Date", "date_field");
        columnConfig3.setRenderer(new Renderer() {
            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum,
                    Store store) {
            	if (value == null)
            		return "NULL";
            	return formatDate(new Date((long)Double.parseDouble((String)value)));
            }
        });
        ColumnModel colModel = new ColumnModel(new ColumnConfig[] { new ColumnConfig("Number", "number_field"),
                new ColumnConfig("String", "string_field"), columnConfig3 });
        for (int i = 0; i < colModel.getColumnConfigs().length; i++)
            ((ColumnConfig) colModel.getColumnConfigs()[i]).setSortable(true);
        return colModel;
    }

    public String getIntro() {
        return "This example demonstrates LiveGrid. The component allows to read chunks of data from an underlying storage (common use case: a database) without the need of paging";
    }
}