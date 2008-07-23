package com.gwtextux.client.widgets.grid.plugins;


public interface GridFilterListener {
	/**
	 * Fires when a inactive filter becomes active
	 * @param filter the GridFilter that it belongs to
	 */
    public void onActivate(GridFilter filter);
    
	/**
	 * Fires when a active filter becomes inactive
	 * @param filter the GridFilter that it belongs to
	 */
    public void onDeactivate(GridFilter filter);

	/**
	 * Fires when a filter configuration has changed
	 * @param filter the GridFilter that it belongs to
	 */
    public void onUpdate(GridFilter filter);

}
