package com.rightkarma.jvm.gc;

import java.util.Deque;

public class TaskCreator {

	private Deque<Task> taskList;
	
	public TaskCreator(Deque<Task> taskList) {
		System.out.println("TaskCreator constructor");
		this.taskList=taskList;
	}

	public void createTask() {
		taskList.add(new Task());
	}

}

class Task {
	float[] mystring = new float[10000000];
}