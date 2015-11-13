package com.practice.thread.concurrent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class ReadWebPage {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<List<String>> callable;

		callable = new Callable<List<String>>() {
			@Override
			public List<String> call() throws IOException,
					MalformedURLException {
				List<String> lines = new ArrayList<String>();
				URL url = new URL(
						"http://www.javaworld.com/article/2990828/core-java/java-101-primer-composition-and-inheritance.html");
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();
				InputStreamReader isr = new InputStreamReader(
						con.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				String line;
				while ((line = br.readLine()) != null)
					lines.add(line);
				return lines;
			}

		};
		Future<List<String>> result = executorService.submit(callable);

		try {
//			List<String> lines = result.get(10, TimeUnit.SECONDS);
			List<String> lines = result.get();
			
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
/*		} catch (TimeoutException e) {
			e.printStackTrace();
*/		}
		executorService.shutdown();
	}
}
