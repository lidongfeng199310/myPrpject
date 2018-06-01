package com.ldf.java.thread.future;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 互斥
 * @author Edianzu
 *
 */
public class Synchronized {

	public static void main(String[] args) {
		new Synchronized().init();
	}
	
	private void init(){
		Output output = new Output();
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.lock("lidongfeng");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					output.lock("jilanyang");
				}
			}
		}).start();
	}
	
	static class Output{
		
		Lock lock = new ReentrantLock();
		public  void output(String name){
			int len = name.length();
			synchronized (Output.class) {
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		public  void lock(String name){
			int len = name.length();
			try {
				lock.lock();
				for(int i = 0;i<len;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			} catch (Exception e) {
			}finally {
				lock.unlock();
			}
		}
		
		public static synchronized  void output1(String name){
			for(int i = 0;i<name.length();i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
