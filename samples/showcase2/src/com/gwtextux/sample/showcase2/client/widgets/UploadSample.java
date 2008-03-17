/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.sample.showcase2.client.widgets;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtextux.client.widgets.upload.UploadDialog;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;


/**
 * Example that illustrates simple buttons.
 */
public class UploadSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/widgets/UploadDialogSample.java.html";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            Button button = new Button("Upload File", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    UploadDialog dialog = new UploadDialog();
                    dialog.setUrl("UploadSvc");
                    //dialog.setPermittedExtensions(new String[]{"jpg", "gif"});
                    UrlParam param[] = new UrlParam[2];
                    param[0]=new UrlParam("name1", "value1");
                    param[1]=new UrlParam("name2", "value2");
                    dialog.setBaseParams(param);
                    dialog.setPostVarName("myvar");
                    dialog.show();
                }
            });
            panel.add(button);
        }
        
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates Upload Dialog. The component allows to " +
        "upload file(s) to the server.  Other parameters can also be passed as well as "+
        "restricting by file extensions.</p>";
    }


}