package com.concurrent.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ReentrantLock reentrantLock = new ReentrantLock();

		class Worker implements Runnable {
			String name;

			public Worker(String name) {
				this.name = name;
			}

			@Override
			public void run() {
				reentrantLock.lock();
				try {
					if (reentrantLock.isHeldByCurrentThread())
						System.out.printf("Thread %s entered the critical section %n", name);
					System.out.printf("Thread %s is performing 2 sec work %n ", name);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("Thread %s finished the work %n", name);
				} finally {
					reentrantLock.unlock();
				}
			}
		}

		executorService.execute(new Worker("A"));
		executorService.execute(new Worker("B"));

		try {
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdownNow();

	}

}
