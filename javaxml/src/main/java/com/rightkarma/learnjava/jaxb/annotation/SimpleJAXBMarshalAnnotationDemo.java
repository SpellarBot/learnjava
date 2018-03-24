package com.rightkarma.learnjava.jaxb.annotation;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * LearningNote
 * Create a class Employee and another class Department. These will be used to create xml.
 * NOTE - classes should have getter and setter methods.
 * NOTE - Unmarshaller would need constructor without properties
 * Create objects for Employee class
 * Standard steps for XML creation:
 * JAXBContext
 * Create Marshaller
 * set root element
 * print output.
 *
 * Also, look at StAX code to write only parts of xml.
 * This is required for large data files.
 *
 */
public class SimpleJAXBMarshalAnnotationDemo {
    public static void main(String[] args) {
        SimpleJAXBMarshalAnnotationDemo simpleJAXBMarshalAnnotationDemo = new SimpleJAXBMarshalAnnotationDemo();
        try {
            simpleJAXBMarshalAnnotationDemo.demo();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void demo() throws ParseException {
        Employee employee = new Employee(1, "John", new SimpleDateFormat("yyyy-MM-dd").parse("1998-02-02"));
        Employee employee2 = new Employee(1, "David", new SimpleDateFormat("yyyy-MM-dd").parse("1977-12-21"));
        Department department = new Department("Maths", "Gradulate level Mathematics");
        department.addEmployee(employee);
        department.addEmployee(employee2);
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Department.class);

            // LearningNote - Using JAXB first
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); // LearningNote - for easy reading by humans
            /*QName rootElementName= new QName(null, "department");
            JAXBElement<Department> rootElement =
                    new JAXBElement<>(rootElementName, Department.class, department);*/
            // marshal and output
            marshaller.marshal(department, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}

/*OUTPUT

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<department name="Maths" description="Gradulate level Mathematics">
    <elements>
        <employee>
            <dob>1998-02-02+05:30</dob>
            <id>1</id>
            <name>John</name>
        </employee>
        <employee>
            <dob>1977-12-21+05:30</dob>
            <id>1</id>
            <name>David</name>
        </employee>
    </elements>
</department>


* */
