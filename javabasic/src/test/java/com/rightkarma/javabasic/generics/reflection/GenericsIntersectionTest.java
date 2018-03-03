package com.rightkarma.javabasic.generics.reflection;

import com.rightkarma.javabasic.generics.reflection.intersection.Consultant;
import com.rightkarma.javabasic.generics.reflection.intersection.Employee;
import com.rightkarma.javabasic.generics.reflection.intersection.GenericsIntersection;
import org.junit.Test;

public class GenericsIntersectionTest {

	@Test
	public void test() {
		GenericsIntersection g = new GenericsIntersection();
		g.work(new Employee());
		g.work(new Consultant());
//		g.work(new Officer()); // wont compile as Officer does not implement both Developer and Worker class
	}

}
