package com.rightkarma.javaapp.algo;

/*
 * LEARN: the main thing to understand in this implementation is that when linkedlist is created
 * we save the first element in head.
 * after that we always use it to traverse. even to append we traverse from head to tail and add the element.
 * it will more efficient to keep the last element in tail but that is not implemented here
 * 
 * key functions to check and understand in this program
 * isCyclic() - uses Floyd�s cycle finding algorithm to check if LinkedList is cyclic
 * lengthIterative
 * lengthRecursive
 * */
/**
 * 
 * Java program to find if LinkedList contains loop or cycle or not. This
 * example uses two pointer approach to detect cycle in linked list. Fast
 * pointer moves two node at a time while slow pointer moves one node. If linked
 * list contains any cycle or loop then both pointer will meet some time.
 */

public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = new Node("head");
	}

	public Node head() {
		return head;
	}

	public void appendIntoTail(Node node) {
		Node current = head;

		// find last element of LinkedList i.e. tail
		while (current.next() != null) {
			current = current.next();
		}
		// appending new node to tail in LinkedList
		current.setNext(node);
	}

	/*
	 * If singly LinkedList contains Cycle then following would be true 1) slow
	 * and fast will point to same node i.e. they meet On the other hand if fast
	 * will point to null or next node of fast will point to null then
	 * LinkedList does not contains cycle.
	 */
	public boolean isCyclic() {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			// if fast and slow pointers are meeting then LinkedList is cyclic
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public int lengthIterative() {
		int count = 0;
		Node current = this.head;

		while (current != null) {
			count++;
			current = current.next();
		}
		return count;
	}

	public int lengthRecursiveLogic(Node current){
		if (current == null) // base case
			return 0;

		return 1 + lengthRecursiveLogic(current.next());
	}
	
	public int lengthRecursive() {
		return lengthRecursiveLogic(head);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head.next();
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next();
		}
		sb.delete(sb.length() - 3, sb.length()); // to remove --> from last node
		return sb.toString();
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return this.data;
		}
	}

	/*
	 * In this section we will test linked list using Java main method with
	 * twolinked list, one contains cycle and other is not cyclic. Here is first
	 * test where linked list does not contain any cycle.
	 */
	public static void main(String args[]) {

		/*CHECK ISCYCLIC*/
		LinkedList linkedList ;
		
		linkedList = new LinkedList();
		linkedList.appendIntoTail(new LinkedList.Node("101"));
		LinkedList.Node cycle = new LinkedList.Node("201");
		linkedList.appendIntoTail(cycle);
		linkedList.appendIntoTail(new LinkedList.Node("301"));
		linkedList.appendIntoTail(new LinkedList.Node("401"));
		linkedList.appendIntoTail(cycle);
		checkCyclic(linkedList);

		linkedList = new LinkedList();
		linkedList.appendIntoTail(new LinkedList.Node("101"));
		linkedList.appendIntoTail(new LinkedList.Node("201"));
		linkedList.appendIntoTail(new LinkedList.Node("301"));
		linkedList.appendIntoTail(new LinkedList.Node("401"));

		checkCyclic(linkedList);
		/*GET LENGTH*/
		System.out.println(linkedList.lengthIterative());
		System.out.println(linkedList.lengthRecursive());
		
	}

	private static void checkCyclic(LinkedList linkedList) {
		/* System.out.println("Linked List : " + linkedList); */

		if (linkedList.isCyclic()) {
			System.out
					.println("Linked List is cyclic as it contains cycles or loop");
		} else {
			System.out
					.println("LinkedList is not cyclic, no loop or cycle found");
		}
	}

}
