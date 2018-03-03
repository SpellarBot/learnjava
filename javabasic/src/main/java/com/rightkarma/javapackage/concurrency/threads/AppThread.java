package com.rightkarma.javapackage.concurrency.threads;

public class AppThread extends Thread {

	private final static String prmain="....................................MAIN : ";
	private final static String prother="..........OTHER : ";
	
	@Override
	public void run() {
		String pr;
		String name = Thread.currentThread().getName();
		if ( name.equals("main")) {
			pr=prmain;
		}else {
			pr=prother;
		} 
		System.out.println(pr+"running");
		int i = 2;
		while (i > 0) {
			
			System.out.println(pr + i);
			i--;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(pr+"THREAD EXCEPTION. Thread:" + name+" i : "+i);
				System.out.println(pr+e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		AppThread t = new AppThread();
		t.start();// this will start a new thread.
		t.interrupt();
		t.run(); // this will run code on main thread.
		t.run();// second call will wait for first main thread exec to finish
	}
}


/*
 * OUTPUT
....................................MAIN : running
..........OTHER : running
..........OTHER : 2
....................................MAIN : 2
..........OTHER : THREAD EXCEPTION. Thread:Thread-0 i : 1
..........OTHER : sleep interrupted
..........OTHER : 1
....................................MAIN : 1
....................................MAIN : running
....................................MAIN : 2
....................................MAIN : 1

 * 
 */