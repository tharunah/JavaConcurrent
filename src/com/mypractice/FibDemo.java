package com.mypractice;

public class FibDemo {

	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		FibDemo fibDemo = new FibDemo();
		for (int i = 0; i < 11; i++)
			System.out.println(fibDemo.fib(i));

		int a[] = { 0, 1, 5, 153 };
		for (int n : a) {
			System.out.println(n + " = " + fibDemo.anstraNumber(n));
		}
	}

	public boolean anstraNumber(int n) {
		int t = n;
		int i, m =0;
		while (n != 0) {
			i = n % 10;
			n = n / 10;
			m = m + (i * i * i);
		}
		if (t == m)
			return true;
		else
			return false;
	}

}
