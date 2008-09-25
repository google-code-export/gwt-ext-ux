/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.BooleanFieldDef;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.GroupingStore;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SortState;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GroupingView;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.widgets.grid.plugins.ColumnWithRowActionsConfig;
import com.gwtextux.client.widgets.grid.plugins.GroupAction;
import com.gwtextux.client.widgets.grid.plugins.GroupActionListener;
import com.gwtextux.client.widgets.grid.plugins.RowAction;
import com.gwtextux.client.widgets.grid.plugins.RowActionListener;
import com.gwtextux.client.widgets.grid.plugins.RowActionsPlugin;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class RowActionsSample extends ShowcasePanel {

	public String getSourceUrl() {
        return "source/grid/RowActionsSample.java.html";
    }
	
	/* (non-Javadoc)
	 * @see com.gwtextux.sample.showcase2.client.ShowcasePanel#getViewPanel()
	 */
	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBorder(false);
			panel.setPaddings(15);

			RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("icon"), new BooleanFieldDef("hide"),
					new StringFieldDef("company"),
					new FloatFieldDef("price"), new FloatFieldDef("change"), new FloatFieldDef("pctChange"), 
					new DateFieldDef("lastChanged", "n/j h:ia"), new StringFieldDef("symbol"), new StringFieldDef("industry"), 
					new StringFieldDef("action") });

			GridPanel grid = new GridPanel();

			Object[][] data = this.getGridCellActionData();
			MemoryProxy proxy = new MemoryProxy(data);

			ArrayReader reader = new ArrayReader(recordDef);
			GroupingStore store = new GroupingStore(proxy, reader);
			store.setSortInfo(new SortState("industry", SortDir.ASC));
			store.setGroupField("industry");
			store.load();
			grid.setStore(store);

			final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");
			
			RowAction dynamicRowAction = new RowAction();
			dynamicRowAction.setIconIndex("icon");
			dynamicRowAction.setTooltip("dynamic");
			
			RowAction hiddenRowAction = new RowAction("progressbar-nav-icon", "Progressbar");
			hiddenRowAction.setHideIndex("hide");
			ColumnWithRowActionsConfig actionsColumn = new ColumnWithRowActionsConfig("Actions");
			actionsColumn.setRowActions(new RowAction[] { new RowAction("mask-nav-icon","Mask"), 
					hiddenRowAction, dynamicRowAction});
			
			GroupAction groupAction = new GroupAction("dataview-nav-icon", "Data view");
			groupAction.setAlign("left");
			
			actionsColumn.setGroupRowActions(new GroupAction[] {groupAction, new GroupAction("windows-category-icon", "Some icon")});
			actionsColumn.addGroupActionListener(new GroupActionListener(){
				public boolean execute(GridPanel grid, Record[] records, String action,
						String groupId) {
					MessageBox.alert("Group icon", "Number of records: " + records.length + "; grid title: " + grid.getTitle());
					return false;
				}
			});
			
			actionsColumn.addActionListener(new RowActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						 int rowIndex, int colIndex) {
					MessageBox.alert("Callback", "Row: " + rowIndex + "; grid title: " + grid.getTitle() + "; record value: " + 
							record.getAsString("company"));
					return true;
				}
			});
			
			actionsColumn.addGlobalRowListener("pie-chart-icon", new RowActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						int rowIndex, int colIndex) {
					record.set("icon", "line-chart-icon");
					return false;
				}
			});
			
			actionsColumn.addGlobalRowListener("line-chart-icon", new RowActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						int rowIndex, int colIndex) {
					record.set("icon", "pie-chart-icon");
					return false;
				}
			});
			
			BaseColumnConfig[] columns = new BaseColumnConfig[] { new ColumnConfig("Company", "company", 55),
					new ColumnConfig("Industry", "industry", 55),
					new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {
						public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, 
								int colNum, Store store) {
							Date date = (Date) value;
							return dateFormatter.format(date);
						}
					}), actionsColumn};

			ColumnModel columnModel = new ColumnModel(columns);
			grid.setColumnModel(columnModel);

			GroupingView applicationGroupingView = new GroupingView();
			applicationGroupingView.setForceFit(true);
			applicationGroupingView.setScrollOffset(10);
			applicationGroupingView.setGroupTextTpl(
					("{text} ({[values.rs.length]} {[values.rs.length > 1 ? \"Items\" : \"Item\"]})"));
			
			grid.setView(applicationGroupingView);
			grid.setFrame(true);
			grid.setStripeRows(true);

			grid.setHeight(350);
			grid.setWidth(500);
			grid.setTitle("Grid with CellActions");

			RowActionsPlugin rowActionsPlugin = new RowActionsPlugin(actionsColumn);
			
			grid.addPlugin(rowActionsPlugin);

			panel.add(grid);
		}

		return panel;
	}
	
	public String getIntro() {
		return "This example demonstrates the Row Actions plugin <br/>" +
				"<p>This sample and wrapper was added by <b>Krzysztof</b></p>";
	}

	private Object[][] getGridCellActionData(){
		Object[][] companyData = null;
	      if (companyData == null) {
	          companyData = new Object[][]{
	        		  new Object[]{"pie-chart-icon", new Boolean(false), "3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false), "Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", "AA", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true), "Altria Group Inc", new Double(83.81), new Double(0.28), new Double(0.34), "9/1 12:00am", "MO", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false), "American Express Company", new Double(52.55), new Double(0.01), new Double(0.02), "9/1 12:00am", "AXP", "Finance", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "American International Group, Inc.", new Double(64.13), new Double(0.31), new Double(0.49), "9/1 12:00am", "AIG", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "AT&T Inc.", new Double(31.61), new Double(-0.48), new Double(-1.54), "9/1 12:00am", "T", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Boeing Co.", new Double(75.43), new Double(0.53), new Double(0.71), "9/1 12:00am", "BA", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Caterpillar Inc.", new Double(67.27), new Double(0.92), new Double(1.39), "9/1 12:00am", "CAT", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true), "Citigroup, Inc.", new Double(49.37), new Double(0.02), new Double(0.04), "9/1 12:00am", "C", "Finance", "Stop"},
	                  new Object[]{"line-chart-icon", new Boolean(false),  "E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing", "Stop"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Exxon Mobil Corp", new Double(68.1), new Double(-0.43), new Double(-0.64), "9/1 12:00am", "XOM", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "General Electric Company", new Double(34.14), new Double(-0.08), new Double(-0.23), "9/1 12:00am", "GE", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "General Motors Corporation", new Double(30.27), new Double(1.09), new Double(3.74), "9/1 12:00am", "GM", "Automotive", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Hewlett-Packard Co.", new Double(36.53), new Double(-0.03), new Double(-0.08), "9/1 12:00am", "HPQ", "Computer", "Stop"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Honeywell Intl Inc", new Double(38.77), new Double(0.05), new Double(0.13), "9/1 12:00am", "HON", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Intel Corporation", new Double(19.88), new Double(0.31), new Double(1.58), "9/1 12:00am", "INTC", "Computer", "Stop"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "International Business Machines", new Double(81.41), new Double(0.44), new Double(0.54), "9/1 12:00am", "IBM", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Johnson & Johnson", new Double(64.72), new Double(0.06), new Double(0.09), "9/1 12:00am", "JNJ", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "JP Morgan & Chase & Co", new Double(45.73), new Double(0.07), new Double(0.15), "9/1 12:00am", "JPM", "Finance", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "McDonald\"s Corporation", new Double(36.76), new Double(0.86), new Double(2.40), "9/1 12:00am", "MCD", "Food", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "Merck & Co., Inc.", new Double(40.96), new Double(0.41), new Double(1.01), "9/1 12:00am", "MRK", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Microsoft Corporation", new Double(25.84), new Double(0.14), new Double(0.54), "9/1 12:00am", "MSFT", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Pfizer Inc", new Double(27.96), new Double(0.4), new Double(1.45), "9/1 12:00am", "PFE", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "The Coca-Cola Company", new Double(45.07), new Double(0.26), new Double(0.58), "9/1 12:00am", "KO", "Food", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "The Home Depot, Inc.", new Double(34.64), new Double(0.35), new Double(1.02), "9/1 12:00am", "HD", "Retail", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "The Procter & Gamble Company", new Double(61.91), new Double(0.01), new Double(0.02), "9/1 12:00am", "PG", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "United Technologies Corporation", new Double(63.26), new Double(0.55), new Double(0.88), "9/1 12:00am", "UTX", "Computer", "Stop"},
	                  new Object[]{"pie-chart-icon", new Boolean(false),  "Verizon Communications", new Double(35.57), new Double(0.39), new Double(1.11), "9/1 12:00am", "VZ", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "Wal-Mart Stores, Inc.", new Double(45.45), new Double(0.73), new Double(1.63), "9/1 12:00am", "WMT", "Retail", "Start"},
	                  new Object[]{"pie-chart-icon", new Boolean(true),  "Walt Disney Company (The) (Holding Company)", new Double(29.89), new Double(0.24), new Double(0.81), "9/1 12:00am", "DIS", "Services", "Start"}
	          };

	      }
	      return companyData;
	}

}
	