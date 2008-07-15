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
 * <p>This class represents the grid options</p>
 * 
 * @author LeLLuMe
 */
public class OptionGrid extends JavaScriptObject{
    protected OptionGrid(){
        super();
    }
    
    private static native OptionGrid createobj()/*-{
        return new Object;
    }-*/;
    
    
    /**
     * <p>Creates an OptionGrid object</p>
     * 
     */
    public static OptionGrid create(){
        //return OptionGridCreator.create();
        return createobj();
    }
    
    /**
     * <p>Sets the border grid color</p>
     * 
     * @param color
     */
    public final void setColor(String color){
        ObjectHelper.setAttribute(this, "color", color);
    }
    
    /**
     * <p>Sets the background color</p>
     * 
     * @param color
     */
    public final void setBackgroundColor(String color){
        ObjectHelper.setAttribute(this, "backgroundColor", color);
    }
    
    /**
     * <p>Sets the grid color</p>
     * 
     * @param color
     */
    public final void setTickColor(String color){
        ObjectHelper.setAttribute(this, "tickColor", color);
    }
    
    /**
     * <p>Sets the margin of ticks' labels from the grid</p>
     * 
     * @param labelMargin
     */
    public final void setLabelMargin(int labelMargin){
        ObjectHelper.setAttribute(this, "labelMargin", labelMargin);
    }
    
    
    /**
     * <p>Sets an array of colored area to be shown on the plot</p>
     * <p>The format is [{area1, area2,...,arean}]</p>
     * <p>where areai (i= 1,..,n) format is</p>
     * <p>{x1,y1,x2,y2,color}</p>
     * 
     * @param areas: JSONArray object
     */
    public final void setColoredAreas(JSONArray areas){
        ClassArrayColoredAreas JSArray = ClassArrayColoredAreas.create();
        
        for (int i = 0; i < areas.size(); i++){
            ClassColoredArea area = ClassColoredArea.create();
            area.setX1(Float.parseFloat(areas.get(i).isObject().get("x1").toString()));
            area.setY1(Float.parseFloat(areas.get(i).isObject().get("y1").toString()));
            area.setX2(Float.parseFloat(areas.get(i).isObject().get("x2").toString()));
            area.setY2(Float.parseFloat(areas.get(i).isObject().get("y2").toString()));
            area.setColor(areas.get(i).isObject().get("color").toString());
            JSArray.addColoredArea(area);
        }
        
        setColoredAreas(JSArray);
    }
    
    /**
     * <p>Sets an array of ClassColoredArea objects</p>
     * 
     * @param areas: ClassArrayColoredAreas object
     */
    public final void setColoredAreas(ClassArrayColoredAreas areas){
        ObjectHelper.setAttribute(this, "coloredAreas", areas);
    }
    
    /**
     * <p>Sets the fill color of the colored areas plotted</p>
     * 
     * @param color
     */
    public final void setColoredAreasColor(String color){
        ObjectHelper.setAttribute(this, "coloredAreasColor", color);
    }
    
    /**
     * <p>Sets the width of the grid border </p>
     * 
     * @param width
     */
    public final void setBorderWidth(int width){
        ObjectHelper.setAttribute(this, "borderWidth", width);
    }
    
    /**
     * <p>Determines if the plot is "click sensible" (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setClickable(boolean state){
        ObjectHelper.setAttribute(this, "clickable", state);
    }
    
    /**
     * <p>Determine if the plot is "onMouseOver sensible" (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setTriggerOnMouseOver(boolean state){
        ObjectHelper.setAttribute(this, "triggerOnMouseOver", state);
    }
    
    /**
     * <p>Sets the width of the area in which the plot points are sensible on the</p>
     * <p>onMouseOver events</p>
     * 
     * @param area
     */
    public final void setMouseCatchingArea(int area){
        ObjectHelper.setAttribute(this, "mouseCatchingArea", area);
    }
    
    /**
     * <p>Gets the grid border color</p>
     * 
     */
    public final String getColor(){
        return ObjectHelper.getAttribute(this, "color");
    }
    
    /**
     * <p>Gets the background color</p>
     * 
     */
    public final String getBackgroundColor(){
        return ObjectHelper.getAttribute(this, "backgroundColor");
    }
    
    /**
     * <p>Gets the ticks color</p>
     * 
     */
    public final String getTickColor(){
        return ObjectHelper.getAttribute(this, "tickColor");
    }
    
    /**
     * <p>Gets the labels margin</p>
     * 
     */
    public final int getLabelMargin(){
        return ObjectHelper.getAttributeAsInt(this, "labelMargin");
    }
    
    /**
     * <p>Gets the ClassColoredAreas as JSONArray</p>
     * 
     */
    public final JSONArray getColoredAreasAsJSONArray(){
        return new JSONArray(ObjectHelper.getAttributeAsJavaScriptObject(this, "coloredAreas"));
    }
    
    /**
     * <p>Gets the array of ClassColoredAreas as JavaScriptObject</p>
     * 
     */
    public final JavaScriptObject getColoredAreas(){
        return ObjectHelper.getAttributeAsJavaScriptObject(this, "coloredAreas");
    }
    
    /**
     * <p>Gets the fill color of the colored areas</p>
     * 
     */
    public final String getColoredAreasColor(){
        return ObjectHelper.getAttribute(this, "coloredAreasColor");
    }
    
    /**
     * <p>Gets the border width</p>
     * 
     */
    public final int getBorderWidth(){
        return ObjectHelper.getAttributeAsInt(this, "borderWidth");
    }
    
    /**
     * <p>Gets the option "clickable"</p>
     * 
     */
    public final boolean getClickable(){
        return ObjectHelper.getAttributeAsBoolean(this, "clickable");
    }
    
    /**
     * <p>Gets the option "triggerOnMouseOver"</p>
     * 
     */
    public final boolean getTriggerOnMouseOver(){
        return ObjectHelper.getAttributeAsBoolean(this, "triggerOnMouseOver");
    }
    
    /**
     * <p>Gets the option "mouseCatchingArea"</p>
     * 
     */
    public final int getMouseCatchingArea(){
        return ObjectHelper.getAttributeAsInt(this, "mouseCatchingArea");
    }

}
