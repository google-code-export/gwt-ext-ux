package com.gwtextux.client.widgets.sliders;

import com.gwtext.client.widgets.event.BoxComponentListener;

public interface RangeSliderListener extends BoxComponentListener {
	public void onDragStart(RangeSlider slider);
	public void onDragEnd(RangeSlider slider);
	public void onDrag(RangeSlider slider);
	public void onMouseOver(RangeSlider slider);
	public void onMouseOut(RangeSlider slider);
}
