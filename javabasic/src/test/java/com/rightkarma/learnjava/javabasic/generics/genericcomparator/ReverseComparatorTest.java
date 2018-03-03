package com.rightkarma.learnjava.javabasic.generics.genericcomparator;

import com.rightkarma.learnjava.javabasic.generics.common.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReverseComparatorTest {

	private List<Person> people;
	final Person chi=new Person(45, "Chi");
	final Person ram=new Person(50, "Ram");
	final Person don=new Person(24, "Don");
	
	@Before
    public void setUp()
    {
		people = new ArrayList<>();
		people.add(chi);
		people.add(ram);
		people.add(don);
		System.out.println(people);
    }

	@Test
	public void testOrderByAge() {
		Collections.sort(people, new AgeComparator());
		assertEquals(don,people.get(0));
	}
	
	@Test
	public void testReverseOrder() {
		Collections.sort(people, new ReverseComparator<>(new AgeComparator()));
		assertEquals(ram,people.get(0));
	}

}
