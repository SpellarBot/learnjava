package com.rightkarma.learnjava.javabasic.generics.reflection;

import com.rightkarma.learnjava.generics.reflection.Injector;
import com.rightkarma.learnjava.generics.reflection.Logger;
import org.junit.Test;

public class InjectorTest {

	@Test
	public void test() {
		Injector injector = new Injector().with("Hello World");
		Logger logger = injector.newInstance(Logger.class);
		logger.log();
	}

}
