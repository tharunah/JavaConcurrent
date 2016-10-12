package test.com.mypractice;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable{

	/*ProdConsumeObject pc;
	
	public Producer(ProdConsumeObject pc) {
     this.pc = pc;
	}*/
	
	BlockingQueue<Integer> bq;
	int i =0;
	public Producer(BlockingQueue<Integer> bq) {
        this.bq = bq;
	}
	
	
	@Override
	public void run() {
      	while(i<20)
			try {
				bq.put(++i);
				System.out.println("Produced --="+i);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};	
	}

}
