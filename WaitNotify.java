package Thread;

public class WaitNotify {

	int counter =0;
	boolean isav;
	
	public static void main(String[] args) throws InterruptedException {
		WaitNotify wn = new WaitNotify();
		
		Thread consumer = new Thread(()->{
			while(true)
			{
				
				try {
					Thread.sleep(2000);
					System.out.println("read val from cos"+ Thread.currentThread().getName()+" "
							+wn.read());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread producer = new Thread(()->{
			while(true)
			{
				try {
					Thread.sleep(2000);
					wn.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		consumer.start();
		
producer.start();
producer.join();
consumer.join();

	}
	
	private synchronized void increment() throws InterruptedException {
		while(isav)
		{
			wait();
		}
		isav=true;
		notify();
	}

	public synchronized int read() throws InterruptedException
	{
		while(!isav)
		{
			wait();
		}
		counter++;
		isav = false;
		notify();
		return counter;
		
	}

}
