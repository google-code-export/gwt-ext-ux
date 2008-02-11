package com.gwtextux.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.data.Store;
import com.gwtext.client.core.SortDir;

public class ItemSelector extends Field {


	public ItemSelector() {
		setImagePath("js/msis");
	}

	public String getXType() {
		return "itemselector";
	}

	public native String getValue(String valueField) /*-{
        var field = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var val = field.getValue(valueField);
		return val === undefined || val == null ? null : val.toString();
	}-*/;



	//-- config options --
	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ux.ItemSelector(config);
    }-*/;

	public void setDataFields(String[] dataFields) throws IllegalArgumentException {
		setAttribute("dataFields", dataFields, true);
	}	

	public void setMsWidth(int msWidth) throws IllegalArgumentException {
		setAttribute("msWidth", msWidth, true);
	}

	public void setMsHeight(int msHeight) throws IllegalArgumentException {
		setAttribute("msHeight", msHeight, true);
	}

	public void setHideNavIcons(boolean hideNavIcons) throws IllegalArgumentException {
		setAttribute("hideNavIcons", hideNavIcons, true);
	}

	public void setImagePath(String imagePath) throws IllegalArgumentException {
		setAttribute("imagePath", imagePath, true);
	}

	public void setIconUp(String iconUp) throws IllegalArgumentException {
		setAttribute("iconUp", iconUp, true);
	}

	public void setIconDown(String iconDown) throws IllegalArgumentException {
		setAttribute("iconDown", iconDown, true);
	}

	public void setIconLeft(String iconLeft) throws IllegalArgumentException {
		setAttribute("iconLeft", iconLeft, true);
	}

	public void setIconRight(String iconRight) throws IllegalArgumentException {
		setAttribute("iconRight", iconRight, true);
	}

	public void setIconTop(String iconTop) throws IllegalArgumentException {
		setAttribute("iconTop", iconTop, true);
	}

	public void setIconBottom(String iconBottom) throws IllegalArgumentException {
		setAttribute("iconBottom", iconBottom, true);
	}

	public void setDrawUpIcon(boolean drawUpIcon) throws IllegalArgumentException {
		setAttribute("drawUpIcon", drawUpIcon, true);
	}

	public void setDrawDownIcon(String drawDownIcon) throws IllegalArgumentException {
		setAttribute("drawDownIcon", drawDownIcon, true);
	}

	public void setDrawLeftIcon(boolean drawLeftIcon) throws IllegalArgumentException {
		setAttribute("drawLeftIcon", drawLeftIcon, true);
	}

	public void setDrawRightIcon(boolean drawRightIcon) throws IllegalArgumentException {
		setAttribute("drawRightIcon", drawRightIcon, true);
	}

	public void setDrawTopIcon(boolean drawTopIcon) throws IllegalArgumentException {
		setAttribute("drawTopIcon", drawTopIcon, true);
	}

	public void setDrawBottomIcon(boolean drawBottomIcon) throws IllegalArgumentException {
		setAttribute("drawBotIcon", drawBottomIcon, true);
	}

	public void setFromStore(Store fromStore) throws IllegalArgumentException {
		setAttribute("fromStore", fromStore.getJsObj(), true);
	}

	public void setToStore(Store toStore) throws IllegalArgumentException {
		setAttribute("toStore", toStore.getJsObj(), true);
	}

	public void setFromData(Object[][] fromData) throws IllegalArgumentException {
		setAttribute("fromData", JavaScriptObjectHelper.convertToJavaScriptArray(fromData), true);
	}

	public void setToData(Object[][] toData) throws IllegalArgumentException {
		setAttribute("toData", JavaScriptObjectHelper.convertToJavaScriptArray(toData), true);
	}

	public void setDisplayField(int displayField) throws IllegalArgumentException {
		setAttribute("displayField", displayField, true);
	}

	public void setDisplayField(String displayField) throws IllegalArgumentException {
		setAttribute("displayField", displayField, true);
	}

	public void setValueField(int valueField) throws IllegalArgumentException {
		setAttribute("valueField", valueField, true);
	}
	
	public void setValueField(String valueField) throws IllegalArgumentException {
		setAttribute("valueField", valueField, true);
	}

	public void setSwitchToFrom(boolean switchToFrom) throws IllegalArgumentException {
		setAttribute("switchToFrom", switchToFrom, true);
	}

	public void setAllowDup(boolean allowDup) throws IllegalArgumentException {
		setAttribute("allowDup", allowDup, true);
	}

	public void setFocusClass(String focusClass) throws IllegalArgumentException {
		setAttribute("focusClass", focusClass, true);
	}

	public void setDelimiter(String delimiter) throws IllegalArgumentException {
		setAttribute("delimiter", delimiter, true);
	}

	public void setReadOnly(boolean readOnly) throws IllegalArgumentException {
		setAttribute("readOnly", readOnly, true);
	}

	public void setToLegend(String toLegend) throws IllegalArgumentException {
		setAttribute("toLegend", toLegend, true);
	}

	public void setFromLegend(String fromLegend) throws IllegalArgumentException {
		setAttribute("fromLegend", fromLegend, true);
	}

	public void setToSortField(String toSortField) throws IllegalArgumentException {
		setAttribute("toSortField", toSortField, true);
	}

	public void setFromSortField(String fromSortField) throws IllegalArgumentException {
		setAttribute("fromSortField", fromSortField, true);
	}

	public void setFromSortDir(SortDir fromSortDir) throws IllegalArgumentException {
		setAttribute("fromSortDir", fromSortDir.getDirection(), true);
	}

	public void setToSortDir(SortDir toSortDir) throws IllegalArgumentException {
		setAttribute("toSortDir", toSortDir.getDirection(), true);
	}

	public void setToToolbar(Toolbar toToolbar) throws IllegalArgumentException {
		setAttribute("toTBar", toToolbar.getOrCreateJsObj(), true);
	}

	public void setFromToolbar(Toolbar fromToolbar) throws IllegalArgumentException {
		setAttribute("fromTBar", fromToolbar.getOrCreateJsObj(), true);
	}

	public void setBodyStyle(String bodyStyle) throws IllegalArgumentException {
		setAttribute("bodyStyle", bodyStyle, true);
	}

	public void setBorder(boolean border) throws IllegalArgumentException {
		setAttribute("border", border, true);
	}
	
}