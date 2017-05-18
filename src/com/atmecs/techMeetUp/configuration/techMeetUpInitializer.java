package com.atmecs.techMeetUp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class techMeetUpInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{techMeetUpConfiguration.class,ApplicationConfiguration.class};
	}

	
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	
	protected String[] getServletMappings() {
		
		return new String[]{"/"};
	}

}
