package com.rightkarma.learnjava.threads;

public class CurrentThread {

	public static void main(String[] args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName);
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
	}
}
