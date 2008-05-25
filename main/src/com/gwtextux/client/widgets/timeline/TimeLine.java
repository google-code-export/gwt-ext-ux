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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

import java.util.List;


/**
 * TimeLine
 *
 * @author ajr
 */
public class TimeLine extends JavaScriptObject
{
    protected TimeLine()
    {
        super();
    }

    /**
     * Create TimeLine object
     */
    public static TimeLine create(List bands, EventSource source, Element divElement, Element clientElement)
    {
    	JavaScriptObject[] bandArr = JavaScriptObjectHelper.listToArray(bands);
        JavaScriptObject jarr = JavaScriptObjectHelper.arrayConvert(bandArr);
        boolean currVisible = UIObject.isVisible(clientElement);
        UIObject.setVisible(clientElement, true);
        TimeLine timeLine = TimeLineImpl.create(jarr, divElement);
        UIObject.setVisible(clientElement, currVisible);
        return timeLine;
    }


    /**
     * Redraw timeline 
     *
     */
    public final void layout()
    {
        TimeLineImpl.layout(this);
    }

    /**
     * loadXML through handler function.
     * 
     * @param dataUrl
     * @param handler
     */
    public final void loadXML(String dataUrl, TimelineXMLHandler handler)
    {
        TimeLineImpl.loadXML(dataUrl, handler);
    }
 
    /**
     * Close info bubble for indicated band
     * @param index
     */
    public final void closeBubble(int index)
    {
    	TimeLineImpl.closeBubble(index, this);
    }
    
}
