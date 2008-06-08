package com.gwtextux.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Reader;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A reader that integrates with the store API and allows user to parse arbitrary format data
 * when the stock readers are not sufficient. Works with proxies that fetch remote data like HttpProxy.
 * <p/>
 * Sample usage:
 * <pre>
 * <code>
 * // parses comma separated values and creates records out of them
 * // sample input: <a href="http://download.finance.yahoo.com/d/quotes.csv?s=INFY+XOM+BBDb.TO+JNJ+MSFT+GOOG+YHOO&f=nd1l1">http://download.finance.yahoo.com/d/quotes.csv?s=INFY+XOM+BBDb.TO+JNJ+MSFT+GOOG+YHOO&f=nd1l1</a>
 *
 * RecordDef recordDef = new RecordDef(  
 *      new FieldDef[]{  
 *      	new StringFieldDef("name"),
 *      	new StringFieldDef("lasttrdate"),
 *      	new StringFieldDef("lasttrval")
 *      }
 * );  
 *
 * CustomReader c = new CustomReader(recordDef){
 * 	public ReaderResult handleRemoteResponse(RemoteResponse remoteResponse) {
 *       		String csvalue = remoteResponse.getResponseText();
 *       		String[] lines = csvalue.split("\n");
 *      		Record[] records = new Record[lines.length];
 *       		
 *      		for(int i=0; i&lt;lines.length; ++i)
 *      		{
 *      			String[] columns = lines[i]. replace('\"', ' ').split(",");
 *      			records[i] = this.recordDef.createRecord(columns);
 *      		}
 *       		
 *      		return new ReaderResult(true, records);
 * 	}
 * };
 *    
 * // redirect is a utility servlet which fetches content from given url and passes it to the client 
 * String url = "http://download.finance.yahoo.com/d/quotes.csv?s=INFY+XOM+BBDb.TO+JNJ+MSFT+GOOG+YHOO&f=nd1l1";
 * DataProxy proxy = new HttpProxy("redirect?url=" + url);
 *       
 * Store store = new Store(proxy, c);
 * </code>
 * </pre>
 * 
 * @author Abhijeet Maharana
 */
public abstract class CustomReader extends Reader {

	static {
		init();
	}

	public CustomReader(RecordDef recordDef) {
		setRecordDef(recordDef);
	}
	
	private static native void init()/*-{
        $wnd.Ext.namespace("Ext.ux");
        $wnd.Ext.namespace("Ext.ux.data");
	        
	    $wnd.Ext.ux.data.CustomReader = function(meta, recordType, readerInstance) {
	      	meta = meta || {};
	       	this.readerInstance = readerInstance;
	        $wnd.Ext.ux.data.CustomReader.superclass.constructor.call(this);
	    };
	        
	    $wnd.Ext.extend($wnd.Ext.ux.data.CustomReader, $wnd.Ext.data.DataReader, {
	      	read : function(response){
	       		return this.readerInstance.@com.gwtextux.client.data.CustomReader::read(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
	       	},
	        	
	       	readRecords : function(o){
				alert('Custom reader does not work with local data.');
	       	}
	    });
	}-*/;
	
	protected JavaScriptObject read(JavaScriptObject response) {
		ReaderResult r = handleRemoteResponse(new RemoteResponse(response));
		JavaScriptObject o = JavaScriptObjectHelper.createObject();
		
		JavaScriptObjectHelper.setAttribute(o, "success", r.success);
		
		JavaScriptObject[] jsRecords = new JavaScriptObject[r.records.length];
		for(int i =0; i<r.records.length;i++)
			jsRecords[i] = r.records[i].getJsObj();
			
		JavaScriptObjectHelper.setAttribute(o, "records", JavaScriptObjectHelper.convertToJavaScriptArray(jsRecords));
		JavaScriptObjectHelper.setAttribute(o, "totalRecords", r.records.length);
		
		return o;
	}

	/**
	 * Provide your custom parsing logic here.  
	 * @param remoteResponse remote result fetched by proxy 
	 * @return status and records
	 */
	public abstract ReaderResult handleRemoteResponse(RemoteResponse remoteResponse);
	
	protected native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef)/*-{
		return new $wnd.Ext.ux.data.CustomReader(config, recordDef, this);
	}-*/;
}
