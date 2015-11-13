package com.practice.thread.concurrent;

import java.util.concurrent.Semaphore;


public class ItemPool {

	public static int MAX_AVAILABLE = 10;
	private String[] items;
	private boolean[] used = new boolean[MAX_AVAILABLE];

	Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

	public ItemPool() {
		items = new String[MAX_AVAILABLE];
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			items[i] = "Item " + i;
		}
	}

	public String getItem() throws InterruptedException {
		semaphore.acquire();
		return getNextAvailableItem();
	}

	public void putItem(String item) {
		if (markUnused(item))
			semaphore.release();
	}

	private synchronized String getNextAvailableItem() {

		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}

	private synchronized boolean markUnused(String item) {
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else
					return false;
			}
		}
		return false;
	}

}
