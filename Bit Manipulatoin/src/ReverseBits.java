import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseBits
{
	public static int solve(int n)
	{
		int rev=0;
		boolean flag=false;
		int j=0;
		for(int i=31; i>=0; i--)
		{
			int mask=(1 << i);
			if(flag)
			{
				if((n & mask)!=0)
				{
					int smask = (1 << j);
					rev=rev|smask;
					System.out.print(1);
				}
				else
				{
					System.out.print(0);
				}
				j++;
			}
			else
			{
				if((n & mask)!=0)
				{
					flag=true;
					int smask = (1 << j);
					rev=rev|smask;
					j++;
					System.out.print(1);
				}
			}
		}
		System.out.println();
		return rev;
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
