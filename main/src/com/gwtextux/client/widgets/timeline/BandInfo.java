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

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * BandInfo
 *
 * @author ajr
 */
public class BandInfo extends JavaScriptObject
{
    protected BandInfo()
    {
        super();
    }
    
    public static BandInfo create(BandOptions options)
    {
        return BandInfoImpl.create(options);
    }

    public static BandInfo createHotZone(BandOptions options)
    {
        return BandInfoImpl.createHotZone(options);
    }
    
    public final void setSyncWith(int value)
    {
        BandInfoImpl.setSyncWith(this, value);
    }

    public final void setHighlight(boolean value)
    {
        BandInfoImpl.setHighlight(this, value);
    }

    /**
     * optional, Set decorator list
     * 
     * @param decorators
     */
    public final void setDecorators(List decorators)
    {
    	JavaScriptObject[] decoratorArr = JavaScriptObjectHelper.listToArray(decorators);

        JavaScriptObject jarr = JavaScriptObjectHelper.arrayConvert(decoratorArr);

        BandInfoImpl.setDecorators(this, jarr);
    }
}
