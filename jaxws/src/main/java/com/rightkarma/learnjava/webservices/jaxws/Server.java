package com.rightkarma.learnjava.webservices.jaxws;

import com.rightkarma.learnjava.webservices.jaxws.services.SampleService;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * LearningNote
 * to get a JaxWS service out, all it takes is a class ( SampleServiceImpl ). annotated @WebService
 *
 * How is CXF coming into picture , since there is no reference to CXF anywhere in the project files ?
 * we have added CXF jars (cxf-rt-frontend-jaxws) to the project and they are part of Class Path.
 * javax.xml.ws.spi.Provider inside the META-INF/services directory
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        SampleService implementor = new SampleServiceImpl();
        String address = "http://localhost:8097/sampleservice";
        // access wsdl at http://localhost:8097/sampleservice?wsdl
        Endpoint.publish(address, implementor);
        Thread.sleep(60 * 1000);
        System.exit(0);
    }
}
