package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Executor ex =Executors.newFixedThreadPool(10);
		for(int i=1;i<=100;i++)
		{
			ex.execute(new NumberPrinter(i));
		}
	}

}
