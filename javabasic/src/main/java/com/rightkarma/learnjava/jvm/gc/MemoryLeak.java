package com.rightkarma.learnjava.jvm.gc;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemoryLeak {

	public static void main(String[] args) {
		Deque<Task> taskList = new ArrayDeque<Task>();
		final TaskCreator taskCreator = new TaskCreator(taskList);

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000000; i++) {
					taskCreator.createTask();
					try {
						System.out.println("sleeping..");
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("program is over");
			}
		}).start();
	}
}

