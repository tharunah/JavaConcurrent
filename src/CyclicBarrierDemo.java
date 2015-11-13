import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		Runnable barrierAction = new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.printf(" Thread %s executing Barrier action %n", name);
			}
		};

		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, barrierAction);

		Runnable task = new Runnable() {

			@Override
			public void run() {
                 String name = Thread.currentThread().getName();
                 System.out.printf("Thread %s about to join game %n", name);
                 try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		};
		
		ExecutorService[] executorService = new ExecutorService[] {
				                             Executors.newSingleThreadExecutor(),
				                             Executors.newSingleThreadExecutor(),
				                             Executors.newSingleThreadExecutor()
		};
		for(ExecutorService executorService2 : executorService){
			executorService2.execute(task);
			executorService2.shutdown();
		}
	}

}
