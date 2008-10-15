package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.BoxComponent;

public abstract class Slider extends BoxComponent {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
	    var c = new $wnd.Ext.ux.Slider();
		@com.gwtextux.client.widgets.sliders.Slider::configPrototype = c.initialConfig;
	}-*/;

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.Slider(config);
	}-*/;

	public String getName() {
		return getAttribute("name");
	}

	public void setName(String name) {
		setAttribute("name", name, true);
	}

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "slider";
	}


}
