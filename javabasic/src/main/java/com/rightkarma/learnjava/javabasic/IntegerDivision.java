package com.rightkarma.learnjava.javabasic;

public class IntegerDivision {
	public static void main(String[] args) {
		int x = -5;
		int y = 3;
		float f = x/y;
		System.out.println(x / y);
		System.out.println("Notice that decimal part is dropped !!");
		System.out.println(f);
		System.out.println("Notice that decimal part is dropped even when result is captured in float!!");
		f = (float)x/(float)y;
		System.out.println(f);
		System.out.println("decimal part is retained when numbers are converted upfront");
	}
}
