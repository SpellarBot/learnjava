package com.rightkarma.learnjava.javabasic;

public class ImplicitTruncation {
	public static void main(String[] args) {
		float f1=10000000000f;
		System.out.println(String.format("%f",f1));
		f1++;
		System.out.println(String.format("%f",f1));
	}
}
/*
 *
 * OUTPUT 
 * 10000000000.000000
 * 10000000000.000000
 * that is becuase mantissa space is limited and 10exp10 does not fit in
 * so adding 1 makes no difference.
 * 
 * Note there is no exception generated here for overflow. 
 * because this is ok for floating point numbers
 */
