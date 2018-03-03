package com.rightkarma.javabasic.generics.rawtypes;

import java.util.List;

public class Overloading {

	public void print(String name) {
	}

	public void print(Integer i) {
	}

	public void print(List<String> l) {
	}
	// public void print(List<Integer> l) {} // won't compile . because they are
	// nothing but List. Generics are dropped ultimately by compiler.
	
}
