package com.rightkarma.learnjava.javapackage.concurrency.threads;

import java.util.Date;

public class SynchroDemo implements Runnable {

	private Target target;
	private int threadId;

	public SynchroDemo(Target t, int threadId) {
		this.target = t;
		this.threadId = threadId;
	}

	@Override
	public void run() {
		int i = 3;
		while (i > 0) {
			// all three blocks execute this, and targetId is not consistent unless
			// synchronized
//			synchronized (target) {

				target.setTargetId(threadId);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				target.call(threadId);
				i--;
//			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("START:"+new Date());
		Target t = new Target();
		SynchroDemo s1 = new SynchroDemo(t, 1);
		SynchroDemo s2 = new SynchroDemo(t, 2);
		SynchroDemo s3 = new SynchroDemo(t, 3);
		Thread t1=new Thread(s1);
		Thread t2=new Thread(s2);
		Thread t3=new Thread(s3);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("END:"+new Date());
	}

}

class Target {
	int targetId;

	public Target() {

	}

	public void setTargetId(int i) {
		targetId = i;
	}

	public void call(int threadId) {
		System.out
				.println("targetId : " + targetId + " threadId : " + threadId + " Thread : " + Thread.currentThread());
	}
}

/*OUTPUT

START:Sun Sep 10 16:09:03 IST 2017
targetId : 3 threadId : 1 Thread : Thread[Thread-0,5,main]
targetId : 3 threadId : 3 Thread : Thread[Thread-2,5,main]
targetId : 3 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 2 threadId : 1 Thread : Thread[Thread-0,5,main]
targetId : 2 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 2 threadId : 3 Thread : Thread[Thread-2,5,main]
targetId : 3 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 3 threadId : 3 Thread : Thread[Thread-2,5,main]
targetId : 3 threadId : 1 Thread : Thread[Thread-0,5,main]
END:Sun Sep 10 16:09:06 IST 2017

when Synchronized , runs longer but targetId is correct.

targetId : 1 threadId : 1 Thread : Thread[Thread-0,5,main]
START:Sun Sep 10 16:08:35 IST 2017
targetId : 1 threadId : 1 Thread : Thread[Thread-0,5,main]
targetId : 1 threadId : 1 Thread : Thread[Thread-0,5,main]
targetId : 1 threadId : 1 Thread : Thread[Thread-0,5,main]
targetId : 2 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 2 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 2 threadId : 2 Thread : Thread[Thread-1,5,main]
targetId : 3 threadId : 3 Thread : Thread[Thread-2,5,main]
targetId : 3 threadId : 3 Thread : Thread[Thread-2,5,main]
targetId : 3 threadId : 3 Thread : Thread[Thread-2,5,main]
END:Sun Sep 10 16:08:44 IST 2017
*/
		