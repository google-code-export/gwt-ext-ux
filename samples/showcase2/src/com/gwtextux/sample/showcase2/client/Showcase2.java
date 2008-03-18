/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */

package com.gwtextux.sample.showcase2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelListenerAdapter;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.client.widgets.tree.TreePanel;


public class Showcase2 implements EntryPoint, HistoryListener {

    private static PopupPanel messagePanel = new PopupPanel(true);
    private TabPanel centerPanel;
    private ScreenManager screenManager;
    private Menu menu;

    public void onModuleLoad() {

        //create the main panel and assign it a BorderLayout
        Panel mainPanel = new Panel();
        mainPanel.setLayout(new BorderLayout());

        BorderLayoutData northLayoutData = new BorderLayoutData(RegionPosition.NORTH);
        northLayoutData.setSplit(false);

        BorderLayoutData centerLayoutData = new BorderLayoutData(RegionPosition.CENTER);
        centerLayoutData.setMargins(new Margins(5, 0, 5, 5));

        Panel centerPanelWrappper = new Panel();
        centerPanelWrappper.setLayout(new FitLayout());
        centerPanelWrappper.setBorder(false);
        centerPanelWrappper.setBodyBorder(false);

        centerPanel = new TabPanel();
        centerPanel.setBodyBorder(false);
        centerPanel.setEnableTabScroll(true);
        centerPanel.setAutoScroll(true);
        centerPanel.setAutoDestroy(false);
        centerPanel.setActiveTab(0);

        //hide the panel when the tab is closed
        centerPanel.addListener(new TabPanelListenerAdapter() {
            public boolean doBeforeTabChange(TabPanel source, Panel newPanel, Panel oldPanel) {
                WindowMgr.hideAll();
                return true;
            }

            public void onRemove(Container self, Component component) {
                component.hide();
            }

            public void onContextMenu(TabPanel source, Panel tab, EventObject e) {
                showMenu(tab, e);
            }
        });

        centerPanel.setLayoutOnTabChange(true);
        centerPanel.setTitle("Main Content");

        screenManager = new ScreenManager(centerPanel);

        //setup the west regions layout properties
        BorderLayoutData westLayoutData = new BorderLayoutData(RegionPosition.WEST);
        westLayoutData.setMargins(new Margins(5, 5, 0, 5));
        westLayoutData.setCMargins(new Margins(5, 5, 5, 5));
        westLayoutData.setMinSize(155);
        westLayoutData.setMaxSize(350);
        westLayoutData.setSplit(true);

        //create the west panel and add it to the main panel applying the west region layout properties
        Panel westPanel = createWestPanel();
        mainPanel.add(westPanel, westLayoutData);

        final Panel introPanel = new Panel();
        introPanel.setTitle("GWT-Ext UX Showcase");
        introPanel.setPaddings(10);
        introPanel.setLayout(new FitLayout());
        final ShowcaseView showcaseView = new ShowcaseView(screenManager);
        introPanel.add(showcaseView);

        centerPanel.add(introPanel, centerLayoutData);
        centerPanelWrappper.add(centerPanel);
        mainPanel.add(centerPanelWrappper, centerLayoutData);

        final String initToken = History.getToken();
        if (initToken.length() != 0) {
            mainPanel.addListener(new PanelListenerAdapter() {
                public void onRender(Component component) {
                    onHistoryChanged(initToken);
                }
            });
        }

        Viewport viewport = new Viewport(mainPanel);

        // Add history listener
        History.addHistoryListener(this);
    }

    private Panel createWestPanel() {
        Panel westPanel = new Panel();
        westPanel.setId("side-nav");
        westPanel.setTitle("Showcase Explorer");
        westPanel.setLayout(new FitLayout());
        westPanel.setWidth(210);
        westPanel.setCollapsible(true);

        Toolbar toolbar = new Toolbar();
        toolbar.addFill();
        toolbar.addItem(new ToolbarTextItem("Select Theme "));
        toolbar.addSpacer();
        toolbar.addField(new ThemeChanger());
        westPanel.setTopToolbar(toolbar);
        
        TabPanel tabPanel = new TabPanel();
        tabPanel.setActiveTab(0);
        tabPanel.setDeferredRender(true);
        tabPanel.setTabPosition(Position.BOTTOM);
        TreePanel treePanel = screenManager.getTreeNav();

        tabPanel.add(treePanel);
        tabPanel.add(screenManager.getAccordionNav());
        westPanel.add(tabPanel);

        return westPanel;
    }

    /**
     * This method is called whenever the application's history changes.
     *
     * @param historyToken the histrory token
     */
    public void onHistoryChanged(String historyToken) {
        screenManager.showScreen(historyToken);
    }

    private void showMenu(final Panel tab, EventObject e) {
        if (menu == null) {
            menu = new Menu();
            Item close = new Item("Close Tab");
            close.setId("close-tab-item");
            close.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    centerPanel.remove(centerPanel.getActiveTab());
                }
            });
            menu.addItem(close);

            Item closeOthers = new Item("Close Other Tabs");
            closeOthers.setId("close-others-item");
            closeOthers.addListener(new BaseItemListenerAdapter() {
                public void onClick(BaseItem item, EventObject e) {
                    Component[] items = centerPanel.getItems();
                    for (int i = 0; i < items.length; i++) {
                        Panel panel = (Panel) items[i];
                        if (panel.isClosable() && !panel.getId().equals(centerPanel.getActiveTab().getId())) {
                            centerPanel.remove(panel);
                        }
                    }
                }
            });
            menu.addItem(closeOthers);
        }

        BaseItem close = menu.getItem("close-tab-item");
        if (!centerPanel.getActiveTab().isClosable()) {
            close.disable();
        } else {
            close.enable();
        }

        BaseItem closeOthers = menu.getItem("close-others-item");
        if (centerPanel.getItems().length == 1) {
            closeOthers.disable();
        } else {
            closeOthers.enable();
        }
        menu.showAt(e.getXY());
    }

    public static void showMessage(String title, String message) {
        messagePanel.setPopupPosition(500, 300);
        messagePanel.setWidget(new HTML(getMessageHtml(title, message)));
        messagePanel.setWidth("300px");
        messagePanel.show();
    }

    private static native String getMessageHtml(String title, String message) /*-{
                                                          return ['<div class="msg">',
                                                                  '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
                                                                  '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', title, '</h3>', message, '</div></div></div>',
                                                                  '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>',
                                                                  '</div>'].join('');
                                                      }-*/;


}
