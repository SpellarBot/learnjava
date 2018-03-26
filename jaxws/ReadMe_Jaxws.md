### reference:
http://www.baeldung.com/introduction-to-apache-cxf
http://www.baeldung.com/apache-cxf-with-spring

Run the test class StudentTest .
It directly calls Java classes also the Server end point ( you need run Server.main first before running the test)  


### Classes to pay attention

XmlAdapter 

### Project explanation
This is a simple project showing CXF.  
A basic service SampleServiceImpl is created and annotated.  
When the service is called, it exposed 3 methods to the client.  
These methods further uses classes that can't be passed back in response and go on to show use of XmlAdapter class.  

A simple Test class is created to call the service. You need to start the Server.main before calling the test.  

