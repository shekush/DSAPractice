import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipBits 
{
	public static int countBits(int n)
	{
		int count=0;
		int rsb;
		while(n>0)
		{
			rsb = n & -n;
			n-=rsb;
			count++;
		}
		return count;
	}
	public static int countDifferentBits(int a, int b)
	{
		int differentBits = a^b;
		int res = countBits(differentBits);
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the two numbers: ");
		int a=Integer.parseInt(in.readLine());
		int b=Integer.parseInt(in.readLine());
		int n = countDifferentBits(a,b);
		System.out.println("The number of bits to flip to make two numbers same is  :  "+n);
	}

}
