package com.gwtextux.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.DataProxy;
import com.gwtext.client.util.JavaScriptObjectHelper;

public abstract class GWTProxy extends DataProxy{
    
    public GWTProxy(){
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        var o=new $wnd.Ext.ux.data.GWTProxy();
        o.gwtmem=this;
        return o;
    }-*/;
    
    private static native void init()/*-{
        $wnd.Ext.namespace("Ext.ux");
        $wnd.Ext.namespace("Ext.ux.data");
        $wnd.Ext.ux.data.GWTProxy = function(){
            $wnd.Ext.ux.data.GWTProxy.superclass.constructor.call(this);
        };        
        
        $wnd.Ext.extend($wnd.Ext.ux.data.GWTProxy, $wnd.Ext.data.DataProxy, {
            load : function(params, reader, callback, scope, arg){
                    var  o = {
                        params : params || {},
                        request: {
                            callback : callback,
                            scope : scope,
                            arg : arg
                        },
                        reader: reader,
                        callback : this.loadResponse,
                        scope: this
                    }; 
                    this.gwtmem.@com.gwtextux.client.data.GWTProxy::load(IILjava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)
                    (params.start==undefined?-1:params.start, params.limit==undefined?-1:params.limit,params.sort==undefined?null:params.sort,params.dir==undefined?null:params.dir,o);   
            },
            loadResponse : function(o, success, totalRecords, response){
                if(!success){
                    this.fireEvent("loadexception", this, o, response);
                    o.request.callback.call(o.request.scope, null, o.request.arg, false);
                    return;
                }
                var result;
                try {
                    result = o.reader.readRecords(response);
                    result.totalRecords=totalRecords;
                }catch(e){
                    this.fireEvent("loadexception", this, o, response, e);
                    o.request.callback.call(o.request.scope, null, o.request.arg, false);
                    return;
                }
                this.fireEvent("load", this, o, o.request.arg);
                o.request.callback.call(o.request.scope, result, o.request.arg, true);
            }
        });
        
    }-*/;
    
    public abstract void load(int start, int limit, String sort, String dir, final JavaScriptObject o);
    
    protected void loadResponse(JavaScriptObject o, boolean success, int totalRecords, String[][] data){
        loadResponse(o, true, totalRecords,  JavaScriptObjectHelper.convertToJavaScriptArray(data));        
    }
    
    protected native void loadResponse(JavaScriptObject o, boolean success, int totalRecords, JavaScriptObject response)/*-{
        var m = this.@com.gwtext.client.core.JsObject::getJsObj()();
        m.loadResponse(o, success, totalRecords, response);
     }-*/;
     
    static{
        init();
    }
}
