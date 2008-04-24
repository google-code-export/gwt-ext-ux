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


import com.google.gwt.core.client.JavaScriptObject;


/**
 * BandOptions
 *
 * @author ajr
 */
public class HotZoneBandOptions extends JavaScriptObject
{
    protected HotZoneBandOptions(int opaque)
    {
        super();
    }

    public static HotZoneBandOptions create()
    {
        return HotZoneBandOptionsImpl.create();
    }

    /**
     * required, a String or a Date object that specifies the beginning date/time of the zone. It is parsed by Timeline.DateTime.parseGregorianDateTime()  
     * to get a Date object.
     */
    public void setStart(String value)
    {
        JavaScriptObjectHelper.setAttribute(this, "start", value);
    }

    /**
     * required, a String or a Date object that specifies the ending date/time of the zone. It is parsed by Timeline.DateTime.parseGregorianDateTime()  
     * to get a Date object.
     */
    public void setEnd(String value)
    {
        JavaScriptObjectHelper.setAttribute(this, "end", value);
    }

    /**
     * required, a number specifying the magnification of the mapping in this zone. A greater-than-1 number causes more pixels to be mapped 
     * to the same time interval, resulting in a zoom-in effect.
     */
    public void setMagnify(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "magnify", value);
    }

    /**
     * required, one of the Gregorian calendar unit defined in Timeline.DateTime, e.g., Timeline.DateTime.MINUTE. This argument specifies 
     * the interval at which ticks and labels are painted on the band's background inside this hot-zone..
     */
    public void setUnit(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "unit", value);
    }
    
    /**
     * optional, default to 1. A label is painted for every multiple of unit. For example, if unit is Timeline.DateTime.MINUTE and 
     * multiple is 15, then there is a label for every 15 minutes (i.e., 15, 30, 45,...). 
     */
    public void setMultiple(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "multiple", value);
    }
        
}
