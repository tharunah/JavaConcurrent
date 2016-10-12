package com.practice.thread.concurrent;

public class MyReentrantLock {
	
	private int count =0;
	private boolean isLocked = false;
	private Thread lockedByThread = null;
	
	
	public synchronized void lock() throws InterruptedException{
		if(isLocked && Thread.currentThread() != lockedByThread){
			wait();
		}
		isLocked = true;
		lockedByThread = Thread.currentThread();
		count++;
	}
	
	public synchronized void unlock() throws InterruptedException{
		if(!isLocked || Thread.currentThread()!= lockedByThread){
		  return;	
		}
		count--;
		if(count ==0){
		  isLocked = false;
		  notify();
		}
	}

}
