package com.practice.thread.concurrent;

public class ExceptionTest {

	public void testException() throws Exception {
		try {
			System.out.println("Try Block");
			throw new Exception("from try");
		} catch (Exception ex) {
			System.out.println("Catch Block");
			throw new Exception("from catch");
		} finally {
			System.out.println("Finally block");
			throw new Exception("From Finally");
		}

	}
	
	public static void main(String[] args) throws Exception {
		ExceptionTest exp = new ExceptionTest();
		exp.testException();
		
	}

}
