## Chapter 2 - Creating and Destroying Objects

### Item 1. Consider Static factory methods instead of constructors

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

### Item 2. Consider a builder when faced with many constructor parameters

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
 
### Item 3. Enforce the singleton property with a private constructor or an Enum type.
Singleton:
* instantiated once only
* represents unique system component like windows manager, file system
* makes it difficult for clients to test ?

Approaches:
* SingletonUsingStatic - private constructor. public static field holds the reference.
* SingletonUsingStaticFactory - private constructor. private static field holds the reference, accessible via getInstance(). This is better becuase if you change the implementation to non-singleton, client would not know.
* SingletonUsingEnum - preferred approach.

### Item 4. Enforce noninstantiability with a private Constructor
Make a class noninstantiable by putting a private constructor in it.  
This is typically done for Utility classes so that people don't instantiate them.

### Item 5. Avoid creating unncessary objects.
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

### Item 6 . Eliminate obsolete object references
Ref class - ObsoleteObjectsNotRemoved

## Chapter 3 - Methods common to All Objects

### Item 7 . Avoid finalizers
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

### Item 8. Obey the general contract when overriding _equals_ method
ref: equalscontract.main
* don't override when not needed.
    a) each instance is expected to be unique ( so default equals will compare ref )
    b) logically not required.
    c) superclass has provided equals implementation
    d) class is private or package-private
    e) singleton classes
    
    When to provide ?  
    * comparing pojo classes.
    // TODO 
    * look for Java SE _equals_ **contract** online.

**Contract:**  
* Reflexivity - object must be equal to itself
* Symmetry - any two objects must agree on whether they are equal. so if a.equals(b) is true then, b.equals(a) should also be true.
* Transitivity -  if a.equals(b) is true, and b.equals(c) is true, then a.equals(c) should be true.
* Consistency - if 2 objects are equal, they must remain equal all time unless one or both of them are modified.
* Non-nullity - all objects must be unequal to null. so thats why check for nulls in equals method ( actually we use instanceof check ) and throw false, else you run the risk of throwing NPE.
```
@Override
public boolean equals (Object o){
    if ( !( o instanceof MyType) ) // instanceof can manage null arg
        return false;
    MyType mt = (MyType) o; // cast for further comparisons
}
``` 


**Notes:**
There is no way to extend an instantiable class and add a value component while preserving the equals contract, unless you are willing to forgo the benefits of objects oriented abstraction.

**Other Caveats**
* always override hashcode along with equals.
* changing Object class in param means you are not Overriding equals. so this is fixed:
```
public boolean equals ( Object o ){
...
}
```

### Item 9 Always override _hashcode_ when you override _equals_

YOu have to do that to maintain the hashcode/equals contract.
* when invoked on same object, should generate same hashcode, unless object changes.
* as part of contract, if a.equals(b) is true, then both a and b should have same hashcode.
* 2 unequal objects may produce same hashcode.

### Item 10 Always override toString()
* Always write toString(). It helps in logging.
* document it well
* all variables in toString() should be available directly. Otherwise their is a risk that programmer might parse toString to get that information.


### Item 11 Override clone judiciously
`https://docs.oracle.com/javase/7/docs/api/java/lang/Cloneable.html`   
A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a field-for-field copy of instances of that class.
  
Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the exception CloneNotSupportedException being thrown. 

Issue - Java Object's clone method is protected. 
Solution - So people need to invoke clone by using reflection.
Risk - clone may not be accessible, so reflection may fail.

Absolute requirements:  
* `x.clone() != x`
* `x.clone().getClass() != x.getClass()`

x.clone.equals(x) is not an absolute requirement of cloning.

* it does not make immutable classes to support clone as objects created will be same as original.
* many cases, you may not provide clone, unless super class implements.
* Good approach - provide constructor to return clone
 
    ```
    public A ( A a ) {
    ...
    }
    ```
    
    OR static factory
    
    ```
    public static newA ( A a ) {
        ...
    }
    ```
### Item 12. COnsider implementing `Comparable`
* for Value classes
* Important for classes that will be used in Collections.

* rules - 
    * Reflexivity - a == b, then b == a 
    * Symmetry - a > b, then b < a
    * Transitivity - `x.compareTo(y) > 0 && y.compareTo(z) > 0 => x.compareTo(z) > 0` 

* If x.compareTo(y) should throw exception then y.compareTo(x) should throw exception. 

* **Strongly recommend** - 
    `x.compareTo(y)==0 => x.equalsTo(y)`

How to compare:  
* Use < and > 
* Double.compare
* Float.compare
* Compare most significant field first. Example PIN code in Address class.

## Chapter 4

### Item 13. Minimize the accessibility of classes and members
* decouples client and implementation
* sub class method can't be more restrictive than super class method access modifier
* methods from interface are implicitly public
* **instance fields should never be public.**
    * if final for mutable object - no control
    * if non-final , no control on modification
    
    * if final for non-mutable, client can still access and difficult to remove the field in future.
    