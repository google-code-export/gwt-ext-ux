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

import com.gwtextux.client.widgets.timeplot.ITimePlotRender;
import com.gwtextux.client.widgets.timeplot.TimePlotWidget;
import com.gwtext.client.widgets.Panel;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Command;


public class TimePlotPanel extends Panel
{
    TimePlotWidget plotWidget = null;
    ITimePlotRender render;

    public TimePlotPanel(String width, String height)
    {
        render = new TimeplotRender();
        plotWidget = new TimePlotWidget(width, height, render, "chart1");
        this.add(plotWidget);
    }

     protected void afterRender() {
		DeferredCommand.addCommand(new Command() {
			public void execute() {
					DeferredCommand.addCommand(new Command() {
						public void execute() {
                            render.afterRender(plotWidget);
						}
					});
				}
		});
	}

    public void onWindowResized(int width, int height)
    {
        resize(width, height);
    }

     private void resize(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            plotWidget.setWidth(Integer.toString(width) + "px");
            plotWidget.setHeight(Integer.toString(height) + "px");
            plotWidget.resize();
        }
    }
}
