package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class RangeSlider extends Slider {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init() /*-{
	    var c = new $wnd.Ext.ux.RangeSlider();
		@com.gwtextux.client.widgets.sliders.RangeSlider::configPrototype = c.initialConfig;
	}-*/;


	public RangeSlider(String name, int rangeBegin, int rangeEnd) {
		setName(name);		
		setValue(new int[]{rangeBegin, rangeEnd});
	}

	public RangeSlider(String name, int[] range) {
		setName(name);
		setValue(range);
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
	
	public int[] getValue() {
		JavaScriptObject js = getAttributeAsJavaScriptObject("value");
		int length = JavaScriptObjectHelper.getArrayLength(js);
		int[] value = new int[length];
		for(int i=0; i < length; ++i) {
			value[i]=Integer.parseInt(JavaScriptObjectHelper.getArrayValue(js, i));
		}
		return value;
	}
	
	public void setValue(int begin, int end) {
		setValue(new int[] { begin,end});
	}
	
	public void setValue(int[] value) {
		setAttribute("value", value, true);
	}

//	private native void alert(String msg)/*-{
//	$wnd.alert(msg);
//}-*/;

	public native void addListener(RangeSliderListener listener) /*-{	
	this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);

	var sliderJ = this;

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragstart',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.RangeSliderListener::onDragStart(Lcom/gwtextux/client/widgets/sliders/RangeSlider;)(sliderJ);
        }
	);

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragend',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.RangeSliderListener::onDragEnd(Lcom/gwtextux/client/widgets/sliders/RangeSlider;)(sliderJ);
        }
	);

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('drag',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.RangeSliderListener::onDrag(Lcom/gwtextux/client/widgets/sliders/RangeSlider;)(sliderJ);
        }
	);

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseover',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.RangeSliderListener::onMouseOver(Lcom/gwtextux/client/widgets/sliders/RangeSlider;)(sliderJ);
        }
	);

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseout',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.RangeSliderListener::onMouseOut(Lcom/gwtextux/client/widgets/sliders/RangeSlider;)(sliderJ);
        }
	);

	}-*/;
}