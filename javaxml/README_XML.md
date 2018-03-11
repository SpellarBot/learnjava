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
  