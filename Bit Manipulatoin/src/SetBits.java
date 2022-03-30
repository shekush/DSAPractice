import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//count set bits of first n natural numbers

public class SetBits 
{
	public static int getHighestPowerOfTwo(int n)
	{
		int x=0;
		while((1 << x)<=n)
		{
			x++;
		}
		return x-1;
	}
	public static int solve(int n)
	{
		if(n==0)
			return 0;
		int x = getHighestPowerOfTwo(n);
		int uptoPowerX = (1 << (x-1))*x;
		int remMSB = n-(1 << x)+1;
		int rem=n-(1 << x);
		int ans = uptoPowerX + remMSB + solve(rem);
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		int n=Integer.parseInt(in.readLine().trim());
		
		int res = solve(n);
		System.out.println(res);
	}

}
