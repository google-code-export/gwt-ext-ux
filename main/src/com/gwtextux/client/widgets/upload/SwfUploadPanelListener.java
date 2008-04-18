package com.gwtextux.client.widgets.upload;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.grid.event.GridCellListener;

public interface SwfUploadPanelListener extends GridCellListener {

	public void onFileQueued(SwfUploadPanel swfUploadPanel, String filename);
	
	public void onQueueUploadComplete(SwfUploadPanel swfUploadPanel);
	
	public void onFileUploadComplete(SwfUploadPanel swfUploadPanel, String filename, JavaScriptObject response);

	public void onSwfUploadLoaded(SwfUploadPanel swfUploadPanel);

}
