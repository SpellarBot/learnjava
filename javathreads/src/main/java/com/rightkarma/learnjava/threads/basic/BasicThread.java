package com.rightkarma.learnjava.threads.basic;


public class BasicThread extends Thread {

	public BasicThread() {

	}

	public BasicThread(String a) {

	}

	@Override
	public void run() {
		System.out.println("Thread..run().. not necessary to override as parent class run method is available.");
	}

	public static void main(String[] args) {
		BasicThread bt = new BasicThread("A");
		bt.run(); // learn - starting a thread using Thread SubClass
	}
}
