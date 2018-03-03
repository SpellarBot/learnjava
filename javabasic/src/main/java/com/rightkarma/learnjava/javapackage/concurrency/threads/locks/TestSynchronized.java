/* TO LEARN - threads lock objects not sync blocks. 
 * A class with 2 synchronized methods would still cause one of the threads to wait
 * while another thread finishes running the other sync method
*/
package com.rightkarma.learnjava.javapackage.concurrency.threads.locks;

import java.util.Date;

public class TestSynchronized {
	
	public static void main(String[] args) throws InterruptedException {
		

		final ClassWithMethods classWithMethods = new ClassWithMethods();

		Thread t1 = new Thread() {
			public void run() {
				classWithMethods.syncMethod1();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				classWithMethods.syncMethod2();
			}
		};

		t1.start();
		t2.start();

		/* 
		 * expect thread status:
		 * RUNNABLE - the thread that runs first 
		 * BLOCKED - thread that runs next
		 */
		System.out.println("t1 syncMethod1 "+t1.getState().toString() +"  " + new Date());
		System.out.println("t2 syncMethod2 "+t2.getState().toString() +"  " + new Date());
	}
}
