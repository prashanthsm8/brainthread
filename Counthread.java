package Thread;

public class Counthread {

	public static void main(String[] args) {
		Counter ct = new Counter();
		Counter ct2 = new Counter();
			Thread t1 = new Thread(ct, "first thread");
			Thread t2 = new Thread(ct, "second thread");
			Thread t3 = new Thread(ct2, "third thread");
			Thread t4 = new Thread(ct2, "fourth thread");
			t1.start();
			t2.start();
			t3.start();
			t4.start();
	}

}
