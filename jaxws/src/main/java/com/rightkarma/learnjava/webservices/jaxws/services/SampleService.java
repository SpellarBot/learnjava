package com.rightkarma.learnjava.webservices.jaxws.services;

import com.rightkarma.learnjava.webservices.jaxws.model.Student;
import com.rightkarma.learnjava.webservices.jaxws.model.StudentMapAdapter;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@WebService
public interface SampleService {

    public String hello(String name);

    public String helloStudent(Student student);


    /**
     *
     * LearningNote
     * This is the service class that would return the object to web service call.
     * If the class returns map type, Jaxb does not know how to convert to regular Class or say create XML out of it.
     * So we have to specify adapter class that can convert this Map to a proper class.
     *
     * By default, Apache CXF uses JAXB as its data binding architecture.
     * However, since JAXB does not directly support binding of a Map, which is returned from the getStudents method,
     * we need an adapter to convert the Map to a Java class that JAXB can use.
     */
    @XmlJavaTypeAdapter(StudentMapAdapter.class)
    public Map<Integer, Student> getStudents();
}