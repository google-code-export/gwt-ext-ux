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
 * <p>This class represents an array of ClassSeries/ClassRowData objects</p>
 * 
 * @author LeLLuMe
 */
public class ClassDataSet extends JavaScriptObject{
    
	//private int nrSeries;
	
    protected ClassDataSet(){
        super();
        //nrSeries = 0;
    }
    
    private static native ClassDataSet createobj()/*-{
        return new Array;
    }-*/; 
    
    /**
     * <p>Creates a ClassDataSet object</p>
     * 
     */
    public static ClassDataSet create(){
        //return ClassDataSetCreator.create();
        return createobj();
    }
    
    /**
     * <p>Adds a ClassSeries object</p>
     * 
     * @param series
     */
    public final void addSeries(ClassSeries series){    
        ObjectHelper.addObjectValue(this, series);
        //nrSeries = nrSeries + 1;
    }
    
    /**
     * <p>Adds a ClassRowData object</p>
     * 
     * @param rowData
     */
    public final void addRowData(ClassRowData rowData){
        ObjectHelper.addObjectValue(this, rowData);
    }
    
    /**
     * <p>Return the ith data series</p>
     * 
     */
    public final JavaScriptObject getSeries(int index){
        return ObjectHelper.getJavaScriptObjectFromJavaScriptObjectArray(this, index);
    }
    
    /**
     * <p>Returns the equivalent JSONArray object</p>
     * 
     */
    public final JSONArray wrapToJSON(){
        return new JSONArray(this);
    }
    
    /**
     * <p>Returns number of ClassSeries object stored</p>
     * 
     */
    public final int getTotSeries(){
        return ObjectHelper.getJavaScriptObjectArraySize(this);
    }

}
