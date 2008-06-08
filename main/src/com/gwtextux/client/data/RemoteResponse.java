package com.gwtextux.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Wraps the response obtained by proxy from a remote datasource.
 * @see CustomReader
 * 
 * @author Abhijeet Maharana
 *
 */
public class RemoteResponse {

	JavaScriptObject response;
	
	public RemoteResponse(JavaScriptObject response) {
		this.response = response;
	}
	
	public String getResponseText() {
		return JavaScriptObjectHelper.getAttribute(response, "responseText");
	}
	
	public String getResponseXML() {
		return JavaScriptObjectHelper.getAttribute(response, "responseXML");
	}
}
