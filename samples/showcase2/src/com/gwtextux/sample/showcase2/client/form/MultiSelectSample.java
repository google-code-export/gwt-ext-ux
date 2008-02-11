/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.form;


import com.gwtextux.client.widgets.form.MultiSelect;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.EventObject;

public class MultiSelectSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FormPanel formPanel = new FormPanel();
            formPanel.setFrame(true);
            formPanel.setLabelAlign(Position.RIGHT);
            formPanel.setTitle("Multi Select Form");
            formPanel.setWidth(320);
            formPanel.setLabelWidth(75);

            formPanel.add(new TextField("Team", "team"));

            final MultiSelect multiSelect = new MultiSelect();
            multiSelect.setName("players");
            multiSelect.setDataFields(new String[]{"playerID", "name"});
            multiSelect.setData(new Object[][]{
                    new Object[]{"1", "One"},
                    new Object[]{"2", "Two"},
                    new Object[]{"3", "Three"},
                    new Object[]{"4", "Four"},
                    new Object[]{"5", "Five"},
                    new Object[]{"6", "Six"},
                    new Object[]{"7", "Seven"},
                    new Object[]{"8", "Eight"},
                    new Object[]{"9", "Nine"}
            });
            multiSelect.setValueField("playerID");
            multiSelect.setDisplayField("name");
            multiSelect.setWidth(160);
            multiSelect.setHeight(180);
            multiSelect.setAllowBlank(true);
            multiSelect.setLegend("Players");
            multiSelect.setFieldLabel("Players");

            formPanel.add(multiSelect);

            formPanel.addButton(new Button("Get Value", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    super.onClick(button, e);

                    String values = formPanel.getForm().getValues();
                    MessageBox.alert("Values", values);
                }
            }));

            formPanel.addButton(new Button("Set Value (2,3)", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    multiSelect.setValue("2,3");
                }
            }));

            formPanel.addButton(new Button("Mark Invalid", new ButtonListenerAdapter() {

                public void onClick(Button button, EventObject e) {
                    multiSelect.markInvalid("Invalid");
                }
            }));

            formPanel.addButton(new Button("Toggle Enabled", new ButtonListenerAdapter() {

                public void onClick(Button button, EventObject e) {
                    if (multiSelect.isDisabled()) {
                        multiSelect.enable();
                    } else {
                        multiSelect.enable();
                    }
                }
            }));

            panel.add(formPanel);
        }
        return panel;
    }
}