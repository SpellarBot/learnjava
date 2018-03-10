package com.rightkarma.learnjava.generics.intersection;

public class GenericsIntersection {

	public <T extends Manager & Developer> void work(T t) {
		t.manage();
		t.code();		
	}
}
