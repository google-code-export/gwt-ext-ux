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
 * <p>This class represents a ClassColoredArea object</p>
 * 
 * @author LeLLuMe
 */
public class ClassColoredArea extends JavaScriptObject{
    protected ClassColoredArea(){
        super();
    }
    
    private static native ClassColoredArea createobj()/*-{
        return new Object;
    }-*/;
    
    
    /**
     * <p>Creates a ClassColoredArea object</p>
     * 
     */
    public static ClassColoredArea create(){
        //return ClassColoredAreaCreator.create();
        return createobj();
    }
    
    /**
     * <p>Sets the first coordinate of the first point</p>
     * 
     * @param coor: the first float coordinate
     */
    public final void setX1(float coor){
        ObjectHelper.setAttribute(this, "x1", coor);
    }
    
    /**
     * <p>Sets the first coordinate of the first point</p>
     * 
     * @param coor: the first int coordinate
     */
    public final void setX1(int coor){
        ObjectHelper.setAttribute(this, "x1", coor);
    }
    
    /**
     * <p>Sets the second coordinate of the first point</p>
     * 
     * @param coor: the second float coordinate
     */
    public final void setY1(float coor){
        ObjectHelper.setAttribute(this, "y1", coor);
    }
    
    /**
     * <p>Sets the second coordinate of the first point</p>
     * 
     * @param coor: the second float coordinate
     */
    public final void setY1(int coor){
        ObjectHelper.setAttribute(this, "y1", coor);
    }
    
    /**
     * <p>Sets the first coordinate of the second point</p>
     * 
     * @param coor: the first float coordinate
     */
    public final void setX2(float coor){
        ObjectHelper.setAttribute(this, "x2", coor);
    }
    
    /**
     * <p>Sets the first coordinate of the second point</p>
     * 
     * @param coor: the first int coordinate
     */
    public final void setX2(int coor){
        ObjectHelper.setAttribute(this, "x2", coor);
    }
    
    /**
     * <p>Sets the second coordinate of the second point</p>
     * 
     * @param coor: the second float coordinate
     */
    public final void setY2(float coor){
        ObjectHelper.setAttribute(this, "y2", coor);
    }
    
    /**
     * <p>Sets the second coordinate of the second point</p>
     * 
     * @param coor: the second int coordinate
     */
    public final void setY2(int coor){
        ObjectHelper.setAttribute(this, "y2", coor);
    }
    
    /**
     * <p>Sets the fill color of the area</p>
     * 
     * @param color
     */
    public final void setColor(String color){
        ObjectHelper.setAttribute(this, "color", color);
    }
    
    /**
     * <p>Gets the fill color of the area</p>
     * 
     */
    public final String getColor(){
        return ObjectHelper.getAttribute(this, "color");
    }
    
    /**
     * <p>Gets xaxis coordinate of the first point</p>
     * 
     */
    public final int getX1AsInt(){
        return ObjectHelper.getAttributeAsInt(this, "x1");
    }
    
    /**
     * <p>Gets xaxis coordinate of the first point</p>
     * 
     */
    public final float getX1AsFloat(){
        return ObjectHelper.getAttributeAsFloat(this, "x1");
    }
    
    /**
     * <p>Gets yaxis coordinate of the first point</p>
     * 
     */
    public final int getY1AsInt(){
        return ObjectHelper.getAttributeAsInt(this, "y1");
    }
    
    /**
     * <p>Gets yaxis coordinate of the first point</p>
     * 
     */
    public final float getY1AsFloat(){
        return ObjectHelper.getAttributeAsFloat(this, "y1");
    }
    
    /**
     * <p>Gets xaxis coordinate of the second point</p>
     * 
     */
    public final int getX2AsInt(){
        return ObjectHelper.getAttributeAsInt(this, "x2");
    }
    
    /**
     * <p>Gets xaxis coordinate of the second point</p>
     * 
     */
    public final float getX2AsFloat(){
        return ObjectHelper.getAttributeAsFloat(this, "x2");
    }
    
    /**
     * <p>Gets yaxis coordinate of the second point</p>
     * 
     */
    public final int getY2AsInt(){
        return ObjectHelper.getAttributeAsInt(this, "y2");
    }
    
    /**
     * <p>Gets yaxis coordinate of the second point</p>
     * 
     */
    public final float getY2AsFloat(){
        return ObjectHelper.getAttributeAsFloat(this, "y2");
    }

}
