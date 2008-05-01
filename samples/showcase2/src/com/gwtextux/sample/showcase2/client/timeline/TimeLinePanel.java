package com.gwtextux.sample.showcase2.client.timeline;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Panel;
import com.gwtextux.client.widgets.timeline.ITimeLineRender;
import com.gwtextux.client.widgets.timeline.TimeLineWidget;


public class TimeLinePanel extends Composite
{
    // GUI elements
    private Panel panel = null;
    private TimeLineWidget simileWidget = null;

    /**
     * Constructor
     */
    public TimeLinePanel()
    {
        panel = new ScrollPanel();
        ITimeLineRender render = new Render();
        simileWidget = new TimeLineWidget("100%", "100%", render);
        panel.add(simileWidget);
        initWidget(panel);
        simileWidget.setStyleName("timeline-default");
    }

    /**
     * onWindowResized
     * @param width
     * @param height
     */
    public void onWindowResized(int width, int height)
    {
        resize(width, height);
    }

    /**
     * Resize view elements
     *
     * @param width
     * @param height
     */
    private void resize(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
            panel.setWidth(Integer.toString(width) + "px");
            panel.setHeight(Integer.toString(height) + "px");
            simileWidget.setWidth(Integer.toString(width) + "px");
            simileWidget.setHeight(Integer.toString(height) + "px");
            simileWidget.layout();
        }

    }

    /**
     * Returns timeline widget to other UI components.
     *
     * @return widget reference.
     */
    public TimeLineWidget getTimeLineWidget()
    {
        return simileWidget;
    }

}