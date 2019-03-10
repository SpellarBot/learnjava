package com.rightkarma.learnjava.threads.methods;

import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class SynchronizedBlock {

	public static void main(String[] args) {
		SynchronizedBlock sb = new SynchronizedBlock();

		Runnable r1 =  new Runnable() {
			@Override
			public void run() {
				sb.methodWithoutSyncBlock();
				sb.methodWithSyncBlock();
			}
		};
//		Runnable r2 = () -> sb.methodWithSyncBlock(); // learn using Lambda
		Thread t1=new Thread(r1,"T1");
		Thread t2=new Thread(r1,"T2");
		t1.start();
		t2.start();
	}

	// learn - prints immediately
	public void methodWithoutSyncBlock(){
		System.out.println("methodWithoutSyncBlock code:"+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// learn - prints one after the other
	public synchronized void methodWithSyncBlock(){
		System.out.println("methodWithSyncBlock code:"+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
