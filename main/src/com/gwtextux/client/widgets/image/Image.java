package com.gwtextux.client.widgets.image;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventManager;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ListenerConfig;
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.menu.Menu;

/**
 * Image Component for gwt-ext
 * @author mlim1972
 *
 */
public class Image extends BoxComponent {
	private Element img = null;
	private ListenerConfig listenerConfig = new ListenerConfig();
	private Menu menu = null;
    
	/**
	 * Constructor to create the Image Widget.
	 * @param id The id to use for this component
	 * @param imgURL The URL for the image
	 */
    public Image(String id, String imgURL) {

        super(DOM.createImg());
        img = this.getElement();
        
        DOM.setElementProperty(img, "src", imgURL);
        DOM.setElementProperty(img, "id", id);
        
        listenerConfig.setPreventDefault(true);
     }

    /**
     * Empty Constructor
     */
	public Image(){
        super(DOM.createImg());
        img = this.getElement();	
	}

	/**
	 * Constructor that receives the Javascript Object
	 * @param jsObj the Javascript object
	 */
	public Image(JavaScriptObject jsObj){
		super(jsObj);
	}
	
	/**
	 * Method that gets the X-type of this component
	 */
    public String getXType() {
    	return "image";
    }
    
    /**
     *  The url of the image.
     *
     * @param src the source URL to get to the image
     */
    public void setSrc(String src) {
    	DOM.setElementProperty(img, "src", src);
    }
    
    /**
     *  The tooltip for the image.
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
    	DOM.setElementProperty(img, "alt", tooltip);
    }
    
    /**
     * Displays the context menu when the right click is pressed on the image
     * @param menu the menu to show
     */
    public void setContextMenu(Menu menu){
    	this.menu = menu;
    }
    
    /**
     * Add a listener.
     *
     * @param listener the listener
     */
    public void addListener(ImageListener listener) {
    	super.addListener(listener);
    	final ImageListener fListener = listener;
    	final Image me = this;
    	
    	EventCallback onClick = new EventCallback(){
			public void execute(EventObject e) {
				fListener.onClick(me, e);
			}  		
    	};
    	
    	EventCallback onMouseOut = new EventCallback(){
			public void execute(EventObject e) {
				fListener.onMouseOut(me, e);
			}  		
    	};
    	
    	EventCallback onMouseOver = new EventCallback(){
			public void execute(EventObject e) {
				fListener.onMouseOver(me, e);
			}  		
    	};
    	
    	EventCallback onMouseDown = new EventCallback(){
			public void execute(EventObject e) {
				if(menu != null)
					menu.showAt(e.getXY());
			}  		
    	};
    	
    	EventManager.addListener(getElement(), "click", onClick, listenerConfig);
    	EventManager.addListener(getElement(), "mouseout", onMouseOut, listenerConfig);  
    	EventManager.addListener(getElement(), "mouseover", onMouseOver, listenerConfig);  
    	EventManager.addListener(getElement(), "contextmenu", onMouseDown, listenerConfig);
    }

//    public native void addListener(ImageListener listener) /*-{
//        this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
//        var componentJ = this;
//
//        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
//                function(self, event) {
//                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
//                    listener.@com.onlineassets.client.widgets.ImageListener::onClick(Lcom/onlineassets/client/widgets/Image;Lcom/gwtext/client/core/EventObject;)(componentJ, e);
//                }
//        );
//    }-*/;
   
}
