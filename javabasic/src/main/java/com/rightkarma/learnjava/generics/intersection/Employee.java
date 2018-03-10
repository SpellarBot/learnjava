package com.rightkarma.learnjava.generics.intersection;

public class Employee implements Manager, Developer {
	public void manage() {
		System.out.println("Employee manage");
	}
	public void code() {
		System.out.println("Employee code");
	}
}