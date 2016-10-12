package com.practice.thread.concurrent;

import java.util.TreeMap;

public class ChangeValue {

	
	public static void main(String[] args) {
		ChangeValue changeValue = new ChangeValue();
		changeValue.changes(867);
	}
	
	public void changes(int value) {

		if (value != 0) {

			int quaters;
			int dimes;
			int nickels;
			int pennies;

			quaters = value / 25;
			value = value % 25;
			dimes = value / 10;
			value = value % 10;
			nickels = value / 5;
			value = value % 5;
			pennies = value / 1;

			System.out.println(
					"Quaters= " + quaters + " Dimes =" + dimes + " Nickels = " + nickels + " Pennies =" + pennies);

		}
	}

}
