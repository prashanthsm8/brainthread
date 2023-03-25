package Thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callex2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Future<Integer>> future = new ArrayList<Future<Integer>>();
		
		while(true)
		{
			int y = sc.nextInt();
			if(y==0)
			{
				break;
			}
			/*
			 * Callable<Integer> c = new Callable<Integer>() {
			 * 
			 * @Override public Integer call() throws Exception { return
			 * PrimeNumberUtil.print(y); } };
			 */
			
			/*
			 * ExecutorService es = Executors.newCachedThreadPool(); Future<Integer>
			 * primebox= es.submit(c); future.add(primebox);
			 */
			CompletableFuture.supplyAsync(()->PrimeNumberUtil.print(y)).
			thenAccept((Integer t)->System.out.println(t));
		}
		
		/*
		 * Iterator<Future<Integer>> it= future.iterator(); while(it.hasNext()) {
		 * Future<Integer> f = it.next(); if(f.isDone()) { System.out.println(f.get());
		 * } }
		 */
	}

}
