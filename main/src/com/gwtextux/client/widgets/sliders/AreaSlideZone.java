package com.gwtextux.client.widgets.sliders;

import com.google.gwt.core.client.JavaScriptObject;

public class AreaSlideZone extends SlideZone {
	
	public AreaSlideZone() {
		setArea();
	}
	
	public void addSlider(RangeSlider slider) {
		addSliderJS(slider);
	}
	
	public void addSlider(ThumbSlider slider) {
		addSliderJS(slider);
	}
	
	private void addSliderJS(Slider slider) {
		JavaScriptObject sliderJS = slider.getOrCreateJsObj();
		addSlider(sliderJS);
	}
	
	public void setArea(int[] area) {
		setSize(area);
	}
	
	public void setArea(int horizontal, int vertical) {
		setArea(new int[] {horizontal, vertical});
	}
	
	private void setSize(int[] size) {
		setAttribute("size", size, true);
	}
	
	public void setWidth(int width) {
		setAttribute("sliderWidth", width, true);
	}
	
	public void setHeight(int height) {
		setAttribute("sliderHeight", height, true);
	}
	
	public void setMaxValue(int x, int y) {
		setMaxValue(new int[] {x,y});
	}
	
	private void setMaxValue(int[] max) {
		setAttribute("maxValue", max, true );
	}
	
	public void setMinValue(int x, int y) {
		setMaxValue(new int[] {x,y});
	}
	
	public void setMinValue(int[] min) {
		setAttribute("minValue", min, true);
	}
	
	public void setSnap(int x, int y) {
		setSnap(new int[] {x,y});
	}

	public void setSnap(int[] snap) {
		setAttribute("sliderSnap", snap, true);
	}
}
