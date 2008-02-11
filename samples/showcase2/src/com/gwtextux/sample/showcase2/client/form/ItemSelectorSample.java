/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.form;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtextux.client.widgets.form.ItemSelector;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class ItemSelectorSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/ItemSelectorSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FormPanel formPanel = new FormPanel();
            formPanel.setTitle("Team Selection");
            formPanel.setFrame(true);
            formPanel.setPaddings(5, 0, 5, 5);
            formPanel.setWidth(520);
            formPanel.setLabelWidth(75);
            formPanel.add(new TextField("Team", "team", 230));

            final ItemSelector itemSelector = new ItemSelector();
            itemSelector.setFieldLabel("Players");
            itemSelector.setName("players");
            itemSelector.setDataFields(new String[]{"playerID", "name"});
            itemSelector.setFromData(new Object[][]{
                    new Object[]{"1", "Player One"},
                    new Object[]{"2", "Player Two"},
                    new Object[]{"3", "Player Three"},
                    new Object[]{"4", "Player Four"},
                    new Object[]{"5", "Player Five"}
            });
            itemSelector.setToData(new Object[][]{
                    new Object[]{"6", "Player Six"}
            });
            itemSelector.setMsWidth(160);
            itemSelector.setMsHeight(200);

            itemSelector.setValueField("playerID");
            itemSelector.setDisplayField("name");

            //can also assign legends
            //itemSelector.setToLegend("Selected");
            //itemSelector.setFromLegend("Available");

            Toolbar fromToolbar = new Toolbar();
            ToolbarButton addButton = new ToolbarButton();
            addButton.setDisabled(true);
            addButton.setIconCls("user-add-icon");
            fromToolbar.addButton(addButton);
            fromToolbar.addSpacer();
            fromToolbar.addItem(new ToolbarTextItem("Available"));
            itemSelector.setFromToolbar(fromToolbar);

            Toolbar toToolbar = new Toolbar();
            ToolbarButton clearButton = new ToolbarButton("Clear");
            clearButton.setIconCls("user-delete-icon");
            clearButton.addListener(new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    itemSelector.reset();
                }
            });
            toToolbar.addButton(clearButton);
            itemSelector.setToToolbar(toToolbar);

            formPanel.add(itemSelector);

            Button values = new Button("Get Value", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    super.onClick(button, e);

                    String values = formPanel.getForm().getValues();
                    log(MESSAGE, "Form data : " + values);
                }
            });
            formPanel.addButton(values);

            Button markInvalid = new Button("Mark Invalid", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    itemSelector.markInvalid("Invalid");
                }
            });

            formPanel.addButton(markInvalid);

            panel.add(formPanel);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "This is an example of a dual column Item selector.";
    }
}