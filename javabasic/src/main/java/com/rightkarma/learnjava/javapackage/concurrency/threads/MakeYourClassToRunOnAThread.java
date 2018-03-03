package com.rightkarma.learnjava.javapackage.concurrency.threads;

public class MakeYourClassToRunOnAThread {
	public static void main(String[] args) {
		MyThread mt = new MyThread("mt");
		mt.start();
		
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr, "mr");
		t.start();
	}
}

class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("Executing thread "
				+ Thread.currentThread().getName());
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing thread "
				+ Thread.currentThread().getName());
	}
}
