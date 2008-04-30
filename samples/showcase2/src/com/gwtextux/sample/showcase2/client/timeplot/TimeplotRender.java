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

package com.gwtextux.sample.showcase2.client.timeplot;


import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.gwtextux.client.widgets.timeplot.*;
import com.gwtextux.client.widgets.timeplot.Color;
import com.gwtextux.client.widgets.timeplot.TimePlotWidget;
import com.gwtextux.client.widgets.timeplot.TimeGeometryOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * Render timeline
 */
public class TimeplotRender implements ITimePlotRender
{

    EventSource eventSource1;
    EventSource eventSource2;
    EventSource eventSource3;

    /**
     * Create timeline custom elements.
     *
     * @param widget Timeline rendered into this widget.
     */
    public void render(TimePlotWidget widget)
    {

        Color redcolor = Color.createColor("#ff0000");
        Color bluecolor = Color.createColor("#0000ff");
        Color greencolor = Color.createColor("#00ff00");
        Color lightGreencolor = Color.createColor("#5C832F");
        Color gridcolor = Color.createColor("#ffff00");

        TimeGeometryOptions tgopts = TimeGeometryOptions.create();
        tgopts.setGridColor(gridcolor);
        tgopts.setAxisLabelsPlacement("bottom");
        TimeGeometry tgeo = TimeGeometry.create(tgopts);

        ValueGeometryOptions geometry1opts = ValueGeometryOptions.create();
        geometry1opts.setAxisLabelsPlacement("left");
        geometry1opts.setGridColor(gridcolor);
        geometry1opts.setGridType("short");
        geometry1opts.setMin(0);
        ValueGeometry geometry1 = ValueGeometry.create(geometry1opts);

        ValueGeometryOptions geometry2opts = ValueGeometryOptions.create();
        geometry2opts.setMin(0);
        ValueGeometry geometry2 = ValueGeometry.create(geometry2opts);

        List eventSources = widget.getEventSources();
        List dataSources = widget.getDataSources();

        eventSource3 = EventSource.create();
        eventSources.add(eventSource3);
        
        eventSource1 = EventSource.create();
        eventSources.add(eventSource1);

        DataSource dataSource1 = DataSource.create(eventSource1, 1);
        dataSources.add(dataSource1);

        eventSource2 = EventSource.create();
        eventSources.add(eventSource2);

        DataSource dataSource2 = DataSource.create(eventSource2, 1);
        dataSources.add(dataSource2);

        ArrayList plotInfos = widget.getPlotInfos();

        PlotOptions plotOptions1 = PlotOptions.create();
        plotOptions1.setId("Population");
        plotOptions1.setDataSource(dataSource1);
        plotOptions1.setTimeGeometry(tgeo);
        plotOptions1.setValueGeometry(geometry1);
        plotOptions1.setLineColor(greencolor);
        plotOptions1.setDotColor(lightGreencolor);
        plotOptions1.setShowValues(true);
        PlotInfo pinfo1 = PlotInfo.create(plotOptions1);
        plotInfos.add(pinfo1);

        PlotOptions plotOptions2 = PlotOptions.create();
        plotOptions2.setId("Immigration");
        plotOptions2.setDataSource(dataSource2);
        plotOptions2.setTimeGeometry(tgeo);
        plotOptions2.setValueGeometry(geometry2);
        plotOptions2.setLineColor(bluecolor);
        plotOptions2.setDotColor(bluecolor);
        plotOptions2.setShowValues(true);
        PlotInfo pinfo2 = PlotInfo.create(plotOptions2);
        plotInfos.add(pinfo2);

        PlotOptions plotOptions3 = PlotOptions.create();
        plotOptions3.setId("Events");
        plotOptions3.setEventSource(eventSource3);
        plotOptions3.setTimeGeometry(tgeo);
        plotOptions3.setLineColor(redcolor);
        PlotInfo pinfo3 = PlotInfo.create(plotOptions3);
        plotInfos.add(pinfo3);

    }

    public void postCreate(TimePlotWidget widget)
    {
        DeferredCommand.add(new CommandLoadXMLDataset(eventSource3, widget, "data/us_history.xml"));
        DeferredCommand.add(new CommandLoadTextDataset(eventSource1, widget, "data/us_population.txt", " "));
        DeferredCommand.add(new CommandLoadTextDataset(eventSource2, widget, "data/immigration.txt", " "));

    }

}