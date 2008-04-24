package com.gwtextux.sample.showcase2.client.timeline;

import com.google.gwt.user.client.ui.Composite;
import com.gwtextux.client.widgets.timeline.TimeLineWidget;


/**
 * Main Panel
 *
 * Note: The Timeline view does not like any operation performed upon it unless it is the
 * focussed view. Not sure why not but you will save yourself endless grief if you remember
 * this.
 *
 * Note: The client window sizes returned when each tab is selected are different, hence we
 * have to force a resize to the correct view when each tab is selected.
 *
 */
public class MainTabPanel extends Composite
{
    private TimeLinePanel tabTimeLine = null;

    public MainTabPanel()
    {
        tabTimeLine = new TimeLinePanel();
        tabTimeLine.setSize("100%", "100%");
        initWidget(tabTimeLine);
        TimeLineWidget widget = tabTimeLine.getTimeLineWidget();
        widget.clearBubbles();
        setStyleName("gwt-TabPanel");
    }

    /**
     * onWindowResized
     * @param width
     * @param height
     */
    public void onWindowResized(int width, int height)
    {
        resizeTabs(width, height);
    }

    /**
     * Resize view elements
     *
     * @param width
     * @param height
     */
    private void resizeTabs(int width, int height)
    {
        if ((width > 0) && (height > 0))
        {
/*
            int tabBarAbsoluteLeft = panelTabbed.getTabBar().getAbsoluteLeft();
            int tabBarOffsetHeight = panelTabbed.getTabBar().getOffsetHeight();

            int viewWidth = width - tabBarAbsoluteLeft;
            int viewHeight = height - tabBarOffsetHeight;
*/

            tabTimeLine.onWindowResized(width, height);

            tabTimeLine.setWidth(Integer.toString(width) + "px");
            tabTimeLine.setHeight(Integer.toString(height) + "px");
        }
    }


    /**
     * Returns timeline control
     *
     * @return map control
     */
    public TimeLinePanel getTabTimeLine()
    {
        return tabTimeLine;
    }

}