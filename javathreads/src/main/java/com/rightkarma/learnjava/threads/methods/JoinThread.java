package com.rightkarma.learnjava.threads.methods;

import java.util.stream.IntStream;

public class JoinThread extends Thread{

	public static void main(String[] args) {
		JoinThread j1=new JoinThread();
		JoinThread j2=new JoinThread();
		JoinThread j3=new JoinThread();
		System.out.println("start pgm");
		j1.start();
		try {
			j1.join(); // learn - this will cause main thread to wait for j1 to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// learn - j2 and j3 will run in parallel
		j2.start();
		j3.start();

	}

	@Override
	public void run(){
//		try {
			String cT = this.getName();
			IntStream.range(0, 5).forEach(x -> System.out.printf("%s:%d%n", cT, x));
//			Thread.currentThread().sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
