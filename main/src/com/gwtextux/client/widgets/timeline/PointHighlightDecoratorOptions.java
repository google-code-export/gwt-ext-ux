/*
 * Copyright 2006 Alistair Rutherford (http://code.google.com/p/gwtsimiletimeline/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtextux.client.widgets.timeline;


import com.google.gwt.core.client.JavaScriptObject;


/**
 * BandOptions
 *
 * @author ajr
 */
public class PointHighlightDecoratorOptions extends JavaScriptObject
{
    protected PointHighlightDecoratorOptions(int opaque)
    {
        super();
    }

    public static PointHighlightDecoratorOptions create()
    {
        return PointHighlightDecoratorOptionsImpl.create();
    }
    
    /**
     * required, date
     * 
     * @param value
     */
    public void setDate(String value)
    {
        JavaScriptObjectHelper.setAttribute(this, "date", value);
    }

    /**
     * required, color
     * 
     * @param value
     */
    public void setColor(String value)
    {
        JavaScriptObjectHelper.setAttribute(this, "color", value);
    }

    /**
     * required, opacity
     * 
     * @param value
     */
    public void setOpacity(int value)
    {
        JavaScriptObjectHelper.setAttribute(this, "opacity", value);
    }

    /**
     * required, Band theme
     * 
     * @param value
     */
    public void setTheme(Theme value)
    {
        JavaScriptObjectHelper.setAttribute(this, "theme", value);
    }

    
}
