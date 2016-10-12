package com.practice.thread.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintListOrder {

	public static void main(String[] args) {

		final List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 4, 7, 10, 13));
		final List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 5, 8, 11, 14));
		final List<Integer> l3 = new ArrayList<>(Arrays.asList(3, 6, 9, 12, 15));

		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		final ThreadId id = new PrintListOrder.ThreadId();
		id.setId(1);
		Thread t1 = getThread(lock, condition, 1, 2, l1, id);
		Thread t2 = getThread(lock, condition, 2, 3, l2, id);
		Thread t3 = getThread(lock, condition, 3, 1, l3, id);

		t1.start();
		t2.start();
		t3.start();

	}

	static class ThreadId {
		private int id;

		public void setId(int i) {
			id = i;
		}

		public int getid() {
			return id;
		}
	}

	public static Thread getThread(Lock lock, Condition condition, int currentThreadId, int nextthreadID,
			List<Integer> list, ThreadId id) {
		Thread t = new Thread() {

			public void run() {
				for (Integer i : list) {
					try {
						lock.lock();
						while (currentThreadId != id.getid())
							try {
								condition.await();
							} catch (InterruptedException ie) {
								ie.printStackTrace();
							}
						System.out.println(i.toString());
						id.setId(nextthreadID);
						condition.signalAll();
					} finally {
						lock.unlock();
					}
				}
			}
		};

		return t;
	}
}
