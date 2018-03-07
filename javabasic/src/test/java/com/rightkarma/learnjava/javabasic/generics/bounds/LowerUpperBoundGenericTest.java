package com.rightkarma.learnjava.javabasic.generics.bounds;

import com.rightkarma.learnjava.generics.bounds.LowerUpperBoundGeneric;
import com.rightkarma.learnjava.generics.common.Person;
import com.rightkarma.learnjava.generics.common.YoungPerson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LowerUpperBoundGenericTest {

	private List<YoungPerson> youngPeople;
//	final Person chi=new Person(45, "Chi");
//	final Person ram=new Person(50, "Ram");
	final YoungPerson don=new YoungPerson(24, "Don");
	final YoungPerson tom=new YoungPerson(21, "Tom");
	
	@Before
    public void setUp()
    {
		youngPeople = new ArrayList<>();
		// adding a young person should not break anything
		youngPeople.add(tom);
		youngPeople.add(don); 
		System.out.println(youngPeople);
    }

	@Test
	public void testOrderOfSaveAndGet() {
		LowerUpperBoundGeneric g = new LowerUpperBoundGeneric();
		g.saveAll(youngPeople); // save all will take any list of Persons or child of Person class.
		Assert.assertEquals(don, g.get()); // last saved person should come out.
		Assert.assertEquals(tom, g.get()); // last saved person should come out.
	}
	
	@Test
	public void testLowerBound() {
		LowerUpperBoundGeneric g = new LowerUpperBoundGeneric();
//		g.loadAll(youngPeople); // this will not compile 
		g.loadAll(new ArrayList<Person>());
	}
}
