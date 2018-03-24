**XML - Extensible Markup Language**  



**DOM - Document Object Model**  
in memory tree of nodes  
    nodes correspond to items in XML
    
package **org.w3c.dom**  
    Document, Element, Attr
    
_Issue:_ Easy to use but does not scale well to large documents as whole document is loaded in memory

**SAX - Simple API for XML**  
Use for large documents.  
Completely different from DOM.  
Does not load in memory, but event based.

package - **org.xml.sax**  
Implement ContentHandler  

_Issue:_ Cumbersome to work with

**STAX - Streaming API for XML**  
Event Based 

SAX - push based  
STAX - pull based. Application pulls  

package - **javax.xml.stream**  

interfaces - XMLStreamReader, XMLStreamWriter..

better than SAX but still cumbersome.

**JAXB - Java Architecture for XML Binding**  

Higher level API  
Less boiler plate  

XML Schema files.

Two models - 
1. Java -> XSD
2. XSD -> Java  

Code First.  
Schema First  

_Issues:_  

Less precise.   
Large Documents - SAX, STAX still might be better.

  
**XML SChema languages**  

DTD -  
issue - no name spaces and no data types

XSD  
Is an xml document  
Clearly defines XML  

Checkout - https://www.w3.org/2001/XMLSchema  

**JAXB API**

http://docs.oracle.com/javase/8/docs/api  
Entry point - JAXBContext, factory method - newInstance  
  

Java to XML - marshalling  
XML to Java - unmarshalling  

Binder, JAXBIntrospector

Best Practices  
Only one JAXBContext should be used . Thread safe  
Creation is expensive to only object.  

Marshaller, Unmarshaller - Not thread safe, don't reuse  

**How JAXB handles domain model classes**  
Very important to understand

Annotating a field:  
@XmlElement
private String name;

Annotating a property:
@XmlElement
private String getName(){ // }

Annotations:  
* @XmlRootElement - classes or enums 
* @XmlAccessorType - class or package. controls what jaxb considers for creating xml.   
* @XmlElement - put on fields
* @XmlTransient - to ignore fields for jaxb
* @XmlAttribute - these will go as attributes 


* @XmlAccessorOrder - limited use
* @XmlType - class or Enums. ordering of elements

* @XmlSchemaType - to map simple types to something else.
* @XmlValue - if your domain class actually represents simple type. Use exactly on one value. No other property should be part of xml. ( mark others as @XmlTransient to exclude them or mark them @XmlAttribute)   

* @XmlEnum . JaxB maps by default so not required. but useful if extra info needed like -  @XmlEnum(Integer.class)  
* @XmlEnumValue  

_XML Schema Domain Model_  

<xs:element>
<xs:attribute>
<xs:simpleType>
<xs:complexType>

Java       XML Schema  
Classes     <> Complex Types  
Fields      <> Complex Type elements  
Value Types <> Simple Types  



**XMLAdapter**   
refer the course if you need this. translate maps into proper tags in xml. creates a wrapper around map.  

**package-info.java** - what is this ? you can put Jaxb package options in this file.  

**How to generate Schema**  

Schemagen tool


```concept
E:\git\learnjava>schemagen -cp E:\git\learnjava\javaxml\out\production\classes -encoding UTF-8 com.rightkarma.learnjava.jaxb.annotation.Employee
```
  
Programatically  
- side question - Abset vs Nillable elements  

**Making elements Nil**  

Element not present in xml  
Element present but Empty  
Element set to "nul"  

Note - During marshalling, jaxb would leave element out of xml if null. but if you specify nillable = true
then jaxb would put an element will nil="true" .

During unmarshalling, depends what is specified in java class.
example:  
name = "TEST"   
    - if nil="true" in xml, it would mark name as null.  
    - if nil="true" NOT in xml, it would create the field with default value TEST.  


**Generating code from xsd**  

```concept
E:\git\learnjava\javaxml>xjc -d src\main\java -p com.rightkarma.learnjava.jaxb.xsdtojava  -encoding UTF-8 src\main\resources\DepartmentToRead.xsd
```

Command generated SomeClass as well as ObjectFactory class in the same package.  
