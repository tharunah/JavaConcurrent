package com.practice.thread.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerTest {
	static int i = 1;
//	static Runtime runtime = Runtime.getRuntime();
	static Executor pool = Executors.newFixedThreadPool(20);

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		while (i < 10000) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					System.out.println("Value of I is " + i++);
					doWork();
				}
			};
			pool.execute(runnable);//new Thread(runnable).start();
			/*System.out.println("Memory Usage: "
					+ ((runtime.totalMemory() - runtime.freeMemory()) / 1048576));*/
		}
		
	}

	public static void doWork() {
		Runtime runtime = Runtime.getRuntime();
		//System.out.println("Value of I is " + i++);
		System.out.println("Memory Usage: "
				+ (runtime.totalMemory() - runtime.freeMemory()));
//		try {
//			Thread.sleep(500000);
//		} catch (InterruptedException ie) {
//
//		}
	}

}
