package com.gwtextux.client.widgets.sliders;

import com.gwtext.client.widgets.event.BoxComponentListener;

public interface ThumbSliderListener extends BoxComponentListener {
	public void onDragStart(ThumbSlider slider);
	public void onDragEnd(ThumbSlider slider);
	public void onDrag(ThumbSlider slider);
	public void onMouseOver(ThumbSlider slider);
	public void onMouseOut(ThumbSlider slider);
}
