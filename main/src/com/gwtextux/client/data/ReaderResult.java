package com.gwtextux.client.data;

import com.gwtext.client.data.Record;

/**
 * Convenience class to wrap the result of parsing data fetched by a proxy.
 * @see CustomReader
 * 
 * @author Abhijeet Maharana 
 *
 */
public class ReaderResult {
	public final boolean success;
	public final Record[] records;
	
	public ReaderResult(boolean success, Record[] records) {
		this.success = success;
		this.records = records;
	}
}
