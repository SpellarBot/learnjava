package com.rightkarma.learnjava.javabasic.generics.reflection.intersection;

public class GenericsIntersection {

	public <T extends Worker & Developer> void work(T t) {
		t.work();
		t.code();		
	}
}
