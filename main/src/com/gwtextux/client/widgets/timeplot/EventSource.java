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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * EventSource
 *
 * @author antonio.signore@gmail.com
 */
public class EventSource extends JavaScriptObject
{
    protected EventSource()
    {
        super();
    }

    public static EventSource create()
    {
        return EventSourceImpl.createEventSourceObject();
    }

    /* public void loadXML(String dataUrl)
    {
        EventSourceImpl.loadXML(timeplot, dataUrl, this);
    }*/

    /* public void load(JavaScriptObject xml, String url)
   {
       EventSourceImpl.loadXML(xml, url, this);
   }
    */

    /*  public void loadText(JavaScriptObject xml, String url)
    {
        EventSourceImpl.loadText(xml, url, this);
    }
    */

    public final void clear()
    {
        EventSourceImpl.clear(this);
    }

}