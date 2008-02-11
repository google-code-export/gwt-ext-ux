/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.client.widgets.layout;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.layout.LayoutData;


/**
 * Supporting class for {@link com.gwtextux.client.widgets.layout.RowLayout}.
 *
 * @see com.gwtextux.client.widgets.layout.RowLayout
 */
public class RowLayoutData extends LayoutData {

    public RowLayoutData() {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", 0);
    }

    public RowLayoutData(String height) {
        setHeight(height);
    }

    public RowLayoutData(int height) {
        setHeight(height);
    }

    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    public void setHeight(String height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }
}
