package com.gwtextux.sample.showcase2.client.grid;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtextux.client.widgets.flotPlotter.ClassFlotPlotter;
import com.gwtextux.client.widgets.flotPlotter.options.*;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class FlotPlotterSample extends ShowcasePanel{

	public String getSourceUrl() {
		return "source/grid/FlotPlotterSample.java.html";
    }
	
	static private ClassFlotPlotter plot = new ClassFlotPlotter();
	
    private static Object[][] getData(){
        Object[][] series = new Object[28][5];
        double val = 0.0;

        for (int i = 0; i < 28; i++){
            for (int j = 0; j < 5; j++){
                switch (j){
                    case 0:
                        series[i][j] = new Double(val);
                        break;
                    case 1:
                        series[i][j] = new Double(Math.sin(val));
                        break;
                    case 2:
                        series[i][j] = new Double(Math.cos(val));
                        break;
                    case 3:
                        series[i][j] = new Double(Math.sqrt(val * 10));
                        break;
                    case 4:
                        series[i][j] = new Double(Math.sqrt(val));
                        break;
                }
            }
            val = val + 0.5;
        }

        return series;
    }

	
	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
			panel.setPaddings(15);
			panel.setLayout(new VerticalLayout(15));
        }
		
		MemoryProxy proxy = new MemoryProxy(getData());
        final RecordDef recordDef = new RecordDef(
            new FieldDef[]{
                new FloatFieldDef("i"),
                new FloatFieldDef("sin(i)"),
                new FloatFieldDef("cos(i)"),
                new FloatFieldDef("sqrt(i * 10)"),
                new FloatFieldDef("sqrt(i)")
            }
        );

        ArrayReader reader = new ArrayReader(recordDef);
        final Store store = new Store(proxy,reader);
        store.load();
        
        ClassDataSet dataset = ClassDataSet.create();

        float[][] dati1 = new float[store.getTotalCount()][2];
        float[][] dati2 = new float[store.getTotalCount()][2];
        float[][] dati3 = new float[store.getTotalCount()][2];
        float[][] dati4 = new float[store.getTotalCount()][2];
        for (int j = 1; j < recordDef.getFields().length; j++){
            for (int i = 0; i < store.getTotalCount(); i++){
                switch (j){
                    case 1:
                        dati1[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                        dati1[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                        break;
                    case 2:
                        dati2[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                        dati2[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                        break;
                    case 3:
                        dati3[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                        dati3[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                        break;
                    case 4:
                        dati4[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                        dati4[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                        break;
                }
            }
        }
        
        float[][] dati = new float[4][2];
        dati[0][0] = 0;
        dati[0][1] = 3;
        dati[1][0] = 4;
        dati[1][1] = 8;
        dati[2][0] = 8;
        dati[2][1] = 5;
        dati[3][0] = 9;
        dati[3][1] = 13;
        
        //Creates and fills the datasets
        ClassRowData rowData = ClassRowData.create();
        ClassRowData rowData1 = ClassRowData.create();
        ClassRowData rowData2 = ClassRowData.create();
        ClassRowData rowData3 = ClassRowData.create();
        ClassRowData rowData4 = ClassRowData.create();
        
        rowData.fillRowDataFromArray(dati);
        rowData1.fillRowDataFromArray(dati1);
        rowData2.fillRowDataFromArray(dati2);
        rowData3.fillRowDataFromArray(dati3);
        rowData4.fillRowDataFromArray(dati4);
        
        ClassSeries series1 = ClassSeries.create();
        ClassSeries series2 = ClassSeries.create();
        ClassSeries series3 = ClassSeries.create();
        ClassSeries series4 = ClassSeries.create();
        ClassSeries series5 = ClassSeries.create();
        
        series1.setRowData(rowData1);
        series2.setRowData(rowData2);
        series3.setRowData(rowData3);
        series4.setRowData(rowData4);
        series5.setRowData(rowData);
        
        //Sets the data series labels
        series1.setLabel(recordDef.getFields()[1].getName());
        series2.setLabel(recordDef.getFields()[2].getName());
        series3.setLabel(recordDef.getFields()[3].getName());
        series4.setLabel(recordDef.getFields()[4].getName());
        series5.setLabel("random values");
        
        //Sets the area plot
        OptionLines lines1 = OptionLines.create();
        lines1.setShow(true);
        lines1.setFill(true);
        OptionPoints points1 = OptionPoints.create();
        points1.setShow(false);
        series1.setLines(lines1);
        series1.setPoints(points1);
        
        //Sets the scatter plot
        OptionPoints points2 = OptionPoints.create();
        points2.setShow(true);
        OptionLines lines2 = OptionLines.create();
        lines2.setShow(false);
        series2.setLines(lines2);
        series2.setPoints(points2);
        
        //Sets the line plot
        OptionPoints points3 = OptionPoints.create();
        points3.setShow(false);
        OptionLines lines3 = OptionLines.create();
        lines3.setShow(true);
        series3.setLines(lines3);
        series3.setPoints(points3);
        
        
        //Sets the line plot with visible points
        OptionPoints points4 = OptionPoints.create();
        points4.setShow(true);
        OptionLines lines4 = OptionLines.create();
        lines4.setShow(true);
        series4.setLines(lines4);
        series4.setPoints(points4);
        
        //Sets the bar plot
        OptionPoints points5 = OptionPoints.create();
        points5.setShow(false);
        OptionLines lines5 = OptionLines.create();
        lines5.setShow(false);
        OptionBars bars = OptionBars.create();
        bars.setShow(true);
        series5.setLines(lines5);
        series5.setPoints(points5);
        series5.setBars(bars);
        
        dataset.addSeries(series1);
        dataset.addSeries(series5);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        
        //Sets the plot options
        OptionTooltip tooltip = OptionTooltip.create();
        tooltip.setShow(true);
        OptionLegend legend = OptionLegend.create();
        legend.setShow(true);
        ClassOptions options = ClassOptions.create();
        OptionSelection selection = OptionSelection.create();
        selection.setMode("xy");
        options.setTooltip(tooltip);
        options.setLegend(legend);
        options.setSelection(selection);
        //Draws the plots
        plot.drawWithOptionsAndOverviewWithNoOptions(dataset, options, "#overview");//;.drawWithOptions(dataset, options);

        ColumnConfig columnConfig = new ColumnConfig("I", "i", 100, true);
        NumberField columnField = new NumberField();
        columnField.setAllowDecimals(true);
        columnField.setSelectOnFocus(true);
        columnConfig.setEditor(new GridEditor(columnField));
            
        NumberField sinField = new NumberField();  
        sinField.setSelectOnFocus(true);
        ColumnConfig sinConfig = new ColumnConfig("Sin(i)", "sin(i)", 130, true);  
        sinConfig.setEditor(new GridEditor(sinField));   

        NumberField cosField = new NumberField();  
        cosField.setSelectOnFocus(true);  
        ColumnConfig cosConfig = new ColumnConfig("Cos(i)", "cos(i)", 130, true);  
        cosConfig.setEditor(new GridEditor(cosField));    

        NumberField sqrt1Field = new NumberField();  
        sqrt1Field.setSelectOnFocus(true);
        ColumnConfig sqrt1Config = new ColumnConfig("Sqrt(i * 10)", "sqrt(i * 10)", 130, true);  
        sqrt1Config.setEditor(new GridEditor(sqrt1Field)); 
        
        NumberField sqrt2Field = new NumberField();  
        sqrt2Field.setSelectOnFocus(true);
        ColumnConfig sqrt2Config = new ColumnConfig("Sqrt(i)", "sqrt(i)", 130, true);  
        sqrt2Config.setEditor(new GridEditor(sqrt2Field));  

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{  
                columnConfig,  
                sinConfig,  
                cosConfig,  
                sqrt1Config,
                sqrt2Config
        });  

        EditorGridPanel grid = new EditorGridPanel();  
        grid.setStore(store);  
        grid.setClicksToEdit(1);  
        grid.setColumnModel(columnModel);  
        grid.setWidth(500);  

        grid.addEditorGridListener(new EditorGridListenerAdapter() {  
            public void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex) {  
                store.commitChanges();
                ClassDataSet newDataset = ClassDataSet.create();
                float[][] dati1 = new float[store.getTotalCount()][2];
                float[][] dati2 = new float[store.getTotalCount()][2];
                float[][] dati3 = new float[store.getTotalCount()][2];
                float[][] dati4 = new float[store.getTotalCount()][2];
                for (int j = 1; j < recordDef.getFields().length; j++){
                    for (int i = 0; i < store.getTotalCount(); i++){
                        switch (j){
                            case 1:
                                dati1[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                                dati1[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                                break;
                            case 2:
                                dati2[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                                dati2[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                                break;
                            case 3:
                                dati3[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                                dati3[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                                break;
                            case 4:
                                dati4[i][0] = store.getAt(i).getAsFloat(recordDef.getFields()[0].getName());
                                dati4[i][1] = store.getAt(i).getAsFloat(recordDef.getFields()[j].getName());
                                break;
                        }
                    }
                }

                //var d2 = [[0, 3], [4, 8], [8, 5], [9, 13]];
                float[][] dati = new float[4][2];
                dati[0][0] = 0;
                dati[0][1] = 3;
                dati[1][0] = 4;
                dati[1][1] = 8;
                dati[2][0] = 8;
                dati[2][1] = 5;
                dati[3][0] = 9;
                dati[3][1] = 13;

                ClassRowData rowData = ClassRowData.create();
                ClassRowData rowData1 = ClassRowData.create();
                ClassRowData rowData2 = ClassRowData.create();
                ClassRowData rowData3 = ClassRowData.create();
                ClassRowData rowData4 = ClassRowData.create();

                rowData.fillRowDataFromArray(dati);
                rowData1.fillRowDataFromArray(dati1);
                rowData2.fillRowDataFromArray(dati2);
                rowData3.fillRowDataFromArray(dati3);
                rowData4.fillRowDataFromArray(dati4);

                ClassSeries series1 = ClassSeries.create();
                ClassSeries series2 = ClassSeries.create();
                ClassSeries series3 = ClassSeries.create();
                ClassSeries series4 = ClassSeries.create();
                ClassSeries series5 = ClassSeries.create();

                series1.setRowData(rowData1);
                series2.setRowData(rowData2);
                series3.setRowData(rowData3);
                series4.setRowData(rowData4);
                series5.setRowData(rowData);

                series1.setLabel(recordDef.getFields()[1].getName());
                series2.setLabel(recordDef.getFields()[2].getName());
                series3.setLabel(recordDef.getFields()[3].getName());
                series4.setLabel(recordDef.getFields()[4].getName());
                series5.setLabel("random values");

                OptionLines lines1 = OptionLines.create();
                lines1.setShow(true);
                lines1.setFill(true);
                OptionPoints points1 = OptionPoints.create();
                points1.setShow(false);
                series1.setLines(lines1);
                series1.setPoints(points1);

                OptionPoints points2 = OptionPoints.create();
                points2.setShow(true);
                OptionLines lines2 = OptionLines.create();
                lines2.setShow(false);
                series2.setLines(lines2);
                series2.setPoints(points2);

                OptionPoints points3 = OptionPoints.create();
                points3.setShow(false);
                OptionLines lines3 = OptionLines.create();
                lines3.setShow(true);
                series3.setLines(lines3);
                series3.setPoints(points3);


                OptionPoints points4 = OptionPoints.create();
                points4.setShow(true);
                OptionLines lines4 = OptionLines.create();
                lines4.setShow(true);
                series4.setLines(lines4);
                series4.setPoints(points4);

                OptionPoints points5 = OptionPoints.create();
                points5.setShow(false);
                OptionLines lines5 = OptionLines.create();
                lines5.setShow(false);
                OptionBars bars = OptionBars.create();
                bars.setShow(true);
                series5.setLines(lines5);
                series5.setPoints(points5);
                series5.setBars(bars);

                newDataset.addSeries(series1);
                newDataset.addSeries(series5);
                newDataset.addSeries(series2);
                newDataset.addSeries(series3);
                newDataset.addSeries(series4);

                plot.setData(newDataset);
                plot.reset();
            }  
        });  

        panel.add(grid);


        return panel;
    }
	
	public String getIntro() {
        return "This example demonstrates using FlotPlotter to draw different plot types with zoom and overview";
    }
}

