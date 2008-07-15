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

/**
 * <p>This class represents an array of points</p>
 * 
 * @author LeLLuMe
 */
public class ClassRowData extends JavaScriptObject {
    protected ClassRowData(){
        super();
    }
    
    private static native ClassRowData createobj()/*-{
        return new Array;
    }-*/;
    
    
    /**
     * <p>Creates a ClassRowData object</p>
     * 
     */
    public static ClassRowData create(){
        //return ClassRowDataCreator.create();
        return createobj();
    }
    
    /**
     * <p>Creates an array of points from a JSONArray object</p>
     * <p>The format is</p>
     * <p>[[x1,y1],[x2,y2],...,[xn,yn]]</p>
     * 
     * @param dataset: JSONArray object
     */
    public final void fillRowData(JSONArray rowData){
        ObjectHelper.wrapJSONRowDataToJSRowData(rowData,this);
    }
    
    /**
     * <p>Adds a coordinates pair</p>
     * 
     * @param x: x coordinate
     * @param y: y coordinate
     */
    public final void addData(float x, float y){
        JavaScriptObject pair;
        pair = ObjectHelper.wrapPair(x,y);
        ObjectHelper.addObjectValue(this,pair);
    }
    
    /**
     * <p>Adds a coordinates pair</p>
     * 
     * @param x: x coordinate
     * @param y: y coordinate
     */
    public final void addData(int x, int y){
        JavaScriptObject pair;
        pair = ObjectHelper.wrapPair(x,y);
        ObjectHelper.addObjectValue(this,pair);
    }
    
    /**
     * <p>Creates an array of points from a JavaScriptObject object</p>
     * <p>The format is</p>
     * <p>[[x1,y1],[x2,y2],...,[xn,yn]]</p>
     * 
     * @param dataset: JavaScriptObject object
     */
    public final void fillRowDataFromArray(float[][] rawData){
        ObjectHelper.wrapArrayToJSRawData(rawData, this);
    }
    
    /**
     * <p>Creates an array of points from a JavaScriptObject object</p>
     * <p>The format is</p>
     * <p>[[x1,y1],[x2,y2],...,[xn,yn]]</p>
     * 
     * @param dataset: JavaScriptObject object
     */
    public final void fillRowDataFromArray(int[][] rawData){
        ObjectHelper.wrapArrayToJSRawData(rawData, this);
    }
    
    /**
     * <p>Returns the equivalent JSONArray object</p>
     * 
     */
    public final JSONArray wrapToJSON(){
        return new JSONArray(this);
    }
    
    /**
     * <p>Gets the ith data</p>
     * 
     */
    public final JavaScriptObject getData(int i){
        return ObjectHelper.getJavaScriptObjectFromJavaScriptObjectArray(this, i);
    }

}
