package test.com.mypractice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic implements Runnable {

	static AtomicInteger a = new AtomicInteger(0);
	int m = 1;
	static AtomicBoolean flag = new AtomicBoolean(false);

	/*
	 * private int myCounter; private int myPrevCounter; private int
	 * myCounterPlusFive; private boolean isNine;
	 * 
	 * public void run() { myCounter = at.incrementAndGet();
	 * System.out.println("Thread " + Thread.currentThread().getId() +
	 * "  / Counter : " + myCounter); myPrevCounter = at.getAndIncrement();
	 * System.out.println("Thread " + Thread.currentThread().getId() +
	 * " / Previous : " + myPrevCounter); myCounterPlusFive = at.addAndGet(5);
	 * System.out.println("Thread " + Thread.currentThread().getId() +
	 * " / plus five : " + myCounterPlusFive); isNine = at.compareAndSet(9, 3);
	 * if (isNine) { System.out.println("Thread " +
	 * Thread.currentThread().getId() +
	 * " / Value was equal to 9, so it was updated to " + at.intValue()); }
	 * 
	 * }
	 * 
	 */
	@Override
	public void run() {
		/*
		 * do { if (flag) { // b = a.getAndDecrement();
		 * System.out.println(" decrement - Thread- " +
		 * Thread.currentThread().getName() + "-" + a.getAndDecrement()); } else
		 * { // b = a.getAndIncrement();
		 * System.out.println(" Increment -Thread- " +
		 * Thread.currentThread().getName() + "-" + a.getAndIncrement()); } }
		 * while (a.get() != 0);
		 */ 
		if (Thread.currentThread().getName().equals("A")) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a = null;
		} else {
			a = new AtomicInteger(0);
		}
		m = a.incrementAndGet();
		
		do{
		try {
			Thread.sleep(1000);
			System.out.println("im loping");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(!flag.get());
		System.out.println(" visitor no--" + m);
	}
	
	static Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
	    public void uncaughtException(Thread th, Throwable ex) {
	    	flag.compareAndSet(false, true);
	        System.out.println("Uncaught exception: " + ex);
	    }
	};


	public static void main(String[] args) {
		Thread t1 = new Thread(new TestAtomic(), "A");
		Thread t2 = new Thread(new TestAtomic(), "B");
		// Thread t3 = new Thread(new TestAtomic(), "C");

		
		t1.start();
		t1.setUncaughtExceptionHandler(h);
		t2.start();
		t2.setUncaughtExceptionHandler(h);
		// t3.start();
        
	}

	
}
