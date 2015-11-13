package com.mypractice;

import java.util.Scanner;

public class PerfectNumber {


	private static void isPerfectNumber(int number) {
		int temp = 0;
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				System.out.println(i);
				temp += i;
			}
		}
		if (temp == number) {
			System.out.println("Perfect Numer ");
		} else {
			System.out.println("Its not a perfect number");
		}
	}

	public static void main(String... a){
		System.out.println("Enter the number to check Its perfect no or not"); 
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		isPerfectNumber(number);
		sc.close();
	}
}
