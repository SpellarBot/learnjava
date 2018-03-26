package test;

import com.rightkarma.learnjava.webservices.jaxws.model.Student;
import com.rightkarma.learnjava.webservices.jaxws.model.StudentImpl;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleService;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.util.Map;

import static org.junit.Assert.assertEquals;

// LearningNote - this class is for testing cxf v2 where WebApplicationInitializer is used instead of web.xml
public class StudentTestAnnotation {

    private ApplicationContext context
            = new AnnotationConfigApplicationContext(ClientConfiguration.class);
    private SampleService sampleServiceProxy= (SampleService) context.getBean("client");

    @Test
    public void whenUsingHelloMethod_thenCorrect() {
        String response = sampleServiceProxy.hello("John Doe");
        assertEquals("Hello John Doe!", response);
    }
}