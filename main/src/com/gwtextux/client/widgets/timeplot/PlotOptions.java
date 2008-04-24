/*
 Copyright 2008 - Antonio Signore (antonio.signore@gmail.com)

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.

3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/


package com.gwtextux.client.widgets.timeplot;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * BandOptions
 *
 * @author antonio.signore@gmail.com
 */
public class PlotOptions extends JavaScriptObject
{
    protected PlotOptions()
    {
        super();
    }

    public static PlotOptions create()
    {
        return PlotOptionsImpl.create();
    }

    /**
     * how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     */
    public String getId()
    {
        return JavaScriptObjectHelper.getAttribute(this, "id");
    }

    /**
     * required, how much of the timeline's space this band takes up, expressed as a percent in a string, e.g., "30%"
     */
    public void setId(String width)
    {
        JavaScriptObjectHelper.setAttribute(this, "id", width);
    }

    /**
     * required, Data source
     */
    public void setDataSource(DataSource value)
    {
        JavaScriptObjectHelper.setAttribute(this, "dataSource", value);
    }

    /**
     * Data source
     */
    public JavaScriptObject getDataSource()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "dataSource");
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
     * required, Event source
     */
    public void setTimeGeometry(TimeGeometry value)
    {
        JavaScriptObjectHelper.setAttribute(this, "timeGeometry", value);
    }

    /**
     * Event source
     */
    public JavaScriptObject getTimeGeometry()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "timeGeometry");
    }


    /**
     * required, Event source
     */
    public void setValueGeometry(ValueGeometry value)
    {
        JavaScriptObjectHelper.setAttribute(this, "valueGeometry", value);
    }

    /**
     * Event source
     */
    public JavaScriptObject getValueGeometry()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "valueGeometry");
    }


    public JavaScriptObject getLineColor()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "lineColor");
    }

    /**
     * required, a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     */
    public void setLineColor(Color value)
    {
        JavaScriptObjectHelper.setAttribute(this, "lineColor", value);
    }


    public JavaScriptObject getDotColor()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "dotColor");
    }

    /**
     * required, a time unit from Timeline.DateTime, e.g., Timeline.DateTime.WEEK.
     */
    public void setDotColor(Color value)
    {
        JavaScriptObjectHelper.setAttribute(this, "dotColor", value);
    }


    /**
     * a boolean specifying whether event titles are to be painted. The default is true.
     */
    public boolean getShowValues()
    {
        return JavaScriptObjectHelper.getAttributeAsBoolean(this, "showValues");
    }

    /**
     * optional, a boolean specifying whether event titles are to be painted. The default is true.
     */
    public void setShowValues(boolean value)
    {
        JavaScriptObjectHelper.setAttribute(this, "showValues", value);
    }

}