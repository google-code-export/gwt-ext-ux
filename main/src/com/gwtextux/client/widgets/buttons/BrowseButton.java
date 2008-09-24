package com.gwtextux.client.widgets.buttons;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.form.TextField;

public class BrowseButton extends Button {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
	    var c = new $wnd.Ext.ux.form.BrowseButton();
		@com.gwtextux.client.widgets.buttons.BrowseButton::configPrototype = c.initialConfig;
	}-*/;

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.form.BrowseButton(config);
    }-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "browsebutton";
	}

	public BrowseButton(String text) {
		setText(text);
	}
	
	public native void addListener(BrowseButtonListener listener) /*-{	
		//calling super here clobbers BrowseButton's internal handlers which perform all the magic
		//this.@com.gwtext.client.widgets.Button::addListener(Lcom/gwtext/client/widgets/event/ButtonListener;)(listener);
	    var browseButtonJ = this;
	    
	    this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('inputfilechange',
	            function(source,filename) {
	                return listener.@com.gwtextux.client.widgets.buttons.BrowseButtonListener::onInputFileChange(Lcom/gwtextux/client/widgets/buttons/BrowseButton;Ljava/lang/String;)(browseButtonJ, filename);
	            }
	    );
	}-*/;
	
	// this screwed me up forever: boolean noCreate vs Boolean noCreate
	private native JavaScriptObject detachInputFile(boolean noCreate) /*-{
	    var browseButtonJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
	    return browseButtonJ.detachInputFile(noCreate);
	}-*/;
	
	public TextField getFileInputField() {
		return getFileField(Ext.generateId());
	}
	
	public TextField getFileInputField(String name) {
		return getFileField(name);
	}
	
	private TextField getFileField(String name) {
		JavaScriptObject inputFile = detachInputFile(false);
		ExtElement e = new ExtElement(inputFile);		
		//this is GWT 1.5 specific, lets check with users first before removing support for 1.4
		//e.getDOM().setAttribute("name", name);
		DOM.setElementAttribute(e.getDOM(), "name", name);
		TextField tf = new TextField();
		tf.setInputType("file");
		tf.setEl(e.getDOM());
		return tf;
	}
}		
