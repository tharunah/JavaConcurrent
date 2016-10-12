package com.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import sun.applet.Main;

public class PipeExample {

	public static void main(String... arg) throws IOException {
		PipedOutputStream output = new PipedOutputStream();
		PipedInputStream input = new PipedInputStream(output);

		Thread t1 = new Thread(new Runnable() {
 
			@Override
			public void run() {
				try {
					output.write("this is thread 1".getBytes());
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int c = input.read();
					while (c != -1) {
						System.out.print((char) c);
						c = input.read();

					}
					input.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
