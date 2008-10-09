package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class RangeSlider extends Slider {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init() /*-{
	    var c = new $wnd.Ext.ux.RangeSlider();
		@com.gwtextux.client.widgets.sliders.RangeSlider::configPrototype = c.initialConfig;
	}-*/;


	public RangeSlider(String name, float rangeBegin, float rangeEnd) {
		setName(name);		
		setRange(new float[]{rangeBegin, rangeEnd});
	}

	public RangeSlider(String name, float[] range) {
		setName(name);
		setRange(range);
	}

	private native JsArrayNumber getNumberArray()/*-{
		return [0.0,0.0]
	}-*/;
	
	public void setRange(float[] value) {
		JsArrayNumber js = getNumberArray();
		js.set(0, value[0]);
		js.set(1, value[1]);
		setValue(js);
	}
	
	
	private native void setValue(JavaScriptObject value)/*-{
		var rangeSliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		rangeSliderJ.value = value;
	}-*/;
	
	public float[] getRange() {
		JsArrayNumber value = getJSValue();
		return new float[] {(float) value.get(0), (float) value.get(1)};
	}
	
	private native JsArrayNumber getJSValue()/*-{
		var rangeSliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();	
		return rangeSliderJ.value;
	}-*/;
	

	private native void alert(String msg)/*-{
		$wnd.alert(msg);
	}-*/;

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.RangeSlider(config);
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "thumbslider";
	}
}
