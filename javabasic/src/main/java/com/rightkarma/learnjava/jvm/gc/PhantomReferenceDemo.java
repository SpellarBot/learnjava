package com.rightkarma.learnjava.jvm.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomReferenceDemo {
	public static void main(String[] args) {
		ReferenceQueue<Person3> queue = new ReferenceQueue<Person3>();
		ArrayList<FinalizePerson> list = new ArrayList<FinalizePerson>();
		ArrayList<Person3> people = new ArrayList<Person3>();
		for (int i = 0; i < 10; i++) {
			Person3 p = new Person3();
			people.add(p);
			list.add(new FinalizePerson(p, queue));
		}
		
		people = null;
		System.gc();

		// at this point all reference should be in queue
		for(PhantomReference<Person3> reference : list){
			System.out.println(reference.isEnqueued());
		}
		
		Reference<? extends Person3> referenceFromQueue;
		while ( ( referenceFromQueue = queue.poll()) != null){
			((FinalizePerson) referenceFromQueue).cleanup();
			referenceFromQueue.clear();
		}
	}
}

class FinalizePerson extends PhantomReference<Person3> {

	public FinalizePerson(Person3 referent, ReferenceQueue<? super Person3> q) {
		super(referent, q);
	}

	public void cleanup() {
		System.out.println("clean up done");
		
	}

}

class Person3 {
}