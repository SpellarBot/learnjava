package com.rightkarma.learnjava.javabasic.cloning;

public class AnotherChildNonCloneable {
	private String name;

	public AnotherChildNonCloneable(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AnotherChildNonCloneable{" +
				"name='" + name + '\'' +
				'}';
	}

	public void setChildName(String name) {
		this.name=name;
	}
}
