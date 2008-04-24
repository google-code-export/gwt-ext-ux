package com.gwtextux.sample.showcase2.client.timeline;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;


public class BusyPopup extends PopupPanel
{
    public BusyPopup()
    {
        // PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
        // If this is set, the panel closes itself automatically when the user
        // clicks outside of it.
        super(false);

        add(new HTML("<div id=\"busyPopup\">Working...</div>"));
    }

    /**
     * This method is called when the widget becomes attached to the browser's
     * document.
     */
    protected void onLoad()
    {
        super.onLoad();

        center();
    }

    /**
     * Calculate centre position for display of element
     *
     */
    public void center()
    {
        int left = ((Window.getClientWidth() - getOffsetWidth()) / 2) + getBodyScrollLeft()-60;
        int top = ((Window.getClientHeight() - getOffsetHeight()) / 2) + getBodyScrollTop();
        setPopupPosition(left, top);
    }

    /**
     * Returns correct offset if browser window contents have been scrolled left.
     *
     * @return offset
     */
    private native int getBodyScrollLeft() /*-{
    	return $doc.body.scrollLeft;
    }-*/;

    /**
     * Returns correct offset if browser window has been scrolled down.
     *
     * @return offset
     */
    private native int getBodyScrollTop() /*-{
    	return $doc.body.scrollTop;
    }-*/;
}