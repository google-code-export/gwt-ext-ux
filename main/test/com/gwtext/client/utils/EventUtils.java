/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.utils;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.UIObject;

//Original Authod SeanC
//http://groups.google.com/group/Google-Web-Toolkit/browse_frm/thread/ecb25ba44760c88c/b09cea646cecef59?lnk=gst&q=eventutils&rnum=1&hl=en#b09cea646cecef59

public class EventUtils {

    public static void sendClickEvent(UIObject componentToClick) {
        fireClickEvent(componentToClick.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendDoubleClickEvent(UIObject componentToDoubleClick) {
        fireDoubleClickEvent(componentToDoubleClick.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendMouseOverEvent(UIObject componentToMouseOver) {
        fireMouseOverEvent(componentToMouseOver.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendFocusEvent(UIObject componentToFocus) {
        fireFocusEvent(componentToFocus.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendChangeEvent(UIObject componentChanged) {
        fireChangeEvent(componentChanged.getElement());
    }

    /**
     * requires Internet Explorer 5.5 or later.
     */
    public static void sendEnterKeyPressEvent(UIObject componentToKeyPressOn) {
        fireEnterKeyPressEvent(componentToKeyPressOn.getElement());
    }

    static native void fireClickEvent(Element elementToClick)/*-{
         elementToClick.click();
         }-*/;

    static native void fireDoubleClickEvent(Element elementToDoubleClick)/*-{
         var newEvent = $doc.createEventObject();
         elementToDoubleClick.fireEvent("ondblclick", newEvent);
         }-*/;

    static native void fireMouseOverEvent(Element elementToMouseOver)/*-{
         var newEvent = $doc.createEventObject();
         elementToMouseOver.fireEvent("onmouseover", newEvent);
         }-*/;

    static native void fireFocusEvent(Element elementToFocus) /*-{
         var newEvent = $doc.createEventObject();
         elementToFocus.fireEvent("onfocus", newEvent);
         }-*/;

    static native void fireChangeEvent(Element elementChanged) /*-{
         var newEvent = $doc.createEventObject();
         elementChanged.fireEvent("onchange", newEvent);
         }-*/;

    static native void fireEnterKeyPressEvent(Element elementToKeyPressOn) /*-{
         var newEvent = $doc.createEventObject();
         newEvent.keyCode = 13;
         elementToKeyPressOn.fireEvent("onkeypress", newEvent);
    }-*/;
}
