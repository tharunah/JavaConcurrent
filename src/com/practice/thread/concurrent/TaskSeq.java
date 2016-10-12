package com.practice.thread.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskSeq {
	static int i=1;
	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();
		Runnable task = ()-> { System.out.println("Task- "+i++);};
		
		for(int i=0;i<100;i++){
			executor.execute(task);
		}
	}

}
