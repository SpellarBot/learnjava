# Object-oriented programming : 
From wiki -
Object-oriented programming (OOP) is a programming paradigm based on the concept of "objects", which may contain data, in the form of fields, often known as attributes; and code, in the form of procedures, often known as methods.
 
[link](https://www.google.co.in/url?sa=t&rct=j&q=&esrc=s&source=web&cd=3&cad=rja&uact=8&ved=0ahUKEwjTzfzQ-M_WAhXMMI8KHZVRBC0QFgg7MAI&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FObject-oriented_programming&usg=AOvVaw0U8UogMT5Cr_429wtLRNWa) 


#### Class 
A template that describes the kinds of state and behavior that objects of its type support.

#### Object 
At runtime, when the Java Virtual Machine (JVM) encounters the new keyword, it will use the appropriate class to make an object that is an instance of that class. That object will have its own state and access to all of the behaviors defined by its class.

#### Inheritance 
It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class. ... The subclass can add its own fields and methods in addition to the superclass fields and methods.

#### Polymorphism 
Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object. Any Java object that can pass more than one IS-A test is considered to be polymorphic.

#### Interface
An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface. Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types.

#### Cohesion
Cohesion is the OO principle most closely associated with making sure that a class is designed with a single, well-focused purpose. 
Aspire for high cohesion in class design.

#### Coupling 
Coupling refers to the degree to which one class knows about or uses members of another class.
Aspire for loose coupling in class design



# Java Basics

#### Identifiers i.e. variable, method names etc.
1. start with _ $ or letter. no limit on length 
2. cant' start with Number
3. can't use keywords
4. case sensitive

_Legal Identifiers_

```
	int _a;
	int $c;
	int ______2_w;
	int _$;
	int this_is_a_very_detailed_name_for_an_identifier; 
```

_Illegal Identifiers_

```
	int :b;
	int -d;
	int e#;
	int .f;
	int 7g; 
```

#### Complete List of Java Keywords 
|---|---|---|---|---|---|
|abstract |boolean |break |byte |case |catch|
|char |class |const |continue |default |do|
|double |else |extends |final |finally |float|
|for |goto |if |implements |import |instanceof|
|int |interface |long |native |new |package|
|private |protected |public |return |short |static|
|strictfp |super |switch |synchronized |this |throw|
|throws |transient |try |void |volatile |while|
|assert |enum|||||

#### JVM understands only this signature of main 
public static void main(String[] args)

#### static import of classes
Static import is a feature introduced in the Java programming language that allows members (fields and methods) which have been scoped within their container class as public static , to be used in Java code without specifying the class in which the field has been defined.

```java
import static java.lang.System.out; // 1 - note the static keyword
import static java.lang.Integer.*; // 2
public class TestStaticImport {
	public static void main(String[] args) {
		out.println(MAX_VALUE); // 3
		out.println(toHexString(42)); // 4
	}
}
```

#### * - for search
* `import java.util.*;` // ok to search the java.util package
* `import static java.lang.Integer.*; `// ok to search the java.lang.Integer class
* `import java.*; `// Legal, but this WILL NOT search across packages.

### Identifiers

* Access modifiers (public, protected, private, default or package-private)  
* Non-access modifiers (including strictfp, final, and abstract)
* private and protected are not common for classes but possible. See notes below.

[Oracle JavaOO](http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

* At the top levelpublic, or package-private (no explicit modifier).
* At the member levelpublic, private, protected, or package-private (no explicit modifier).

#### Access Modifiers

##### public 
* class : accessible from anywhere. Import statement might be required.
* member:  accessible from anywhere. 

##### default or package-private
* class : accessible only in that package. Not even in sub-packages.
* member: accessible only in that package. Not even in sub-packages.

##### private 
* class : private classes are allowed but only as inner or nested classes.
If you have a private inner or nested class, then access is restricted to the scope of that outer class.  
> We can not declare outer class as private. If you have a private class on its own as a top-level class, 
then you can't get access to it from anywhere. 
* member: private modifier specifies that the member can only be accessed in its own class. No child class has access.

##### protected
member: The protected modifier specifies that the member can only be accessed within its own package (as with package-private) and, in addition, by a subclass of its class in another package.
class : If you have a _protected inner or nested class_, then access is permitted from inside the same package or subclasses of the outer class or something similar. 
> If you have a protected top-level class there isn't an outer class to have subclasses to gain access from, so protected is meaningless.

----
>Local Variables and Access Modifiers

>Can access modifiers be applied to local variables? NO!

>One modifier that can ever be applied to local variables is _final_.

----

#### Non Access Modifiers

##### strictfp
member: method code will conform to the IEEE 754 standard rules for floating points. variables can't be strictfp.
class : any method code in the class will conform to the IEEE 754 standard rules for floating points. Without that modifier, floating points used in the methods might behave in a platform-dependent way. 

##### final 
* method: The final keyword prevents a method from being overridden in a subclass, and is often used to enforce the API functionality of a method.
* variable : Declaring a variable with the final keyword makes it impossible to reassign that variable once it has been initialized with an explicit value 
* method arguments : it means method can't alter the value of parameter.
* class  : class can't be sub classed

```
public void doit(final int i) {
		i=20; // won't compile
	}
```

##### synchronized
The synchronized keyword indicates that a method can be accessed by only one thread at a time.

##### native
The native modifier indicates that a method is implemented in platform-dependent code, often in C.
native can be applied only to methodsnot classes, not variables, just methods.


##### abstract
member : An abstract method does not have any implementation. Code has to be written by child class.
class  : An abstract class can never be instantiated. Its sole purpose, mission in life, raison d'tre, is to be extended (sub classed).
variables : NA

##### static
* member : The static modifier is used to create variables and methods that will exist independently of any instances created for the class.
* instance variables aka fields : The static modifier is used to create variables and methods that will exist independently of any instances created for the class.
* class  : A class nested within another class, but not within a method
* static blocks : Initialization blocks

Things you can't mark as static:
* Constructors (makes no sense; a constructor is used only to create instances)
* Classes (unless they are nested)
* Interfaces (unless they are nested)
* Method local inner classes
* Inner class methods and instance variables
* Local variables

##### transient
* variables : If you mark an instance variable as transient, you're telling the JVM to skip (ignore) this variable when you attempt to serialize the object containing it.
applies to instance variables aka fields
* methods, classes : not applicable.

##### volatile
* variable : The Java volatile keyword is used to mark a Java variable as "being stored in main memory". More precisely that means, that every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache, and that every write to a volatile variable will be written to main memory, and not just to the CPU cache.
applies to instance variables aka fields
* methods, classes : not applicable.

##### summary modifier

local variables - final
non-local variables - final ,public, protected, private, static, transient, volatile
methods - final, public, private, protected, static, abstract, synchronized, strictfp, native 

### Interface
Interfaces are like 100% abstract classes. 

##### public and package
Interface can be public or package only

##### public and abstract
All interface methods are implicitly public and abstract.

```java
public interface Bounceable {
public abstract void bounce();
public abstract void setBounceFactor(int bf);
}
```
is same as

```java
public interface Bounceable {
	void bounce();
	void setBounceFactor(int bf);
}
```

##### public, static, and final
All variables defined in an interface must be public, static, and final. In other words, interfaces can declare only constants, not instance variables.

##### interface methods can't be static
Interface methods must not be static.

##### interface methods are abstract
Because interface methods are abstract, they cannot be marked final, strictfp, or native.

##### interface - extend and implement
* An interface can extend one or more other interfaces.
* An interface cannot extend anything but another interface.
* An interface cannot implement another interface or class.

##### interface constants
interface variables are public, static, and final implicitly.

Following are all identical:
* public int x = 1; // Looks non-static and non-final, but isn't!
* int x = 1; // Looks default, non-final, non-static, but isn't!
* static int x = 1; // Doesn't show final or public
* final int x = 1; // Doesn't show static or public
* public static int x = 1; // Doesn't show final
* public final int x = 1; // Doesn't show static
* static final int x = 1 // Doesn't show public
* public static final int x = 1; // what you get implicitly



### Other basics

##### java primitives
char, boolean, byte, short, int, long, double, or float. 

##### this keyword
refers to the current object.

##### enums
Java lets you restrict a variable to having one of only a few predefined valuesin other words, one value from an enumerated list.
The most important thing to remember is that enums are not Strings or ints! Each of the enumerated types is actually an instance of that enum class.

##### explain floating point numbers. precision, mantissa


##### JAVA BASICS
Notes from https://www.lynda.com/Java-tutorials/Java-Advanced-Training/107061-2.html

* Diamond Operator - no need to repeat the class name on right side in case of Generics
* Number format - java 7 will ignore _ in numbers
* String Switch - java 7 will let you create switch statement on string values
* static block - called once before any other static field is used. called once only.
* non-static block - called before constructor is called. called everytime object is instantiated.
* member class - visible only to the class inside which it is declared.
* inner class - visible only the method inside which it is declared.
* annonymous class - remove the name when not needed. define and instantiate on the fly.

reflection - you can get class details

collections - http://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

|Interface | Implementations |
|----------|-----------------|
|Set| HashSet, TreeSet, LinkedHashSet, EnumSet|
|List| ArrayList, LinkedList|
|Deque|ArrayDeque|
|Map|HashMap, TreeMap, LinkedHashMap|

|Key Points|Details|
|----------|-------|
|HashSet vs TreeSet| __1.__ HashSet is faster <br> __2.__ TreeSet - TreeSet maintains objects in Sorted order defined by either Comparable or Comparator method in Java.|
|HashSet vs LinkedHashSet| The only difference between HashSet and LinkedHashSet is that LinkedHashSet maintains the insertion order.|
|HashMap vs TreeMap|TreeMap is implemented based on red-black tree structure, and it is ordered by the key. |
|HashMap vs LinkedHashMap|LinkedHashMap has more memory foot print than HashMap to maintain doubly LinkedList which it uses to keep track of insertion order of keys. Same performance|


**io**
Paths, Files - 2 util classes to make File/Dir ops easier  
FileReader - text files.   
FileBufferedReader - text files - faster reading   
FileWriter - write text files.  
FileBufferedWriter - text files - faster writing  
FileInputStream - binary data reader  
FileOutputStream - binary data writer  

SimpleFileVisitor - scanning paths to see what files exist  
PathMatcher - to filter files found by SimpleFileVisitor   
WatchService - to track file creation/deletion/modification in a directory   

**Threads:**
t.run - start process on main  
t.start - run a separate thread  
synchronized - block of code that only one thread can run at any time  


**Method Overriding:**
Static methods are called as per reference type.   
Non-static methods are based upon actual object type.  

**Further Discussion Topics**

1. **Thread-safety with the Java final keyword**

final has the following important characteristic as part of its definition:

* When the constructor exits, the values of final fields are guaranteed to be visible to other threads accessing the constructed object.

Now, if fields are declared final, post contrutcor call, JVM will ensure that values are correctly shown to other threads accessing the object.

But why is this a problem in first place ?

When the JVM executes the constructor of your object, it must store values into the various fields of the object, and store a pointer to the object data. As in any other case of data writes, these accesses can potentially occur out of order, and their application to main memory can be delayed and other processors can be delayed unless you take special steps to combat this. In particular, the pointer to the object data could be stored to main memory and accessed before the fields themselves have been committed (this can happen partly because of compiler ordering). And this in turn could lead to another thread seeing the object in an invalid or partially constructed state.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
final prevents this from happening: if a field is final, it is part of the JVM specification that it must effectively ensure that, once the object pointer is available to other threads, so are the correct values of that object's final fields.


