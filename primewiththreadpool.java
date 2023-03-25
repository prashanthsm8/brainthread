package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class primewiththreadpool {

	public static void main(String[] args) {
		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		ScheduledExecutorService reporterserv = Executors.newScheduledThreadPool(1);
		Runnable r1  = new Runnable() {
			public void run() {
				System.out.println("No of threads running" + es.getActiveCount());
				System.out.println("No of tasks completed"+ es.getCompletedTaskCount());
			}
		};
		reporterserv.scheduleAtFixedRate(r1, 3, 4, TimeUnit.SECONDS);
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			int y = sc.nextInt();
			if(y==0) break;
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					int number = PrimeNumberUtil.print(y);
					System.out.println(number);
					
				}
			};
			
			es.execute(r);
		
		}
		
	}

}
