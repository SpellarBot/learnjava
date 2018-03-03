package com.rightkarma.learnjava.javabasic.generics.bounds;


import com.rightkarma.learnjava.javabasic.generics.common.Person;

import java.util.ArrayList;
import java.util.List;

public class LowerUpperBoundGeneric {

	List<Person> persons = new ArrayList<>();
	
	public void saveAll(final List<? extends Person> persons) { // this is cleaner
//	OR
//	public <T extends Person> void saveAll(final List<T> persons) { 
		for ( Person p :persons) {
			save(p);
		}
	}

	private void save(Person p) {
		persons.add(p);
	}
	
	public Person get() {
		if ( persons.isEmpty()) {
			return null;
		}
		return persons.remove(persons.size()-1);
	}
	
	/*
	 * LowerBOund example - 
	 * when we are doing get, we expect at least Person. 
	 * so the list we can add the person to should take Person call or its parent.
	 * */
	public void loadAll(final List<? super Person> people) {
		Person p;
		while ( (p=get())!=null) {
			people.add(p);
		}
	}
	
}
