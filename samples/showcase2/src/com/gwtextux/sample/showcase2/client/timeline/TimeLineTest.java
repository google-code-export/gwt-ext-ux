package com.gwtextux.sample.showcase2.client.timeline;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;
import com.gwtextux.client.widgets.timeplot.ClientSizeHelper;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class TimeLineTest extends ShowcasePanel implements WindowResizeListener
{
    public static MainTabPanel mainPanel = null;

    public TimeLineTest()
    {
        mainPanel = new MainTabPanel();
    }

    public Panel getViewPanel()
    {
        if (panel == null)
        {
            panel = new Panel();
            DatasetHandler.getInstance().initialise(this, getInitialDataset());
            panel.add(mainPanel);
        }
        return panel;
    }

    /**
     * getInitialDataset
     * <p/>
     * <p>Returns dataset to load on startup. </p>
     *
     * @return dataset name
     */
    private String getInitialDataset()
    {
        String dataset = "data/timeline.xml";
        return (dataset);
    }

    /**
     * Resize all components
     */
    public void onWindowResized(int width, int height)
    {
        mainPanel.onWindowResized(ClientSizeHelper.getClientWidth(), ClientSizeHelper.getClientHeight());
    }

    public static MainTabPanel getMainPanel()
    {
        return mainPanel;
    }
}