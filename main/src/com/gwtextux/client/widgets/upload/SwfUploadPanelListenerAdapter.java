package com.gwtextux.client.widgets.upload;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;

public class SwfUploadPanelListenerAdapter extends GridCellListenerAdapter 
	implements SwfUploadPanelListener{

	public void onFileQueued(SwfUploadPanel swfUploadPanel, String filename) {
	}

	public void onFileUploadComplete(SwfUploadPanel swfUploadPanel,
			String filename, JavaScriptObject response) {	
	}

	public void onQueueUploadComplete(SwfUploadPanel swfUploadPanel) {
	}

	public void onSwfUploadLoaded(SwfUploadPanel swfUploadPanel) {
	
	}         

}
