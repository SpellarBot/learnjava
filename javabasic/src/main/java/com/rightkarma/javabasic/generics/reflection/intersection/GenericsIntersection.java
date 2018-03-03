package com.rightkarma.javabasic.generics.reflection.intersection;

public class GenericsIntersection {

	public <T extends Worker & Developer> void work(T t) {
		t.work();
		t.code();		
	}
}
