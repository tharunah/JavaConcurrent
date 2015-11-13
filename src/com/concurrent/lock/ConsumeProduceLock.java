package com.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumeProduceLock {
  
	public static void main(String[] args) {
		Shared1 shared = new Shared1();
		new Thread(new Produce1(shared)).start();
		new Thread(new Consume1(shared)).start();
	}
}

class Shared1 {
	boolean numberProduced = false;
	Integer number;
	final ReentrantLock lock = new ReentrantLock();
	final Condition condition = lock.newCondition();

	public void numberProducer(Integer number) {
		lock.lock();
		try {
			if (numberProduced)
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			this.number = number;
			System.out.println("Number produced : " + number);
			numberProduced = true;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public void numberConsume() {
		lock.lock();
		try {
			if (!numberProduced)
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             numberProduced = false;
			System.out.println("Number consumed : " + number);
			this.number = null;
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}

class Produce1 implements Runnable {

	final Shared1 shared;

	public Produce1(Shared1 shared) {
		this.shared = shared;
	}

	@Override
	public void run() {
      for(int i=0; i<11;i++){
    	  shared.numberProducer(i);
      }
	}

}

class Consume1 implements Runnable {
     final Shared1 shared;
     
     public Consume1(Shared1 shared) {
      this.shared = shared;
     }
	
	@Override
	public void run() {
      do {
    	  shared.numberConsume();
      }while(true);
	}
	
}
