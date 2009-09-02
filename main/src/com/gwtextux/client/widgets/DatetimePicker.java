package com.gwtextux.client.widgets;
/**
 * A DatetimePicker 
 * 
 * by Henry Chan
 * hchan@apache.org
 * Sep/2009
 */
import java.util.Date;

import org.eclipse.swt.browser.Browser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.CSS;
import com.gwtext.client.util.DateUtil;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.DatePickerListenerAdapter;
import com.gwtext.client.widgets.event.WindowListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.TimeField;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.AnchorLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class DatetimePicker extends com.gwtext.client.widgets.Panel {

	private TextField textField;
	private Window dateTimeWindowPopup;
	private Button dateButton;
	private DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("MM/dd/yy hh:mm a");
	private String timeFormat = "h:i A";
	



	public String getTimeFormat() {
		return timeFormat;
	}


	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}


	public DateTimeFormat getDateTimeFormat() {
		return dateTimeFormat;
	}


	public void setDateTimeFormat(DateTimeFormat dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}


	public TextField getTextField() {
		return textField;
	}


	public void setTextField(TextField textField) {
		this.textField = textField;
	}


	public Window getDateTimeWindowPopup() {
		return dateTimeWindowPopup;
	}


	public void setDateTimeWindowPopup(Window dateTimeWindowPopup) {
		this.dateTimeWindowPopup = dateTimeWindowPopup;
	}


	public Button getDateButton() {
		return dateButton;
	}


	public void setDateButton(Button dateButton) {
		this.dateButton = dateButton;
	}


	
	
	public DatetimePicker() {
		init();
	}
	
	public void init() {
		textField = new TextField();
		dateButton = new Button("Date");
		
		
		this.setBorder(false);
		this.setLayout(new HorizontalLayout(1));
		
		dateButton.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {
				dateTimeWindowPopup = initDateTimeWindowPopup(textField, dateButton);
				dateTimeWindowPopup.show();
			
				
				if (e.getXY()[1] + dateTimeWindowPopup.getHeight() >
						com.google.gwt.user.client.Window.getClientHeight()
						&& e.getXY()[1] - dateTimeWindowPopup.getHeight() > 0
						) {
					dateTimeWindowPopup.setPagePosition(e.getXY()[0], e.getXY()[1] - dateTimeWindowPopup.getHeight());					
				} else {
					dateTimeWindowPopup.setPagePosition(e.getXY()[0], e.getXY()[1]);
				}
				button.disable();
			}
			

		});
		this.add(textField);
		this.add(dateButton);
	}


	public DatetimePicker(String idTextField, String textFieldValue) {
		init();
		textField.setId(idTextField);
		textField.setName(idTextField);
		textField.setValue(textFieldValue);
	}


	public Window initDateTimeWindowPopup(final TextField textField, final Button dateButton) {
		final Window window = new Window();
		window.setCls("gwtextux-datetimepicker");			
		window.setWidth(193);
		window.setAutoHeight(true);
		Panel windowPanel = new Panel();
		windowPanel.setLayout(new AnchorLayout());
		window.setTitle("Datetime Picker");  		
		window.setMaximizable(false);  
		window.setResizable(true);  
		window.setModal(false);  
		window.addListener(new WindowListenerAdapter(){
			@Override
			public void onClose(Panel panel) {
				dateButton.enable();
				super.onClose(panel);
			}
			
		});
		
		final StringBuffer dpStr = new StringBuffer(dateTimeFormat.format(new Date()));
		final StringBuffer timeStr = new StringBuffer();
		
		final DatePicker dp = new DatePicker();
		
		dp.addListener(new DatePickerListenerAdapter() {
			@Override
			public void onSelect(DatePicker datePicker, Date date) {
				dpStr.setLength(0);
				dpStr.append(dateTimeFormat.format(date));
			}
		});
		
		FormPanel fp = new FormPanel();
		
		fp.setFrame(true);
		
		
		Panel timePanel = new Panel();
		timePanel.setLayout(new FitLayout());
	//timePanel.setLayout(new AnchorLayout());
		//Label timePanelLabel = new Label("Time: ");
	
		final Button okButton = new Button("OK");
		final TimeField timeField = new TimeField();
		timeField.setFormat(timeFormat);
		timeField.addListener(new ComboBoxListenerAdapter() {
			@Override
			public void onValid(Field field) {
				if (timeField.isValid()) {
					timeStr.setLength(0);
					timeStr.append(field.getValueAsString());
					okButton.setDisabled(false);
				} else {
					okButton.setDisabled(true);
				}
			};
			
			
		});
	

		
		//timePanel.add(timePanelLabel, new AnchorLayoutData("100% 50%"));
		timePanel.add(timeField);//, new AnchorLayoutData("100% 50%"));

		fp.add(timePanel);
		
		
		okButton.setDisabled(true);
		fp.addButton(okButton);  
		Button cancelButton = new Button("Cancel");
		fp.addButton(cancelButton);  
		
		cancelButton.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {
				window.close();
				dateButton.enable();
			}
		});

		okButton.addListener(new ButtonListenerAdapter() {
			@Override
			public void onClick(Button button, EventObject e) {
				if (!timeField.isValid()) {
					timeField.focus();
				} else {
					window.close();
					dateButton.enable();
					Date dateFromDP = dateTimeFormat.parse(dpStr.toString());
					Date dateFromTP = DateUtil.parseDate(timeStr.toString(), timeFormat);
					dateFromDP.setHours(dateFromTP.getHours());
					dateFromDP.setMinutes(dateFromTP.getMinutes());
					textField.setValue(dateTimeFormat.format(dateFromDP));
				}
			}
		});
		
		windowPanel.add(dp);
		windowPanel.add(fp);
		window.add(windowPanel);
		return window;
	}

}
