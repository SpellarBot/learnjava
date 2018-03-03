package com.rightkarma.javabasic;

import org.junit.Test;

public class TruthTable {

	public static void showResults() {
		System.out.println("---------------OR");
		System.out.println(false|| false);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(true || true);
		System.out.println("---------------AND");
		System.out.println(false && false);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(true && true);
		System.out.println("---------------EX OR");
		System.out.println(false ^ false);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(true ^ true);
	}
	
	@Test
	public void testTruthTable() {
		TruthTable.showResults();
	}
}
