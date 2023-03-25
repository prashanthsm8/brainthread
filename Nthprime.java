package Thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Nthprime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<Thread> lt = new ArrayList<>();
		Runnable rt = ()->{
			try {
			while(true)
				{
					printThreads(lt);
					Thread.sleep(5000);
				}
			}
			catch (InterruptedException e) {
				System.out.println("reporter thread interrupted");
			}
		};
		Thread statusrep = new Thread(rt);
		//statusrep.setDaemon(true);
		statusrep.start();
		
		while(true)
		{
			int y = sc.nextInt();
			if(y==0)
			{
				statusrep.interrupt();
				try
				{
				System.out.println("waititng for all threads to join");
				waitforthreads(lt);
				System.out.println("no of threads "+lt.size());
				}
				catch (Exception e) {
					System.out.println("wait threads interrrupted");
				}
				break;
			}
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					int number = PrimeNumberUtil.print(y);
					System.out.println(number);
					
				}
			};
			
			Thread myt = new Thread(r);
			lt.add(myt);
			myt.start();
		}
		
	}
	
	private static void printThreads(List<Thread> lt)
	{
		System.out.println("thread status");
		lt.forEach((t)->System.out.println( t.getState().toString() + " "));
	}
	
	private static void waitforthreads(List<Thread> lt) throws InterruptedException
	{
		for(Thread t : lt)
		{
			t.join();
		}
	}
	
}
