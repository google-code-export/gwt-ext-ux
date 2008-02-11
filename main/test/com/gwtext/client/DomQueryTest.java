/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.DomQuery;
import com.gwtext.client.core.DomQueryFunction;

//java -classpath gwt-user.jar com.google.gwt.junit.remote.BrowserManagerServer WinIE6 "C:\Program Files\Internet Explorer\IEXPLORE.EXE"
//-Dgwt.args="-remoteweb rmi://localhost/WinIE6"  for remote

public class DomQueryTest extends GWTTestCase {

    public String getModuleName() {
        return "com.gwtext.Test";
    }

    public void testSelect() {
        HTMLPanel html = new HTMLPanel(TEST_DATA);
        RootPanel.get().add(html);
        for (int i = 0; i < tests.length; i++) {
            String selector = tests[i][0];
            Element[] results = DomQuery.select(selector);
            int expectedCnt = Integer.parseInt(tests[i][1]);
            assertEquals("Selector : " + selector + " returned wrong count", expectedCnt, results.length);
        }
    }

    public void atestCompile() {
        HTMLPanel html = new HTMLPanel(TEST_DATA);
        RootPanel.get().add(html);
        for (int i = 7; i < 8; i++) {
            String selector = tests[i][0];
            DomQueryFunction fn = DomQuery.compile(selector);
            Element[] results = fn.query();
            int expectedCnt = Integer.parseInt(tests[i][1]);
            assertEquals("Selector : " + selector + " returned wrong count", expectedCnt, results.length);

        }
    }

    private String[][] tests = new String[][]{
            new String[]{"#test-data", "1"},
            new String[]{"#test-data span", "147"},
            new String[]{"#test-data pre code", "2"},
            new String[]{"#test-data pre > code", "2"},
            new String[]{"#test-data pre code span", "147"},
            new String[]{"#test-data pre > code > span", "147"},
            new String[]{"#test-data span.hl-code", "46"},
            new String[]{"#test-data span.hl-code, #test-data span.hl-brackets", "61"}, //not working
            new String[]{"#test-data pre.highlighted > code", "2"},
            new String[]{"#test-data span:first-child", "2"},
            new String[]{"#test-data span:last-child", "2"},
            new String[]{"#test-data span:nth-child(odd)", "74"},
            new String[]{"#test-data span:nth-child(even)", "73"},
            new String[]{"#test-data span:nth-child(10)", "2"},
            new String[]{"#test-data span:empty", "0"},
            new String[]{"#test-data span:contains(new)", "2"},
            new String[]{"#test-data span:not(span.hl-code)", "101"},
            new String[]{"#test-data span.hl-default:not(:first-child)", "13"},
            new String[]{"#test-data span:first", "1"}, //not working
            new String[]{"#test-data span:last", "1"}, //not working
            new String[]{"#test-data span[title=east]", "4"},
            new String[]{"#test-data span[title=east]", "4"},
            new String[]{"#test-data span[title!=east]", "143"},
            new String[]{"#test-data span[title^=min]", "2"},
            new String[]{"#test-data span[title$=er]", "2"},
            new String[]{"#test-data span[title*=in]", "2"},
            new String[]{"#test-data/pre/code/span", "147"},
            new String[]{"#test-data/pre[class=highlighted]/code", "2"}
    };

