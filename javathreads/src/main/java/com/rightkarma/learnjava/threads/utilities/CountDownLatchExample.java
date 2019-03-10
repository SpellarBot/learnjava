package com.rightkarma.learnjava.threads.utilities;

import java.util.concurrent.CountDownLatch;

// learn -

public class CountDownLatchExample {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(4);

		System.out.println(Thread.currentThread().getName()+" - start work in main. start: "+start.getCount());
		System.out.println(Thread.currentThread().getName()+" - start work in main. end: "+end.getCount());

		for ( int i = 0 ;i< 2;i++){
			new Thread(new Worker(start, end)).start();
		}

		System.out.println(Thread.currentThread().getName()+" - after calling threads. start: "+start.getCount());
		System.out.println(Thread.currentThread().getName()+" - after calling threads. end: "+end.getCount());

		start.countDown();// let all threads proceed
		System.out.println(Thread.currentThread().getName()+" - after start.countDown(). start: "+start.getCount());
		System.out.println(Thread.currentThread().getName()+" - after start.countDown(). end: "+end.getCount());


		end.await();// wait until count reaches zero or its interrupted by another Thread.
		System.out.println(Thread.currentThread().getName()+" - end work in main. start: "+start.getCount());
		System.out.println(Thread.currentThread().getName()+" - end work in main. end: "+end.getCount());
	}
}

class Worker implements Runnable{

	private final CountDownLatch start;
	private final CountDownLatch end;

	Worker(CountDownLatch start, CountDownLatch end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+" - start work. start: "+start.getCount());
			System.out.println(Thread.currentThread().getName()+" - start work. end: "+end.getCount());
			start.await(); // waits for start count to be zero. that's why in main class we do start.countDown()
			System.out.println(Thread.currentThread().getName()+" - after thread start.await(). start: "+start.getCount());
			System.out.println(Thread.currentThread().getName()+" - after thread start.await(). end: "+end.getCount());
			Thread.sleep(2000);
			end.countDown();  // this will reduce the count specified in CountDownLatch
			System.out.println(Thread.currentThread().getName()+" - end work. start: "+start.getCount());
			System.out.println(Thread.currentThread().getName()+" - end work. end: "+end.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}