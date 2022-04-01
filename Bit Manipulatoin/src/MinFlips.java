import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//return the min bits required to be flipped to make a OR b equal to c
public class MinFlips
{
	public static int minFlips(int a, int b, int c)
	{
		int res=0;
		for(int i=0; i<32; i++)
		{
			boolean ai = false;
			boolean bi = false;
			boolean ci = false;
			
			if((a & (1 << i)) > 0)
				ai = true;
			if((b & (1 << i)) > 0)
				bi = true;
			if((c & (1 << i)) > 0)
				ci = true;
			
			if(ci)
			{
				if(!ai && !bi)
					res++;
			}
			else
			{
				if(ai && bi)
					res+=2;
				else if(ai || bi)
					res++;
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers:");
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());
		
		int ans=minFlips(a,b,c);
		System.out.println(ans);
	}

}
