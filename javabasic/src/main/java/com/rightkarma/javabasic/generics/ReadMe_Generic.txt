Generics will make 
. code generic
. keep the safety that we get from static typing. ie. compile time error would be generated if wrong types are used.

=============
Generics could be :
Upper Bound: List<? extends Cls>
Lower Bound: List<? super Cls> 
Unbound: List<?>

To understand Unbound or ?, look at following code.
?  really means - ? extends Object. 
When you do get(). that ok becuase you can cast it to Object.
when you do add() there is a problem because you are saying that you don't know what it is and you need to LowerBound

		List<?> l = new ArrayList<>();
		Object object = l.get(0);
		l.add(object); //this will not compile

		List<? extends Number> l = new ArrayList<>();
		l.add(1); // can't add . this will give compiler error
		Number n = l.get(0); 

Following works fine:
		List<? super Number> l = new ArrayList<>();
		l.add(1);
		Number n = l.get(0); // can't read. this will not compile
		
? extends:
1. declare an upper bound for the type parameter
2. to get data out of the parameter
3. Covariance

? super:
1. declare a lower bound for the type parameter
2. to put data into parameter
3. Contravariance

=============
RawTypes:
Problem with using RawTypes. Check class - RawTypeRuntimeException

Erasure: compiler make these changes after code compilation
List<whatever> -> List
List<whatever> [] -> List []
T without bounds -> Object
T extends Foo -> Foo

=============
Substitution Principal:

When you can pass in parameter, A) an object of subclass B) an object of another class that implements that interface

use T when declaring generics in classes. Becuase you need T in further method declarations and hence a name (T) is required.
use ? when declaring generics in methods as it is restricted just to that method.
=============

Examples covered.
AgeComparator
------------------
Implementing a Generic- AgeComparator implements Comparator<Person>
	USAGE - new AgeComparator()

ReverseComparator
------------------	
Passing parameter to Generic - ReverseComparator<T> implements Comparator<T>. 
	USAGE - new ReverseComparator<>(new AgeComparator())
	ReverseComparator implements another comparator of generic type and takes actual comparator as parameter. Passed in comparator knows how to compare the objects.
	So you notice that ReverseComparator Type and Comparator Type are same i.e. T 

SortedPair
------------------
Type Bounds - SortedPair<T extends Comparable<T>>
	UAGE - SortedPair<Integer> pair=new SortedPair<>(1, 2); // sorting integer pair
	
=============
Generic Class - Type is passed in class signature after name.
	example - public class SortedPair<T extends Comparable<T>> 
Generic Method - Type is passed just before Return value.
	code - public static <T> Object min(List<T> values, Comparator<T> c).
	In this code, T defines the type only for this method declaration. It means that List and Comparator will take in certain types T - and it can be whatever

	code - public static <T> T min(List<T> values, Comparator<T> c).
	This code says everything above, and further that return type will be of T. This is better because calling method knows what it is going to get back. 
	
MethodGenerics
---------------
	example of Generic method 
		class  : in.purihim.javabasic.generics.genericmethod.MethodGenerics
		method : public <T> T min(List<T> list, Comparator<T> c)
=============
