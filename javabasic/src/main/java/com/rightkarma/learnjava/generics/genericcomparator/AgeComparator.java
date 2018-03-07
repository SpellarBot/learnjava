package com.rightkarma.learnjava.generics.genericcomparator;

import com.rightkarma.learnjava.generics.common.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}

	
}
