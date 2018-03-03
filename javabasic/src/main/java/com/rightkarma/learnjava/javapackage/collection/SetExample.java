package com.rightkarma.learnjava.javapackage.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * HashSet is not sorted.
 * TreeSet is sorted
 * */
public class SetExample {
	public static void main(String[] args) {
		showHashSet();
		showTreeSet();
	}

	private static void showTreeSet() {
		Set<Integer> set = new TreeSet<>();
		set.add(12);
		set.add(10);
		set.add(18);
		set.add(8);
		System.out.println("TreeSet: "+set); // it will be sorted TreeSet: [8, 10, 12, 18]

		
	}

	private static void showHashSet() {
		Set<Integer> set = new HashSet<>();
		set.add(10);
		set.add(12);
		set.add(18);
		set.add(10);
		System.out.println("HashSet size : "+set.size());
		set.add(11);
		System.out.println("HashSet size : "+set.size());
		set.add(null);
		System.out.println("HashSet size : "+set.size());
		System.out.println("HashSet: "+set); // it will not be sorted : HashSet: [null, 18, 10, 11, 12]
	}
}
