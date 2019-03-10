#### Generics will make 
. code generic
. keep the safety that we get from static typing. ie. compile time error would be generated if wrong types are used.

=============
#### Generics Types:
* Upper Bound: List<? extends Cls> -- Covariance
* Lower Bound: List<? super Cls> -- Contravariance 
* Unbound: List<?>

**Case 1: Unbound**

To understand Unbound or ?, look at following code.

        List<?> l = new ArrayList<>();
		Object object = l.get(0);
		l.add(object); //this will not compile

* ?  really means - ? extends Object. 
* When you do get() -> that's ok becuase you can cast it to Object.
* When you do add() -> there is a problem because you are saying that you don't know what it is 
and you need to LowerBound

**Case 2: ? extends**
		
		List<? extends Number> l = new ArrayList<>();
		l.add(1); // can't add . this will give compiler error
		Number n = l.get(0); 
? extends:
1. declare an upper bound for the type parameter
2. to get data out of the parameter
3. Covariance


**Case 3: ? super**

		List<? super Number> l = new ArrayList<>();
		l.add(1);
		Number n = l.get(0); // can't read. this will not compile
? super:
1. declare a lower bound for the type parameter
2. to put data into parameter
3. Contravariance

=============

####  RawTypes:
Problem with using RawTypes is that at run time, while reading objects you might cast to a class type.
Since it is not gauranteed what class types will be used, exception will happen.

Erasure: compiler make these changes after code compilation
```
List<whatever> -> List
List<whatever> [] -> List []
T without bounds -> Object
T extends Foo -> Foo
```

=============
#### Substitution Principal:

When you can pass in parameter, 
* an object of subclass 
* an object of another class that implements that interface

* use T when declaring generics in classes. Because you need T in further method declarations 
and hence a name (T) is required.
* use ? when declaring generics in methods as it is restricted just to that method.


####  Generic class and method
**Generic Class** - Type is passed in class signature after name.

    public class SortedPair<T extends Comparable<T>> 


**Generic Method** - Type is passed just before Return value.
    
    public static <T> Object min(List<T> values, Comparator<T> c).
	    
* In this code, T defines the type only for this method declaration. 
* It means that List and Comparator will take in certain types T - and it can be whatever

**Generic Method Improved** 
 
Consider this improvement:
    
    public static <T> T min(List<T> values, Comparator<T> c)
	
This code says everything mentioned in Generic Method, and further that return type will be of T. 
This is better because calling method knows what it is going to get back. 

#### Get/Put Principle

In summary, we use covariance when we only intend to take generic values out of a structure. 
We use contravariance when we only intend to put generic values into a structure and 
we use an invariant when we intend to do both.

```
public static void copy(List<? extends Number> source,
                         List<? super Number> destiny) {
        for(Number number : source) { 
            destiny.add(number);
        }
    }
```
* source - you can always expect to get number. whatever extended Number is a Number
* destiny - you can always add a number. But you can't read as you don't know if you get Number or any super class.

#### Overloading in Generics
```
public void print(List<String> l) {}
public void print(List<Integer> l) {} 
```
2nd method won't compile because they are nothing but List. 
Generics are dropped ultimately by compiler.


	