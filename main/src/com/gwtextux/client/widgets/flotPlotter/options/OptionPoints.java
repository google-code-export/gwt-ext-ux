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
 * <p>This class represents the points plot options</p>
 * 
 * @author LeLLuMe
 */
public class OptionPoints extends JavaScriptObject {
    protected OptionPoints(){
        super();
    }
    
    private static native OptionPoints createobj()/*-{
        return new Object;
    }-*/; 
    
    
    /**
     * <p>Creates an OptionPoints object</p>
     * 
     */
    public static OptionPoints create(){
        //return OptionPointsCreator.create();
        return createobj();
    }
    
    /**
     * <p>It specifies if we want to plot a points graph (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setShow(boolean state){
        ObjectHelper.setAttribute(this, "show", state);
    }
    
    /**
     * <p>Sets the border witdh of the points</p>
     * 
     * @param width
     */
    public final void setBorderWidth(int width){
        ObjectHelper.setAttribute(this, "lineWidth", width);
    }
    
    /**
     * <p>Sets if the points are colored (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setFill(boolean state){
        ObjectHelper.setAttribute(this, "fill", state);
    }
    
    /**
     * <p>Sets the fill color of the points</p>
     * 
     * @param color
     */
    public final void setFillColor(String color){
        ObjectHelper.setAttribute(this, "fillColor", color);
    }
    
    /**
     * <p>Sets the radius values of the points</p>
     * 
     * @param radius
     */
    public final void setRadius(int radius){
        ObjectHelper.setAttribute(this, "radius", radius);
    }
    
    /**
     * <p>Gets the option "show"</p>
     * 
     */
    public final boolean getShow(){
        return ObjectHelper.getAttributeAsBoolean(this, "show");
    }
    
    /**
     * <p>Gets the border width</p>
     * 
     */
    public final int getBorderWidth(){
        return ObjectHelper.getAttributeAsInt(this, "lineWidth");
    }
    
    /**
     * <p>Gets the option "fill"</p>
     * 
     */
    public final boolean getFill(){
        return ObjectHelper.getAttributeAsBoolean(this, "fill");
    }
    
    /**
     * <p>Gets the fill color</p>
     * 
     */
    public final String getFillColor(){
        return ObjectHelper.getAttribute(this, "fillColor");
    }
    
    /**
     * <p>Gets the radius value</p>
     * 
     */
    public final int getRadius(){
        return ObjectHelper.getAttributeAsInt(this, "radius");
    }

}
