/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.window;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.HorizontalLayout;

import com.gwtextux.client.widgets.window.plugins.IconMenu;
import com.gwtextux.client.widgets.window.plugins.IconMenuConfig;

import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class IconMenuSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/window/IconMenuSample.java.html";
    }

    public String getIntro() {
        return "<p>Adds user defined menu to Window/Panel icon and adds dbl click close action.</p>";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
        	panel = new Panel();
        	
        	final Window window1 = createWindow("IconMenu Example 1");
        	window1.addPlugin(new IconMenu());
        	
        	Button button1 = new Button() {
        		{
        			setText("Window 1");
        			setIconCls("wand-icon");
        			addListener(new ButtonListenerAdapter() {
        				public void onClick(Button button, EventObject e) {
        					window1.show();
        				}
        			});
        		}
        	};
        	
        	IconMenuConfig config = new IconMenuConfig();
        	config.setTooltip("Click to Open Menu");
        	config.addSeparator();
        	config.addCustomItem(new Item() {
        		{
        			setText("Zoom in");
        			setIconCls("zoom-in-icon");
        		}
        	});
        	config.addCustomItem(new Item() {
        		{
        			setText("Zoom out");
        			setIconCls("zoom-out-icon");
        		}
        	});
        	config.addSeparator();
        	config.addCustomItem(new Item() {
        		{
        			setText("Print");
        			setIconCls("print-icon");
        		}
        	});
        	
        	final Window window2 = createWindow("IconMenu Example 2");
        	window2.addPlugin(new IconMenu(config));
        	
        	Button button2 = new Button() {
        		{
        			setText("Window 2");
        			setIconCls("image-icon");
        			addListener(new ButtonListenerAdapter() {
        				public void onClick(Button button, EventObject e) {
        					window2.show();
        				}
        			});
        		}
        	};
        	
        	panel.setLayout(new HorizontalLayout(10));
        	panel.add(button1);
        	panel.add(button2);
        }
        return panel;
    }
    
    private Window createWindow(String title) {
    	Window window = new Window();
    	
    	window.setTitle(title);
    	window.setIconCls("window-icon");
    	window.setWidth(400);
    	window.setHeight(300);
    	
    	return window;
    }
}