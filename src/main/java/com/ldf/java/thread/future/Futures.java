package com.ldf.java.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		Future<String> result = executorService.submit(new Futer());
//		try {
//			System.out.println(result.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
		
		CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		for(int i=0;i<5;i++){
			final String seq = i+"";
			completionService.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return seq;
				}
			});
		}
		
		for(int i=0;i<5;i++){
			try {
				System.out.println(completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}

}

class Futer implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(3200);
		return "ldfTEst";
	}

}
