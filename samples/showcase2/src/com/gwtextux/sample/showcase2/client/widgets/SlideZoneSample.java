package com.gwtextux.sample.showcase2.client.widgets;

import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtextux.client.widgets.sliders.RangeSlider;
import com.gwtextux.client.widgets.sliders.SlideZone;
import com.gwtextux.client.widgets.sliders.Slider;
import com.gwtextux.client.widgets.sliders.SliderListenerAdapter;
import com.gwtextux.client.widgets.sliders.ThumbSlider;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class SlideZoneSample extends ShowcasePanel {

	private SlideZone sz;
	
	public String getSourceUrl() {
		return "source/widgets/SlideZoneSample.java.html";
	}

	public String getIntro() {
		return "<p>This example demonstrates the SlideZone bindings. The SlideZone bindings provide..." + 
		"<p>This sample and wrapper was added by <b>Justin Riley</b></p>";
	}

	protected boolean showEvents() {
		return true;
	}

	public Panel getViewPanel() {
		if (null == panel) {
			panel = new Panel();
			panel.setWidth(700);
			panel.add(getSlider());
		}
		return panel;
	}

	private SlideZone getSlider() {
		if (null == sz) {
			sz = new SlideZone();
			sz.setHorizontal();
//			sz.setVertical();
			sz.setSize(500);
			sz.setWidth(10);
			sz.setHeight(13);
			sz.setMaxValue(1000);
			sz.setMinValue(0);
			sz.setSnap(20);
			sz.allowSliderCrossing(false);
			
			ThumbSlider sl1 = new ThumbSlider("slider1", 250);
			RangeSlider sl2 = new RangeSlider("slider2",300,500);
			ThumbSlider sl3 = new ThumbSlider("slider3", 750);
			
			sl1.addListener(new SliderListenerAdapter() {
				public void onDrag(Slider slider) {
					log(EVENT, "onDrag: " + slider.getValue());					
				}

				public void onDragEnd(Slider slider) {
					log(EVENT, "onDragEnd: " + slider.getValue());
				}

				public void onDragStart(Slider slider) {
					log(EVENT, "onDragStart: " + slider.getValue());
				}

				public void onMouseOut(Slider slider) {
					log(EVENT, "onMouseOut: " + slider.getValue());
				}

				public void onMouseOver(Slider slider) {
					log(EVENT, "onMouseOver: " + slider.getValue());
				}
			});
			sz.addSlider(sl1);
			sz.addSlider(sl2);
			sz.addSlider(sl3);
			
		}
		return sz;
	}

}
