package com.mypractice;

import java.util.HashSet;
import java.util.Set;

public class PrintPair {

	public void printPait(int[] arr, int sum) {
		Set<Integer> set = new HashSet<>();
		int target;
		for (int a : arr) {
			target = sum - a;
			if (set.contains(target)) {
				System.out.println("(" + target + "," + a + ")");
			} else {
				set.add(a);
				set.add(sum-a);
			}
		}

	}
	
	
	
	public static void main(String[] args) {
		PrintPair p = new PrintPair();
		int [] arr = {10,5,3,2,3};
		p.printPait(arr, 15);
	}

}
