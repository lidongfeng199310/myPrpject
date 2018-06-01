package com.ldf.java.thread.future;

/**
 * 互斥通信
 * 子线程循环十次，主线一百次，又回到子线程，依次各执行五十次
 * @author Edianzu
 *
 */
public class SynchronizedWaitNotify {
	
	
	public static void main(String[] args) {
		new SynchronizedWaitNotify().init();
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
		//子线程
		public synchronized void sub(int i){
			while(flag){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=0;j<10;j++){
				System.out.println("sub thread "+i+"second\t"+j);
			}
			flag = true;
			this.notifyAll();
		}
		//主线程
		public synchronized void main(int i){
			while(!flag){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=0;j<100;j++){
				System.out.println("main thread "+i+"second\t"+j);
			}
			flag= false;
			this.notifyAll();
		}
	}

}
