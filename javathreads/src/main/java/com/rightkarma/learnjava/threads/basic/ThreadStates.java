package com.rightkarma.learnjava.threads.basic;

public class ThreadStates implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		new ThreadStates().mainLogic();
	}

	private void mainLogic() throws InterruptedException {
		Thread t1 = new Thread(new ThreadStates(),"T1");
		printStatus(t1);
		Thread t2 = new Thread(new ThreadStates());
		printStatus(t2);
		System.out.println("---------------above status is before threads started.----------");
		t1.start();
		t2.start();
		printStatus(Thread.currentThread());
		Thread.sleep(1000);
		System.out.println("---------------above status is after threads started.----------");

		// runnables will print status as part of run and main will print as we call printStatus

		Thread.sleep(10000);
		System.out.println("---------------sleep 10000 over.----------");
		printStatus(Thread.currentThread());
		printStatus(t1);
		printStatus(t2);
	}

	@Override
	public void run() {
		printStatus(Thread.currentThread());
	}

	private void printStatus(Thread t1) {
		System.out.println(t1.getName()+"|"+t1.isAlive()+"|"+t1.getState()+"|"+t1.getPriority());
	}
}
