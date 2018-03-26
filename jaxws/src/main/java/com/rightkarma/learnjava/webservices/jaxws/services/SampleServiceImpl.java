package com.rightkarma.learnjava.webservices.jaxws.services;

import com.rightkarma.learnjava.webservices.jaxws.model.Student;

import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.Map;

@WebService(endpointInterface = "com.rightkarma.learnjava.webservices.jaxws.services.SampleService")
public class SampleServiceImpl implements SampleService {
    private Map<Integer, Student> students
            = new LinkedHashMap<Integer, Student>();

    public String hello(String name) {
        System.out.println("SampleServiceImpl.hello called with ."+name);
        return "Hello " + name;
    }

    public String registerStudent(Student student) {
        students.put(students.size() + 1, student);
        return "Hello " + student.getName();
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }
}