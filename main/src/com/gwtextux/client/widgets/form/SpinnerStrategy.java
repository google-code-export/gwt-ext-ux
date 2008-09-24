package com.gwtextux.client.widgets.form;

import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class SpinnerStrategy extends JsObject {

	protected SpinnerStrategy() {
		jsObj = create();
	}

	protected abstract JavaScriptObject create();

	public void setDefaultValue(int defaultValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultValue", defaultValue);
    }

	public void setDefaultValue(String defaultValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultValue", defaultValue);
    }

	public void setMinValue(int minValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

	public void setMinValue(String minValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

	public void setMaxValue(int maxValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

	public void setMaxValue(String maxValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

	public void setIncrementValue(int incrementValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "incrementValue", incrementValue);
    }

	public void setAlternateIncrementValue(int alternateIncrementValue)  {
        JavaScriptObjectHelper.setAttribute(jsObj, "alternateIncrementValue", alternateIncrementValue);
    }
}
