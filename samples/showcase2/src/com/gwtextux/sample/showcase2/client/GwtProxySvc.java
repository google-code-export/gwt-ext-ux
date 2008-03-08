package com.gwtextux.sample.showcase2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtextux.sample.showcase2.client.grid.GWTProxySample.MyData;

public interface GwtProxySvc extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static GwtProxySvcAsync instance;
		public static GwtProxySvcAsync getInstance(){
			if (instance == null) {
				instance = (GwtProxySvcAsync) GWT.create(GwtProxySvc.class);
				ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "GwtProxySvc");
			}
			return instance;
		}
	}
	
    MyData gimmeData(int start, int limit, String sort, String dir);
}
