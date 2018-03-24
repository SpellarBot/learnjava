@XmlSchemaType(type= Date.class, name="date") // LearningNote - this will remove time part from xml, as we are saying this is just date, not timestamp
package com.rightkarma.learnjava.jaxb.annotation;


import javax.xml.bind.annotation.XmlSchemaType;
import java.util.Date;