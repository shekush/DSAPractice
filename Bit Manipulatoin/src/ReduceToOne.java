import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReduceToOne 
{
	public static void solution(int n)
	{
		int res=0;
		while(n!=1)
		{
			if(n%2==0)
				n=n/2;
			else if(n==3)
			{
				res=2;
				break;
			}
			else if((n & 3)==1)
				n=n-1;
			else if((n & 3)==3)
				n=n+1;
			res++;
		}
		System.out.println(res);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int num = Integer.parseInt(in.readLine().trim());
		solution(num);
	}

}
