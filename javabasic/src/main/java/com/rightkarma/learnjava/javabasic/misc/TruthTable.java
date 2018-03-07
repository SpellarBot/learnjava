package com.rightkarma.learnjava.javabasic.misc;

import org.junit.Test;

public class TruthTable {

	public static void showResults() {
		System.out.println("---------------OR");
		System.out.println(false|| false); // LearningNote - false
		System.out.println(true || false);// LearningNote - true
		System.out.println(false || true); // LearningNote - true
		System.out.println(true || true); // LearningNote - true
		System.out.println("---------------AND");
		System.out.println(false && false); // LearningNote - false
		System.out.println(true && false); // LearningNote - false
		System.out.println(false && true); // LearningNote - false
		System.out.println(true && true); // LearningNote - true
		System.out.println("---------------EX OR");
		System.out.println(false ^ false); // LearningNote - false
		System.out.println(true ^ false); // LearningNote - true
		System.out.println(false ^ true); // LearningNote - true
		System.out.println(true ^ true); // LearningNote - false
	}
	
	@Test
	public void testTruthTable() {
		TruthTable.showResults();
	}
}
