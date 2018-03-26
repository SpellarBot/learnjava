package com.rightkarma.learnjava.webservices.jaxws;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * LearningNote
 * The WebApplicationInitializer interface is implemented to programmatically configure the ServletContext interface for the application.
 * When present on the classpath, its onStartup method is automatically invoked by the servlet container and
 * thereafter the ServletContext is instantiated and initialized.
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        //  LearningNote - Spring application context is created and configured to register a class containing configuration metadata:
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ServiceConfiguration.class); // ServiceConfiguration is the class with spring beans . @Configuration
        container.addListener(new ContextLoaderListener(context));


        // LearningNote - The CXFServlet class, which is defined by Apache CXF, is generated and registered to handle incoming requests:
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new CXFServlet());
        // LearningNote - the CXF servlet is mapped to a relative URL
        dispatcher.addMapping("/services");
        /**
         * LearningNote - dispatcher and mapping are requivalent to following..
         *
         <servlet>
         <servlet-name>cxf</servlet-name>
         <servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
         <load-on-startup>1</load-on-startup>
         </servlet>
         <servlet-mapping>
         <servlet-name>cxf</servlet-name>
         <url-pattern>/services/*</url-pattern>
         </servlet-mapping>
         */
    }
}