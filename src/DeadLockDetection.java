import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DeadLockDetection {

	public void display1() {
		synchronized (String.class) {
			synchronized (Integer.class) {
				System.out.println("Display1....");
			}
		}
	}

	public void display2() {
		synchronized (Integer.class) {
			synchronized (String.class) {
				System.out.println("display2....");

			}

		}
	}

	public static void main(String[] args) {
		DeadLockDetection deadLockDetection = new DeadLockDetection();
		Runnable task1 = () -> {
			deadLockDetection.display1();
		};
		Runnable task2 = () -> {
			deadLockDetection.display2();
		};

		Executor executor = Executors.newCachedThreadPool();
		executor.execute(task1);
		executor.execute(task2);

		deadLockDetection.detectDeadLock();

	}

	public void detectDeadLock() {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] ti = threadMXBean.dumpAllThreads(true, true);
		for (ThreadInfo t : ti)
			System.out.println(t);
		long tl[] = threadMXBean.findDeadlockedThreads();
		if (tl != null) {
           ti =threadMXBean.getThreadInfo(tl, true,true);
           for (ThreadInfo t : ti)
   			System.out.println(t);
   		
		}

	}

}
