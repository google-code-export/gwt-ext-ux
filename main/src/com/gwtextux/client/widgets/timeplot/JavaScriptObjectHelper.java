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

import java.util.List;


class JavaScriptObjectHelper
{

    private JavaScriptObjectHelper()
    {

    }

    public static native String getAttribute(JavaScriptObject elem, String attr) /*-{
	    var ret = elem[attr];
	    return (ret === undefined) ? null : String(ret);
	}-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, String value) /*-{
	    elem[attr] = value;
	}-*/;

    public static native JavaScriptObject getAttributeAsJavaScriptObject(JavaScriptObject elem, String attr) /*-{
    var ret = elem[attr];
    return (ret === undefined) ? null : ret;
    }-*/;

    public static native JavaScriptObject[] getAttributeAsJavaScriptObjectArray(JavaScriptObject elem, String attr) /*-{
    	var ret = elem[attr];
    	return (ret === undefined) ? null : ret;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject[] value) /*-{
		elem[attr] = value;
	}-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, JavaScriptObject value) /*-{
    	elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, int value) /*-{
    	elem[attr] = value;
    }-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, boolean value) /*-{
		elem[attr] = value;
	}-*/;

    public static native void setAttribute(JavaScriptObject elem, String attr, float value) /*-{
        elem[attr] = value;
    }-*/;

    public static native int getAttributeAsInt(JavaScriptObject elem, String attr) /*-{
    	var ret = elem[attr];
    	return (ret === undefined) ? null : ret;
    }-*/;

    public static native float getAttributeAsFloat(JavaScriptObject elem, String attr) /*-{
        var ret = elem[attr];
        return (ret === undefined) ? null : ret;
    }-*/;

    public static int[] getAttributeAsIntArray(JavaScriptObject elem, String attr)
    {
        int[] rtn = null;
        JavaScriptObject hold = getAttributeAsJavaScriptObject(elem, attr);
        if (hold != null)
        {
            rtn = new int[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++)
            {
                rtn[i] = getIntValueFromJavaScriptObjectArray(hold, i);
            }
        }

        return rtn;
    }


    public static native int getJavaScriptObjectArraySize(JavaScriptObject elem) /*-{
		if (elem) return elem.length;
		return 0;
	}-*/;

    public static native int getIntValueFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
		return elem[i];
	}-*/;

    public static native void setAttributeAsIntArray(JavaScriptObject elem, String attr, int[] value) /*-{
    	elem[attr] = value;
    }-*/;

    public static native boolean getAttributeAsBoolean(JavaScriptObject elem, String attr) /*-{
    	var ret = elem[attr];
    	return (ret === undefined) ? null : ret;
    }-*/;


    /**
     * Helper function to create [] array from List.
     *
     * @param list
     * @return array of objects
     */
    public static JavaScriptObject[] listToArray(List list)
    {
        JavaScriptObject[] array = new JavaScriptObject[list.size()];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (JavaScriptObject) list.get(i);
        }

        return array;
    }

    public static JavaScriptObject arrayConvert(Object[] array)
    {
        JavaScriptObject result = newJSArray(array.length);
        for (int i = 0; i < array.length; i++)
        {
            arraySet(result, i, array[i]);
        }
        return result;
    }


    public static JavaScriptObject arrayConvert(JavaScriptObject[] array)
    {
        JavaScriptObject result = newJSArray(array.length);
        for (int i = 0; i < array.length; i++)
        {
            arraySet(result, i, array[i]);
        }
        return result;
    }

    private static native JavaScriptObject newJSArray(int length) /*-{
	    if (length < 0)
	    {
	            return new Array();
	    }
	    else
	    {
	            return new Array(length);
	    }
	}-*/;

    public static native int arrayLength(JavaScriptObject array) /*-{
	        return array.length;
	}-*/;


    public static native Object arrayGetObject(JavaScriptObject array, int index) /*-{
	        return array[index];
	}-*/;

    public static native void arraySet(JavaScriptObject array, int index, Object value) /*-{
    	array[index] = value;

	}-*/;

    public static native void arraySet(JavaScriptObject array, int index, JavaScriptObject value) /*-{
	        array[index] = value;

	}-*/;
}