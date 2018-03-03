package com.rightkarma.javabasic.generics.reflection;

import org.junit.Test;

public class InjectorTest {

	@Test
	public void test() {
		Injector injector = new Injector().with("Hello World");
		Logger logger = injector.newInstance(Logger.class);
		logger.log();
	}

}
