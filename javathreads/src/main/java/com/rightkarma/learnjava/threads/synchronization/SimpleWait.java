package com.rightkarma.learnjava.threads.synchronization;

public class SimpleWait {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		mt.start();
		// learn - after starting mt, how do you ensure that it finishes before main thread continues ?
		// put a wait command.

		// mt.wait(); - this if put outside synchronized block will cause IllegalMonitorStateException because to call wait, thread should first have lock on the object
		synchronized (mt){
			mt.wait();
		}
		System.out.println(mt.sum);
	}
}

class MyThread extends Thread{

	int sum=0;
	@Override
	public void run(){
		synchronized (this){
			sum=sum+100;
		}
	}
}