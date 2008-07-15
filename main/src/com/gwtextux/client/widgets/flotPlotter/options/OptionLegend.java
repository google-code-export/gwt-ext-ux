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

/**
 * <p>This class represents the legend options</p>
 * 
 * @author LeLLuMe
 */
public class OptionLegend extends JavaScriptObject {
    protected OptionLegend(){
        super();
    }
    
    private static native OptionLegend createobj()/*-{
        return new Object;
    }-*/; 
    
    
    /**
     * <p>Creates an OptionLegend object</p>
     * 
     */
    public static OptionLegend create(){
        //return OptionLegendCreator.create();
        return createobj();
    }
    
    /**
     * <p>Determine if the legend is visible (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setShow(boolean state){
        ObjectHelper.setAttribute(this, "show", state);
    }
    
    //Vedere bene quali valori pu˜ assumere questa proprietˆ
    /*public void setLabelFormatter(){
        ObjectHelper.setAttribute(this, "labelFormatter", "");
    }*/
    
    /**
     * <p>Sets the border color of the color box container associated to a label</p>
     * 
     * @param color
     */
    //setta il colore del bordo della legenda
    public final void setLabelBoxBorderColor(String color){
        ObjectHelper.setAttribute(this, "labelBorderColor", color);
    }
    
    /**
     * <p>Sets the number of the columns that constitute the legend structure</p>
     * 
     * @param number: number of columns
     */
    public final void setNrColumns(int number){
        ObjectHelper.setAttribute(this, "noColumns", number);
    }
    
    /**
     * <p>Sets legend position on the plot box</p>
     * <p>Possible values are:</p>
     * <p><ul>
     * <li>"ne" (NorthEst)</li>
     * <li>"nw" (NorthWest)</li>
     * <li>"se" (SouthEst)</li>
     * <li>"sw" (SouthWest)</li>
     * </ul>
     * </p>
     * 
     * @param position
     */
    public final void setPosition(String position){
        ObjectHelper.setAttribute(this, "position", position);
    }
    
    /**
     * <p>Sets margin value of the table that contains the legend</p>
     * <p>rispect to the plot container</p>
     * 
     * @param margin
     */
    public final void setMargin(int pixels){
        ObjectHelper.setAttribute(this, "margin", pixels);
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
     * <p>Sets the opacity of the background</p>
     * 
     * @param opacity
     */
    public final void setBackgroundOpacity(float opacity){
        if (opacity>=0.0 && opacity<=1.0)
            ObjectHelper.setAttribute(this, "backgroundOpacity", opacity);
    }
    
    /**
     * <p>Specifies the id of the legend container</p>
     * <p>if it is different from the plot container</p>
     * <p>The format is "#idcontainer"</p>
     * 
     * @param id
     */
    public final void setContainer(String container){
        ObjectHelper.setAttributeAsJQueryObject(this, "container", container);
    }
    
    /**
     * <p>Gets the option "show"</p>
     * 
     */
    public final boolean getShow(){
        return (ObjectHelper.getAttributeAsBoolean(this, "show"));
    }
    
    /**
     * <p>Gets the label box border color</p>
     * 
     */
    public final String getLabelBoxBorderColor(){
        return (ObjectHelper.getAttribute(this, "labelBoxBorderColor"));
    }
    
    /**
     * <p>Gets the columns number</p>
     * 
     */
    public final int getNrColumns(){
        return (ObjectHelper.getAttributeAsInt(this, "noColumns"));
    }
    
    /**
     * <p>Gets the position of the legend</p>
     * 
     */
    public final String getPosition(){
        return (ObjectHelper.getAttribute(this, "position"));
    }
    
    /**
     * <p>Gets the margin value</p>
     * 
     */
    public final int getMargin(){
        return (ObjectHelper.getAttributeAsInt(this, "margin"));
    }
    
    /**
     * <p>Gets the background color</p>
     * 
     */
    public final String getBackgroundColor(){
        return (ObjectHelper.getAttribute(this, "backgroundColor"));
    }
    
    /**
     * <p>Gets the background opacity</p>
     * 
     */
    public final float getBackgroundOpacity(){
        return (ObjectHelper.getAttributeAsFloat(this, "backgroundOpacity"));
    }
    
    /**
     * <p>Gets the container</p>
     * 
     */
    public final String getContainer(){
        String container = ObjectHelper.getAttribute(this, "container").toString();
        container = container.substring(container.indexOf("#"));
        container = container.substring(0, (container.indexOf("\"") - 1));
        return (container);
    }

}
