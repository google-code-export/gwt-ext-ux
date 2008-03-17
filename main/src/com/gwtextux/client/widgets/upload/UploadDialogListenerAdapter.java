package com.gwtextux.client.widgets.upload;

import com.gwtext.client.widgets.event.WindowListenerAdapter;

public class UploadDialogListenerAdapter extends WindowListenerAdapter
		implements UploadDialogListener {

	public boolean onBeforeAdd(UploadDialog source, String filename) {
		return true;
	}

	public void onFileAdd(UploadDialog source, String filename) {
	}

	public void onFileRemove(UploadDialog source, String filename) {
	}

	public void onFileUploadStart(UploadDialog source, String filename) {
	}

	public void onResetQueue(UploadDialog source) {
	}

	public void onUploadComplete(UploadDialog source) {
	}

	public void onUploadError(UploadDialog source, String filename, String data) {
	}

	public void onUploadFailed(UploadDialog source, String filename) {
	}

	public void onUploadStart(UploadDialog source) {		
	}

	public void onUploadStop(UploadDialog source) {		
	}

	public void onUploadSuccess(UploadDialog source, String filename,
			String data) {		
	}

}
