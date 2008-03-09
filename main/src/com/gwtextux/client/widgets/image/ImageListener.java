package com.gwtextux.client.widgets.image;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.event.BoxComponentListener;

/**
 * This interface sets the Image Listeners available
 * @author mlim1972
 *
 */
public interface ImageListener extends BoxComponentListener {
	
    /**
     * Fires when this image is clicked
     *
     * @param image this
     * @param e      the event object
     */
    public void onClick(Image image, EventObject e);

    /**
     * Fires when the mouse exits the image.
     *
     * @param image this
     * @param e      the event object
     */
    void onMouseOut(Image image, EventObject e);

    /**
     * Fires when the mouse hovers over the image.
     *
     * @param image this
     * @param e      the event object
     */
    void onMouseOver(Image image, EventObject e);

}
