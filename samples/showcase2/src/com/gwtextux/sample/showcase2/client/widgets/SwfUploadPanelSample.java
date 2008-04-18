/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Panel;
import com.gwtextux.client.widgets.upload.SwfUploadPanel;
import com.gwtextux.client.widgets.upload.SwfUploadPanelListenerAdapter;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;


/**
 * Example that illustrates simple buttons.
 */
public class SwfUploadPanelSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/widgets/SwfUploadPanelSample.java.html";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

        	SwfUploadPanel swfpanel = new SwfUploadPanel();
        	swfpanel.setHeight(300);
        	swfpanel.setWidth(500);
        	swfpanel.setTitle("SwfUploadPanel");
        	swfpanel.setUploadUrl("UploadSvc");
        	swfpanel.setFlashUrl("js/swfuploadpanel/swfupload_f9.swf");
        	swfpanel.addListener(new SwfUploadPanelListenerAdapter(){
        		public void onFileQueued(SwfUploadPanel swfUploadPanel, String filename) {
        			log(EVENT, "onFileQueued. File='" + filename);
        		}

        		public void onFileUploadComplete(SwfUploadPanel swfUploadPanel,
        				String filename, JavaScriptObject response) {	
        			log(EVENT, "onFileUploadComplete. File='" + filename + "'.");
        			log(EVENT, "onFileUploadComplete. response='" + JavaScriptObjectHelper.getAttribute(response, "code") + "'. ");
        		}

        		public void onQueueUploadComplete(SwfUploadPanel swfUploadPanel) {
        			log(EVENT, "onQueueUploadComplete event fired...");
        		}

        		public void onSwfUploadLoaded(SwfUploadPanel swfUploadPanel) {
        			log(EVENT, "onSwfUploadLoaded event fired...");
        		}         
        	});
        	swfpanel.show();
        	panel.add(swfpanel);
        }
        
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }
    
    public String getIntro() {
        return "<p>This example demonstrates SwfUploadPanel. The component allows to " +
        "upload file(s) to the server.  The advantage of SwfUploadPanel is that it can " +
        "select multiple files at once." +
        "</p><p>This sample and wrapper was added by <b>Mario Lim</b></p>";
    }


}