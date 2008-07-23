/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import com.gwtextux.client.widgets.grid.plugins.GridDateFilter;
import com.gwtextux.client.widgets.grid.plugins.GridFilter;
import com.gwtextux.client.widgets.grid.plugins.GridFilterPlugin;
import com.gwtextux.client.widgets.grid.plugins.GridListFilter;
import com.gwtextux.client.widgets.grid.plugins.GridNumericFilter;
import com.gwtextux.client.widgets.grid.plugins.GridStringFilter;
import com.gwtextux.sample.showcase2.client.SampleGrid;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.GridPanel;

public class GridFilterSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/GridFilterSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final GridPanel grid = new SampleGrid();
            grid.setWidth(600);
            grid.setHeight(250);
            grid.setTitle("Grid with Filter");
            grid.setAutoExpandColumn("company");
            
            GridFilter gf[] = new GridFilter[7];
            gf[0] = new GridStringFilter("company");
            gf[1] = new GridNumericFilter("price");
            gf[2] = new GridNumericFilter("change");
            gf[3] = new GridNumericFilter("pctChange");
            gf[4] = new GridDateFilter("lastChanged");
            gf[5] = new GridStringFilter("symbol");
            gf[6] = new GridListFilter("industry", new String[]{"Manufacturing", "Finance", "Services", "Computer", "Food", "Retail"});
            
    		GridFilterPlugin gridFilterPlugin = new GridFilterPlugin(gf);
    		gridFilterPlugin.setLocal(true);
    		grid.addPlugin(gridFilterPlugin);
    		    		
            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates the Grid Filter plugin";
    }
}