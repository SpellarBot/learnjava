package com.rightkarma.learnjava.javabasic.generics.genericmethod;

import com.rightkarma.learnjava.generics.common.Person;
import com.rightkarma.learnjava.generics.genericcomparator.AgeComparator;
import com.rightkarma.learnjava.generics.genericmethod.MethodGenerics;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MethodGenericsTest {

	private List<Person> people;
	final Person chi=new Person(45, "Chi");
	final Person ram=new Person(50, "Ram");
	final Person don=new Person(24, "Don");
	
	private List<Integer> integers;
	
	@Before
    public void setUp()
    {
		people = new ArrayList<>();
		people.add(chi);
		people.add(ram);
		people.add(don);
		System.out.println(people);
		
		integers = new ArrayList<>();
		integers.add(93);
		integers.add(52);
		integers.add(72);
		System.out.println(integers);
		
    }

	@Test
	public void testMin() {
		MethodGenerics m = new MethodGenerics();
		Person minAgePerson=m.min(people, new AgeComparator());
		assertEquals(don, minAgePerson);
	}
	
	@Test
	public void testMinIntegerClass() {
		MethodGenerics m = new MethodGenerics();
		
		Integer i=m.min(integers, Integer::compare);
		assertEquals(new Integer(52), i);
	}

}
