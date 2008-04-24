package com.gwtextux.sample.showcase2.client.timeline;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;

import com.gwtextux.sample.showcase2.client.timeline.command.CommandLoadDataset;
import com.gwtextux.client.widgets.timeline.TimeLineWidget;
import com.gwtextux.client.widgets.timeline.TimelineXMLHandler;

/**
 * This class handles requesting and processing the data.
 *
 * @author ajr
 *
 */
class DatasetHandler implements TimelineXMLHandler
{
	// Instance
    private static DatasetHandler instance = null;

    // 'Busy' popup display
    private BusyPopup popupBusy = null;


    /**
     * XMLDatasetHandler
     *
     */
    public DatasetHandler()
    {
        // Popup
        popupBusy = new BusyPopup();
    }

    /**
     * Singleton instance function
     *
     * @return instance of Handler
     */
    public static DatasetHandler getInstance()
    {
        if (instance == null)
        {
            instance = new DatasetHandler();
        }

        return instance;
    }

    /**
     * initialise
     *
     * <p>This function is called from the main app EntryPoint as it relies on
     * graphical elements being instantiated prior to it's execution.</p>
     * @param context
     */
    public void initialise(TimeLineTest context, String dataSet)
    {
        // ---------------------------------------------------------------
        // Do async fetch
        // ---------------------------------------------------------------
        loadDataset(dataSet);
    }

    /**
     * onCompletion
     *
     * @param responseText
     * @param url
     */
	public void onCompletion(JavaScriptObject xml, String url)
	{
        // ---------------------------------------------------------------
        // Hide busy popup
        // ---------------------------------------------------------------
        popupBusy.hide();

        // ---------------------------------------------------------------
        // Process xml
        // ---------------------------------------------------------------
        processSimileData(xml, url);
    }


    /**
     * Load xml data into eventsource for timeline
     *
     * @param urlText
     */
    private void processTextData(String text)
    {
        // Load eventsource with returned xml
        TimeLineWidget tline = TimeLineTest.getMainPanel().getTabTimeLine().getTimeLineWidget();
        tline.getEventSource().loadXMLText(text);

        // We need to send a resize message to 'fix' the display window size.
        TimeLineTest.getMainPanel().onWindowResized(Window.getClientWidth(), Window.getClientHeight());
    }

    /**
     * Load xml data into eventsource for timeline
     *
     * @param urlText
     */
    private void processSimileData(JavaScriptObject xml, String url)
    {
        // Load eventsource with returned xml
        TimeLineWidget tline = TimeLineTest.getMainPanel().getTabTimeLine().getTimeLineWidget();
        tline.getEventSource().load(xml, url);

        // We need to send a resize message to 'fix' the display window size.
        TimeLineTest.getMainPanel().onWindowResized(Window.getClientWidth(), Window.getClientHeight());
    }


    /**
     * Load dataset function
     *
     * @param url
     */
    public void loadDataset(String url)
    {
    	// ---------------------------------------------------------------
    	// This is an example of how to load text directly into timeline
    	// event source
    	// ---------------------------------------------------------------
//    	String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <data> <event start=\"4000 BC\" end=\"3200 BC\" isDuration=\"true\" title=\"Winterbourne Stoke Long Barrow\" icon=\"../image/green-circle.png\" image=\"../image/Timeline_Logo_Thumb.png\"> </event> </data>";
//    	processTextData(text);

        // ---------------------------------------------------------------
    	// NOTE: You could check dataset cache at this point if you were
    	// having to switch between lots of differents sets. The data
    	// could be fetched from the cache instead of fetched through the
    	// ajax mechanism.
        // ---------------------------------------------------------------

        // ---------------------------------------------------------------
        // Open busy popup
        // ---------------------------------------------------------------
        popupBusy.show();

        // ---------------------------------------------------------------
        // Got to get ref to widget
        // ---------------------------------------------------------------
        TimeLineWidget tline = TimeLineTest.getMainPanel().getTabTimeLine().getTimeLineWidget();

        CommandLoadDataset command = new CommandLoadDataset(this, tline, url);
        DeferredCommand.add(command);
    }
}