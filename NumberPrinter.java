package Thread;

public class NumberPrinter implements Runnable {
	
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println(getNumber()+": "+Thread.currentThread().getName());
		
	}

	public NumberPrinter(int number) {
		super();
		this.number = number;
	}

	
}
