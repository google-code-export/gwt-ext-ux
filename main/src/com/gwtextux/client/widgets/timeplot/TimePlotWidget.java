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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimePlotWidget extends Widget
{
    private ArrayList plotInfos = null;
    private TimePlot timeplot = null;
    private Element divElement = null;
    private ITimePlotRender renderer = null;

    List eventSources = new ArrayList();
    List dataSources = new ArrayList();

    public TimePlotWidget(String width, String height, ITimePlotRender render, String divname)
    {
        plotInfos = new ArrayList();
        divElement = DOM.createDiv();
        DOM.setElementAttribute(divElement, "id", divname);
        setElement(divElement);
        setHeight(height);
        setWidth(width);
        this.renderer = render;
    }

    protected void onLoad()
    {
        super.onLoad();
        if (timeplot == null) initialise();
    }

    public void initialise()
    {
        renderer.render(this);
        timeplot = TimePlot.create(plotInfos, divElement, getClientElement());
    }

    public void clearData()
    {
        if (dataSources != null)
        for (Iterator iterator = dataSources.iterator(); iterator.hasNext();)
        {
            DataSource dataSource = (DataSource) iterator.next();
            dataSource.clear();
        }

        if (eventSources != null)
            for (Iterator iterator = eventSources.iterator(); iterator.hasNext();)
            {
                EventSource eventSource = (EventSource) iterator.next();
                eventSource.clear();
            }
    }

    public void clearBubbles()
    {
        if (visible())
        {
            int count = plotInfos.size();
            while (--count > 0)
            {
                timeplot.closeBubble(count);
            }
        }
    }

    public void resize()
    {
        timeplot.resize();
    }

    public void loadXML(EventSource eventSource, String dataUrl)
    {
        timeplot.loadXML(eventSource, dataUrl);
    }

    public void loadText(EventSource eventSource, String dataUrl, String separator)
    {
        timeplot.loadText(eventSource, dataUrl, separator);
    }

    public void loadText(EventSource eventSource, String dataUrl, String separator, JavaScriptObject filter)
    {
        timeplot.loadText(eventSource, dataUrl, separator, filter);
    }

    public boolean visible()
    {
        Element clientElement = getClientElement();
        Element containerElement = getElement();

        boolean client = UIObject.isVisible(clientElement);
        boolean container = UIObject.isVisible(containerElement);

        return (client && container);
    }

    private Element getClientElement()
    {
        Element element = getElement();
        if (getParent() != this)
            element = getParent().getElement();
        return (element);
    }

    public TimePlot getTimePlot()
    {
        return timeplot;
    }

    public List getEventSources()
    {
        return eventSources;
    }

    public void setEventSources(List eventSources)
    {
        this.eventSources = eventSources;
    }

    public List getDataSources()
    {
        return dataSources;
    }

    public void setDataSources(List dataSources)
    {
        this.dataSources = dataSources;
    }

    public ArrayList getPlotInfos()
    {
        return plotInfos;
    }

    public void setPlotInfos(ArrayList plotInfos)
    {
        this.plotInfos = plotInfos;
    }

    public TimePlot getTimeplot()
    {
        return timeplot;
    }

    public void setTimeplot(TimePlot timeplot)
    {
        this.timeplot = timeplot;
    }

    public Element getDivElement()
    {
        return divElement;
    }

    public void setDivElement(Element divElement)
    {
        this.divElement = divElement;
    }

    public ITimePlotRender getRenderer()
    {
        return renderer;
    }

    public void setRenderer(ITimePlotRender renderer)
    {
        this.renderer = renderer;
    }
}