package com.concurrent.lock;

public class ProduceConsumeSynch {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Thread t1 = new Thread(new Producer(shared));
		Thread t2 = new Thread(new Consumer(shared));
		t1.start();
		t2.start();
	}
	
	
}

class Shared {
	volatile boolean evenProduced = false;
	volatile Integer number;

	public synchronized void produceNumber(Integer number) {
		if (evenProduced)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.number = number;
		evenProduced = true;
		System.out.println("Number produced " + this.number);
		notify();
	}

	public synchronized void consumeNumber() {
		if (!evenProduced)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("number consumed " + this.number);
		evenProduced = false;
		number = null;
		notify();
	}
}

class Producer implements Runnable
{

	Shared shared;
	public Producer(Shared shared) {
		this.shared = shared;
	}
	@Override
	public void run() {
       for(int i =0; i<11 ; i++){
    	 shared.produceNumber(i);
    	// System.out.println("Produced by producer");
       }
	}
	
}

class Consumer implements Runnable{

	Shared shared;
	
	public Consumer(Shared shared) {
      this.shared = shared;
	}
	@Override
	public void run() {
		do {
			shared.consumeNumber();
			//System.out.println("Consumer Consumed the number");
			
		}while(true);
	}

}