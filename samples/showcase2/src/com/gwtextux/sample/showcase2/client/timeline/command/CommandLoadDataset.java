package com.gwtextux.sample.showcase2.client.timeline.command;

import com.google.gwt.user.client.Command;
import com.gwtextux.client.widgets.timeline.TimeLineWidget;
import com.gwtextux.client.widgets.timeline.TimelineXMLHandler;


public class CommandLoadDataset implements Command
{
	private TimelineXMLHandler handler = null;
    private TimeLineWidget timeline = null;
    private String dataSet = "";

    public CommandLoadDataset(TimelineXMLHandler handler, TimeLineWidget timeline, String dataSet)
    {
        this.handler = handler;
        this.timeline = timeline;
        this.dataSet = dataSet;
    }

    public void execute()
    {
    	timeline.load(dataSet, handler);
    }

}