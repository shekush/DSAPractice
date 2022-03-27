import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//we are given a number n
// find the numbers smaller than n having same number of set bits present in n

public class SameSetBits 
{
	public static long solution(long n, int bits, int i)
	{
		if(i==0)
			return 0;
		long mask = (1L << i);
		long res = 0;
		if((n & mask)==0)
			res=solution(n,bits,i-1);
		else
		{
			long res1 = solution(n,bits-1,i-1);
			long res0 = ncr(i,bits);
			res = res1+res0;
		}
		return res;
	}
	public static long ncr(int n, int r)
	{
		if(n<r)
			return 0L;
		else if(n==r || r==0)
			return 1L;
		
		long res = 1L;
		for(long i=0L; i<r; i++)
		{
			res *= (n-i);
			res /= (i+1);
		}
		return res;
	}
	public static int countSetBits(long n)
	{
		int res = 0;
		while(n>0)
		{
			long rsb = n & -n;
			n-=rsb;
			res++;
		}
		return res;
	}
	public static int calcPower(long n)
	{
		int i=1;
		while(i*2<=n)
		{
			i=i*2;
		}
		return i;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		long n = Long.parseLong(in.readLine().trim());
		int setBits = countSetBits(n);
		int numLength = calcPower(n)+1;
		solution(n,setBits, numLength);
	}
}