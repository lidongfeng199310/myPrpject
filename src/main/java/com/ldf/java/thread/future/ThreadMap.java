package com.ldf.java.thread.future;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ThreadMap {

	static int data = 0;
	static Map<Thread, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+"\tdata"+data);
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			System.out.println(Thread.currentThread().getName() +"A thread data "+ map.get(Thread.currentThread()));
		}
	}
	
	static class B{
		public void get(){
			System.out.println(Thread.currentThread().getName()+"B thread data "+ map.get(Thread.currentThread()));
		}
	}
}
