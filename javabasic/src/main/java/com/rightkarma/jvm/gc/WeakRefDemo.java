package com.rightkarma.jvm.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeakRefDemo {
	public static void main(String[] args) throws IOException {
		Person2 p = new Person2();
		final ReferenceQueue<Person2> referenceQueue = new ReferenceQueue<Person2>();
		PersonCleaner cleaner = new PersonCleaner();
		
		// create a weak reference to Person object
		// this weak reference will be added to ref queue by jvm
		
		PersonWeakReference weakReference = new PersonWeakReference(p, cleaner, referenceQueue);

		// run a separate thread to see that when GC runs, the object's clean method is called 
		// because it has been put into referenceQueue
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					PersonWeakReference wr = (PersonWeakReference) referenceQueue.remove(); // check to see if object is available
					wr.clean();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		p = null;
		System.gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("press key");
		br.readLine(); // this will cause program from exiting immediately.
		service.shutdown();
	}
}

final class Person2 {
}

class PersonCleaner {

	public void clean() {
		System.out.println("cleaned");

	}
}

class PersonWeakReference extends WeakReference<Person2> {
	PersonCleaner cleaner;

	public PersonWeakReference(Person2 referent, PersonCleaner cleaner,
			ReferenceQueue<? super Person2> q) {
		super(referent, q);
		this.cleaner = cleaner;
	}

	public void clean() {
		cleaner.clean();
	}
}