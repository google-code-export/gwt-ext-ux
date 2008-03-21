/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.grid;

import com.gwtextux.client.widgets.grid.plugins.GridSearchPlugin;
import com.gwtextux.sample.showcase2.client.SampleGrid;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.grid.GridPanel;

public class GridSearchSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/GridSearchSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final GridPanel grid = new SampleGrid();
            grid.setWidth(600);
            grid.setHeight(250);
            grid.setTitle("Grid with Search");
            grid.setAutoExpandColumn("company");

    		Toolbar topToolbar = new Toolbar();
    		topToolbar.addFill();
    		grid.setTopToolbar(topToolbar);
    		
    		GridSearchPlugin gridSearch = new GridSearchPlugin(GridSearchPlugin.TOP);
    		gridSearch.setMode(GridSearchPlugin.LOCAL);
    		grid.addPlugin(gridSearch);
            
            panel.add(grid);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates the Search Grid plugin";
    }
}