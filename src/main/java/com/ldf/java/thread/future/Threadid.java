package com.ldf.java.thread.future;

/**
 * 两个线程，对同一个变量进行增加两个 ，减少两次
 * 线程变量共享
 * @author Edianzu
 *
 */
public class Threadid {
	public static void main(String[] args) {
		Hander hander =new Threadid().new Hander(); 
		for (int i = 0; i < 2; i++) {
			new Thread(new Threadid().new MyHander1(hander)).start();
			new Thread(new Threadid().new MyHander2(hander)).start();
			new Thread(new Runnable() {
				public void run() {
					hander.increment();
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					hander.decrement();;
				}
			}).start();
		}
	}

	class Hander {
		private int j = 0;
		private synchronized void increment(){
			j++;
			System.out.println("this increment 加 thread increase inc\t" + j);
		}
		
		private synchronized void decrement(){
			j--;
			System.out.println("this decrement 减 thread decrement inc\t" + j);
		}
	}
	
	class MyHander1 implements Runnable{
	    private	Hander hander;
	    public MyHander1(Hander hander) {
	    	this.hander = hander;
		}
		@Override
		public void run() {
			hander.increment();
		}
	}
	
	class MyHander2 implements Runnable{
	    private	Hander hander;
	    public MyHander2(Hander hander) {
	    	this.hander = hander;
		}
		@Override
		public void run() {
			hander.decrement();
		}
	}

}
