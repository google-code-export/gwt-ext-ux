package com.gwtextux.client.widgets.buttons;

import com.gwtext.client.widgets.event.ButtonListener;

public interface BrowseButtonListener extends ButtonListener {
	public void onInputFileChange(BrowseButton browseButton, String filename);
}
