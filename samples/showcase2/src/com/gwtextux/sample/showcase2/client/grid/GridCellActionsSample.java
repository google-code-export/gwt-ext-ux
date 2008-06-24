package com.gwtextux.sample.showcase2.client.grid;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.Function;
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
import com.gwtextux.client.widgets.grid.plugins.GridCellActionsPlugin;
import com.gwtextux.sample.showcase2.client.SampleData;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class GridCellActionsSample extends ShowcasePanel {
	
	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setBorder(false);
			panel.setPaddings(15);

			RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("company"), new FloatFieldDef("price"),
					new FloatFieldDef("change"), new FloatFieldDef("pctChange"), new DateFieldDef("lastChanged", "n/j h:ia"),
					new StringFieldDef("symbol"), new StringFieldDef("industry") });

			GridPanel grid = new GridPanel();

			Object[][] data = SampleData.getCompanyDataLarge();
			MemoryProxy proxy = new MemoryProxy(data);

			ArrayReader reader = new ArrayReader(recordDef);
			Store store = new Store(proxy, reader);
			store.load();
			grid.setStore(store);

			final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");
			ColumnWithCellActionsConfig companyColumnConfig = new ColumnWithCellActionsConfig("Company", "company", 240, true, null,
					"company");
			companyColumnConfig.setCellActions(new GridCellAction[] { new GridCellAction("grid-icon", "View details", new Function() {
				public void execute() {
					MessageBox.alert("Callback", "This is a callback action for Details icon");
				}
			}), 
			new GridCellAction("settings-icon", "Settings", new Function() {
				public void execute() {
					MessageBox.alert("Callback", "This is a callback action for Settings icon");
				}
			})});
			ColumnWithCellActionsConfig industryColumnConfig = new ColumnWithCellActionsConfig("Industry", "industry", 100, true);
			industryColumnConfig.setCellActions(new GridCellAction[] { new GridCellAction("folder-icon", "Tooltip 2", null)});
			BaseColumnConfig[] columns = new BaseColumnConfig[] { companyColumnConfig,
					new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {
						public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
							Date date = (Date) value;
							return dateFormatter.format(date);
						}
					}), industryColumnConfig };

			ColumnModel columnModel = new ColumnModel(columns);
			grid.setColumnModel(columnModel);

			grid.setFrame(true);
			grid.setStripeRows(true);

			grid.setHeight(350);
			grid.setWidth(500);
			grid.setTitle("Grid with CellActions");

			GridCellActionsPlugin cellActionsPlugin = new GridCellActionsPlugin("left", null);
			grid.addPlugin(cellActionsPlugin);

			panel.add(grid);
		}

		return panel;
	}

	public String getIntro() {
		return "This example demonstrates the Grid Cell Actions plugin";
	}

}
