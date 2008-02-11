/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtextux.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.layout.ContainerLayout;

/**
 * <p>Layout that distributes heights of elements so they take 100% of the
 * container height.</p>
 * <p>Height of the child element can be given in pixels (as an integer) or
 * in percent. All elements with absolute height (i.e. in pixels) always will
 * have the given height. All "free" space (that is not filled with elements
 * with 'absolute' height) will be distributed among other elements in
 * proportion of their height percentage. Elements without 'height' in the
 * config will take equal portions of the "unallocated" height.</p>
 * <p>Supports panel collapsing, hiding, removal/addition. </p>
 * <p>Example usage:</p>
 * <pre><code>
 *
 * Panel panel = new Panel();
 * panel.setLayout(new RowLayout());
 *
 * Panel first = new Panel();
 * first.setTitle("Height in pixels");
 * first.setHtml("panel height = 100px");
 * panel.add(first, new RowLayoutData(100);
 *
 * Panel second = new Panel();
 * second.setTitle("1/2");
 * second.setHtml("Will take half of remaining height");
 * panel.add(second, new RowLayoutData("50%"));
 *
 * Panel third = new Panel();
 * third.setTitle("No height 1");
 * third.setHtml("Panel without given height");
 * panel.add(third);
 *
 * Panel fourth = new Panel();
 * fourth.setTitle("No height 2");
 * fourth.setHtml("Another Panel");
 * panel.add(fourth);
 *
 * Viewport viewport = new Viewport(panel);
 *
 * </code></pre>
 *
 */
public class RowLayout extends ContainerLayout {

    static {
        init();
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.ux.layout.RowFitLayout(config);
    }-*/;

