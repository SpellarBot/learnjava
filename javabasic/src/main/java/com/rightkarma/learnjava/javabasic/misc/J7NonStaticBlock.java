package com.rightkarma.learnjava.javabasic.misc;

import java.util.ArrayList;
import java.util.List;

public class J7NonStaticBlock {

	List<Person> list ;
	
	{ // java 7 - non-static block is executed before class constructor is called..
		System.out.println("non-static block started..");
		list = new ArrayList<>(); // Note java 7 does not need class name on right side
		Person p1 = new Person("A", 31);
		Person p2 = new Person("B", 32);
		Person p3 = new Person("C", 29);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println("non-static block ended..");
	}

	public J7NonStaticBlock() {
		System.out.println("constructor called..");
	}

	private void displayPersonList() {
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		System.out.println("start pgm..");  
		new J7NonStaticBlock().displayPersonList();
		new J7NonStaticBlock().displayPersonList(); // non-static blok is called twice before constructor runs.
		System.out.println("end pgm..");
	}
}
/*
 * OUTPUT
start pgm..
non-static block started..
non-static block ended..
constructor called..
[Person [age=31, name=A], Person [age=32, name=B], Person [age=29, name=C]]
non-static block started..
non-static block ended..
constructor called..
[Person [age=31, name=A], Person [age=32, name=B], Person [age=29, name=C]]
end pgm..

 * */

