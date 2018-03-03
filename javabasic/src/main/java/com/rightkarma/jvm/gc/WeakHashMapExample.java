package com.rightkarma.jvm.gc;

import java.util.Date;
import java.util.WeakHashMap;

public class WeakHashMapExample {
	public static void main(String[] args) {
		WeakHashMap<Animal, AnimalMetaData> weakHashMap = new WeakHashMap<Animal, AnimalMetaData>();
		Animal kevin = new Animal(); // strong reference
		weakHashMap.put(kevin, new AnimalMetaData());

		AnimalMetaData p = weakHashMap.get(kevin); // at this point, this should return the value
		System.out.println(p); // prints the meta data
		kevin = null; // now we need to prove that this is gone from weakHashMap becuase strong reference is gone
		
		System.gc();

		// sleep to ensure that GC has run
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// expect that key gone is printed.
		// this is because we had cleared the strong reference 
		// key value is expected to be gone from WeakHashMap because of that 
		if (weakHashMap.containsValue(p)) {
			System.out.println("still contains key");
		} else {
			System.out.println("key gone");
		}
	}
}

final class Animal {
}

class AnimalMetaData {
	Date date;

	AnimalMetaData() {
		date = new Date();
	}

	@Override
	public String toString() {
		return "AnimalMetaData [date=" + date + "]";
	}

}