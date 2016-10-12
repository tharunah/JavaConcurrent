package test.com.mypractice;

import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class TestProducerConsumer {

	public static void main(String[] args) {
		/*ProdConsumeObject pc = new ProdConsumeObject();
		Thread p = new Thread(new Producer(pc));
		Thread c = new Thread(new Consumer(pc));
		
		p.start();
		c.start();
		*//*
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
		Thread p = new Thread(new Producer(bq));
		Thread c = new Thread(new Consumer(bq));
		Runtime.getRuntime().addShutdownHook(p);
		
		
		p.start();
		c.start();*/
		String s ="abc";
		String s1 = new String("abc");
		String s3 = new String("abc");
		String s2 = "abc";
if(s1.equals(s3))
			System.out.println("true");
		else
			System.out.println("false");
	}
	
}
