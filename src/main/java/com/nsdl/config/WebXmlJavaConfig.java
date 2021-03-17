package com.nsdl.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXmlJavaConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringConfig.class }; // springbean.xml --> beans-->
	}

	@Override
	protected String[] getServletMappings() { // url pattern.
		return new String[] { "/" }; // http://localhost:8082/spmvc --> url pattern
	}
}
