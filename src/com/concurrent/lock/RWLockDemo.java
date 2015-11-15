package com.concurrent.lock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockDemo {

	final static int DELAY = 80;
	final static int NUITER = 5;

	public static void main(String[] args) {

		final Names names = new Names();

		class NamedThread implements ThreadFactory {

			String name;

			public NamedThread(String name) {
				this.name = name;
			}

			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r, name);
			}

		}

		ExecutorService wExecutor = Executors.newSingleThreadExecutor(new NamedThread("Writer"));
		Runnable wrunnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < NUITER; i++) {
					names.add(Thread.currentThread().getName(), "W" + i);
					try {
						Thread.sleep(DELAY);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		wExecutor.submit(wrunnable);

		ExecutorService rExecutor1 = Executors.newSingleThreadExecutor(new NamedThread("Reader1"));
		ExecutorService rExecutor2 = Executors.newSingleThreadExecutor(new NamedThread("Reader1"));

		Runnable rRunnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < NUITER; i++) {
					names.dump(Thread.currentThread().getName());
				}
			}
		};

		rExecutor1.submit(rRunnable);
		rExecutor2.submit(rRunnable);

		wExecutor.shutdown();
		rExecutor1.shutdown();
		rExecutor2.shutdown();
	}
}

class Names {
	private List<String> names;
	private ReentrantReadWriteLock rwlock;
	private Lock readLock, writeLock;

	public Names() {
		names = new ArrayList<>();
		rwlock = new ReentrantReadWriteLock(true);
		readLock = rwlock.readLock();
		writeLock = rwlock.writeLock();
	}

	public void add(String threadName, String name) {
		writeLock.lock();
		try {
			System.out.printf("%s : number of waiting thread %d%n", threadName, rwlock.getQueueLength());
			names.add(name);
		} finally {
			writeLock.unlock();
		}
	}

	public void dump(String threadName) {
		readLock.lock();
		try {
			System.out.printf("%s : number of thread waiting %d%n", threadName, rwlock.getQueueLength());
			Iterator<String> itr = names.iterator();
			while (itr.hasNext()) {
				System.out.printf("%s : %s%n", threadName, itr.next());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} finally {
			readLock.unlock();
		}
	}
}
