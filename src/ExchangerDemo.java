import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerDemo {

	public static Exchanger<DataBuffer> exchanger = new Exchanger<>();
	public static DataBuffer initialEmptyBuffer = new DataBuffer();
	public static DataBuffer initialFullBuffer = new DataBuffer("Tharuna");

	public static void main(String[] args) {

		class FillingLoop implements Runnable {
			int count = 0;

			@Override
			public void run() {
				DataBuffer currentBuffer = initialEmptyBuffer;
				while (true) {
					addtoBuffer(currentBuffer);
					if (currentBuffer.isFull()) {
						System.out.println("Buffer full - Filling Loop thread wants to exchange");
						try {
							currentBuffer=exchanger.exchange(currentBuffer);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Waiting for exchange complete - Filling Thread");
					}
				}
			}

			private void addtoBuffer(DataBuffer currentBuffer) {
				String item = "Anil" + count++;
				System.out.println("Add - " + item);
				currentBuffer.add(item);
			}

		}

		class EmptyingLoop implements Runnable {

			@Override
			public void run() {
				DataBuffer currentBuffer = initialFullBuffer;
				while (true) {
					removeFromBuffer(currentBuffer);
					if (currentBuffer.isEmpty()) {
						System.out.println("Buffer empty - emptying thread wants to exchange");
						try {
							currentBuffer=exchanger.exchange(currentBuffer);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Waiting for exchange complete - Emptying Thread");
					}
				}
			}

			private void removeFromBuffer(DataBuffer currentBuffer) {
				System.out.println("Remove - " + currentBuffer.remove());
			}

		}
		new Thread(new FillingLoop()).start();
		new Thread(new EmptyingLoop()).start();
	}

}

class DataBuffer {
	private final static int MAX = 10;
	private List<String> items = new ArrayList<>();

	public DataBuffer() {
	}

	public DataBuffer(String prefix) {
		for (int i = 0; i < MAX; i++) {
			String value = prefix + i;
			System.out.println("Add - " + value);
			items.add(value);
		}
	}

	void add(String s) {
		if (!isFull()) {
			items.add(s);
		}
	}

	boolean isFull() {
		return items.size() == MAX;
	}

	boolean isEmpty() {
		return items.size() == 0;
	}

	String remove() {
		if (!isEmpty()) {
			return items.remove(0);
		}
		return null;
	}
}
