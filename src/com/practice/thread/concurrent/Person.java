package com.practice.thread.concurrent;

public class Person {

	private String name;
	private String phNumber;

	public Person(String name, String phNumber) {
		this.name = name;
		this.setPhNumber(phNumber);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phNumber
	 */
	public String getPhNumber() {
		return phNumber;
	}

	/**
	 * @param phNumber the phNumber to set
	 */
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	

}
