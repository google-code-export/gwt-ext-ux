package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.BoxComponent;

public abstract class SlideZone extends BoxComponent {
	
	private static JavaScriptObject configPrototype;
	
	static {
		init();
	}

	private static native void init() /*-{
	    var c = new $wnd.Ext.ux.SlideZone();
		@com.gwtextux.client.widgets.sliders.SlideZone::configPrototype = c.initialConfig;
	}-*/;
	
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
    	return new $wnd.Ext.ux.SlideZone(config);
	}-*/;
	
	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "slidezone";
	}

	public void allowSliderCrossing(boolean allowCross) {
		setAttribute("allowSliderCrossing", allowCross, true);
	}
	
	protected void setHorizontal() {
		setAttribute("type", "horizontal", true);
	}
	
	protected void setVertical() {
		setAttribute("type", "vertical", true);
	}
	
	protected void setArea() {
		setAttribute("type", "area", true);
	}

	protected native void addSlider(JavaScriptObject slider) /*-{
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.addSlider(slider);
	}-*/;
}