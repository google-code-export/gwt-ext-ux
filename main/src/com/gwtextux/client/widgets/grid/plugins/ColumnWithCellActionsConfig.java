package com.gwtextux.client.widgets.grid.plugins;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtextux.client.widgets.grid.plugins.GridCellAction;

/**
 * The Grid Column with cell actions configuration.
 * 
 * See http://cellactions.extjs.eu/
 * @author Jozef Sakalos (Original Ext component author)
 * @author Mariusz Pala (GWT-Ext wrapper author)
 * 
 */
public class ColumnWithCellActionsConfig extends ColumnConfig {

	public ColumnWithCellActionsConfig() {
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex) {
		super(header, dataIndex);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width) {
		super(header, dataIndex, width, false);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable) {
		super(header, dataIndex, width, sortable, null);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 * @param renderer
	 * a renderer to allow custom formating of cells of this column
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable, Renderer renderer) {
		super(header, dataIndex, width, sortable, renderer, null);
	}

	/**
	 * Create a new ColumnWithCellActionsConfig.
	 * 
	 * @param header
	 * the column header
	 * @param dataIndex
	 * the data index (the field name pf the Store associated with the Grid)
	 * @param width
	 * the column width
	 * @param sortable
	 * true for sortable
	 * @param renderer
	 * a renderer to allow custom formating of cells of this column
	 * @param id
	 * the grid ID
	 */
	public ColumnWithCellActionsConfig(String header, String dataIndex, int width, boolean sortable, Renderer renderer, String id) {
		super(header, dataIndex, width, sortable, renderer, id);
	}

	/**
	 * Sets the cell actions for a column.
	 * @param actions
	 */
	public void setCellActions(GridCellAction[] actions) {
		JavaScriptObject[] config = new JavaScriptObject[actions.length];
		for (int i = 0; i < actions.length; i++) {
			GridCellAction column = actions[i];
			config[i] = column.getJsObj();
		}
		JavaScriptObject configJS = JavaScriptObjectHelper.convertToJavaScriptArray(config);
		JavaScriptObjectHelper.setAttribute(jsObj, "cellActions", configJS);
	}

}
