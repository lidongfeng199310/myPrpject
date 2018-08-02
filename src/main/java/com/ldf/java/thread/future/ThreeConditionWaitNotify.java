package com.ldf.java.thread.future;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 互斥通信 Condition
 * 子线程循环十次，主线一百次，又回到子线程，依次各执行五十次
 * @author Edianzu
 *
 */
public class ThreeConditionWaitNotify {
	
	
	public static void main(String[] args) {
		new ThreeConditionWaitNotify().init();
	}
	
	private void init(){
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for(int i = 0;i<50;i++){
					business.sub2(i);
				}
			}
		}).start(); 
		
		new Thread(new Runnable() {
			public void run() {
				for(int i = 0;i<50;i++){
					business.sub3(i);
				}
			}
		}).start(); 
		
		for(int i = 0;i<50;i++){
			business.main(i);
		}
	}
	
	class Business{
		boolean flag = false;
		Lock lock = new ReentrantLock(); 
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();
		private int shouldSub = 1;
		//子线程
		public  void sub2(int i){
			try{
				lock.lock();
				
				while(shouldSub != 2){
					try {
						condition2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<10;j++){
					System.out.println("sub2 thread "+i+"second\t"+j);
				}
				flag = true;
				shouldSub = 3;
				condition3.signal();
			}catch (Exception e) {
				lock.unlock();
			}
			
		}
		
		//子线程
				public  void sub3(int i){
					try{
						lock.lock();
						while(shouldSub != 3){
							try {
								condition3.await();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for(int j=0;j<20;j++){
							System.out.println("sub3 thread "+i+"second\t"+j);
						}
						flag = true;
						shouldSub = 1;
						condition1.signal();
					}catch (Exception e) {
						lock.unlock();
					}
					
				}
		
		//主线程
		public  void main(int i){
			try{
				lock.lock();
				while(shouldSub != 1){
					try {
						condition1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<100;j++){
					System.out.println("main thread "+i+"second\t"+j);
				}
				flag= false;
				shouldSub = 2;
				condition2.signal();
			}catch (Exception e) {
				lock.unlock();
			}
		}
	}

}
