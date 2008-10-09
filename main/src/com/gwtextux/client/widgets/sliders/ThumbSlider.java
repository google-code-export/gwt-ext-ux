package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;

public class ThumbSlider extends Slider {

	private static JavaScriptObject configPrototype;
	
	static {
		init();
	}

	private static native void init() /*-{
	    var c = new $wnd.Ext.ux.ThumbSlider();
		@com.gwtextux.client.widgets.sliders.ThumbSlider::configPrototype = c.initialConfig;
	}-*/;
	

	public ThumbSlider(String name, float value)
	{
		super();
		setName(name);
		setValue(value);
	}

	private native void alert(String msg)/*-{
		$wnd.alert(msg);
	}-*/;

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.ThumbSlider(config);
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "thumbslider";
	}
}
