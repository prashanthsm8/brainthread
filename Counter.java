package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {
	
	public Integer i=10;
	int val=0;
	private Lock l = new ReentrantLock();
	
	public void increment()
	{
		try
		{
			val++;
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			System.out.println("exception");
		}
	}
	
	public void decrement()
	{
		 val--;
	}
	
	public int getval() {
		return val;
	}

	@Override
	public void run() {

		/*
		 * synchronized (this) { this.increment();
		 * System.out.println(Thread.currentThread().getName()+" val "+this.getval());
		 * this.decrement();
		 * System.out.println(Thread.currentThread().getName()+" val "+this.getval()); }
		 */
		l.lock();
		try
		{
			this.increment();
			System.out.println(Thread.currentThread().getName()+" val "+this.getval());
			this.decrement();
			System.out.println(Thread.currentThread().getName()+" val "+this.getval());
		}
		finally {
			l.unlock();
		}
		
	}

}