    //author Kirill Hryapin "kx" -- http://extjs.com/forum/showthread.php?t=17116
    private static native void init()/*-{
$wnd.Ext.namespace('Ext.ux.layout');



$wnd.Ext.ux.layout.RowFitLayout = $wnd.Ext.extend($wnd.Ext.layout.ContainerLayout, {
  // private
  monitorResize: true,

  // private
  trackChildEvents: ['collapse', 'expand', 'hide', 'show'],

  // private
  renderAll: function(ct, target) {
    $wnd.Ext.ux.layout.RowFitLayout.superclass.renderAll.apply(this, arguments);
    // add event listeners on addition/removal of children
    ct.on('add', this.containerListener);
    ct.on('remove', this.containerListener);
  },

  // private
  renderItem: function(c, position, target) {
    $wnd.Ext.ux.layout.RowFitLayout.superclass.renderItem.apply(this, arguments);

    // add event listeners
    for (var i=0, n = this.trackChildEvents.length; i < n; i++) {
      c.on(this.trackChildEvents[i], this.itemListener);
    }
    c.animCollapse = false; // looks ugly together with row-fit layout

    // store some layout-specific calculations
    c.rowFit = {
      hasAbsHeight: false, // whether the component has absolute height (in pixels)
      relHeight: 0, // relative height, in pixels (if applicable)
      calcRelHeight: 0, // calculated relative height (used when element is resized)
      calcAbsHeight: 0 // calculated absolute height
    };

    // process height config option
    if (c.height) {
      // store relative (given in percent) height
       if ((typeof c.height == "string") && ( c.height.indexOf("%") >= 0)) {      
        c.rowFit.relHeight = parseInt(c.height);
      }
      else { // set absolute height
        var cheight;
        if (typeof c.height == "string") {
            cheight = parseInt(c.height);
        }
        else {
            cheight = c.height;
        }
        c.setHeight(cheight);
        c.rowFit.hasAbsHeight = true;
      }
    }
  },

  // private
  onLayout: function(ct, target) {
    $wnd.Ext.ux.layout.RowFitLayout.superclass.onLayout.call(this, ct, target);

    if (this.container.collapsed || !ct.items || !ct.items.length) { return; }

    // first loop: determine how many elements with relative height are there,
    // sums of absolute and relative heights etc.
    var absHeightSum = 0, // sum of elements' absolute heights
        relHeightSum = 0, // sum of all percent heights given in children configs
        relHeightRatio = 1, // "scale" ratio used in case sum <> 100%
        relHeightElements = [], // array of elements with 'relative' height for the second loop
        noHeightCount = 0; // number of elements with no height given

	// Set width for all items.
    var w = target.getViewSize().width - target.getPadding('lr');
	for (var i=0, n = ct.items.length; i < n; i++) {
      var c = ct.items.itemAt(i);

      if (!c.isVisible()) { continue; }

	 //patch from jay prasad	
	  c.setWidth(w);

	  // collapsed panel is treated as an element with absolute height
      if (c.collapsed) { absHeightSum += c.getFrameHeight(); }
      // element that has an absolute height
      else if (c.rowFit.hasAbsHeight) {
        absHeightSum += c.height;
      }
      // 'relative-heighted'
      else {
        if (!c.rowFit.relHeight) { noHeightCount++; } // element with no height given
        else { relHeightSum += c.rowFit.relHeight; }
        relHeightElements.push(c);
      }
    }

    // if sum of relative heights <> 100% (e.g. error in config or consequence
    // of collapsing/removing panels), scale 'em so it becomes 100%
    if (noHeightCount == 0 && relHeightSum != 100) {
      relHeightRatio = 100 / relHeightSum;
    }

    var freeHeight = target.getStyleSize().height - absHeightSum, // "unallocated" height we have
        absHeightLeft = freeHeight; // track how much free space we have

    while (relHeightElements.length) {
      var c = relHeightElements.shift(), // element we're working with
          relH = c.rowFit.relHeight * relHeightRatio, // height of this element in percent
          absH = 0; // height in pixels

      // no height in config
      if (!relH) {
        relH = (100 - relHeightSum) / noHeightCount;
      }

      // last element takes all remaining space
      if (!relHeightElements.length) { absH = absHeightLeft; }
      else { absH = Math.round(freeHeight * relH / 100); }

      // anyway, height can't be negative
      if (absH < 0) { absH = 0; }

      c.rowFit.calcAbsHeight = absH;
      c.rowFit.calcRelHeight = relH;

      c.setHeight(absH);
      absHeightLeft -= absH;
    }
  },

  itemListener: function(item) {
    item.ownerCt.doLayout();
  },


  containerListener: function(ct) {
    ct.doLayout();
  }

});

// Split adapter
if ($wnd.Ext.SplitBar.BasicLayoutAdapter) {
  $wnd.Ext.ux.layout.RowFitLayout.SplitAdapter = function(splitbar) {
    if (splitbar && splitbar.el.dom.nextSibling) {
      var next = $wnd.Ext.getCmp( splitbar.el.dom.nextSibling.id ),
          resized = $wnd.Ext.getCmp(splitbar.resizingEl.id);

      if (next) {
        splitbar.maxSize = (resized.height || resized.rowFit.calcAbsHeight) +
                           next.getInnerHeight() - 1; // seems can't set height=0 in IE, "1" works fine
      }
      splitbar.minSize = resized.getFrameHeight() + 1;
    }
  }

  $wnd.Ext.extend($wnd.Ext.ux.layout.RowFitLayout.SplitAdapter, $wnd.Ext.SplitBar.BasicLayoutAdapter, {

    setElementSize: function(splitbar, newSize, onComplete) {
      var resized = $wnd.Ext.getCmp(splitbar.resizingEl.id);

      // can't resize absent, collapsed or hidden panel
      if (!resized || resized.collapsed || !resized.isVisible()) return;

      // resizingEl has absolute height: just change it
      if (resized.rowFit.hasAbsHeight) {
        resized.setHeight(newSize);
      }
      // resizingEl has relative height: affects next sibling
      else {
        if (splitbar.el.dom.nextSibling) {
          var nextSibling = $wnd.Ext.getCmp( splitbar.el.dom.nextSibling.id ),
              deltaAbsHeight = newSize - resized.rowFit.calcAbsHeight, // pixels
              nsRf = nextSibling.rowFit, // shortcut
              rzRf = resized.rowFit,
              // pixels in a percent
              pctPxRatio = rzRf.calcRelHeight / rzRf.calcAbsHeight,
              deltaRelHeight = pctPxRatio * deltaAbsHeight; // change in height in percent

          rzRf.relHeight = rzRf.calcRelHeight + deltaRelHeight;

          if (nsRf.hasAbsHeight) {
            var newHeight = nextSibling.height - deltaAbsHeight;
            nextSibling.height = newHeight;
            nextSibling.setHeight(newHeight);
          }
          else {
            nsRf.relHeight = nsRf.calcRelHeight - deltaRelHeight;
          }
        }
      }
      // recalculate heights
      resized.ownerCt.doLayout();
    } // of setElementSize

  }); // of SplitAdapter
}

$wnd.Ext.Container.LAYOUTS['row-fit'] = $wnd.Ext.ux.layout.RowFitLayout;
    }-*/;
}
