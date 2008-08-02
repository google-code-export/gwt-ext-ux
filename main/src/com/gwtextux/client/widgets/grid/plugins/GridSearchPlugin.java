/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.ComponentPlugin;

/**
 * See http://extjs.com/forum/showthread.php?t=23615
 * Requires ext-ux-grid-search.js
 */
public class GridSearchPlugin extends ComponentPlugin {

    public static Mode REMOTE = new Mode("remote");
    public static Mode LOCAL = new Mode("local");
    
    public static Position TOP = new Position("top");
    public static Position BOTTOM = new Position("bottom");
	
	protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
	
	/**
	 * Constructs a new GridSearchPlugin.
	 */
	public GridSearchPlugin(Position toolbarPosition) {
		JavaScriptObjectHelper.setAttribute(configJS, "position", toolbarPosition.getPosition());
	}

	public JavaScriptObject getJsObj() {
		if (!isCreated()) {
			jsObj = create(configJS);
		}
		return jsObj;
	}

	public native JavaScriptObject create(JavaScriptObject configJS) /*-{
	   return new $wnd.Ext.ux.grid.Search(configJS);
	}-*/;
	
	public void init(Component component) {
	}
	
    public native String getSearchValue() /*-{
	    var plugin = this.@com.gwtext.client.core.JsObject::getJsObj()();
	    return plugin.field ? plugin.field.getValue() : '';
	}-*/;

    public void setSearchText(String searchText) {
		JavaScriptObjectHelper.setAttribute(configJS, "searchText", searchText);
	}
    
    public void setMode(Mode mode) {
    	JavaScriptObjectHelper.setAttribute(configJS, "mode", mode.getMode());
    }
	
    protected static class Mode {
        private String mode;

        private Mode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }
    
    protected static class Position {
        private String position;

        private Position(String position) {
            this.position = position;
        }

        public String getPosition() {
            return position;
        }
    }
    
}
