package com.rightkarma.learnjava.javabasic.misc;

public class Java7NumberFormat {
	public static void main(String[] args){
		int anynum = 1_00_0000; // java 7 - numbers can have _ in them
		float anothernum = 2_3.00_78f; // floats are also covered
		anynum++;
		anothernum++;
		System.out.println(anynum);
		System.out.println(anothernum);
	}
}
