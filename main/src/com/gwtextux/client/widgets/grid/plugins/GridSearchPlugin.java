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
