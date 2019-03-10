# NOTES
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

if you override equals, then you need to override hashCode, but reverse is not true.


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

## Chapter 4 - Classes and Interfaces

### Item 13. Minimize the accessibility of classes and members
* decouples client and implementation
* sub class method can't be more restrictive than super class method access modifier
* methods from interface are implicitly public
* **instance fields should never be public.**
    * if final for mutable object - no control
    * if non-final , no control on modification
    * if final for non-mutable, client can still access and difficult to remove the field in future.
    * Exception - Static fields. ( CAPITALIZED usually.)
    * Hide Array fields and don't put getters for it. if you do, use cloning or Collections.
        *
        ```
        private static final Thing[] PRIVATE_VALUES = { ... };
        public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
        ```
        OR
        ```
        private static final Thing[] PRIVATE_VALUES = { ... };
        public static final Thing[] values(){
            return PRIVATE_VALUES.clone();
        }
        ```

### Item 14 . In public classes, use accessor methods, not public fields
* use getters and setters.

### Item 15 . Minimize Mutability
An immutable class is simply a class whose instances can't be modified.  
Examples - String, BigDecimal, BigInteger

To make class Immutable, follow these five rules:
* Don't provide any methods that modify the object's state.
* Ensure that classes can't be extended.
    * make class final
* make all fields final
* make all fields private
* Ensure exclusive access to any mutable component
* Immutable objects are inherently thread safe
* Immutable classes don't and shouldn't implement clone

* **Disadvantage** - different objects for each different value.

Reference - Complex.class - See how it returns new objects without modifying the object itself.
This approach is known as _functional_ approach.

Other approaches:
* provide mutable companion class. For String, StringBuilder is provided.
* make constructor private and provide static factory for new instance

### Item 16 - Favor composition over inheritance
* Inheritance violates encapsulation.
* Forced to override multiple methods in subclass if methods call other class methods.
* Subclass with no override is safer but not risk free. if later version of parent class adds a method of same name and different return type, subclass will not compile.
* inheritance propagates flaws.

_forwarding_ - Method of new class calling method of contained class and return the results.

### Item 17 - Design and document for inheritance or else prohibit it
* a class may have to provide hooks into its internal workings in the form of judiciously chosen protected methods.
* The only way to test a class designed for inheritance is to write sub classes.
* Constructor should not call methods that are overridden
* Cloning, Serialization should not use overridden methods

**Problem** - It is common, but it is a problem that neither sub-classes are avoided, nor documentation done. 
Two ways to prohibit subclassing.

* make class **_final_**
* public static factory instead of contructor
* another safety feature - methods meant for overriding, don't use within that class.. That way overriding that method would not change behaviour of any other method.

### Item 18 - Prefer interfaces to abstract classes
* Class can extend only one class, but multiple interfaces
* easy to add interfaces to existing classes
* ideal for mixins . **mixin** is a type that a class can implement in addition to its primary type.

* easy to add new methods to abstract class

### Item 19 - use interfaces only to define types
* dont use for holding Constants.

 
### Item 20 - Prefer class hierarchies to tagged classes
Reference class - Figure. can be Circle or Rectangle  
Numerous shortcomings. difficult to read and maintain.  

Solution - use class hierarchy

### Item 21 - Use function objects to represent strategies
*** function pointers, lambdas etc were not part of java at the time of book writing..***

### Item 22 - Favor static member classes over nonstatic
applicable to _nested classes_.  
**4 kinds:**  
* static member ( think ordinary class in another class. can access private members. access like any other static member)
* nonstatic member
* anonymous 
* local
All but first are called _inner classes_.

* if you delcare a member class that does not require access to an enclosing instance, always put the static modifier in its declaration.

* Non static member class 
Usage - implemenations of Map interface typically use nonstatic member classes to implement their collection views whic are retunred by Maps keySet, entrySet and values methods.


* Anonymous class - 
    * it is not member of enclosing class
    * declared and instantiated together
    * can't have static members
    **USAGE:**
    * function objects like implementing sort on the fly 
    * process objects - runnable, thread
    * within static factory methods 
    
* Local classes -least used

## Chapter 5 - Generics

More things to understand

### Item 23 : Don't use raw types in new code.

Raw types

|Type | Example|
        |-----|--------|
     |Parametrized type | List\<String\> |
     |Actual Type parameter | String |
     |Generic Type | List\<E\> |
     |Formal Type Parameter | E |
     |Unbounded wildcard type | List\<?\> |
     |Raw type | List |
     |Bounded Type parameter| \<E extends Number\> |
     |Recursive Type bound | \<T extends Comparable\<T\>\> |
     |Bounded wildcard type| List\<? extends Number\> |
     |Generic method | static \<E\> List\<E\> asList(E[] a) |
     |Type Token | String.class |

### Item 24 : Eliminate unchecked warnings

