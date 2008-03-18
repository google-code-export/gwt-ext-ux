package com.gwtextux.sample.showcase2.client;

import com.gwtextux.sample.showcase2.client.grid.GWTProxySample.MyData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GwtProxySvcAsync {
	void gimmeData(int start, int limit, String sort, String dir, String[][] params, AsyncCallback callback);
}
