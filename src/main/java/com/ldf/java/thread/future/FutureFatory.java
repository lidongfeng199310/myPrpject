package com.ldf.java.thread.future;

import java.util.concurrent.Callable;

public class FutureFatory implements Callable<String>{

	private String value;
	public FutureFatory(String variable) {
		value = variable;

	}
	@Override
	public String call() throws Exception {
		char[] c = new char[value.length()];
		 String v = value;
		for(int i=0;i<v.length();i++){
			c[i] = v.charAt(i);
			System.out.print(c[i]);
		}
		System.out.println();
		Thread.sleep(1000);
		return String.valueOf(c);
	}
	
}
