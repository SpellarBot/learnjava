package com.rightkarma.learnjava.threads.basic;

public class RunnableClass implements Runnable {
	@Override
	public void run() {
		System.out.println("RunnableClass..run().. necessary to override run to provide implementation");
	}

	public void OtherThreads() {
		RunnableClass rc = new RunnableClass();
		rc.run(); // learn - run the runnable directly
		Thread t;
		t = new Thread(rc);// create thread using runnable
		t.run();

		// learn - creating runnable on the fly using anonymous class
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("runnable anonymous class"+Thread.currentThread().getName());
			}
		};
		// learn - creating runnable on the fly using lambda
		Runnable r2 = () -> {
			System.out.println("r2");
		};
		// learn - create thread from runnable and give name
		Thread tr2 = new Thread(r2, "tr2");

		Runnable r3 = () -> System.out.println("r2");
		Thread tr3 = new Thread(r3);

	}

	public static void main(String[] args) {


	}
}
