package com.gwtextux.sample.showcase2.client.grid;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.DateFieldDef;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.FloatFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.widgets.grid.plugins.ColumnWithCellActionsConfig;
import com.gwtextux.client.widgets.grid.plugins.GridCellAction;
import com.gwtextux.client.widgets.grid.plugins.GridCellActionListener;
import com.gwtextux.client.widgets.grid.plugins.GridCellActionsPlugin;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class GridCellActionsSample extends ShowcasePanel {
	
	 public String getSourceUrl() {
	        return "source/grid/CellActionsSample.java.html";
	    }
	
	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBorder(false);
			panel.setPaddings(15);

			RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("icon"), new StringFieldDef("company"),
					new FloatFieldDef("price"), new FloatFieldDef("change"), new FloatFieldDef("pctChange"), 
					new DateFieldDef("lastChanged", "n/j h:ia"), new StringFieldDef("symbol"), new StringFieldDef("industry"), 
					new StringFieldDef("action") });

			GridPanel grid = new GridPanel();

			Object[][] data = this.getGridCellActionData();
			MemoryProxy proxy = new MemoryProxy(data);

			ArrayReader reader = new ArrayReader(recordDef);
			Store store = new Store(proxy, reader);
			store.load();
			grid.setStore(store);

			final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");
			
			GridCellAction dynamicCellAction = new GridCellAction();
			dynamicCellAction.setIconIndex("icon");
			dynamicCellAction.setTooltip("dynamic");
			dynamicCellAction.setGridCellActionListener(new GridCellActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						Object value, String dataIndex, int rowIndex, int colIndex) {
					return true;
				}
			});
			
			ColumnWithCellActionsConfig companyColumnConfig = new ColumnWithCellActionsConfig("Company", "company", 
					240, true, null, "company");
			companyColumnConfig.setCellActions(new GridCellAction[] { new GridCellAction("grid-icon", "View details"),
			new GridCellAction("settings-icon", "Settings")});
			
			ColumnWithCellActionsConfig industryColumnConfig = new ColumnWithCellActionsConfig("Industry", "industry", 
					100, true);
			industryColumnConfig.setCellActions(new GridCellAction[] { new GridCellAction("folder-icon", "Tooltip 2")});
			
			ColumnWithCellActionsConfig actionColumnConfig = new ColumnWithCellActionsConfig("Action", "action", 
					100, true);
			actionColumnConfig.setCellActions(new GridCellAction[] {dynamicCellAction});
			
			BaseColumnConfig[] columns = new BaseColumnConfig[] { companyColumnConfig,
					new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {
						public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, 
								int colNum, Store store) {
							Date date = (Date) value;
							return dateFormatter.format(date);
						}
					}), industryColumnConfig, actionColumnConfig };

			ColumnModel columnModel = new ColumnModel(columns);
			grid.setColumnModel(columnModel);

			grid.setFrame(true);
			grid.setStripeRows(true);

			grid.setHeight(350);
			grid.setWidth(500);
			grid.setTitle("Grid with CellActions");

			GridCellActionsPlugin cellActionsPlugin = new GridCellActionsPlugin(TextAlign.LEFT, null);
			cellActionsPlugin.addActionListener(new GridCellActionListener(){//setting global listener as recommended
				public boolean execute(GridPanel grid, Record record,
						String action, Object value, String dataIndex,
						int rowIndex, int colIndex) {
					
					if(!dataIndex.equals("action")){
						//display message when all but action (pie-chart, line-chart) icons are displayed 
						MessageBox.alert("Callback", "Row: " + rowIndex + "; col: " + colIndex + 
								"; value: " + value + "; dataIndex: " + dataIndex);
					}
					return false;
				}
			});
			
			//change icons for dynamically set icons 
			cellActionsPlugin.addGlobalGridCellListener("pie-chart-icon", new GridCellActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						Object value, String dataIndex, int rowIndex, int colIndex) {
					record.beginEdit();
					record.set("icon", "line-chart-icon");
					record.set("action", "Stop");
					record.endEdit();
					return false;
				}
			});
			
			cellActionsPlugin.addGlobalGridCellListener("line-chart-icon", new GridCellActionListener(){
				public boolean execute(GridPanel grid, Record record, String action,
						Object value, String dataIndex, int rowIndex, int colIndex) {
					record.beginEdit();
					record.set("icon", "pie-chart-icon");
					record.set("action", "Start");
					record.endEdit();
					return false;
				}
			});
			grid.addPlugin(cellActionsPlugin);

			panel.add(grid);
		}

		return panel;
	}

	public String getIntro() {
		return "This example demonstrates the Grid Cell Actions plugin";
	}

	private Object[][] getGridCellActionData(){
		Object[][] companyData = null;
	      if (companyData == null) {
	          companyData = new Object[][]{
	        		  new Object[]{"pie-chart-icon", "3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", "AA", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "Altria Group Inc", new Double(83.81), new Double(0.28), new Double(0.34), "9/1 12:00am", "MO", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "American Express Company", new Double(52.55), new Double(0.01), new Double(0.02), "9/1 12:00am", "AXP", "Finance", "Start"},
	                  new Object[]{"pie-chart-icon", "American International Group, Inc.", new Double(64.13), new Double(0.31), new Double(0.49), "9/1 12:00am", "AIG", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", "AT&T Inc.", new Double(31.61), new Double(-0.48), new Double(-1.54), "9/1 12:00am", "T", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", "Boeing Co.", new Double(75.43), new Double(0.53), new Double(0.71), "9/1 12:00am", "BA", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "Caterpillar Inc.", new Double(67.27), new Double(0.92), new Double(1.39), "9/1 12:00am", "CAT", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", "Citigroup, Inc.", new Double(49.37), new Double(0.02), new Double(0.04), "9/1 12:00am", "C", "Finance", "Start"},
	                  new Object[]{"line-chart-icon", "E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing", "Stop"},
	                  new Object[]{"pie-chart-icon", "Exxon Mobil Corp", new Double(68.1), new Double(-0.43), new Double(-0.64), "9/1 12:00am", "XOM", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "General Electric Company", new Double(34.14), new Double(-0.08), new Double(-0.23), "9/1 12:00am", "GE", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "General Motors Corporation", new Double(30.27), new Double(1.09), new Double(3.74), "9/1 12:00am", "GM", "Automotive", "Start"},
	                  new Object[]{"pie-chart-icon", "Hewlett-Packard Co.", new Double(36.53), new Double(-0.03), new Double(-0.08), "9/1 12:00am", "HPQ", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", "Honeywell Intl Inc", new Double(38.77), new Double(0.05), new Double(0.13), "9/1 12:00am", "HON", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "Intel Corporation", new Double(19.88), new Double(0.31), new Double(1.58), "9/1 12:00am", "INTC", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", "International Business Machines", new Double(81.41), new Double(0.44), new Double(0.54), "9/1 12:00am", "IBM", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", "Johnson & Johnson", new Double(64.72), new Double(0.06), new Double(0.09), "9/1 12:00am", "JNJ", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", "JP Morgan & Chase & Co", new Double(45.73), new Double(0.07), new Double(0.15), "9/1 12:00am", "JPM", "Finance", "Start"},
	                  new Object[]{"pie-chart-icon", "McDonald\"s Corporation", new Double(36.76), new Double(0.86), new Double(2.40), "9/1 12:00am", "MCD", "Food", "Start"},
	                  new Object[]{"pie-chart-icon", "Merck & Co., Inc.", new Double(40.96), new Double(0.41), new Double(1.01), "9/1 12:00am", "MRK", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", "Microsoft Corporation", new Double(25.84), new Double(0.14), new Double(0.54), "9/1 12:00am", "MSFT", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", "Pfizer Inc", new Double(27.96), new Double(0.4), new Double(1.45), "9/1 12:00am", "PFE", "Medical", "Start"},
	                  new Object[]{"pie-chart-icon", "The Coca-Cola Company", new Double(45.07), new Double(0.26), new Double(0.58), "9/1 12:00am", "KO", "Food", "Start"},
	                  new Object[]{"pie-chart-icon", "The Home Depot, Inc.", new Double(34.64), new Double(0.35), new Double(1.02), "9/1 12:00am", "HD", "Retail", "Start"},
	                  new Object[]{"pie-chart-icon", "The Procter & Gamble Company", new Double(61.91), new Double(0.01), new Double(0.02), "9/1 12:00am", "PG", "Manufacturing", "Start"},
	                  new Object[]{"pie-chart-icon", "United Technologies Corporation", new Double(63.26), new Double(0.55), new Double(0.88), "9/1 12:00am", "UTX", "Computer", "Start"},
	                  new Object[]{"pie-chart-icon", "Verizon Communications", new Double(35.57), new Double(0.39), new Double(1.11), "9/1 12:00am", "VZ", "Services", "Start"},
	                  new Object[]{"pie-chart-icon", "Wal-Mart Stores, Inc.", new Double(45.45), new Double(0.73), new Double(1.63), "9/1 12:00am", "WMT", "Retail", "Start"},
	                  new Object[]{"pie-chart-icon", "Walt Disney Company (The) (Holding Company)", new Double(29.89), new Double(0.24), new Double(0.81), "9/1 12:00am", "DIS", "Services", "Start"}
	          };

	      }
	      return companyData;
	}
}
