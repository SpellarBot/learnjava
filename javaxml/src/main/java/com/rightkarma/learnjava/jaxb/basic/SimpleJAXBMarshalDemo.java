package com.rightkarma.learnjava.jaxb.basic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

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
public class SimpleJAXBMarshalDemo {
    public static void main(String[] args) {
        SimpleJAXBMarshalDemo simpleJAXBMarshalDemo = new SimpleJAXBMarshalDemo();
        simpleJAXBMarshalDemo.demo();
    }
    public void demo(){
        Employee employee = new Employee(1, "John");
        Employee employee2 = new Employee(1, "David");
        Department department = new Department("Maths", "Gradulate level Mathematics");
        department.addEmployee(employee);
        department.addEmployee(employee2);
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Department.class);

            // LearningNote - Using JAXB first
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); // LearningNote - for easy reading by humans
            QName rootElementName= new QName(null, "department");
            JAXBElement<Department> rootElement =
                    new JAXBElement<>(rootElementName, Department.class, department);
            // marshal and output
            marshaller.marshal(rootElement, System.out);


            // LearningNote - Using StAX - write a part of xml
            Marshaller marshaller2 = jaxbContext.createMarshaller();
            marshaller2.setProperty(Marshaller.JAXB_FRAGMENT,true);// LearningNote - tell marshaller that only a part would be written
            marshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true); // LearningNote - for easy reading by humans
            XMLStreamWriter xmlStreamWriter= XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
            JAXBElement<Employee> rootElement2 =
                    new JAXBElement<>(rootElementName, Employee.class, employee);
            xmlStreamWriter.writeStartDocument("UTF-8","1.0");
            xmlStreamWriter.writeStartElement("department");
            marshaller2.marshal(rootElement2,xmlStreamWriter);
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}

/*OUTPUT
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<department>
    <description>Gradulate level Mathematics</description>
    <employees>
        <id>1</id>
        <name>John</name>
    </employees>
    <employees>
        <id>1</id>
        <name>David</name>
    </employees>
    <name>Maths</name>
</department>
<?xml version="1.0" encoding="UTF-8"?><department><department><id>1</id><name>John</name></department></department>

* */
