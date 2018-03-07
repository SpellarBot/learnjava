package com.rightkarma.learnjava.generics.genericcomparator;

import java.util.Comparator;


/*
 * This class implements generic comparator and uses another comparator class to do actual comparison
 * Understand that you are declaring constructor with parameter as another comparator.
 * */
public class ReverseComparator<T> implements Comparator<T> {

	private final Comparator<T> delegateComparator;
	

	public ReverseComparator(Comparator<T> delegateComparator) {
		this.delegateComparator = delegateComparator;
	}


	@Override
	public int compare(final T o1, final T o2) {
		return -1*delegateComparator.compare(o1, o2);
	}
	
	
}
