package com.gwtextux.client.widgets.htmleditor.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * HTMLEditor styles plugin by Dan W. Greenfield
 * http://extjs.com/forum/showthread.php?t=19480
 * http://danwgreenfield.free-web-hosting.biz/ (was working ... defunct now)
 * 
 * @author Abhijeet Maharana
 *
 */
public class HtmlEditorStyles extends ComponentPlugin {

	public HtmlEditorStyles(NameValuePair[] styles) {
		JavaScriptObject[] styleArray = new JavaScriptObject[styles.length];
		
		// NameValuePair uses name:value whereas HtmlEditorStyles uses text:value
		for(int i=0; i<styles.length; ++i)
		{
			JavaScriptObject style = JavaScriptObjectHelper.createObject();
			JavaScriptObjectHelper.setAttribute(style, "text", styles[i].getName());
			JavaScriptObjectHelper.setAttribute(style, "value", styles[i].getValue());
			
			styleArray[i] = style;
		}

		jsObj = create(JavaScriptObjectHelper.convertToJavaScriptArray(styleArray));
	}

	/**
	 * Creates a native HTMLEditorStyles object
	 * 
	 * @return
	 */
	protected native JavaScriptObject create() /*-{
		return new $wnd.Ext.ux.HTMLEditorStyles();
	}-*/;

	/**
	 * Creates a native HTMLEditorStyles object
	 * 
	 * @param cfg
	 * @return
	 */
	protected native JavaScriptObject create(JavaScriptObject cfg) /*-{
		return new $wnd.Ext.ux.HTMLEditorStyles(cfg);
	}-*/;

	/**
	 * Returns the xtype of this plugin.
	 * 
	 * @return
	 */
	public String getXType() {
		return "htmleditorstyles";
	}
	
	/**
	 * @param component
	 */
	@Override
	public void init(Component component) {
	}
}
