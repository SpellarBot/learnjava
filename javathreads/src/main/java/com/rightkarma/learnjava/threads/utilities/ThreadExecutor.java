package com.rightkarma.learnjava.threads.utilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadExecutor {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(5);
		int i;

		for ( i = 0 ; i< 10;i++){
			Runnable r = new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread:"+Thread.currentThread().getName());
					try {
						Thread.currentThread().sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} ;
			es.submit(r);
		}

		es.shutdown();
	}

}

