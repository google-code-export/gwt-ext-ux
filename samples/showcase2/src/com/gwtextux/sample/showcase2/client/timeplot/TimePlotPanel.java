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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.gwtextux.client.widgets.timeplot.ITimePlotRender;
import com.gwtextux.client.widgets.timeplot.TimePlotWidget;


public class TimePlotPanel extends Composite
{
    private ScrollPanel panel = null;
    TimePlotWidget plotWidget = null;

    public TimePlotPanel(String width, String height)
    {
        panel = new ScrollPanel();
        ITimePlotRender render = new TimeplotRender();
        plotWidget = new TimePlotWidget(width, height, render, "chart1");
        panel.add(plotWidget);
        panel.setAlwaysShowScrollBars(true);
        initWidget(panel);
    }

    public void onWindowResized(int width, int height)
    {
        resize(width, height);
    }

    public ScrollPanel getPanel()
    {
        return panel;
    }

   /* private void resize()
    {
        plotWidget.resize();
    }*/

     private void resize(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            panel.setWidth(Integer.toString(width) + "px");
            panel.setHeight(Integer.toString(height) + "px");
            plotWidget.setWidth(Integer.toString(width) + "px");
            plotWidget.setHeight(Integer.toString(height) + "px");
            plotWidget.resize();
        }
    }
}
