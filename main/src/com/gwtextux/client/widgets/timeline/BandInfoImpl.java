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
 * BandInfoImpl
 * 
 * @author ajr
 *
 *
 */
class BandInfoImpl
{
    // -------------------------------------------------------------------
    // Band
    // -------------------------------------------------------------------

    public native static BandInfo create(BandOptions options) /*-{
        return $wnd.Timeline.createBandInfo(options)
    }-*/;
    
    public native static BandInfo createHotZone(BandOptions options) /*-{
        return $wnd.Timeline.createHotZoneBandInfo(options)
    }-*/;
    
    public native static void setSyncWith(BandInfo band, int index) /*-{
        band.syncWith = index;
    }-*/;
    
    public native static void setHighlight(BandInfo band, boolean value) /*-{
        band.highlight = value;
    }-*/;

    public native static void setDecorators(BandInfo band, JavaScriptObject value) /*-{
        band.decorators = value;
    }-*/;
    
}

