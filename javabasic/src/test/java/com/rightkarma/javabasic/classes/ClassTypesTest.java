package com.rightkarma.javabasic.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassTypesTest {

	@Test
	public void howToUseStaticInnerClass() {
		ClassTypes.StaticNestedClass staticNestedClass = new ClassTypes.StaticNestedClass();
		assertEquals("Hi", staticNestedClass.sayHi());
	}

}
