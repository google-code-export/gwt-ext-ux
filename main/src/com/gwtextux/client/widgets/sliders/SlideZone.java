package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.gwtext.client.widgets.BoxComponent;

public class SlideZone extends BoxComponent {
	
	private static JavaScriptObject configPrototype;
	public static int UNKNOWN = -1;
	public static int HORIZONTAL = 0;
	public static int VERTICAL = 1;
	public static int AREA = 2;
	
	static {
		init();
	}

	private static native void init() /*-{
	    var c = new $wnd.Ext.ux.SlideZone();
	    //$wnd.alert('slidezone init: ' + c.initialConfig);
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
	
	public native int getOrientation() /*-{
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		if(slideZoneJ.type == "horizontal") {
			return 0;
		} else if(slideZoneJ.type == "vertical") {
				return 1;
		} else if(slideZoneJ.type == "area") {
				return 2;
		} else {
				return -1;
		}
	}-*/;
	
	public native void allowSliderCrossing(boolean allowCross) /*-{
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.allowSliderCrossing = allowCross;
	}-*/; 
	
	public native void setHorizontal() /*-{
		//$wnd.alert('setHorizontal');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.type = 'horizontal';
	}-*/;
		
	public native void setVertical() /*-{
		//$wnd.alert('setVertical');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.type = 'vertical';
		//$wnd.alert(slideZoneJ.type);
	}-*/;
	
	public native void setArea() /*-{
		//$wnd.alert('setArea');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.type = 'area';
	}-*/;

	public native void setSize(int size) /*-{
		//$wnd.alert('setSize');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.size = size;
	}-*/;
	
	public native void setWidth(int width) /*-{
		//$wnd.alert('setWidth');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.sliderWidth = width;
	}-*/;
	
	public native void setHeight(int height) /*-{
		//$wnd.alert('setHeight');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.sliderHeight = height;
	}-*/;
	
	public native void setMaxValue(float max) /*-{
		//$wnd.alert('setMaxValue');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.maxValue = max;
	}-*/;
	
	private native void setMaxValue(JavaScriptObject max) /*-{
		//$wnd.alert('setMaxValue');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.maxValue = max;
}-*/;	
	public void setMaxValue(float x, float y) {
		setMaxValue(new float[] {x,y});
	}
	
	public void setMaxValue(float[] maxCoords) {
		JsArrayNumber maxValue = getNumberArray();
		maxValue.set(0, maxCoords[0]);
		maxValue.set(1, maxCoords[1]);
		setMaxValue(maxValue);
	}
	
	private native JsArrayNumber getNumberArray() /*-{
		return [0.0,0.0];
	}-*/;

	public native void setMinValue(float min) /*-{
		//$wnd.alert('setMinValue');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.minValue = min;
	}-*/;

	public native void setSnap(float snap) /*-{
		//$wnd.alert('setSnap');
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.sliderSnap = snap;
	}-*/;
	
	public void addSlider(Slider slider) {
		JavaScriptObject sliderJS = slider.getOrCreateJsObj();
		addSlider(sliderJS);
	}
	
	private native void addSlider(JavaScriptObject slider) /*-{
		var slideZoneJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		slideZoneJ.addSlider(slider);
	}-*/;
}