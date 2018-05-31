### Static methods as constructor

**Advantages:**  
* You can give proper names for different constructors
* Constructor with same set of parameters are possible as these will be two seperate static methods
* Unlike regular constructors, a new object does not need to be created everytime. static methods can return the same object everytime.  
An immutable class using static method as constructor can guarantee that no two instances of same class exist. So a==b will be true always. This means clients can use == instead of a.equals(b) which can improve performance.
* It is possible to return subtype of a class as object.  
excellent example - java.util.Collections that returns multiple subtypes. Object returned is referenced using the interface.

Service Provider Framework:  
* Service Interface - which providers implement
* Provider Registration API - which the system uses to register implementations
* Service access API - which clients use to obtain an instance of the service
* Service provider interface - which providers implement to create instances of their service interface

Example JDBC  
* _Connection_  - service interface
* _DriverManager.registerDriver_ - provider registration API
* _DriverManager.getConnection_ - service access API
* _Driver_ - service provider interface 

**DisAdvantages:**
* if you give only static constructors, and no public or default constructor, the class can't be sub-classed.
* static method constructors are not readily distuiguishable from other methods.

few factory methods one can implement:  
* valueof - returns an instance that has, loosely speaking, the same value as its parameters. 
* of - same as valueof
* getInstance - returns an instance that is described by the parameters but cannot be said to have the same value.
* newInstance - gaurantees new instance.
* getType - like getInstance but when factory method is in different class. 
* newType - like newInstance     

### Consider a builder when having multiple constructors

**telescoping constructor** pattern works but it is hard to write client code when there are many parameters, harder still to read it.
Example:
```
a(int a, String b)
a(int a, String b, String c)
a(int a, String b, String c, Long d)
```

**Java Bean pattern** - an alternative ?   
Create bean with default parameter less constructor and then set the properties.  
* Clean to read.
* Disadvantage is that bean could be in inconsistent state partway through its construction.  
* Class can't be made immutable. 
* Thread safety is a problem.

**Builder Pattern** - Best solution -
* Use a static class to build the object.
* Create builder.build method that can class private constructor of the class.
* setter return back the builder object 
 
### Enforce the singleton property with a private constructor or an Enum type.
Singleton:
* instantiated once only
* represents unique system component like windows manager, file system
* makes it difficult for clients to test ?

Approaches:
* SingletonUsingStatic - private constructor. public static field holds the reference.
* SingletonUsingStaticFactory - private constructor. private static field holds the reference, accessible via getInstance(). This is better becuase if you change the implementation to non-singleton, client would not know.
* SingletonUsingEnum - preferred approach.

### Enforce noninstantiability with a private Constructor
Make a class noninstantiable by putting a private constructor in it.  
This is typically done for Utility classes so that people don't instantiate them.

### Avoid creating unncessary objects.
Specific example of String class.  
Wrong:
```
    String s = new String("A");
``` 
Right:  
```
    String s = "A";
``` 

Boolean.valueOf(String) is better than Boolean(String) as latter produces new object.  

Find variables that can be instantiated once and then reused.  

Prefer primitives to boxing. and watch for unintentional boxing. Within loop, autoboxing can cost several seconds of processing time and have **negative impact on performance**.  

### 6 . Eliminate obsolete object references
Ref class - ObsoleteObjectsNotRemoved

### 7 . Avoid finalizers
* Never do anything time critical in finalizer (try-catch-finally) as you don't know when the code will execute.
* For example, depending upon finalizer to release a persistent lock on your database is a good way to bring your entire distributed system to a **grinding halt**.
* Uncaught exceptions - another major issue with finalizer. Uncaught exceptions are ignore and object finalization terminates. This can leave objects in corrupt state.
* Performance penalty - finalizers slow down the program.

**Solution ?**  
* provide explicit termination method.
* instance must keep track of whether it has been terminated. The explicit termination method must record in a private field that the object is no longer valid.
and other methods must check this field and throw _IllegalStateException_ if they are called after the object has been terminated.

Examples:  
* close method on InputStream, OutputStream, java.sql.Connection
* cancel method on java.util.Timer

Recommendation:  
* call terminate method in code and in finally block

### 8. Obey the general contract when overriding _equals_ method
* don't override when not needed.
    a) each instance is expected to be unique ( so default equals will compare ref )
    b) logically not required.
    c) superclass has provided equals implementation
    d) class is private or package-private
    e) singleton classes
    
    When to provide ?  
    
 