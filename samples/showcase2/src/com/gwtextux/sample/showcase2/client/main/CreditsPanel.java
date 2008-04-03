/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.main;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;


public class CreditsPanel extends ShowcasePanel {


	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			panel.setLayout(new VerticalLayout(15));

			ColumnConfig[] columnConfigs = new ColumnConfig[]{
					new ColumnConfig("Name", "name", 120, true),
					new ColumnConfig("Ext-UX Library Author", "uxAuthor", 120, true),
					new ColumnConfig("Ext-UX Library URL", "uxUrl", 280, true),
					new ColumnConfig("GWT-Ext-UX Author", "guxAuthor", 120, true)
			};

			RecordDef recordDef = new RecordDef(new FieldDef[]{
					new StringFieldDef("name"),
					new StringFieldDef("guxAuthor"),
					new StringFieldDef("uxAuthor"),
					new StringFieldDef("uxUrl")
			});

			ArrayReader reader = new ArrayReader(recordDef);
			MemoryProxy proxy = new MemoryProxy(getCreditsData());

			Store store = new Store(proxy, reader);
			store.load();

			final GridPanel grid = new GridPanel();
			grid.setColumnModel(new ColumnModel(columnConfigs));
			grid.setStore(store);
			grid.setHeight(200);
			grid.setWidth(660);
			grid.setTitle("Credits for Extensions");


			RecordDef recordDef2 = new RecordDef(new FieldDef[]{
					new StringFieldDef("name"),
					new StringFieldDef("description")
			});

			ArrayReader reader2 = new ArrayReader(recordDef2);
			MemoryProxy proxy2 = new MemoryProxy(getCreditsData2());

			Store store2 = new Store(proxy2, reader2);
			store2.load();

			ColumnConfig descCol = new ColumnConfig("Description", "description", 120, true);
			descCol.setId("descCol");
			ColumnConfig[] columnConfigs2 = new ColumnConfig[]{
					new ColumnConfig("Name", "name", 120, true),
					descCol
			};

			final GridPanel grid2 = new GridPanel();
			grid2.setColumnModel(new ColumnModel(columnConfigs2));
			grid2.setStore(store2);
			grid2.setHeight(200);
			grid2.setWidth(660);
			grid2.setAutoExpandColumn("descCol");
			grid2.setTitle("Other Credits");


			panel.add(grid);
			panel.add(grid2);
		}
		return panel;
	}

	private static Object[][] getCreditsData() {
		return new Object[][]{
				new Object[]{"MultiSelect", "Sanjiv", "Figtree Systems, Valcom Inc.", "<a href=\"http://extjs.com/learn/Extension:Multiselect2\" target=\"_blank\">http://extjs.com/learn/Extension:Multiselect2</a>"},
				new Object[]{"Live Grid", "Michal Bergmann", "Mind Patterns", "<a href=\"http://www.siteartwork.de/livegrid/\" target=\"_blank\">http://www.siteartwork.de/livegrid/</a>"},
				new Object[]{"Row Layout", "Sanjiv", "Kirill Hryapin", "<a href=\"http://extjs.com/forum/showthread.php?t=17116\" target=\"_blank\">http://extjs.com/forum/showthread.php?t=17116</a>"},
				new Object[]{"Managed IFrame", "Matthew Lieder", "Doug Hendricks", "<a href=\"http://extjs.com/learn/Extension:ManagedIframe\" target=\"_blank\">http://extjs.com/learn/Extension:ManagedIframe</a>"},
				new Object[]{"Multi Month Calendar", "Michal Bergmann", "Aung Win Myat", "<a href=\"http://extjs.com/learn/Extension:Multi_Month_Calendar\" target=\"_blank\">http://extjs.com/learn/Extension:Multi_Month_Calendar</a>"},
				new Object[]{"File upload dialog", "Mario Lim", "Maxim Bazhenov", "<a href=\"http://max-bazhenov.com/dev/upload-dialog-2.0/index.php\" target=\"_blank\">http://max-bazhenov.com/dev/upload-dialog-2.0/index.php</a>"},
				new Object[]{"Grid Search Plugin", "Matthew Lieder", "Jozef Sakalos", "<a href=\"http://gridsearch.extjs.eu/\" target=\"_blank\">http://gridsearch.extjs.eu/</a>"},
				new Object[]{"Image", "Mario Lim", "", ""}
		};
	}

	private static Object[][] getCreditsData2() {
		return new Object[][]{
				new Object[]{"Silk Icons", "The icons used in this Showcase are from <a href=\"http://www.famfamfam.com\" target=\"_blank\">famfamfam.com</a>"},
				new Object[]{"Green Theme", "Author : Charles Dietrich. Site <a href=\"http://code.google.com/p/tobydietrichlibs/\" target=\"_blank\">here</a>"},
				new Object[]{"Slate Theme", "Author : J.C. Bize. Site <a href=\"http://extjs.com/learn/Extension:SlateTheme/\" target=\"_blank\">here</a>"},
				new Object[]{"Indigo Theme", "Author : elyxr. Site <a href=\"http://extjs.com/forum/showthread.php?t=26294/\" target=\"_blank\">here</a>"},
				new Object[]{"Silver cherry Theme", "Author : elyxr. Site <a href=\"http://extjs.com/forum/showthread.php?t=26294/\" target=\"_blank\">here</a>"}
		};
	}
}