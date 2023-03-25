package Thread;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Thread t = new thr(); t.start(); System.out.println(t.getClass().getName());
		 */
		
		Thread t = new Thread(new Runn());
		t.start();
		System.out.println(t.getClass().getName());
	}

}
