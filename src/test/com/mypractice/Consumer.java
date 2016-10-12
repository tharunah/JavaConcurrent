package test.com.mypractice;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	/*
	 * ProdConsumeObject pc;
	 * 
	 * public Consumer(ProdConsumeObject pc) { this.pc = pc; }
	 * 
	 * @Override public void run() { pc.consumer(); }
	 */

	BlockingQueue<Integer> bq;
     int i ;
	public Consumer(BlockingQueue<Integer> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {

		while(i<25){
			try {
				i= bq.take();
				System.out.println("Consumed --="+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
