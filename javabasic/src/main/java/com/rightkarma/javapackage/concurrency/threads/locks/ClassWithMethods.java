package com.rightkarma.javapackage.concurrency.threads.locks;

import java.util.Date;

public class ClassWithMethods {

		
	public synchronized void syncMethod1() {
		System.out.println("syncMethod1  "+new Date());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
	}

	public synchronized void syncMethod2() {
		System.out.println("syncMethod2  "+new Date());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
		}
	}



	
}
