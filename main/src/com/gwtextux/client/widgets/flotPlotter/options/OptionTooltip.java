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
 * <p>This class represents the tooltip options</p>
 * 
 * @author LeLLuMe
 */
public class OptionTooltip extends JavaScriptObject {
    
    protected OptionTooltip(){
        super();
    }
    
    private static native OptionTooltip createobj()/*-{
        return new Object;
    }-*/;
    
    
    /**
     * <p>Creates an OptionTooltip object</p>
     * 
     */
    public static OptionTooltip create(){
        //return OptionTooltipCreator.create();
        return createobj();
    }
    
    /**
     * <p>Determine if tooltips can appear (true) or not (false)</p>
     * 
     * @param state
     */
    public final void setShow(boolean state){
        ObjectHelper.setAttribute(this, "show", state);
    }
    
    /**
     * <p>Sets the tootip background</p>
     * 
     * @param background
     */
    public final void setBackground(String color){
        ObjectHelper.setAttribute(this, "background", color);
    }
    
    /**
     * <p>Sets the textcolor</p>
     * 
     * @param color
     */
    public final void setColor(String color){
        ObjectHelper.setAttribute(this, "color", color);
    }
    
    /**
     * <p>Gets the option "show"</p>
     * 
     */
    public final boolean getShow(){
        return ObjectHelper.getAttributeAsBoolean(this, "show");
    }
    
    /**
     * <p>Gets the background color</p>
     * 
     */
    public final String getBackground(){
        return ObjectHelper.getAttribute(this, "background");
    }
    
    /**
     * <p>Gets the text color</p>
     * 
     */
    public final String getColor(){
        return ObjectHelper.getAttribute(this, "color");
    }

}
