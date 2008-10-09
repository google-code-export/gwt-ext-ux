package com.gwtextux.client.widgets.sliders;

import com.gwtext.client.widgets.event.BoxComponentListener;

public interface SliderListener extends BoxComponentListener {
	public void onDragStart(Slider slider);
	public void onDragEnd(Slider slider);
	public void onDrag(Slider slider);
	public void onMouseOver(Slider slider);
	public void onMouseOut(Slider slider);
}
