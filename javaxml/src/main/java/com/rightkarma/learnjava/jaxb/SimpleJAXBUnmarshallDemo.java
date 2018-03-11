package com.rightkarma.learnjava.jaxb;

import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class SimpleJAXBUnmarshallDemo {

    public static void main(String[] args) {
        SimpleJAXBUnmarshallDemo simpleJAXBMarshalDemo = new SimpleJAXBUnmarshallDemo();
        simpleJAXBMarshalDemo.demo();
    }
    public void demo(){

        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Department.class);

            // LearningNote - Using JAXB first
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<Department> rootElement = unmarshaller.unmarshal(new StreamSource(new File("javaxml/src/main/resources/Department.xml")), Department.class);
            Department xml = rootElement.getValue();
            System.out.println(xml.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

/**
 * LearningNote
 *
 OUTPUT
 Department{name='Maths', description='Gradulate level Mathematics', employees=[Employee{id=1, name='John'}, Employee{id=1, name='David'}]}

 */