/*
 Copyright 2008 - Pantaleo de Pinto (depinto.pantaleo@gmail.com)

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

package com.gwtextux.client.widgets.flotPlotter.options;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import java.util.List;

/**
*
* @author LeLLuMe
*/
class ObjectHelper{
    private ObjectHelper(){
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
        if (hold != null){
            rtn = new int[getJavaScriptObjectArraySize(hold)];

            for (int i = 0; i < rtn.length; i++){
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

    public static JavaScriptObject[] listToArray(List list){
        JavaScriptObject[] array = new JavaScriptObject[list.size()];
        
        for (int i = 0; i < array.length; i++){
            array[i] = (JavaScriptObject) list.get(i);
        }
        
        return array;
    }

    public static JavaScriptObject arrayConvert(Object[] array){
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++){
            arraySet(result, i, array[i]);
        }

        return result;
    }

    public static JavaScriptObject arrayConvert(JavaScriptObject[] array){
        JavaScriptObject result = newJSArray(array.length);

        for (int i = 0; i < array.length; i++){
            arraySet(result, i, array[i]);
        }

        return result;
    }
    
    private static native JavaScriptObject newJSArray(int length) /*-{
	    if (length < 0){
	    	return new Array();
	    }
	    else{
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

   
    //Metodi aggiuntivi
    public static native JavaScriptObject newJSArray() /*-{
	return new Array();
    }-*/;

    //Utile per la creazione del vettore dei ticks
    public static native void addFloatValue(JavaScriptObject array, float value)/*-{
        array.push(value);
    }-*/;

    //Utile per la creazione del vettore dei ticks
    public static native void addIntValue(JavaScriptObject array, int value)/*-{
        array.push(value);
    }-*/;

    public static native void addStringValue(JavaScriptObject array, String value)/*-{
        array.push(value);
    }-*/;

    //Utile per la creazione del dataset
    public static native void addObjectValue(JavaScriptObject array, JavaScriptObject value)/*-{
        array.push(value);
    }-*/;

    //Trasforma un dataset JSONArray in un dataset JavaScriptObject

    /*public static void wrapJSONDatasetsToJSDatasets(JSONArray jsonArray, JavaScriptObject jsArray){

        JavaScriptObject dataset; //rappresenta una generica serie

        JavaScriptObject pair; //rappresenta una generica coppia di ordinate

        float x, y; //rapppresentano i valori delle coordinate

        JSONArray jsonSeries; //rapppresenta una generica serie in formato JSON

        JSONArray jsonPair; //rappresenta una generica coppia di ordinate in formato JSON

        String descr; //rappresenta un'eventuale descrizione da associare al punto

        

        for (int i = 0; i < jsonArray.size(); i++){

            //seleziono una generica serie di dati

            jsonSeries = (JSONArray)jsonArray.get(i);

            dataset = newJSArray();

            for (int j = 0; j < jsonSeries.size(); j++){

                //seleziono una generica coppia di ordinate

                jsonPair = (JSONArray)jsonSeries.get(j);

                x = Float.parseFloat(jsonPair.get(0).toString());

                y = Float.parseFloat(jsonPair.get(1).toString());

                pair = newJSArray();

                addFloatValue(pair,x);

                addFloatValue(pair,y);

                if (jsonPair.get(3) != null){

                    descr = jsonPair.get(3).toString();

                    addStringValue(pair,descr);

                }

                addObjectValue(dataset,pair);

            }

            addObjectValue(jsArray,dataset);

        }

    }*/

    public static JavaScriptObject wrapPair(float x, float y){
        JavaScriptObject pair;
        pair = newJSArray();
        
        addFloatValue(pair,x);
        addFloatValue(pair,y);
        
        return pair;
    }

    public static JavaScriptObject wrapPair(int x, int y){
        JavaScriptObject pair;
        pair = newJSArray();

        addFloatValue(pair,x);
        addFloatValue(pair,y);

        return pair;
    }

    //Trasforma un dataset JSONArray in un dataset JavaScriptObject
    public static void wrapJSONRowDataToJSRowData(JSONArray jsonArray, JavaScriptObject dataset){
        JavaScriptObject pair; //rappresenta una generica coppia di ordinate
        float x, y; //rapppresentano i valori delle coordinate
        JSONArray jsonPair; //rappresenta una generica coppia di ordinate in formato JSON
        //String descr;

        for (int i = 0; i < jsonArray.size(); i++){
        //seleziono una generica coppia di ordinate
            jsonPair = (JSONArray)jsonArray.get(i);
            x = Float.parseFloat(jsonPair.get(0).toString());
            y = Float.parseFloat(jsonPair.get(1).toString());
            pair = wrapPair(x,y);
            /*if (jsonPair.get(3) != null){
                descr = jsonPair.get(3).toString();
                addStringValue(pair,descr);
            }*/
            addObjectValue(dataset,pair);
        }
    }   

    //Trasforma un Array in un dataset JavaScriptObject
    public static void wrapArrayToJSRawData(float[][] array, JavaScriptObject jsArray){
        JavaScriptObject pair; //rappresenta una generica coppia di ordinate

        for (int i = 0; i < array.length; i++){
            pair = wrapPair(array[i][0],array[i][1]);
            addObjectValue(jsArray,pair);
        }
    }

    public static void wrapArrayToJSRawData(int[][] array, JavaScriptObject jsArray){
        JavaScriptObject pair; //rappresenta una generica coppia di ordinate

        for (int i = 0; i < array.length; i++){
            pair = wrapPair(array[i][0],array[i][1]);
            addObjectValue(jsArray,pair);
        }
    }

    public static JavaScriptObject wrapJSONArrayToJSObject(JSONArray jsonArray){
        JavaScriptObject jsArray = newJSArray();

        for (int i = 0; i < jsonArray.size(); i++){
            addFloatValue(jsArray,Float.parseFloat((jsonArray.get(i)).toString()));
        }

        return jsArray;
    }

    public static native JavaScriptObject getJavaScriptObjectFromJavaScriptObjectArray(JavaScriptObject elem, int i) /*-{
            return elem[i];
    }-*/;

    public static native void setAttributeAsJQueryObject(JavaScriptObject elem, String attr, String value) /*-{
	    $wnd.setAttributeAsJQueryObject(elem, attr, value);
	}-*/;
}