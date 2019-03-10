package com.rightkarma.learnjava.threads.methods;


// learn methods
// Static Methods
// activeCount()
// currentThread()
// enumeraate(Thread[] tarr) - populates array with active threads.
// sleep(millis) - sleep or stop exec
//
// Non-Static Methods
// join() - waits for this thread to die. returns number of threads
// interrupt() - if you want to stop the thread. returns ref to current thread
//


public class ThreadMethods {
	public static void main(String[] args) throws InterruptedException {


		System.out.println(Thread.activeCount()); // estimated number of threads - at this time 2 - main and Monitor
		MyThread t1= new MyThread();
		MyThread t2= new MyThread();
		MyThread t3= new MyThread();
		t1.start();
		t2.start();
		t3.start();
		System.out.println("New threads sleeping");
		System.out.println("Active Count:"+Thread.activeCount()); // estimated number of threads - at this time - 5
		System.out.println("Current Thread:"+Thread.currentThread()); // main thread
		Thread[] tarr= new Thread[10]; // gets all 5 threads
		Thread.enumerate( tarr  );
		for(Thread t:tarr){
			if (null==t)
				break;
			System.out.println("Thread:"+t.getName());
		}

//		Thread.currentThread().join();
		Thread.currentThread().sleep(12000);


	}

	static class MyThread extends Thread{
		@Override
		public void run(){
			System.out.println("putting thread to sleep:"+this.getName());
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
