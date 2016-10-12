package com.practice.thread.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sun.xml.internal.bind.v2.model.core.ID;

/*
 * There are 3 Threads in a process and each thread prints 1,1,1.. , 2,2,2...  and 3,3,3... respectivily
 * schedule a Thread to print in order 1,2,3,1,2,3..... 
 */
public class ThreadPrintSequncially {

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();

		 ThreadId id = new ThreadPrintSequncially.ThreadId();
		id.setId(1);
		Thread t1 = setThread(lock, condition, 1, 2, id);
		Thread t2 = setThread(lock, condition, 2, 3, id);
		Thread t3 = setThread(lock, condition, 3, 1, id);

		t1.start();
		t2.start();
		t3.start();
	}

	static class ThreadId {
		private int id;

		public ThreadId() {
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	private static Thread setThread(Lock lock, Condition condition,int actualThreadId, int nextThreadid, final ThreadId id){
		Thread t1 = new Thread(){
			@Override
			public void run(){
				while(true){
					try {
						lock.lock();
						while(id.getId() != actualThreadId)
							try {
								condition.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						System.out.println(actualThreadId);
						id.setId(nextThreadid);
						condition.signalAll();
					} finally {
						lock.unlock();
					}
				}
			}
		};
		
		return t1;
	}

}
