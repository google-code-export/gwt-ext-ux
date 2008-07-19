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
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class IconMenuSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/window/IconMenuSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
        	panel = new Panel();
        	
        	final Window window1 = new Window();
        	
        	Button button1 = new Button() {
        		{
        			setText("show window 1");
        			addListener(new ButtonListenerAdapter() {
        				@Override
        				public void onClick(Button button, EventObject e) {
        					window1.show();
        				}
        			});
        		}
        	};
        	
        	final Window window2 = new Window();
        	
        	Button button2 = new Button() {
        		{
        			setText("show window 2");
        			addListener(new ButtonListenerAdapter() {
        				@Override
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
}