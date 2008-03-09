/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.widgets;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.dd.DD;
import com.gwtext.client.dd.DDProxy;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtextux.client.widgets.image.Image;
import com.gwtextux.client.widgets.image.ImageListenerAdapter;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtext.client.core.EventObject;


/**
 * Example that illustrates Image widget event handlers and Drag and Drop.
 * @author mlim1972
 */
public class ImageDDSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Image myImage = new Image("myImageid", "images/gwt-ext-logo.png");
            myImage.addListener(new ImageListenerAdapter(){
                public void onClick(Image image, EventObject e) {
                	log(EVENT, "Image1" + " clicked.");
                }

                public void onMouseOut(Image image, EventObject e) {
                	log(EVENT, "Image1" + " mouse out.");
                }

                public void onMouseOver(Image image, EventObject e) {
                	log(EVENT, "Image1" + " mouse over.");
                }
            });
            Menu menu = new Menu();
            Item item1 = new Item("Copy this fine Image");
            menu.addItem(item1);
            myImage.setContextMenu(menu);
            
            Panel draggable = new Panel();
            draggable.setBorder(true);
            draggable.setCollapsible(false);
            draggable.add(myImage);

            Image myImage2 = new Image("myImageid2", "images/gwt-ext-logo.png");
            Panel proxy = new Panel();
            proxy.setBorder(true);
            proxy.setCollapsible(false);
            proxy.add(myImage2);
            myImage2.addListener(new ImageListenerAdapter(){
                public void onClick(Image image, EventObject e) {
                	log(EVENT, "Image2" + " clicked.");
                }

                public void onMouseOut(Image image, EventObject e) {
                	log(EVENT, "Image2" + " mouse out.");
                }

                public void onMouseOver(Image image, EventObject e) {
                	log(EVENT, "Image2" + " mouse over.");
                }
            });
            Menu menu2 = new Menu();
            Item item2 = new Item("Another fine Context Menu");
            menu2.addItem(item2);
            myImage2.setContextMenu(menu2);

            DD dd = new DD(draggable);
            DD ddProxy = new DDProxy(proxy);

            horizontalPanel.add(draggable);
            horizontalPanel.add(proxy);

            panel.add(horizontalPanel);
        }

        return panel;
    }

    protected boolean showEvents() {
        return true;
    }
    
    public String getIntro() {
        return "<p>This is a simple example illustrating the Image widget, Image events and drag/drop. The images can handle mouse events as well as context menu.</p>";
    }
}