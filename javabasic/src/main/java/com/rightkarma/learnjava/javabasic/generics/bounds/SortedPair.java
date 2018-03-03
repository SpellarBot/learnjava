package com.rightkarma.learnjava.javabasic.generics.bounds;

/*
 * SortedPair will take any class as generic that implements Comparable.
 * Comparable<T> - here T signifies that class should be comparable to itself. 
 * To understand look at java.lang.Comparable interface. "public interface Comparable<T>".  
 * This is because Comparable needs to know what class it is going to compare to and use it in its method - "public int compareTo(T o);"
 * 
 * Look at following examples to understand how a clas compareTo method would look like based upon what it puts in Comparable interface.
 * 
=====> Person implements Comparable 
    @Override
	public int compareTo(Object o) {
		return -1;
	}
=====> Person implements Comparable<Person>
	@Override
	public int compareTo(Person o) {
		return Integer.compare(this.age, o.getAge());
	}
=====> Person implements Comparable<Integer>
	@Override
	public int compareTo(Integer o) {
		return o> 0 ? 1:0;
	}

Coming to below class, if it takes a class that implements Comparable, it would work..
public class SortedPair<T extends Comparable> { -- THIS COMPILES FINE but will give warning :
		Type safety: The method compareTo(Object) belongs to the raw type Comparable. References to generic type Comparable<T> should be parameterized.
		
		To be clear without parameterization, compareTo method is not really comparing the class but some generic code based upon Object class.
		If intention is indeed to use Object class, then one can specify that and warning would disappear.

public class SortedPair<T extends Comparable<T>> { - THIS COMPILES without WARNING as it is clear what Class needs to be used for Comparison.

 * */

public class SortedPair<T extends Comparable<T>> {

	private final T first;
	private final T second;

	public SortedPair(T left, T right) {
		if ( left.compareTo(right)<0) {
			first=left;
			second=right;
		} else {
			first=right;
			second=left;
		}
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
}
