/*
 Copyright 2008 - Antonio Signore (antonio.signore@gmail.com)

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.

3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/


package com.gwtextux.client.widgets.timeplot;


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