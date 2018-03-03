package com.rightkarma.learnjava.javabasic.misc;

import java.util.ArrayList;
import java.util.List;

public class J7StaticBlock {

	static List<Person> list ;
	
	static { // java 7 - static block is executed before class instantiation..
		System.out.println("static block started..");
		list = new ArrayList<>(); // Note java 7 does not need class name on right side
		Person p1 = new Person("A", 31);
		Person p2 = new Person("B", 32);
		Person p3 = new Person("C", 29);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println("static block ended..");
	}

	private static void displayPersonList() {
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		System.out.println("start pgm.."); // if this is not in this class.. this line will print before static block 
		displayPersonList();
		displayPersonList(); // you can call this twice but static block runs once only
		System.out.println("end pgm..");
	}
}
/*
 * OUTPUT
static block started..
static block ended..
start pgm..
[Person [age=31, name=A], Person [age=32, name=B], Person [age=29, name=C]]
end pgm..

 * */

