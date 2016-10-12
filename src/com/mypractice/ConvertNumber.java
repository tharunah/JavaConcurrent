package com.mypractice;

public class ConvertNumber {

	public int binaryToDecimal(int number) throws IllegalArgumentException {
		int decimal = 0;
		int binary = number;
		int power = 0;
		ThreadLocal<String> t = new ThreadLocal<>();
		while (binary != 0) {
			int lastDigit = binary % 10;
			if(lastDigit >1){
				throw new IllegalArgumentException("What the hell is it "+lastDigit);
			}
			//decimal += lastDigit * Math.pow(2, power);
			decimal += lastDigit * (1<<power);
		//	decimal += lastDigit * (1<<power);
			
			binary = binary / 10;
			power++;
		}

		return decimal;
	}

	public String decimalToBinary(int number) {
		int decimal = number;
		String binary = "";

		if (decimal == 0){
			return "0";
		}
		while (decimal > 0) {
			int rem = decimal % 2;
			binary = rem + binary;
			decimal = decimal / 2;
		}

		return binary;
	}

}
