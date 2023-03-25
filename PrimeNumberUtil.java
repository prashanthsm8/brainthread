package Thread;

public class PrimeNumberUtil {
	
	public static int print(int n)
	{
		
		int numberprimes=0;
		int numb=1;
		int i;
		
		while(numberprimes<n)
		{
			numb++;
			for(i=2; i<numb && numb%i!=0; i++)
			{
				
			}
			if(i==numb)
			{
				numberprimes++;
			}
		}
		
		return numb;
		
	}

}
