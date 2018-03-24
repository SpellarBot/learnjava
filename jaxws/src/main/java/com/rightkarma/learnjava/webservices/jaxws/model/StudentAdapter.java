package com.rightkarma.learnjava.webservices.jaxws.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * LearningNote
 * An adaptation class must implement the XmlAdapter interface and provide implementation for the marshal and unmarshal methods.
 * The marshal method transforms a bound type (Student, an interface that JAXB cannot directly handle) into a value type (StudentImpl,
 * a concrete class that can be processed by JAXB). The unmarshal method does things the other way around.
 */
public class StudentAdapter extends XmlAdapter<StudentImpl, Student> {

    public StudentImpl marshal(Student student) throws Exception {
        if (student instanceof StudentImpl) {
            return (StudentImpl) student;
        }
        return new StudentImpl(student.getName());
    }

    public Student unmarshal(StudentImpl student) throws Exception {
        return student;
    }
}