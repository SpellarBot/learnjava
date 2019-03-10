package com.rightkarma.learnjava.javabasic.p;

import java.util.Date;

public class one implements Cloneable {
	private String s=new Date().toString();

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println(new one().clone());
	}

	@Override
	public String toString() {
		return "one{" +
				"s='" + s + '\'' +
				'}';
	}
}
