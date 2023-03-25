package Thread;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=100;i++)
		{
			Thread tr = new Thread(new NumberPrinter(i));
			tr.start();
		}
	}

}
