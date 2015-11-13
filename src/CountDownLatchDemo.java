import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	final static int N = 3;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);
		for (int i = 0; i < N; i++)
			new Thread(new Worker(startSignal, doneSignal)).start();
		System.out.println("About to let thread processed");
		startSignal.countDown();
		System.out.println("Doih work");
		System.out.println("Waiting for thread to finish");
		doneSignal.await();
		System.out.println("Main thread terminating");
	}

}

class Worker implements Runnable {

	public static int N = 5;
	CountDownLatch startSignal;
	CountDownLatch doneSignal;

	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {

		try {
			String name = Thread.currentThread().getName();
			startSignal.await();
			for (int i = 0; i < N; i++) {
				System.out.printf(" %s Thread is working %n", name);
				Thread.sleep((int) Math.random() * 200);
				System.out.printf("%s Thread Finished %n", name);
				doneSignal.countDown();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}