package com.rightkarma.learnjava.javabasic.generics.reflection.intersection;

public class Employee implements Worker, Developer {
	public void work() {
		System.out.println("Employee work");
	}

	public void code() {
		System.out.println("Employee code");
	}
}