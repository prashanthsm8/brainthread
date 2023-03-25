package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Callable<String> cl = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "inside callable";
			}
		};
		
		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		

		Future<String> ft = es.submit(cl);
		System.out.println(ft.get());
	}

}
