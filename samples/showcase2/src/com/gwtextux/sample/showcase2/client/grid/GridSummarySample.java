/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import com.gwtextux.client.widgets.grid.plugins.GridSummaryPlugin;
import com.gwtextux.client.widgets.grid.plugins.SummaryColumnConfig;
import com.gwtextux.sample.showcase2.client.SampleData;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.EditorGridPanel;
import com.gwtext.client.widgets.grid.GridEditor;
import com.gwtext.client.widgets.grid.Renderer;

public class GridSummarySample extends ShowcasePanel {

	private GridSummaryPlugin summaryPlugin;
	
    public String getSourceUrl() {
        return "source/grid/GridSummarySample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
        	panel = new Panel();
            panel.setBorder(false);
            panel.setPaddings(15);

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

            EditorGridPanel grid = new EditorGridPanel();

            Object[][] data = SampleData.getCompanyDataLarge();
            MemoryProxy proxy = new MemoryProxy(data);

            ArrayReader reader = new ArrayReader(recordDef);
            Store store = new Store(proxy, reader);
            store.load();
            grid.setStore(store);

            BaseColumnConfig[] columns = new BaseColumnConfig[]{
            		new SummaryColumnConfig(
                    		SummaryColumnConfig.COUNT,
                    		new ColumnConfig("Company", "company", 200, true, null, "company"),
                    		new Renderer() { // summary renderer
								public String render(Object value, CellMetadata cellMetadata, Record record,
										int rowIndex, int colNum, Store store) {
									if(value != null) {
										int intValue = ((Integer)value).intValue();
										if(intValue == 0 || intValue > 0) {
											return "(" + intValue + " Companies)";
										} else {
											return "(1 Company)";
										}
									} else {
										return "";
									}
								}
                    		}
                    ),
                    new SummaryColumnConfig(
                    		SummaryColumnConfig.SUM,
                    		new ColumnConfig("Price", "price", 75) {
                    			{
                    				setEditor(new GridEditor(new NumberField() {
                    					{
                    						setAllowDecimals(true);
                    					}
                    				}));
                    			}
                    		}
                    ),
                    new SummaryColumnConfig(
                    		SummaryColumnConfig.AVERAGE,
                    		new ColumnConfig("Change", "change", 100),
                    		new Renderer() { // summary renderer
								public String render(Object value, CellMetadata cellMetadata, Record record,
										int rowIndex, int colNum, Store store) {
									return value == null ? "" : ("Average:&#160;" + ((Float)value).floatValue());
								}
                    		}
                    ),
                    new ColumnConfig("% Change", "pctChange", 75)
            };

            ColumnModel columnModel = new ColumnModel(columns);
            grid.setColumnModel(columnModel);

            grid.setFrame(true);
            grid.setStripeRows(true);

            grid.setHeight(350);
            grid.setWidth(400);
            grid.setTitle("Grid with Summary Footer");
            
        	Toolbar topToolbar = new Toolbar();
        	topToolbar.addButton(new ToolbarButton("Toggle Summary", new ButtonListenerAdapter() {
        	    public void onClick(Button button, EventObject e) {
        	    	summaryPlugin.toggleSummary();
        	    }
        	}));
        	topToolbar.addFill();
        	grid.setTopToolbar(topToolbar);
        	
        	summaryPlugin = new GridSummaryPlugin();
        	grid.addPlugin(summaryPlugin);
            
            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates the Grid Summary plugin." +
        		" Notice that the summary follows horizontal scrolling of the grid" +
        		" and that it dynamically updates when prices are edited.";
    }
}