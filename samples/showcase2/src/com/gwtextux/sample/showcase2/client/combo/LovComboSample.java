/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.combo;


import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtextux.client.widgets.combo.LovCombo;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

/**
 * ComboBox with paging dropdown.
 */
public class LovComboSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/combo/LovComboSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			MemoryProxy proxy = new MemoryProxy(getData());
			RecordDef recordDef = new RecordDef(
					new FieldDef[]{
							new IntegerFieldDef("valueField"),
							new StringFieldDef("displayField")
					}
			);

			ArrayReader reader = new ArrayReader(recordDef);
			final Store store = new Store(proxy, reader);
			store.load();

			final LovCombo lovCombo = new LovCombo();
			lovCombo.setLabel("Lov Combo");
			lovCombo.setId("lovcombo");
			lovCombo.setWidth(300);
			lovCombo.setHideOnSelect(false);
			lovCombo.setMaxHeight(300);
			lovCombo.setTriggerAction(ComboBox.ALL);
			lovCombo.setMode(ComboBox.LOCAL);
			lovCombo.setStore(store);
			lovCombo.setValueField("valueField");
			lovCombo.setDisplayField("displayField");
			lovCombo.setSeprator(";");

			FormPanel form = new FormPanel();
			form.setLabelWidth(120);
			form.setBorder(false);
			form.add(lovCombo);

			TextField tf = new TextField();
			tf.setLabel("Value (updated on focus)");
			tf.setWidth(300);
			tf.setSelectOnFocus(true);
			tf.addListener(new TextFieldListenerAdapter() {
				public void onFocus(Field field) {
					field.setValue(lovCombo.getValue());
				}
			});
			form.add(tf);

			panel.add(form);
		}
		return panel;
	}


	private Object[][] getData() {

		return new Object[][]{
				new Object[]{new Integer(1), "Personnel []"},
				new Object[]{new Integer(11), "Finance (33)"},
				new Object[]{new Integer(5), "Door"},
				new Object[]{new Integer(6), "Door Panel"},
				new Object[]{new Integer(2), "Management !77"},
				new Object[]{new Integer(25), "Production"},
				new Object[]{new Integer(3), "Users"},
				new Object[]{new Integer(20), "Window"},
				new Object[]{new Integer(21), "Window Panel"},
				new Object[]{new Integer(22), "Form Panel"},
				new Object[]{new Integer(23), "Grid Panel"},
				new Object[]{new Integer(24), "Data View Panel"}
		};
	}

	public String getIntro() {
		return "<p> Simple LOV (List Of Values) combo. Individual values are selected in dropdown list and overall value is delimited list of values.\n" +
				"Delimeter is configurable.\n" +
				"LovCombo setValue method accepts the delimited list of values and sets all individual values accordingly.</p>";
	}
}