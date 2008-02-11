/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.chooser;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.DomHelper;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;


/**
 * Example that illustrates simple buttons.
 */
public class ImageChooserSample extends ShowcasePanel {

    private ImageChooser ic;

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(20));
            MemoryProxy dataProxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("name"),
                    new IntegerFieldDef("size"),
                    new DateFieldDef("lastmod", "timestamp"),
                    new StringFieldDef("url")
            });
            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(dataProxy, reader, true);
            store.load();

            Button button = new Button("Add Image", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    if (ic == null) {
                        ic = new ImageChooser("Image Chooser", 515, 400, store);
                    }

                    ic.show(new ImageChooserCallback() {
                        public void onImageSelection(ImageData data) {
                            Element el = DomHelper.append("images", Format.format("<img src='{0}' style='margin:20px;visibility:hidden;'/>", data.getUrl()));
                            ExtElement extEl = new ExtElement(el);
                            extEl.show(true).frame();
                            button.focus();
                        }
                    });
                }
            });
            button.setIconCls("image-icon");

            Panel images = new Panel();
            images.setId("images");
            images.setBorder(false);
            images.setMargins(20);
            images.setWidth(450);

            verticalPanel.add(button);
            verticalPanel.add(images);

            panel.add(verticalPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example shows loading a DataView in a Window.  Each item has a linked details view, and the DataView " +
                " supports custom sorting and filtering.</p>" +
                "<p>This example was contributed by <b>Mario Lim</b>";
    }

    private Object[][] getData() {
        return new Object[][]{
                new Object[]{"Pirates of the Caribbean", new Integer(2120), new Long(1180231870000l), "images/view/carribean.jpg"},
                new Object[]{"Resident Evil", new Integer(2120), new Long(1180231870000l), "images/view/resident_evil.jpg"},
                new Object[]{"Blood Diamond", new Integer(2120), new Long(1180231870000l), "images/view/blood_diamond.jpg"},
                new Object[]{"No Reservations", new Integer(2120), new Long(1180231870000l), "images/view/no_reservations.jpg"},
                new Object[]{"Casino Royale", new Integer(2120), new Long(1180231870000l), "images/view/casino_royale.jpg"},
                new Object[]{"Good Shepherd", new Integer(2120), new Long(1180231870000l), "images/view/good_shepherd.jpg"},
                new Object[]{"Ghost Rider", new Integer(2120), new Long(1180231870000l), "images/view/ghost_rider.jpg"},
                new Object[]{"Batman Begins", new Integer(2120), new Long(1180231870000l), "images/view/batman_begins.jpg"},
                new Object[]{"Last Samurai", new Integer(2120), new Long(1180231870000l), "images/view/last_samurai.jpg"},
                new Object[]{"Italian Job", new Integer(2120), new Long(1180231870000l), "images/view/italian_job.jpg"},
                new Object[]{"Mission Impossible III", new Integer(2120), new Long(1180231870000l), "images/view/mi3.jpg"},
                new Object[]{"Mr & Mrs Smith", new Integer(2120), new Long(1180231870000l), "images/view/smith.jpg"},
                new Object[]{"Inside Man", new Integer(2120), new Long(1180231870000l), "images/view/inside_man.jpg"},
                new Object[]{"The Island", new Integer(2120), new Long(1180231870000l), "images/view/island.jpg"}
        };
    }
}