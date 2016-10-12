package com.practice.thread.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PhoneBook {

	private Map<String, Person> namePhoneBook = new HashMap<>(100);
	private Map<String, Person> phNumberPhoneBook = new HashMap<>(100);
	private Lock readLock;
	private Lock writeLock;
	private ReadWriteLock reentrantLock;

	public PhoneBook() {
		reentrantLock = new ReentrantReadWriteLock();
		readLock = reentrantLock.readLock();
		writeLock = reentrantLock.writeLock();
	}

	public Person lockUpByName(String name) {
		try {
			readLock.lock();
			Person p = namePhoneBook.get(name);
			return p;
		} finally {
			readLock.unlock();
		}
	}

	public Person lockUpByPhoneNumber(String phNumber) {
		try {
			readLock.lock();
			Person p = namePhoneBook.get(phNumber);
			return p;
		} finally {
			readLock.unlock();
		}

	}

	public void addPerson(Person person) {
		try {
			writeLock.lock();
			namePhoneBook.put(person.getName(), person);
			phNumberPhoneBook.put(person.getPhNumber(), person);
		} finally {
			writeLock.unlock();
		}

	}

}
