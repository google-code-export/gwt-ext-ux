/*
 * Copyright 2006 Alistair Rutherford (http://code.google.com/p/gwtsimiletimeline/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtextux.client.widgets.timeline;


import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * BandOptions
 *
 * @author ajr
 */
public class BandOptions extends JavaScriptObject
{
    protected BandOptions(int opaque)
    {
        super();
    }

    public static BandOptions create()
    {
        return BandOptionsImpl.create();
    }

    /**
     * how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     *
     */
    public String getWidth()
    {
        return JavaScriptObjectHelper.getAttribute(this, "width");
    }

    /**
     * required, how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     */
    public void setWidth(String width)
    {
        JavaScriptObjectHelper.setAttribute(this, "width", width);
    }

    /**
     * a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     *
     */
    public int getIntervalUnit()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "intervalUnit");
    }

    /**
     * required, a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     */
    public void setIntervalUnit(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "intervalUnit", value);
    }

    /**
     * the number of pixels that the time unit above is mapped to, e.g., 100.
     *
     */
    public int getIntervalPixels()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "intervalPixels");
    }

    /**
     * required, the number of pixels that the time unit above is mapped to, e.g., 100.
     */
    public void setIntervalPixels(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "intervalPixels", value);
    }

    /**
     * a boolean specifying whether event titles are to be painted. The default is true. 
     *
     */
    public boolean getShowEventText()
    {
        return JavaScriptObjectHelper.getAttributeAsBoolean(this, "showEventText");
    }

    /**
     * optional, a boolean specifying whether event titles are to be painted. The default is true.
     */
    public void setShowEventText(boolean value)
    {
        JavaScriptObjectHelper.setAttribute(this, "showEventText", value);
    }
    
    /**
     * the number of em  (dependent on the current font) to be left between adjacent
     * tracks on which events are painted. The default value is retrieved from the provided or 
     * default theme. E.g., 0.5.
     *
     */
    public float getTrackGap()
    {
        return JavaScriptObjectHelper.getAttributeAsFloat(this, "trackGap");
    }

    /**
     * optional, the number of em  (dependent on the current font) to be left between adjacent
     * tracks on which events are painted. The default value is retrieved from the provided or 
     * default theme. E.g., 0.5.
     */
    public void setTrackGap(float value)
    {
        JavaScriptObjectHelper.setAttribute(this, "trackGap", value);
    }

    /**
     * the height of each track in em  (dependent on the current font). 
     * The default value is retrieved from the provided or default theme. E.g., 1.5.
     *
     */
    public float getTrackHeight()
    {
        return JavaScriptObjectHelper.getAttributeAsFloat(this, "trackHeight");
    }

    /**
     * optional, the height of each track in em  (dependent on the current font). 
     * The default value is retrieved from the provided or default theme. E.g., 1.5.
     */
    public void setTrackHeight(float value)
    {
        JavaScriptObjectHelper.setAttribute(this, "trackHeight", value);
    }

    /**
     * required, Band theme
     */
    public void setTheme(Theme value)
    {
        JavaScriptObjectHelper.setAttribute(this, "theme", value);
    }

    /**
     * Band theme
     */
    public JavaScriptObject getTheme()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "theme");
    }

    /**
     * required, Event source
     */
    public void setEventSource(EventSource value)
    {
        JavaScriptObjectHelper.setAttribute(this, "eventSource", value);
    }

    /**
     * Event source
     */
    public JavaScriptObject getEventSource()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "eventSource");
    }

    /**
     * optional, set date
     */
    public void setDate(String value)
    {
        JavaScriptObjectHelper.setAttribute(this, "date", value);
    }

    /**
     * optional, set time zone
     */
    public void setTimeZone(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "timeZone", value);
    }
    
    /**
     * optional, set hot zones
     */
    public void setZones(List zones)
    {
    	JavaScriptObject[] zonesArr = JavaScriptObjectHelper.listToArray(zones);

        JavaScriptObject jarr = JavaScriptObjectHelper.arrayConvert(zonesArr);

        JavaScriptObjectHelper.setAttribute(this, "zones", jarr);
    }
    
}
