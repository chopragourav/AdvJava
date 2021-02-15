package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.MarriageServlet;

public class WebApllicationInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		MarriageServlet servlet=new MarriageServlet();
		ServletRegistration.Dynamic dyn=sc.addServlet("ms", servlet);
		dyn.addMapping("/marriageurl");
		dyn.setLoadOnStartup(1);

	}

}
