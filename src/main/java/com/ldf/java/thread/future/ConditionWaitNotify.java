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
public class ConditionWaitNotify {
	
	
	public static void main(String[] args) {
		new ConditionWaitNotify().init();
	}
	
	private void init(){
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for(int i = 0;i<50;i++){
					business.sub(i);
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
		Condition condition = lock.newCondition();
		//子线程
		public  void sub(int i){
			try{
				lock.lock();
				while(flag){
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<10;j++){
					System.out.println("sub thread "+i+"second\t"+j);
				}
				flag = true;
				condition.signal();
			}catch (Exception e) {
				lock.unlock();
			}
			
		}
		//主线程
		public  void main(int i){
			try{
				lock.lock();
				while(!flag){
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=0;j<100;j++){
					System.out.println("main thread "+i+"second\t"+j);
				}
				flag= false;
				condition.signal();
			}catch (Exception e) {
				lock.unlock();
			}
		}
	}

}
