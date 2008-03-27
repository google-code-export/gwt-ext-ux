/**
 * 
 */
package com.gwtextux.sample.showcase2.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveGridDataProxy extends HttpServlet {
    
    private static class ObjArrayComparator implements Comparator {
        private int col;
        private int dir;

        ObjArrayComparator(int col, int dir) {
            this.col = col;
            this.dir=dir;
        }

        public int compare(Object o1, Object o2) {
            Object[] a1 = (Object[]) o1;
            Object[] a2 = (Object[]) o2;
            return dir*((Comparable) a1[col]).compareTo(a2[col]);
        }
    }
    
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

    static Object[][] data;
    
    static Map sorted_data=new HashMap();
    
    static{
        /**
         * let's generate data with structure similar to the sql table
         CREATE TABLE IF NOT EXISTS `livegrid` (
              `id` int(10) unsigned NOT NULL auto_increment,
              `number_field` int(10) unsigned NOT NULL,
              `string_field` varchar(255) NOT NULL,
              `date_field` datetime NOT NULL,
              PRIMARY KEY  (`id`)
            ) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5001 ;
         */
        Object[][] data = new Object[15000][4];
        Random r = new Random(137);
        long max = new GregorianCalendar(2010, 12, 12).getTimeInMillis();
        for (int i = 0; i < data.length; i++) {
            data[i][0] = Integer.valueOf(i + 1);
            data[i][1] = Integer.valueOf(i);
            data[i][3] = new Date(Math.round(r.nextDouble() * max));
        }
        int i = 0;
        for (int j = 0; j < 26; j++)
            data[i++][2] = "" + ((char) (j + 'A'));
        for (int j = 0; j < 26; j++)
            for (int k = 0; k < 26; k++)
                data[i++][2] = ("" + ((char) (j + 'A'))) + ((char) (k + 'A'));
        for (int j = 0; j < 26 && i < data.length; j++)
            for (int k = 0; k < 26 && i < data.length; k++)
                for (int l = 0; l < 26 && i < data.length; l++)
                    data[i++][2] = ("" + ((char) (j + 'A'))) + ((char) (k + 'A')) + ((char) (l + 'A'));

        LiveGridDataProxy.data=(Object[][])data.clone();
        // presort the data by all fields
        Arrays.sort(data, new ObjArrayComparator(1,1));
        sorted_data.put("+number_field", data.clone());
        Arrays.sort(data, new ObjArrayComparator(2,1));
        sorted_data.put("+string_field", data.clone());
        Arrays.sort(data, new ObjArrayComparator(3,1));
        sorted_data.put("+date_field", data.clone());

        Arrays.sort(data, new ObjArrayComparator(1,-1));
        sorted_data.put("-number_field", data.clone());
        Arrays.sort(data, new ObjArrayComparator(2,-1));
        sorted_data.put("-string_field", data.clone());
        Arrays.sort(data, new ObjArrayComparator(3,-1));
        sorted_data.put("-date_field", data.clone());        
    }
    
    public LiveGridDataProxy() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String dir = "ASC".equals(req.getParameter("dir")) ? "+" : "-";
            String sort = req.getParameter("sort");
            String start_param = req.getParameter("start");
            int start = start_param == null ? 0 : Integer.parseInt(start_param);
            String limit_param = req.getParameter("limit");
            int limit = limit_param == null ? 100 : Integer.parseInt(limit_param);

            int total_count = data.length;
            limit = Math.min(limit, total_count - start);
            
            Object[][] data=LiveGridDataProxy.data;
            if (sorted_data.containsKey(dir+sort))
                data = (Object[][]) sorted_data.get(dir+sort);
            
            List items = new ArrayList();
            for (int i = start; i < start + limit; i++) {
                Object[] o = data[i];
                JSONObject item=new JSONObject();
                item.put("id", o[0].toString());
                item.put("number_field", o[1].toString());
                item.put("string_field", o[2]);
                Date value = (Date) o[3];
                item.put("date_field", df.format(value));
                items.add(item);
            }
            
            JSONObject feeds = new JSONObject();
            JSONObject response = new JSONObject();
            JSONObject value=new JSONObject();
            feeds.put("response", response);
            response.put("value", value);
            value.put("items", new JSONArray(items));
            value.put("total_count", Integer.toString(total_count));
            value.put("version", new Long(1)); 
            
            resp.setContentType("application/json; charset=utf-8");
            Writer w = new OutputStreamWriter(resp.getOutputStream(), "utf-8");
            w.write(feeds.toString());
            w.close();
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (JSONException e) {
            throw new IOException("Shouldn't happed");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handleRequest(req, resp);
    }

}
