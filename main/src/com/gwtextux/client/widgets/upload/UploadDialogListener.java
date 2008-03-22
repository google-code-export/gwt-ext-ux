package com.gwtextux.client.widgets.upload;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.event.WindowListener;

public interface UploadDialogListener extends WindowListener {

	/**
	 * Fires before file is added into the queue.
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 * @return If handler returns false then file will not be queued.
	 */
	public boolean onBeforeAdd(UploadDialog source, String filename);
	
	/**
	 * Fires when file is added into the queue
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 */
	public void onFileAdd(UploadDialog source, String filename);
	
	/**
	 * Fires when file is removed from the queue
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 */
	public void onFileRemove(UploadDialog source, String filename);
	
	/**
	 * Fires when upload queue is resetted
	 * @param source the UploadDialog
	 */
	public void onResetQueue(UploadDialog source);
	
	/**
	 * Fires when file as about to start uploading
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 */
	public void onFileUploadStart(UploadDialog source, String filename);

	/**
	 * Fires when file is successfuly uploaded
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 * @param data js-object builded from json-data returned from upload handler response.
	 */
	public void onUploadSuccess(UploadDialog source, String filename, JavaScriptObject data);

	/**
	 * Fires when file upload error occured
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 * @param data js-object builded from json-data returned from upload handler response.
	 */
	public void onUploadError(UploadDialog source, String filename, JavaScriptObject data);

	/**
	 * Fires when file upload failed
	 * @param source the UploadDialog
	 * @param filename the name of the file to queue
	 */
	public void onUploadFailed(UploadDialog source, String filename);

	
	/**
	 * Fires when upload process starts
	 * @param source the UploadDialog
	 */
	public void onUploadStart(UploadDialog source);

	/**
	 * Fires when upload process stops
	 * @param source the UploadDialog
	 */
	public void onUploadStop(UploadDialog source);

	/**
	 * Fires when upload process complete (no files to upload left)
	 * @param source the UploadDialog
	 */
	public void onUploadComplete(UploadDialog source);

}
