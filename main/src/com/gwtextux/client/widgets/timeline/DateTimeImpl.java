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


/**
 * DateTimeImpl returns actual values from javascript.
 * 
 * @author ajr
 *
 */
class DateTimeImpl
{
    public native static int MILLISECOND()/*-{
        return $wnd.Timeline.DateTime.MILLISECOND;
    }-*/;

    public native static int SECOND()/*-{
    	return $wnd.Timeline.DateTime.SECOND;
    }-*/;
    
    public native static int MINUTE()/*-{
    	return $wnd.Timeline.DateTime.MINUTE;
    }-*/;
    
    public native static int HOUR()/*-{
    	return $wnd.Timeline.DateTime.HOUR;
    }-*/;

    public native static int DAY()/*-{
    	return $wnd.Timeline.DateTime.DAY;
    }-*/;

    public native static int WEEK()/*-{
    	return $wnd.Timeline.DateTime.WEEK;
    }-*/;
    
    public native static int MONTH()/*-{
    	return $wnd.Timeline.DateTime.MONTH;
    }-*/;
    
    public native static int YEAR()/*-{
    	return $wnd.Timeline.DateTime.YEAR;
    }-*/;
    
    public native static int DECADE()/*-{
    	return $wnd.Timeline.DateTime.DECADE;
    }-*/;
    
    public native static int CENTURY()/*-{
    	return $wnd.Timeline.DateTime.CENTURY;
    }-*/;
    
    public native static int MILLENNIUM()/*-{
    	return $wnd.Timeline.DateTime.MILLENNIUM;
    }-*/;

    public native static int EPOCH()/*-{
    	return $wnd.Timeline.DateTime.EPOCH;
    }-*/;

    public native static int ERA()/*-{
    	return $wnd.Timeline.DateTime.ERA;
    }-*/;
    
}
