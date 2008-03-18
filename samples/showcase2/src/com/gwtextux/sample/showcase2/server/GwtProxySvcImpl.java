package com.gwtextux.sample.showcase2.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwtextux.sample.showcase2.client.GwtProxySvc;
import com.gwtextux.sample.showcase2.client.grid.GWTProxySample.MyData;

public class GwtProxySvcImpl extends RemoteServiceServlet implements GwtProxySvc {

    public MyData gimmeData(int start, int limit, String sort, String dir, String[][] params) {
        for(int i=0;i<params.length;i++)
            System.out.println("Param key:"+params[i][0]+" value:"+params[i][1]);
        System.out.println();
        dir = "ASC".equals(dir) ? "+" : "-";
        int total_count = LiveGridDataProxy.data.length;
        start = Math.min(total_count - 1, start == -1 ? 0 : start);
        limit = Math.min(100, limit == -1 ? 100 : limit);
        limit = Math.min(limit, total_count - start);

        Object[][] data = LiveGridDataProxy.data;
        if (LiveGridDataProxy.sorted_data.containsKey(dir + sort))
            data = (Object[][]) LiveGridDataProxy.sorted_data.get(dir + sort);

        List items = new ArrayList();
        for (int i = start; i < start + limit; i++) {
            Object[] o = data[i];
            items.add(new String[]{o[1].toString(), (String) o[2], LiveGridDataProxy.df.format((Date) o[3])});
        }
        
        return new MyData(((String[][]) items.toArray(new String[0][])), total_count);
    }
}
