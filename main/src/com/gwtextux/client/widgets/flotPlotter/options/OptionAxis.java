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
 * <p>This class represents the axis options</p>
 * 
 * @author LeLLuMe
 */
public class OptionAxis extends JavaScriptObject {
    
    protected OptionAxis(){
        super();
    }
    
    private static native OptionAxis createobj()/*-{
        return new Object;
    }-*/; 
    
    
    /**
     * <p>Creates a OptionAxis object</p>
     * 
     */
    public static OptionAxis create(){
        //return OptionAxisCreator.create();
        return createobj();
    }
    
    /**
     * <p>Sets the time mode</p>
     * <p>It specifies that we are working with time data</p>
     * 
     */
    //specifica che si sta lavorando con dati "temporali"
    public final void setTimeMode(){
        ObjectHelper.setAttribute(this, "mode", "time");
    }
    
    /**
     * <p>Sets the min value of the axis</p>
     * 
     * @param min
     */
    public final void setMin(int min){
        ObjectHelper.setAttribute(this, "min", min);
    }
    
    /**
     * <p>Sets the max value of the axis</p>
     * 
     * @param min
     */
    public final void setMax(int max){
        ObjectHelper.setAttribute(this, "max", max);
    }
    
    //Capire meglio a cosa serve
    /*public final void setAutoScaleMargin(int value){
        ObjectHelper.setAttribute(this, "autoscaleMargin", value);
    }*/
    
    /**
     * <p>Sets number of ticks</p>
     * number = 0 stands for no ticks
     * 
     * @param number
     */
    public final void setNrTicks(int number){
        ObjectHelper.setAttribute(this, "ticks", number);
    }
    
    /**
     * <p>Sets the ticks of the axis</p>
     * <p>Values are floating point numbers</p>
     * 
     * @param tickSet: JSONArray object
     */
    public final void setTicksFloatSet(JSONArray tickSet){
        JavaScriptObject JSArray = ObjectHelper.newJSArray();
        float value;
        
        for (int i = 0; i < tickSet.size(); i++){
            value = Float.parseFloat(tickSet.get(i).toString());
            ObjectHelper.addFloatValue(JSArray, value);
        }
        
        //ObjectHelper.setAttribute(this, "ticks", JSArray);
        setTicksFloatSet(JSArray);
    }
    
    /**
     * <p>Sets the ticks of the axis</p>
     * <p>Values are floating point numbers</p>
     * 
     * @param tickSet: JavaScriptObject object
     */
    public final void setTicksFloatSet(JavaScriptObject tickSet){
        ObjectHelper.setAttribute(this, "ticks", tickSet);
    }
    
    /**
     * <p>Sets the ticks of the axis</p>
     * <p>Values are integer numbers</p>
     * 
     * @param tickSet: JSONArray object
     */
    public final void setTicksSet(JSONArray tickSet){
        JavaScriptObject jsArray = ObjectHelper.newJSArray();
        
        jsArray = ObjectHelper.wrapJSONArrayToJSObject(tickSet);
        
        ObjectHelper.setAttribute(this, "ticks", jsArray);
    }
    
    /**
     * <p>Sets the ticks' size</p>
     * <p>It specifies the distance between ticks </p>
     * 
     * @param tickSize
     */
    public final void setTickSize(int tickSize){
        ObjectHelper.setAttribute(this, "tickSize", tickSize);
    }
    
    /**
     * <p>Sets the min value of the ticks' size</p>
     * 
     * @param minTickSize
     */
    public final void setMinTickSize(int minTickSize){
        ObjectHelper.setAttribute(this, "minTickSize", minTickSize);
    }
    
    //da definire un eventuale funzione per la formattazione delle etichette
    //delle tacche
    /*public final void setTickFormatter(){
        
    }*/
    
    /**
     * <p>Sets number of digits after the floating point of the ticks</p>
     * 
     * @param nrDecimals
     */
    public final void setTickDecimals(int nrDecimals){
        ObjectHelper.setAttribute(this, "tickDecimals", nrDecimals);
    }
    
    /**
     * <p>Gets the option "time"</p>
     * 
     */
    public final boolean isModeTime(){
        return (ObjectHelper.getAttribute(this, "mode") == "time");
    }
    
    /**
     * <p>Gets the min value</p>
     * 
     */
    public final int getMin(){
        return ObjectHelper.getAttributeAsInt(this, "min");
    }
    
    /**
     * <p>Gets the max value</p>
     * 
     */
    public final int getMax(){
        return ObjectHelper.getAttributeAsInt(this, "max");
    }
    
    /*public final int getAutoScaleMargin(){
        return ObjectHelper.getAttributeAsInt(this, "autoscaleMargin");
    }*/
    
    /**
     * <p>Gets the ticks number</p>
     * 
     */
    public final int getNrTicks(){
        return ObjectHelper.getAttributeAsInt(this, "ticks");
    }
    
    /**
     * <p>Gets the array of ticks</p>
     * 
     */
    public final JSONArray getTicksFloatSetAsJSONArray(){
        return new JSONArray(ObjectHelper.getAttributeAsJavaScriptObject(this, "ticks"));
    }
    
    /**
     * <p>Gets the ticks set</p>
     * 
     */
    public final JavaScriptObject getTicksFloatSet(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "ticks");
    }
    
    /**
     * <p>Gets the tick size</p>
     * 
     */
    public final int getTickSize(){
        return ObjectHelper.getAttributeAsInt(this, "tickSize");
    }
    
    /**
     * <p>Gets the minimun tick size</p>
     * 
     */
    public final int getMinTickSize(){
        return ObjectHelper.getAttributeAsInt(this, "minTickSize");
    }
    
    /*public final String getTickFormatter(){
        return ObjectHelper.getAttribute(this, "tickFormatter");
    }*/
    
    /**
     * <p>Gets the ticks decimals</p>
     * 
     */
    public final int getTickDecimals(){
        return ObjectHelper.getAttributeAsInt(this, "tickDecimals");
    }
    
    

}
