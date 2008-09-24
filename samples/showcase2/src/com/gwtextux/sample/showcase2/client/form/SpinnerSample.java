/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.form;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.core.EventObject;
import com.gwtextux.client.widgets.form.Spinner;
import com.gwtextux.client.widgets.form.NumberStrategy;
import com.gwtextux.client.widgets.form.DateStrategy;
import com.gwtextux.client.widgets.form.TimeStrategy;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class SpinnerSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/form/SpinnerSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			Panel panel1 = new Panel();
			panel1.setBorder(false);
			panel1.setPaddings(15);

			panel1.setLayout(new HorizontalLayout(15));

			final FormPanel formPanel = new FormPanel();
			formPanel.setTitle("Spinner Sample");
			formPanel.setFrame(true);
			formPanel.setPaddings(5, 0, 5, 5);
			formPanel.setWidth(280);
			formPanel.setLabelWidth(50);
			final Spinner spinner = new Spinner();

			spinner.setLabel("Spinner");
			formPanel.add(spinner);
			panel1.add(formPanel);

			Panel buttonPanel = new Panel();
			buttonPanel.setBorder(false);
			buttonPanel.setPaddings(10);

			Button reset = new Button("Reset", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					spinner.focus();
				}
			});
			buttonPanel.add(reset);

			Button toggleDisable = new Button("Toggle Disable", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					if(spinner.isDisabled()) {
						spinner.enable();
					} else {
						spinner.disable();
					}
					spinner.focus();
				}
			});
			buttonPanel.add(toggleDisable);

			Button toggleReadOnly = new Button("Toggle readOnly", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					if(spinner.isReadOnly()) {
						spinner.setReadOnly(false);
					} else {
						spinner.setReadOnly(true);
					}
					spinner.focus();
				}
			});
			buttonPanel.add(toggleReadOnly);

			Button convertToNumber = new Button("Convert to Number", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					spinner.setStrategy(new NumberStrategy());
					spinner.focus();
				}
			});
			buttonPanel.add(convertToNumber);

			Button convertToNumber10 = new Button("Convert to Number : Limited[0-10]", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					NumberStrategy strategy = new NumberStrategy();
					strategy.setMinValue(0);
					strategy.setMaxValue(10);
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToNumber10);

			Button convertToNumberLimited = new Button("Convert to Number: Limited[100-200] & Increment[5] & Alternate Increment[10]", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					NumberStrategy strategy = new NumberStrategy();
					strategy.setMinValue(100);
					strategy.setMaxValue(200);
					strategy.setIncrementValue(5);
					strategy.setAlternateIncrementValue(10);
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToNumberLimited);

			Button convertToDate = new Button("Convert to Date", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					spinner.setStrategy(new DateStrategy());
					spinner.focus();
				}
			});
			buttonPanel.add(convertToDate);

			Button convertToDate2 = new Button("Convert to Date: Limited[2008-01-01 - 2008-12-31]", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					DateStrategy strategy = new DateStrategy();
					strategy.setMinValue("2008-01-01");
					strategy.setMinValue("2008-12-31");
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToDate2);

			Button convertToDate3 = new Button("Convert to Date: Format[m-d-Y]", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					DateStrategy strategy = new DateStrategy();
					strategy.setFormat("m-d-Y");
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToDate3);

			Button convertToDate4 = new Button("Convert to Date: Increment 7 Days, Alt 3 Months", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					DateStrategy strategy = new DateStrategy();
					strategy.setIncrementValue(7);
					strategy.setIncrementConstant("d");
					strategy.setAlternateIncrementValue(3);
					strategy.setAlternateIncrementConstant("m");
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToDate4);

			Button convertToTime = new Button("Convert to Time", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					spinner.setStrategy(new TimeStrategy());
					spinner.focus();
				}
			});
			buttonPanel.add(convertToTime);

			Button convertToTime2 = new Button("Convert to Time: Limited[09:00 - 17:00]", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					spinner.reset();
					TimeStrategy strategy = new TimeStrategy();
					strategy.setMinValue("09:00");
					strategy.setMaxValue("17:00");
					spinner.setStrategy(strategy);
					spinner.focus();
				}
			});
			buttonPanel.add(convertToTime2);			
			panel1.add(buttonPanel);

			panel.add(panel1);
		}
		return panel;
	}

	public String getIntro() {
		return "<ul>" +
				"<li>- Click the control to spin</li>" +
				"<li>- Hold \"Shift\" for alternate spinning. </li>" +
				"<li>- Drag the divider with your mouse to spin. </li>" +
				"<li>- Put focus on field and press \"up\" or \"down\" to spin. </li>" +
				"<li>- When focused press \"pageUp\" or \"pageDown\" for alternate spinning. </li>" +
				"<li>- Hover the control and use your scrollwheel on your mouse to spin.</li>" +
				"</ul>";
	}
}