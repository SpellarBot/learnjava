package com.rightkarma.jvm.gc;

import java.lang.ref.WeakReference;

public class JavaReferences {

	public static void main(String[] args) {
		// create a strong reference
		Person person = new Person();
		// create a weak reference
		WeakReference<Person> wr = new WeakReference<Person>(person);
		
		// here strong reference exists so getting object via weak reference would surely work
		Person p1 = wr.get();
		System.out.println(p1);
		
		person=null;
		p1 = null;

		//here strong reference does not exist but there is no pressure on memory so GC would not have run. 
		//you can still get the object via weak reference		
		Person p2 = wr.get();
		System.out.println(p2);
		
		p2 = null;
		System.gc();
		
		// here GC is forced and there is no strong reference so object would be removed from memory
		Person p3 = wr.get();
		System.out.println(p3);
		
		/*
		 * OUTPUT:
		 * ---------------------------------------
		 * jvm.garbagecollector.Person@22509bfc 
		 * jvm.garbagecollector.Person@22509bfc 
		 * null
		 * ---------------------------------------
		 * */
	}
}

class Person{
	
}