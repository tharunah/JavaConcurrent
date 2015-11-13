package com.mypractice;

public class JavaMemory {
	private final int dataSize = (int) (Runtime.getRuntime().maxMemory() * 0.6);

	public void f() {		
		{
			System.out.println(dataSize);
			byte[] data = new byte[dataSize];
		}
		
		// Gives an error if you comment this loop
		/*
		 * for (int i = 0; i < 10; i++) {
		 * System.out.println("Please be so kind and release memory"); }
		 */
		System.out.println(dataSize);
		byte[] data2 = new byte[dataSize];
	}

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().maxMemory());
		JavaMemory jmp = new JavaMemory();
		jmp.f();
	}
}
