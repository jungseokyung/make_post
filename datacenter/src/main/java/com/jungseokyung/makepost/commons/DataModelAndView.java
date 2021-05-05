package com.jungseokyung.makepost.commons;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

public class DataModelAndView extends ModelAndView {
	public DataModelAndView() {
	}

	public DataModelAndView(String viewName) {
		super(viewName);
		checkViewName(viewName);
	}

	public DataModelAndView(String viewName, Map<String, ?> model) {
		super(viewName, model);
		checkViewName(viewName);
	}
	
	public DataModelAndView(View view) {
		super(view);
	}

	public DataModelAndView(String viewName, String modelName, Object modelData) {
		super(viewName, modelName, modelData);
		checkViewName(viewName);
	}

	public void setViewName(String viewName) {
		super.setViewName(viewName);
		checkViewName(viewName);
	}

	private void checkViewName(String viewName) {
		if ("jsonView".equals(viewName))
			super.setView((View) ApplicationContextManager.getInstance().getBean(MappingJacksonJsonView.class));
		else if ("xmlView".equals(viewName))
			super.setView((View) ApplicationContextManager.getInstance().getBean(MarshallingView.class));
	}
}