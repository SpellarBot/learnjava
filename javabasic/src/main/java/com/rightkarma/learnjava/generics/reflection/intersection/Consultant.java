package com.rightkarma.learnjava.generics.reflection.intersection;

public class Consultant implements Worker, Developer {
	public void work() {
		System.out.println("Consultant work");
	}

	public void code() {
		System.out.println("Consultant code");
	}
}