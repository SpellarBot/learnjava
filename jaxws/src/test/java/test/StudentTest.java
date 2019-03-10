package test;

import com.rightkarma.learnjava.webservices.jaxws.model.Student;
import com.rightkarma.learnjava.webservices.jaxws.model.StudentImpl;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleService;
import com.rightkarma.learnjava.webservices.jaxws.services.SampleServiceImpl;
import org.apache.cxf.common.util.StringUtils;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import java.util.Map;

import static org.junit.Assert.assertEquals;

// LearningNote - use this class for testing branch 1, where cxf is configured without web.xml or in other words without WebApplicationInitializer
// Server is started using Server class
public class StudentTest {

    private Service service;
    private SampleService sampleServiceProxy;
    private SampleServiceImpl sampleServiceImpl;

    private static QName SERVICE_NAME= new QName("http://jaxws.learnjava.rightkarma.com/", "SampleService");
    private static QName PORT_NAME= new QName("http://jaxws.learnjava.rightkarma.com/", "SampleServicePort");

    {
        service = Service.create(SERVICE_NAME);
        String endpointAddress = "http://localhost:8097/sampleservice";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
    }

    @Before
    public void reinstantiate() {
        sampleServiceImpl = new SampleServiceImpl();
        sampleServiceProxy = service.getPort(PORT_NAME, SampleService.class);
    }

    /*@Test
    public void test1() {
        String endpointResponse = sampleServiceProxy.hello("Ravi W");
        String localResponse = sampleServiceImpl.hello("Ravi D");
        assertEquals(localResponse.split(" ")[1], endpointResponse.split(" ")[1]);
    }

    @Test
    public void test2() {
        Student student1 = new StudentImpl("Adam");
        sampleServiceProxy.registerStudent(student1);

        Student student2 = new StudentImpl("Eve");
        sampleServiceProxy.registerStudent(student2);

        Map<Integer, Student> students = sampleServiceProxy.getStudents();
        assertEquals("Adam", students.get(1).getName());
        assertEquals("Eve", students.get(2).getName());
    }*/
}