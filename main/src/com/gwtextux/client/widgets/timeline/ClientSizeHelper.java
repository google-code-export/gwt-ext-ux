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


/**
 * Provides rtns to return client browser size.
 *
 */
public class ClientSizeHelper
{
    /**
     * Gets the width of the browser window's client area.
     *
     * @return the window's client width
     */
    public static native int getClientWidth() /*-{
	    var clientWidth = 0;
	    if( typeof( $wnd.innerWidth ) == 'number' )
	    {
		    //Non-IE
		    clientWidth = $wnd.innerWidth;
	    }
	    else if( $doc.documentElement && ( $doc.documentElement.clientWidth || $doc.documentElement.clientHeight ) )
	    {
		    //IE 6+ in 'standards compliant mode'
		    clientWidth = $doc.documentElement.clientWidth;
	    }
	    else if( $doc.body && ( $doc.body.clientWidth || $doc.clientHeight ) )
	    {
		    //IE 4 compatible
		    clientWidth = $doc.body.clientWidth;
	    }
	
	    return clientWidth;
    }-*/;

    /**
     * Gets the height of the browser window's client area.
     *
     * @return the window's client height
     */
    public static native int getClientHeight() /*-{
	    var clientHeight = 0;
	    if( typeof( $wnd.innerWidth ) == 'number' )
	    {
		    //Non-IE
		    clientHeight = $wnd.innerHeight;
	    }
	    else if( $doc.documentElement && ( $doc.documentElement.clientWidth || $doc.documentElement.clientHeight ) )
	    {
		    //IE 6+ in 'standards compliant mode'
		    clientHeight = $doc.documentElement.clientHeight;
	    }
	    else if( $doc.body && ( $doc.body.clientWidth || $doc.body.clientHeight ) )
	    {
		    //IE 4 compatible
		    clientHeight = $doc.body.clientHeight;
	    }
	
	    return clientHeight;
    }-*/;
}
