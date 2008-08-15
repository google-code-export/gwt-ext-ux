package com.gwtextux.client.widgets.htmleditor;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.ComponentPlugin;
import com.gwtext.client.widgets.QuickTips;

/**
 * Enhanced HTMLEditor by Dan W. Greenfield
 * http://extjs.com/forum/showthread.php?t=19480
 * http://danwgreenfield.free-web-hosting.biz/ (was working ... defunct now)
 * 
 * @author Abhijeet Maharana
 */

public class HtmlEditor extends com.gwtext.client.widgets.form.HtmlEditor {
	
	 private static JavaScriptObject configPrototype;
	 
	 static {
		 QuickTips.init();
		 registerXType();
		 init();
	 }

	 /**
	  * If Enhanced HTML Editor returns 'htmleditor' as it's type,
	  * Ext creates form.HtmlEditor and passes it to the plugins.
	  * This causes an error as form.HtmlEditor doesn't have a 'tb' variable which is
	  * present in ux.HTMLEditor as expected by the related plugins. 
	  */
	 private static native void registerXType()/*-{
	 	$wnd.Ext.ComponentMgr.registerType('enhancedhtmleditor', $wnd.Ext.ux.HTMLEditor);
	 }-*/;

	public String getXType() {
		return "enhancedhtmleditor";
	}

	public void addPlugin(ComponentPlugin plugin) {
		super.addPlugin(plugin);
		addListener("render", new Function(){
			public void execute() {
				HtmlEditor.this.getOwnerContainer().doLayout();
			};
		});
	}
	
	private static native void init()/*-{
		var c = new $wnd.Ext.ux.HTMLEditor();
		@com.gwtextux.client.widgets.htmleditor.HtmlEditor::configPrototype = c.initialConfig;
	}-*/;
	
	public HtmlEditor(JavaScriptObject jsObj) {
		super(jsObj);
	}
	
	public HtmlEditor() {
	}

    public HtmlEditor(String fieldLabel) {
        super(fieldLabel);
    }

	public HtmlEditor(String fieldLabel, String name) {
		super(fieldLabel, name);
	}

	public HtmlEditor(String fieldLabel, String name, int width) {
		super(fieldLabel, name, width);
	}
	
	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}
	
	protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
    	return new $wnd.Ext.ux.HTMLEditor(jsObj);
	}-*/;
	
	public void setStylesheetPaths(String[] stylesheetPaths) {
		setAttribute("styles", JavaScriptObjectHelper.convertToJavaScriptArray(stylesheetPaths), false);
	}
}
