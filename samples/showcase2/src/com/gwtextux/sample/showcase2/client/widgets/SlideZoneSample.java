package com.gwtextux.sample.showcase2.client.widgets;

import com.gwtext.client.widgets.Panel;
import com.gwtextux.client.widgets.sliders.AreaSlideZone;
import com.gwtextux.client.widgets.sliders.HorizontalSlideZone;
import com.gwtextux.client.widgets.sliders.RangeSlider;
import com.gwtextux.client.widgets.sliders.RangeSliderListenerAdapter;
import com.gwtextux.client.widgets.sliders.SlideZone;
import com.gwtextux.client.widgets.sliders.ThumbSlider;
import com.gwtextux.client.widgets.sliders.ThumbSliderListenerAdapter;
import com.gwtextux.client.widgets.sliders.VerticalSlideZone;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class SlideZoneSample extends ShowcasePanel {

	private VerticalSlideZone sz;
//	private AreaSlideZone sz;
	
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
			sz = new VerticalSlideZone();
			sz.setSize(500);
			sz.setWidth(10);
			sz.setHeight(13);
			sz.setMaxValue(1000);
			sz.setMinValue(0);
			sz.setSnap(20);
			sz.allowSliderCrossing(false);
			ThumbSlider sl1 = new ThumbSlider("slider1", 250);
			RangeSlider sl2 = new RangeSlider("slider2",300,400);
			ThumbSlider sl3 = new ThumbSlider("slider3", 750);
			
			sl1.addListener(new ThumbSliderListenerAdapter() {
				public void onDrag(ThumbSlider slider) {
					log(EVENT, "onDrag: " + slider.getValue());
				}

				public void onDragEnd(ThumbSlider slider) {
					log(EVENT, "onDragEnd: " + slider.getValue());
				}

				public void onDragStart(ThumbSlider slider) {
					log(EVENT, "onDragStart: " + slider.getValue());
				}
			});
			
			sl2.addListener(new RangeSliderListenerAdapter() {
				public void onDrag(RangeSlider slider) {
					int[] value = slider.getValue();
					log(EVENT, "onDrag: [ " + value[0] + ", " + value[1] + " ]" );	
				}

				public void onDragEnd(RangeSlider slider) {
					int[] value = slider.getValue();
					log(EVENT, "onDragEnd: [ " + value[0] + ", " + value[1] + " ]" );	
				}

				public void onDragStart(RangeSlider slider) {
					int[] value = slider.getValue();
					log(EVENT, "onDragStart: [ " + value[0] + ", " + value[1] + " ]" );	
				}
			});
			
			sz.addSlider(sl1);
			sz.addSlider(sl2);
			sz.addSlider(sl3);
//			sz = new AreaSlideZone();
//			sz.setSize(100, 100);
//			sz.setMaxValue(100, 100);
//			sz.setMinValue(0,0);
//			sz.getOrCreateJsObj();
		}
		return sz;
	}

}
