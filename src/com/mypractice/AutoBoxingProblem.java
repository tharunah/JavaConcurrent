package com.mypractice;

public class AutoBoxingProblem {

	public static void main(String[] args) {
		Integer a = 100;
		Integer b = 100;
		
		
		if(a==b)
			System.out.println("true"); // result true
		else
			System.out.println("false");
		
		Integer d=138;
		Integer e=138;

		if(d==e) // result false
			System.out.println("true");
		else
			System.out.println("false");
	}

}
