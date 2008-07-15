package com.gwtextux.client.widgets.flotPlotter;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Composite;
import com.gwtext.client.widgets.Panel;

/**
 * <p>This class represents the plot widget</p>
 * 
 * @author LeLLuMe
 * 
 * Members:
 * 
 * plot: plot object
 * overview: overview object
 * dataset: dataset plotted
 * plotOptions: plot options
 * overviewOptions: overview options
 * drawType: indicates which kind of plotting is chosen
 * containerAddress: id of the plot container
 * overviewAddress: id of the overview container
 */
public class ClassFlotPlotter extends Composite{
    private JavaScriptObject plot;
    private JavaScriptObject overview;
    private JavaScriptObject dataset;
    private JavaScriptObject plotOptions;
    private JavaScriptObject overviewOptions;
    private int drawType;
    private String containerAddress;
    private String overviewAddress;
    private static Panel panel = new Panel();
    
    public ClassFlotPlotter(){
        panel.setId("plotPlaceholder");
        panel.setBorder(false);
        containerAddress = "#plotPlaceholder";
        panel.setWidth(600);
        panel.setHeight(300);
        initWidget(panel);
    }
    
    /**
     * <p>Sets the width of the widget</p>
     * 
     * @param width
     */
    public void setWidth(int width){
        panel.setWidth(width);
    }
    
    /**
     * <p>Sets the height of the widget</p>
     * 
     * @param height
     */
    public void setHeight(int height){
        panel.setHeight(height);
    }
    
    /**
     * <p>Draws plot without options</p>
     * 
     * @param datasets
     */   
    public native void drawWithNoOptions(JavaScriptObject datasets) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 1;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithNoOptions(datasets,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
    }-*/;
    
    
    /**
     * <p>Draws plot with options</p>
     * 
     * @param datasets
     * @param options: plot options
     */  
    public native void drawWithOptions(JavaScriptObject datasets, JavaScriptObject options) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 2;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions = options;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithOptions(datasets,options,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
    }-*/;
    
    
    /**
     * <p>Draws plot without options and overview without options</p>
     * 
     * @param datasets
     * @param contOverview: id plot overview
     */
    public native void drawWithNoOptionsAndOverviewWithNoOptions(JavaScriptObject datasets, String contOverview) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 3;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress = contOverview;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithNoOptions(datasets,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview = $wnd.drawOverviewWithNoOptions(datasets,contOverview);
        $wnd.bindPlotWithOverviewNoOptions(datasets, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress, contOverview);
    }-*/;
    
    
    /**
     * <p>Draws plot without options and overview with options</p>
     * 
     * @param datasets
     * @param overOptions: overview options
     * @param contOverview: id overview container
     */
    public native void drawWithNoOptionsAndOverviewWithOptions(JavaScriptObject datasets, JavaScriptObject overOptions, String contOverview) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 4;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewOptions = overOptions;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress = contOverview;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithNoOptions(datasets,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview = $wnd.drawOverviewWithOptions(datasets, overOptions, contOverview);
        $wnd.bindPlotWithOverviewNoOptions(datasets, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress, contOverview);
    }-*/;
    
    
    /**
     * <p>Draws plot with options and overview without options</p>
     * 
     * @param datasets
     * @param options: plot options
     * @param contOverview: id overview container
     */
    //ho inserito solo qui questo tipo di controllo in quanto, qualora le opzioni fossero
    //incapsulate nel dataset, allora essere saranno automaticamente ereditate
    //dall'overview    
    public native void drawWithOptionsAndOverviewWithNoOptions(JavaScriptObject datasets, JavaScriptObject options, String contOverview) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 5;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions = options;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress = contOverview;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithOptions(datasets,options,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
        var overOptions = new Object();
        if (options["lines"] != null){ 
            overOptions["lines"] = options["lines"];
        }
        if (options["points"] != null){ 
            overOptions["points"] = options["points"];
        }
        if (options["bars"] != null){ 
            overOptions["bars"] = options["bars"];
        }
        var xaxis = new Object();
        xaxis["ticks"] = 4;
        overOptions["xaxis"] = xaxis;
        var yaxis = new Object();
        yaxis["ticks"] = 4;
        overOptions["yaxis"] = yaxis;
        var selection = new Object();
        selection["mode"] = "xy";
        overOptions["selection"] = selection;
        var tooltip = new Object();
        tooltip["show"] = false;
        overOptions["tooltip"] = tooltip;
        var legend = new Object();
        legend["show"] = false;
        overOptions["legend"] = legend;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview = $wnd.drawOverviewWithOptions(datasets, overOptions, contOverview);
        $wnd.bindPlotWithOverview(options, datasets, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress, contOverview);
    }-*/;
    
    
    /**
     * <p>Draws plot with options and overview with options</p>
     * 
     * @param datasets
     * @param options: plot options
     * @param overOptions: overview options
     * @param contOverview: id overview container
     */
    public native void drawWithOptionsAndOverviewWithOptions(JavaScriptObject datasets, JavaScriptObject options, JavaScriptObject overOptions, String contOverview) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType = 6;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions = options;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewOptions = overOptions;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress = contOverview;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.drawPlotWithOptions(datasets,options,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview = $wnd.drawOverviewWithOptions(datasets, overOptions, contOverview);
        $wnd.bindPlotWithOverview(options, datasets, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview, this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress, contOverview);
    }-*/;
    
    
    /*public native void reDraw()*/ /*-{ 
        if (this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType != null){
            switch (this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawType){
                case 1: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithNoOptions(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
                    break;
                case 2: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithOptions(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
                    break;
                case 3: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithNoOptionsAndOverviewWithNoOptions(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress);
                    break;
                case 4: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithNoOptionsAndOverviewWithOptions(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress);
                    break;
                case 5: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithOptionsAndOverviewWithNoOptions(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress);
                    break;
                case 6: this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::drawWithOptionsAndOverviewWithOptions(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overviewAddress);
                    break;
            }
        }
    }-*///;
    
    
    /**
     * <p>Clear the selection area</p>
     * 
     */
    public native void clearSelection() /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.clearSelection();
    }-*/;
    
    
    /**
     * <p>Sets the selction area</p>
     * 
     */
    public native void setSelection(JavaScriptObject area) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.setSelection(area);
    }-*/;
    
    
    /**
     * <p>Gets the canvas where the plot is drawn </p>
     * 
     */
    public native JavaScriptObject getCanvas() /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.getCanvas();
    }-*/;
    
    
    /**
     * <p>Gets the plot offset</p>
     * 
     */
    public native JavaScriptObject getPlotOffset() /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.getPlotOffset();
    }-*/;
    
    
    /**
     * <p>Set the datasets</p>
     *
     * @param datasets
     */
    public native void setData(JavaScriptObject datasets) /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset = datasets;
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.setData(datasets);
    }-*/;
    
    
    /**
     * <p>Gets the datasets plotted</p>
     * 
     */
    public native JavaScriptObject getDataSet() /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.getData();
    }-*/;
    
    
    /**
     * <p>Resets the grid options</p>
     * 
     */
    public native void setupGrid() /*-{ 
        this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot.setupGrid();
    }-*/;
    
    
    /**
     * <p>Resets the plot</p>
     * 
     */
    public native void reset() /*-{ 
     this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot = $wnd.reset(this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plot,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::dataset,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::plotOptions,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::overview,this.@com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter::containerAddress);
    }-*/;
    
}

