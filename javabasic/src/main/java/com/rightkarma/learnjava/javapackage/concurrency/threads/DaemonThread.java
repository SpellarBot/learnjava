package com.rightkarma.learnjava.javapackage.concurrency.threads;

/*
 * LEARN - MyDeamonThread will stop as soon as loop in main thread is over.
 * This is despite the fact that MyDeamonThread has an infinite loop - while (true)
 * This happens because of this call - setDaemon(true);
 * */

public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new MyDaemonThread();
		thread.start();
		int i=0;
		while ( i<3 ){
			Thread.sleep(2000);
			System.out.println("main sleeping "+i);
			i++;
		}
	}
}


class MyDaemonThread extends Thread {
	public MyDaemonThread() {
		setDaemon(true);
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("t sleeping");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}