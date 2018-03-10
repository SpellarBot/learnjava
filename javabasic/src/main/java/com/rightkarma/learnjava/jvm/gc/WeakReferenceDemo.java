package com.rightkarma.learnjava.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * LearningNote
 * If there is no pressure on memory, GC would not run and collect the objects.
 * Here we will create 2 objects p1 and p2.
 * Then we will nullify them.
 * 2 scenarios will be tested
 * 1) -  p2 remains in memory and we will retrieve it as well.
 * 2) - p2 will be removed if GC is run ( forced below to show that object is removed after GC )
 */
public class WeakReferenceDemo {

	public static void main(String[] args) {
		Person p1 = new Person();
		WeakReference<Person> weakReference = new WeakReference<Person>(new Person());
		Person p2 = weakReference.get();

		// here strong reference exists so getting object via weak reference would surely manage
        System.out.println("----------Objects created----------------------");
		System.out.println(p1);
        System.out.println(p2);

        p1=null;
        p2= null;

        System.out.println("----------Try to recover nullified object----------------------");
		Person p3 = weakReference.get();
        System.out.println(p3);
        p3=null; // remove the reference otherwise it will not let object get removed from memory


        System.out.println("----------Force GC and try to recover----------------------");
        System.gc();
        Person p4 = weakReference.get();
        System.out.println(p4);
	}
}

class Person{

}