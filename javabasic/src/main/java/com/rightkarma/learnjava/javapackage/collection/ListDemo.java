package com.rightkarma.learnjava.javapackage.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Array list will let you insert at a particular location also but its expensive operation.
linked list will let you insert at a particular location and also it maintains that order
*/
public class ListDemo {
	public static void main(String[] args) {
		showLinkedList();
		showArrayList();
	}

	private static void showArrayList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
//		list.addFirst("+A"); does not exist
		list.add(0, "+A");
		list.add(2, "A-");
		System.out.println(list); // [A, A-, B, +A]
		// Array list will let you insert at a particular location also but its expensive operation.

	}
	private static void showLinkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.addFirst("+A");
		list.add(2, "A-");
		System.out.println(list); // [+A, A-, A, B]
		// linked list will let you insert at a particular location and also it maintains that order
	}
}
