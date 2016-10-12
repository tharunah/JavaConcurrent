import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckLock {

	
	private Lock lock = new ReentrantLock();
	public static void main(String[] args) {


CheckLock ck = new CheckLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				ck.getme();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ck.setme();
			}
		});
		t1.start();
		t2.start();
	}

	public  void getme() {
lock.lock();
		System.out.println("Im in get me.... ");
		throw new RuntimeException();
	}

	public synchronized void setme() {
  lock.lock();
		System.out.println("im in set me....");
	//	throw new NullPointerException();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.unlock();
	}
}
