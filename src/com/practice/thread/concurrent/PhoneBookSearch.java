package com.practice.thread.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhoneBookSearch {

	public static void main(String[] args) throws InterruptedException {

		Person person = new Person("Tharun", "902270111");
		Person person1 = new Person("Tharun1", "902270111");
		PhoneBook pb = new PhoneBook();
		pb.addPerson(person);
		Runnable task = () -> {
			Person p = pb.lockUpByName("Tharun");
			if (p != null)
				System.out.println(p.getName());
		};

		Runnable task1 = () -> {
			Person p = pb.lockUpByPhoneNumber("902270111");
			if (p != null)
				System.out.println(p.getPhNumber());
		};

		Runnable task3 = () -> {
			pb.addPerson(person1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("added..........");
			pb.addPerson(person);
		};

		ExecutorService[] executors = new ExecutorService[] { Executors.newFixedThreadPool(25), Executors.newFixedThreadPool(25),
				Executors.newFixedThreadPool(25) };

		for (int i = 0; i < 100; i++) {
			executors[0].execute(task);
			executors[1].execute(task1);
			executors[2].execute(task3);
			Thread.sleep(10);
		}
	   
		for(ExecutorService e:executors){
			e.shutdown();
		}
    
	}

}
