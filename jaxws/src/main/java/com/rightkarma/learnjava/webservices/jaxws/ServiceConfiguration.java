package com.rightkarma.learnjava.webservices.jaxws;

import com.rightkarma.learnjava.webservices.jaxws.services.SampleService;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class ServiceConfiguration {
    // Bean definitions

    // LearningNote - SpringBus – which supplies extensions for Apache CXF to work with the Spring Framework:
    @Bean
    public SpringBus springBus() {
        return new SpringBus();
    }

    // LearningNote - EnpointImpl bean also needs to be created using the SpringBus bean and a web service implementor.
    // This bean is used to publish the endpoint at the given HTTP address

    /**
     * LearningNote - equivalent xml
     <jaxws:endpoint
     id="sampleservice"
     implementor="com.rightkarma.learnjava.webservices.jaxws.services.SampleService"
     address="http://localhost:8080/services/sampleservice" />

     Access on browser - http://localhost:8097/services/sampleservice?wsdl

     */
    @Bean
    public Endpoint endpoint() {
        SampleService implementor = new SampleServiceImpl();
        String address = "http://localhost:8097/services/sampleservice";
        Endpoint endpoint = Endpoint.publish(address, implementor);
        return endpoint;
    }

}