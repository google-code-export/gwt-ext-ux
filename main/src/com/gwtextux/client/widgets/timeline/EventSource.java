/*
 * Copyright 2006 Alistair Rutherford (http://code.google.com/p/gwtsimiletimeline/)
 * 
 * JSON handling contributed jdwyah, Feb 26, 2007.
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


import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * EventSource
 *
 * @author ajr
 */
public class EventSource extends JavaScriptObject
{
    protected EventSource()
    {
        super();
    }

    public static EventSource create()
    {
        return EventSourceImpl.createEventSourceObject();
    }
    
    /**
     * Load data stream into timeline event source
     * @param dataUrl
     */
    public final void loadXML(String dataUrl)
    {
        EventSourceImpl.loadXML(dataUrl, this);
    }

    /**
     * Load xml string directly into source
     * 
     * @param dataUrl
     */
    public final void loadXMLText(String xmlText)
    {
        EventSourceImpl.loadXMLText(xmlText, GWT.getModuleBaseURL(), this);
    }
    
    /**
     * Load json string directly into source
     *  
     * @param json
     */
    public final void loadJSON(String json) 
    {
		EventSourceImpl.loadJSON(json, GWT.getModuleBaseURL(),this);
	}
    
    /**
     * Load data stream into timeline event source
     * @param dataUrl
     */
    public final void load(JavaScriptObject xml, String url)
    {
        EventSourceImpl.loadXML(xml, url, this);
    }
    

    public final void clear()
    {
        EventSourceImpl.clear(this);
    }
    
}
