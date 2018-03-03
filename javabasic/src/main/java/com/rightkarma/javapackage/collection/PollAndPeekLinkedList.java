package com.rightkarma.javapackage.collection;

import java.util.LinkedList;

/*
 * peek - only sees first element
 * poll - removes first element
 * OUTPUT
A
A
A
B

 * */

public class PollAndPeekLinkedList {
	private static LinkedList<String> list;
	
	static {
		list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
	}
	
	public static void main(String[] args) {
		System.out.println(list.peek());
		System.out.println(list.peek());
		System.out.println(list.poll());
		System.out.println(list.poll());
	}
	
}
