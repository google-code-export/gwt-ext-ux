package com.gwtextux.sample.showcase2.client.widgets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Hidden;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtextux.client.widgets.buttons.BrowseButton;
import com.gwtextux.client.widgets.buttons.BrowseButtonListenerAdapter;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class BrowseButtonSample extends ShowcasePanel {

	private Toolbar toolbar;
	private Store fileStore;
	private RecordDef recordDef;
	private FormPanel fileForm;
	private Map<String,TextField> fileMap;
	private GridPanel fileGrid;
	private Button uploadFiles;

	public String getSourceUrl() {
		return "source/widgets/BrowseButtonSample.java.html";
	}

	public String getIntro() {
		return "<p>This example demonstrates the BrowseButton widget. The BrowseButton provides a file dialog at the click of a button." +
		"It allows creating custom file upload widgets such as the file upload grid in this example.  "+
		"The file upload grid uses BrowseButton to get file upload fields and adds them to a hidden form.  View the source for more details" + 
		"<p>This sample and wrapper was added by <b>Justin Riley</b></p>";
	}

	protected boolean showEvents() {
		return true;
	}

	@Override
	public Panel getViewPanel() {
		if (null == panel) {
			panel = new Panel();
			panel.add(getFileForm());
			panel.add(getFileUploadGrid());
			panel.add(getUploadButton());
		}
		return panel;
	}

	private Component getUploadButton() {
		if (null == uploadFiles) {
			uploadFiles = new Button("Upload Files");
			uploadFiles.addListener(new ButtonListenerAdapter() {
			    public void onClick(Button button, EventObject e) {
			    	GWT.log("size: " + getFileMap().size(),null);
			    	getFileForm().removeAll();
			    	Iterator<TextField> files = getFileMap().values().iterator();
			    	while ( files.hasNext() ) {
			    		TextField tf = files.next();
			    		getFileForm().add(tf);
			    	}
			    	getFileForm().doLayout();
			    	getFileForm().getForm().submit();
			    }
			});
		}
		return uploadFiles;
	}

	public GridPanel getFileUploadGrid() {
		if (null == fileGrid) {
			fileGrid = new GridPanel();
			fileGrid.setTitle("File Upload");
			ColumnConfig filenameCol = new ColumnConfig("Filename", "filename", 220, true, null, "filename");
			filenameCol.setTooltip("File to upload");

			ColumnConfig locationCol = new ColumnConfig("Location", "location", 130);  
			locationCol.setTooltip("Full path to file");

			ColumnConfig[] columnConfigs = {  
					filenameCol,  
					locationCol
			};  

			ColumnModel columnModel = new ColumnModel(columnConfigs);  
			columnModel.setDefaultSortable(true);  		

			fileGrid.setAutoScroll(true);
			fileGrid.setStore(getFileStore());  
			fileGrid.setColumnModel(columnModel);  
			//			setAutoExpandColumn("filename");
			fileGrid.setSelectionModel(new RowSelectionModel());
			fileGrid.setAutoHeight(true);
			fileGrid.setFrame(true);  

			fileGrid.setTopToolbar(getToolbar());  
			fileGrid.setAutoWidth(true);
			fileGrid.setStripeRows(true);
		}
		return fileGrid;
	}

	public Map<String,TextField> getFileMap() {
		if (null == fileMap) {
			fileMap = new HashMap<String,TextField>();
		}
		return fileMap;
	}
	public RecordDef getRecordDef() {
		if (null == recordDef) {
			this.recordDef = new RecordDef(  
					new FieldDef[]{  
							new StringFieldDef("filename"),  
							new StringFieldDef("location")
					}  
			);  	
		}
		return recordDef;
	}

	private Store getFileStore() {
		if (null == fileStore) {
			fileStore = new Store(getRecordDef());
		}
		return fileStore;
	}

	private Toolbar getToolbar() {
		if (null == toolbar) {
			toolbar = new Toolbar();
			BrowseButton addFiles = new BrowseButton("Add File");
			addFiles.setTooltip("Add Files");
			addFiles.addListener(new BrowseButtonListenerAdapter() {
				public void onInputFileChange(BrowseButton browseButton, String filename) {
					getFileMap().put(getBaseName(filename), browseButton.getFileInputField());
					Record record = recordDef.createRecord(new Object[] { getBaseName(filename), filename});
					getFileStore().insert(0, record);
					log(EVENT, "added file: " + getBaseName(filename));
				}
			});

			ToolbarButton removeFiles = new ToolbarButton("Remove File(s)");
			removeFiles.setTooltip("Remove Files");
			removeFiles.addListener(new ButtonListenerAdapter() { 
				public void onClick(Button button, EventObject e) {
					Iterator<Record> records = Arrays.asList(getFileUploadGrid().getSelectionModel().getSelections()).iterator();
					while(records.hasNext()) {
						Record record = records.next();
						String filename = record.getAsString("filename");
						getFileStore().remove(record);
						getFileMap().remove(filename);
						log(EVENT, "removed file: " + filename);
					}
					getFileUploadGrid().getSelectionModel().selectFirstRow();
				}
			});
			toolbar.addElement(addFiles.getElement());
			toolbar.addButton(removeFiles);
		}
		return toolbar;
	}

	private String getBaseName(String filePath) {
		String[] parts = filePath.split("/");
		if (parts.length < 2) {
			parts = filePath.split("\\\\");
		}
		return parts[parts.length-1];
	}

	public FormPanel getFileForm() {
		if (null == fileForm) {
			fileForm = new FormPanel();
			fileForm.setTitle("Files Form");
			fileForm.setFileUpload(true);
			fileForm.setVisible(false);
			fileForm.setUrl("UploadSvc");
			fileForm.setMethod(Connection.POST);
			fileForm.add(new Hidden());	
		}
		return fileForm;
	}	

}
