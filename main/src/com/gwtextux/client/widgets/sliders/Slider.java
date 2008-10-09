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

	public native String getName()/*-{
		var sliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return sliderJ.name;
	}-*/;
	
	public native float getValue()/*-{
		var sliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		return sliderJ.value;
	}-*/;
	public native void setName(String name)/*-{
		var sliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		sliderJ.name = name;
	}-*/;

	public native void setValue(float value)/*-{
		var sliderJ = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		sliderJ.value = value;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "slider";
	}

	public native void addListener(SliderListener listener) /*-{	
		this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
		
    	var sliderJ = this;

    	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragstart',
            function(slider) {
                return listener.@com.gwtextux.client.widgets.sliders.SliderListener::onDragStart(Lcom/gwtextux/client/widgets/sliders/Slider;)(sliderJ);
            }
    	);
    	
    	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dragend',
            function(slider) {
                return listener.@com.gwtextux.client.widgets.sliders.SliderListener::onDragEnd(Lcom/gwtextux/client/widgets/sliders/Slider;)(sliderJ);
            }
    	);
    	
    	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('drag',
            function(slider) {
                return listener.@com.gwtextux.client.widgets.sliders.SliderListener::onDrag(Lcom/gwtextux/client/widgets/sliders/Slider;)(sliderJ);
            }
    	);
    	
    	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseover',
            function(slider) {
                return listener.@com.gwtextux.client.widgets.sliders.SliderListener::onMouseOver(Lcom/gwtextux/client/widgets/sliders/Slider;)(sliderJ);
            }
    	);
    	
    	this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseout',
            function(slider) {
                return listener.@com.gwtextux.client.widgets.sliders.SliderListener::onMouseOut(Lcom/gwtextux/client/widgets/sliders/Slider;)(sliderJ);
            }
    	);
    	
	}-*/;
}
