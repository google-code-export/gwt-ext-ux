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
import com.google.gwt.json.client.JSONObject;

/**
 * <p>This class represents a single series of data with a set of plot options associated to it</p>
 * 
 * @author LeLLuMe
 */
public class ClassSeries extends JavaScriptObject {
    protected ClassSeries(){
        super();
    }
    
    private static native ClassSeries createobj()/*-{
        return new Object;
    }-*/; 
    
    
    /**
     * <p>Creates a ClassSeries object</p>
     * 
     */
    public static ClassSeries create(){
        //return ClassSeriesCreator.create();
        return createobj();
    }
    
    //setta il colore abbinato alla serie di dati
    //il formato  #xxxxxx
    //col file di esempio non funziona
    /*public void setColor(String color){
        ObjectHelper.setAttribute(this, "color", color);
    }*/
    
    /**
     * <p>Add a ClassRowData object which represents the dataset to plot</p>
     * 
     * @param dataset: ClassRowData object
     */
    public final void setRowData(ClassRowData rawData){
        ObjectHelper.setAttribute(this, "data", rawData);
    }
    
    /**
     * <p>Sets the label associated to the data series</p>
     * 
     * @param label
     */
    public final void setLabel(String label){
        ObjectHelper.setAttribute(this, "label", label);
    }
    
    /**
     * <p>Sets the legend options</p>
     * 
     * @param legend: OptionLegend object
     */
    public final void setLegend(OptionLegend legend){
        ObjectHelper.setAttribute(this, "legend", legend);
    }
    
    /**
     * <p>Sets the x axis options</p>
     * 
     * @param xaxis: OptionAxis object
     */
    public final void setXaxis(OptionAxis xaxis){
        ObjectHelper.setAttribute(this, "xaxis", xaxis);
    }
    
    /**
     * <p>Sets the y axis options</p>
     * 
     * @param yaxis: OptionAxis object
     */
    public final void setYaxis(OptionAxis yaxis){
        ObjectHelper.setAttribute(this, "yaxis", yaxis);
    }
    
    /**
     * <p>Sets the bars diagram options</p>
     * 
     * @param bars: OptionBars object
     */
    public final void setBars(OptionBars bars){
        ObjectHelper.setAttribute(this, "bars", bars);
    }
    
    /**
     * <p>Sets the lines diagram options</p>
     * 
     * @param lines: OptionLines object
     */
    public final void setLines(OptionLines lines){
        ObjectHelper.setAttribute(this, "lines", lines);
    }
    
    /**
     * <p>Sets the points diagram options</p>
     * 
     * @param points: OptionPoints object
     */
    public final void setPoints(OptionPoints points){
        ObjectHelper.setAttribute(this, "points", points);
    }
    
    /**
     * <p>Sets the grid options</p>
     * 
     * @param grid: OptionGrid object
     */
    public final void setGrid(OptionGrid grid){
        ObjectHelper.setAttribute(this, "grid", grid);
    }
    
    /**
     * <p>Sets the selection options</p>
     * 
     * @param selection: OptionSelection object
     */
    public final void setSelection(OptionSelection selection){
        ObjectHelper.setAttribute(this, "selection", selection);
    }
    
    /**
     * <p>Sets the shadow size option</p>
     * 
     * @param shadow: shadow siza value
     */
    public final void setShadowSize(int shadow){
        ObjectHelper.setAttribute(this, "shadowSize", shadow);
    }
    
    /**
     * <p>Returns the equivalent JSONArray object</p>
     * 
     */
    public final JSONObject wrapToJSON(){
        return new JSONObject(this);
    }
    
    /**
     * <p>Gets the option "bars"</p>
     * 
     */
    public final JavaScriptObject getBars(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "bars");
    }
    
    /**
     * <p>Gets the option "grid"</p>
     * 
     */
    public final JavaScriptObject getGrid(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "grid");
    }
    
    /**
     * <p>Gets the option "legend"</p>
     * 
     */
    public final JavaScriptObject getLegend(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "legend");
    }
    
    /**
     * <p>Gets the option "lines"</p>
     * 
     */
    public final JavaScriptObject getLines(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "lines");
    }
    
    /**
     * <p>Gets the option "points"</p>
     * 
     */
    public final JavaScriptObject getPoints(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "points");
    }
    
    /**
     * <p>Gets the option "selection"</p>
     * 
     */
    public final JavaScriptObject getSelection(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "selection");
    }
    
    /**
     * <p>Gets the option "shadowSize"</p>
     * 
     */
    public final int getShadowSize(){
        return (ObjectHelper.getAttributeAsInt(this, "shadowSize"));
    }
    
    /**
     * <p>Gets the option "xaxis"</p>
     * 
     */
    public final JavaScriptObject getXaxis(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "xaxis");
    }
    
    /**
     * <p>Gets the option "yaxis"</p>
     * 
     */
    public final JavaScriptObject getYaxis(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "yaxis");
    }
    
    /*public final String getColor(){
        return ObjectHelper.getAttribute(this, "color");
    }*/
    
    /**
     * <p>Gets the dataset</p>
     * 
     */
    public final JavaScriptObject getRowData(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "data");
    }
    
    /**
     * <p>Gets the option "label"</p>
     * 
     */
    public final String getLabel(){
        return ObjectHelper.getAttribute(this, "label");
    }

}
