import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthBinaryPalindrome 
{
	public static int getRev(int n)
	{
		int rev=0;
		while(n!=0)
		{
			int lowestBit = (n & 1);
			rev|=lowestBit;
			rev<<=1;
			n>>=1;
		}
		return rev;
	}
	public static int NthPalin(int n)
	{
		int count=1;
		int len=1;
		while(count<n)
		{
			len++;
			int elementsThisLength = (1 << (len-1)/2);
			count+=elementsThisLength;
		}
		count-=(1 << (len-1)/2);
		
		int distanceFromLastGroup = n-count-1;
		int ans = (1 << (len-1));
		ans |= (distanceFromLastGroup << (len/2));
		
		int toBeReversed = (ans >> (len/2));
		int rev = getRev(toBeReversed);
		
		ans|=rev;
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of N: ");
		int n = Integer.parseInt(in.readLine().trim());
		int palindrome = NthPalin(n);
		System.out.println(palindrome);
	}

}
