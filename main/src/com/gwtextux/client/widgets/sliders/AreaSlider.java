package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class AreaSlider extends Slider {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}
	
	private static native void init() /*-{
    	var c = new $wnd.Ext.ux.RangeSlider();
		@com.gwtextux.client.widgets.sliders.RangeSlider::configPrototype = c.initialConfig;
	}-*/;
	
	public AreaSlider(String name, int x1, int x2, int y1, int y2) {
		setName(name);
		setValue(new int[] { x1, x2, y1, y2 });
	}
	
	public AreaSlider(String name, int[] size) {
		setName(name);
		setValue(size);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.RangeSlider(config);
	}-*/;
	
	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "rangeslider";
	}
	
	public void setValue(int begin, int end) {
		setValue(new int[] { begin,end});
	}
	
	public void setValue(int[] value) {
		JavaScriptObject jsArray = JavaScriptObjectHelper.createJavaScriptArray();
		JavaScriptObject coordArray0 = JavaScriptObjectHelper.createJavaScriptArray();
		JavaScriptObject coordArray1 = JavaScriptObjectHelper.createJavaScriptArray();
		JavaScriptObjectHelper.setArrayValue(coordArray0, 0, value[0]);
		JavaScriptObjectHelper.setArrayValue(coordArray0, 1, value[1]);
		JavaScriptObjectHelper.setArrayValue(coordArray1, 0, value[0]);
		JavaScriptObjectHelper.setArrayValue(coordArray1, 1, value[1]);
		JavaScriptObjectHelper.setArrayValue(jsArray, 0, coordArray0);
		JavaScriptObjectHelper.setArrayValue(jsArray, 1, coordArray1);
		setAttribute("value", jsArray, true);
	}
	
	public int[] getValue() {
		JavaScriptObject jsArray = getAttributeAsJavaScriptObject("value");
		int length = JavaScriptObjectHelper.getArrayLength(jsArray);
		int[] value = new int[length];
		for(int i=0; i < length; ++i) {
			JavaScriptObject jsArrayElement = JavaScriptObjectHelper.getValueFromJavaScriptObjectArray(jsArray, i);
			int l = JavaScriptObjectHelper.getArrayLength(jsArrayElement);
			for (int j=0; j<l; ++j) {
				value[i+j] = Integer.parseInt(JavaScriptObjectHelper.getArrayValue(jsArrayElement, j));
			}
		}
		return value;
	}
	
//	private native void alert(String msg)/*-{
//	$wnd.alert(msg);
//}-*/;

}
