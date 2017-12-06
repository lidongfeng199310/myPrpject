package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		FutureTask<?>[] task = new FutureTask<?>[100];
		for(int i=0;i<100;i++){
			task[i] = new FutureTask<>(new FutureFatory("abcdefj"+i+""));
		}
		for(int i=0;i<100;i++){
			executorService.submit(task[i]);
		}
		for(int i=0;i<100;i++){
			System.out.println(task[i].get());;
		}
	}
	
	
}
