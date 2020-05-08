package sample;

public class Sumofdigits 
{
	public static int n=1235,Sum=0;

	public static void main(String[] args)
	{
		
		while (n>0)
		{
			Sum=Sum+n%10;
			n=n/10;			
		}
System.out.println(Sum);
	}

}
