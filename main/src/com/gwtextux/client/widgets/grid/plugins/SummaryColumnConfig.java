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

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.Renderer;

/**
 * For use with GridSummaryPlugin
 * 
 * @author Matthew Lieder
 */
public class SummaryColumnConfig extends BaseColumnConfig {

	public static final String SUM = "sum";
	public static final String COUNT = "count";
	public static final String AVERAGE = "average";
	
	public SummaryColumnConfig(BaseColumnConfig columnConfig) {
		jsObj = columnConfig.getJsObj();
	}
	
	public SummaryColumnConfig(String summaryType, BaseColumnConfig columnConfig) {
		this(columnConfig);
		setSummaryType(summaryType);
	}
	
	public SummaryColumnConfig(String summaryType, BaseColumnConfig columnConfig, Renderer summaryRenderer) {
		this(summaryType, columnConfig);
		setSummaryRenderer(summaryRenderer);
	}
	
	/**
	 * Permissible types are sum, count, average, min, and max
	 * (more can be added using JavaScript; see last part of Ext.ux.grid.GridSummary.js)
	 */
    public void setSummaryType(String type) {
        JavaScriptObjectHelper.setAttribute(jsObj, "summaryType", type);
    }

	public String getSummaryType() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "summaryType");
	}
	
	/**
     * Sets the rendering (formatting) function for this column's summary cell
     *
     * @param renderer the column summary renderer
     */
    public native void setSummaryRenderer(Renderer renderer) /*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();

        config['summaryRenderer'] = function(val, cell, r, rowIndex, colNum, store) {
            var valJ = (val  == null || val === undefined || val === '') ? null : $wnd.GwtExt.convertToJavaType(val);
            var recJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            var cellJ = @com.gwtext.client.widgets.grid.ColumnModel::createCellMetadata(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
            var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/Object;Lcom/gwtext/client/widgets/grid/CellMetadata;Lcom/gwtext/client/data/Record;IILcom/gwtext/client/data/Store;)(valJ, cellJ, recJ, rowIndex, colNum, storeJ);
        }
    }-*/;
    
}
