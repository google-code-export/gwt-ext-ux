package com.gwtextux.sample.showcase2.client.grid;

import com.gwtext.client.data.DataProxy;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtextux.client.data.CustomReader;
import com.gwtextux.client.data.ReaderResult;
import com.gwtextux.client.data.RemoteResponse;
import com.gwtextux.sample.showcase2.client.ShowcasePanel;

public class CustomReaderSample extends ShowcasePanel{

	public String getSourceUrl() {
		return "source/grid/CustomReaderSample.java.html";
    }
	
	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            
            GridPanel grid = createGridWithCustomReader();
            grid.setFrame(true);  
            grid.setStripeRows(true);  
            grid.setHeight(350);
            grid.setWidth(700);
            grid.setTitle("http://download.finance.yahoo.com/d/quotes.csv?s=INFY+XOM+BBDb.TO+JNJ+MSFT+GOOG+YHOO&f=nd1l1");
            grid.getView().setForceFit(true);
            grid.getView().setScrollOffset(0);
            panel.add(grid);
        }

        return panel;
    }
	
	private GridPanel createGridWithCustomReader()
	{
		GridPanel gridPanel = new GridPanel();
		
		RecordDef recordDef = new RecordDef(  
                new FieldDef[]{  
                        new StringFieldDef("name"),
                        new StringFieldDef("lasttrdate"),
                        new StringFieldDef("lasttrval")
                }
        );  

        CustomReader c = new CustomReader(recordDef){
       	 public ReaderResult handleRemoteResponse(
       			RemoteResponse remoteResponse) {
       		
       		 
       		String csvalue = remoteResponse.getResponseText();
       		
       		
       		
       		String[] lines = csvalue.split("\n");
       		Record[] records = new Record[lines.length];
       		
       		for(int i=0; i<lines.length; ++i)
       		{
       			String[] columns = lines[i]. replace('\"', ' ').split(",");
       			records[i] = this.recordDef.createRecord(columns);
       		}
       		
       		return new ReaderResult(true, records);
       	}
        };
        
        String url = "http://download.finance.yahoo.com/d/quotes.csv?s=INFY+XOM+BBDb.TO+JNJ+MSFT+GOOG+YHOO&f=nd1l1";
        DataProxy proxy = new HttpProxy("redirect?url=" + url);
        
        Store store = new Store(proxy, c);
        store.load();
        gridPanel.setStore(store);
        
        
        ColumnConfig[] columns = new ColumnConfig[]{  
                new ColumnConfig("Company", "name", 160, true, null, "name"),
                new ColumnConfig("Last Trade Date", "lasttrdate", 160),
                new ColumnConfig("Last Trade Value", "lasttrval", 160)
        };  

        ColumnModel columnModel = new ColumnModel(columns);  
        gridPanel.setColumnModel(columnModel);  

        return gridPanel;
    }
	
	public String getIntro() {
        return "This example demonstrates using CustomReader to populate a store with arbitrary format data.<br/><br/>" +
        	"This grid parses CSV format data from Yahoo finance. A utility servlet is used for fetching the CSV data from Yahoo.";
    }
}
