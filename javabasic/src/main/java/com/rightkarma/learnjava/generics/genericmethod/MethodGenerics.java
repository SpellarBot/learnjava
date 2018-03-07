package com.rightkarma.learnjava.generics.genericmethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodGenerics {

	/*
	 * this method can find minimum for any class.
	 * Here is class is regular but method is generic.
	 * */
	public <T> T min(List<T> list, Comparator<T> c) {
		if ( list.isEmpty()) {
			throw new IllegalArgumentException("Empty list passed.");
		}
		Collections.sort(list, c);
		return list.get(0);
	}
}
