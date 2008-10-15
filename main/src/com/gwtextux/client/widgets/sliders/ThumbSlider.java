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
	
	public void setValue(float value) {
		setAttribute("value", value, true);
	}
	
	public float getValue() {
		return getAttributeAsFloat("value");
	}
	
	public native void addListener(ThumbSliderListener listener) /*-{	
	this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
	
	var sliderJ = this;

	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragstart',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.ThumbSliderListener::onDragStart(Lcom/gwtextux/client/widgets/sliders/ThumbSlider;)(sliderJ);
        }
	);
	
	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragend',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.ThumbSliderListener::onDragEnd(Lcom/gwtextux/client/widgets/sliders/ThumbSlider;)(sliderJ);
        }
	);
	
	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('drag',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.ThumbSliderListener::onDrag(Lcom/gwtextux/client/widgets/sliders/ThumbSlider;)(sliderJ);
        }
	);
	
	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseover',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.ThumbSliderListener::onMouseOver(Lcom/gwtextux/client/widgets/sliders/ThumbSlider;)(sliderJ);
        }
	);
	
	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseout',
        function(slider) {
            return listener.@com.gwtextux.client.widgets.sliders.ThumbSliderListener::onMouseOut(Lcom/gwtextux/client/widgets/sliders/ThumbSlider;)(sliderJ);
        }
	);
	
}-*/;
}
