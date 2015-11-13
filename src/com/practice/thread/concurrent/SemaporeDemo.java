package com.practice.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaporeDemo {

	public static void main(String[] args) {
		final ItemPool pool = new ItemPool();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				while (true) {
					String item;

					try {
						System.out.printf("%s acquiring %s%n", name,
								item = pool.getItem());
						Thread.sleep(200 + ((int) Math.random() * 200));
						System.out.printf("%s putting back %s%n", name, item);
						pool.putItem(item);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		ExecutorService[] executorServices = new ExecutorService[pool.MAX_AVAILABLE + 12];

		for (int i = 0; i < executorServices.length; i++) {
			executorServices[i] = Executors.newSingleThreadExecutor();
			executorServices[i].execute(runnable);
		}

	}

}