    public static String TEST_DATA = "<div id=\"test-data\" >\n" +
            "\t<div>The tests run against these two code blocks from <a href=\"http://www.jackslocum.com/blog/\">my blog</a>. I chose these because they are loaded with elements to test against. Scroll down to see what the markup looks like.</div><br />\n" +
            "\tpre.highlighted &gt; code 1:<br/>\n" +
            "\t<pre class=\"highlighted\"><code><span class=\"hl-reserved\">var </span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\"> = </span><span class=\"hl-reserved\">new </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">ext</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">LayoutDialog</span><span class=\"hl-brackets\">(</span><span class=\"hl-identifier\">config</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">id</span><span class=\"hl-code\"> || </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">util</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">Dom</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">generateId</span><span class=\"hl-brackets\">()</span><span class=\"hl-code\">, </span><span class=\"hl-brackets\">{\n" +
            "\t</span><span title=\"autoCreate\" class=\"hl-identifier\">autoCreate</span><span class=\"hl-code\"> : </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"minWidth\" class=\"hl-identifier\">minWidth</span><span class=\"hl-code\">:</span><span class=\"hl-number\">400</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"minHeight\" class=\"hl-identifier\">minHeight</span><span class=\"hl-code\">:</span><span class=\"hl-number\">300</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"syncHeightBeforeShow\" class=\"hl-identifier\">syncHeightBeforeShow</span><span class=\"hl-code\">: </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"shadow\" class=\"hl-identifier\">shadow</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"fixedcenter\" class=\"hl-identifier\">fixedcenter</span><span class=\"hl-code\">: </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"center\" class=\"hl-identifier\">center</span><span class=\"hl-code\">:</span><span class=\"hl-brackets\">{</span><span class=\"hl-identifier\">autoScroll</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">false</span><span class=\"hl-brackets\">}</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"east\"  class=\"hl-identifier\">east</span><span class=\"hl-code\">:</span><span class=\"hl-brackets\">{</span><span class=\"hl-identifier\">split</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">initialSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">150</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">minSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">150</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">maxSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">250</span><span class=\"hl-brackets\">}\n" +
            "})</span><span class=\"hl-default\">;\n" +
            "\n" +
            "</span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">setTitle</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">Choose an Image</span><span class=\"hl-quotes\">'</span><span class=\"hl-brackets\">)</span><span class=\"hl-default\">;\n" +
            "</span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">getEl</span><span class=\"hl-brackets\">()</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">addClass</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">ychooser-dlg</span><span class=\"hl-quotes\">'</span><span class=\"hl-brackets\">)</span><span class=\"hl-default\">;</span></code></pre><br />\n" +
            "\n" +
            "pre.highlighted &gt; code 2:<br/>\n" +
            "<pre class=\"highlighted\"><code><span class=\"hl-reserved\">var </span><span class=\"hl-identifier\">animated</span><span class=\"hl-default\"> = </span><span class=\"hl-reserved\">new </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">ext</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">Resizable</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">animated</span><span class=\"hl-quotes\">'</span><span class=\"hl-code\">, </span><span class=\"hl-brackets\">{\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">width</span><span class=\"hl-code\">: </span><span class=\"hl-number\">200</span><span class=\"hl-code\">\n" +
            "\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">height</span><span class=\"hl-code\">: </span><span class=\"hl-number\">100</span><span class=\"hl-code\">\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">minWidth</span><span class=\"hl-code\">:</span><span class=\"hl-number\">100</span><span class=\"hl-code\">\n" +
            "    </span><span class=\"hl-identifier\">minHeight</span><span class=\"hl-code\">:</span><span class=\"hl-number\">50</span><span class=\"hl-code\">\n" +
            "    </span><span class=\"hl-identifier\">animate</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">easing</span><span class=\"hl-code\">: </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">util</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">Easing</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">backIn</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">duration</span><span class=\"hl-code\">:</span><span class=\"hl-number\">.6\n" +
            "\n" +
            "</span><span class=\"hl-brackets\">})</span><span class=\"hl-default\">;</span></code></pre>\n" +
            "\n" +
            "<hr noshade/>\n" +
            "\t<xmp><pre class=\"highlighted\"><code><span class=\"hl-reserved\">var </span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\"> = </span><span class=\"hl-reserved\">new </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">ext</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">LayoutDialog</span><span class=\"hl-brackets\">(</span><span class=\"hl-identifier\">config</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">id</span><span class=\"hl-code\"> || </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">util</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">Dom</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">generateId</span><span class=\"hl-brackets\">()</span><span class=\"hl-code\">, </span><span class=\"hl-brackets\">{\n" +
            "\t</span><span title=\"autoCreate\" class=\"hl-identifier\">autoCreate</span><span class=\"hl-code\"> : </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"minWidth\" class=\"hl-identifier\">minWidth</span><span class=\"hl-code\">:</span><span class=\"hl-number\">400</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"minHeight\" class=\"hl-identifier\">minHeight</span><span class=\"hl-code\">:</span><span class=\"hl-number\">300</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"syncHeightBeforeShow\" class=\"hl-identifier\">syncHeightBeforeShow</span><span class=\"hl-code\">: </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"shadow\" class=\"hl-identifier\">shadow</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"fixedcenter\" class=\"hl-identifier\">fixedcenter</span><span class=\"hl-code\">: </span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"center\" class=\"hl-identifier\">center</span><span class=\"hl-code\">:</span><span class=\"hl-brackets\">{</span><span class=\"hl-identifier\">autoScroll</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">false</span><span class=\"hl-brackets\">}</span><span class=\"hl-code\">,\n" +
            "\t</span><span title=\"east\"  class=\"hl-identifier\">east</span><span class=\"hl-code\">:</span><span class=\"hl-brackets\">{</span><span class=\"hl-identifier\">split</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">initialSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">150</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">minSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">150</span><span class=\"hl-code\">,</span><span class=\"hl-identifier\">maxSize</span><span class=\"hl-code\">:</span><span class=\"hl-number\">250</span><span class=\"hl-brackets\">}\n" +
            "})</span><span class=\"hl-default\">;\n" +
            "</span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">setTitle</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">Choose an Image</span><span class=\"hl-quotes\">'</span><span class=\"hl-brackets\">)</span><span class=\"hl-default\">;\n" +
            "</span><span class=\"hl-identifier\">dlg</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">getEl</span><span class=\"hl-brackets\">()</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">addClass</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">ychooser-dlg</span><span class=\"hl-quotes\">'</span><span class=\"hl-brackets\">)</span><span class=\"hl-default\">;</span></code></pre><br />\n" +
            "<pre class=\"highlighted\"><code><span class=\"hl-reserved\">var </span><span class=\"hl-identifier\">animated</span><span class=\"hl-default\"> = </span><span class=\"hl-reserved\">new </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">ext</span><span class=\"hl-default\">.</span><span class=\"hl-identifier\">Resizable</span><span class=\"hl-brackets\">(</span><span class=\"hl-quotes\">'</span><span class=\"hl-string\">animated</span><span class=\"hl-quotes\">'</span><span class=\"hl-code\">, </span><span class=\"hl-brackets\">{\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">width</span><span class=\"hl-code\">: </span><span class=\"hl-number\">200</span><span class=\"hl-code\">,\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">height</span><span class=\"hl-code\">: </span><span class=\"hl-number\">100</span><span class=\"hl-code\">,\n" +
            "    </span><span title=\"east\" class=\"hl-identifier\">minWidth</span><span class=\"hl-code\">:</span><span class=\"hl-number\">100</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">minHeight</span><span class=\"hl-code\">:</span><span class=\"hl-number\">50</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">animate</span><span class=\"hl-code\">:</span><span class=\"hl-reserved\">true</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">easing</span><span class=\"hl-code\">: </span><span class=\"hl-identifier\">YAHOO</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">util</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">Easing</span><span class=\"hl-code\">.</span><span class=\"hl-identifier\">backIn</span><span class=\"hl-code\">,\n" +
            "    </span><span class=\"hl-identifier\">duration</span><span class=\"hl-code\">:</span><span class=\"hl-number\">.6\n" +
            "</span><span class=\"hl-brackets\">})</span><span class=\"hl-default\">;</span></code></pre></xmp>\n" +
            "\t</div>";
}
