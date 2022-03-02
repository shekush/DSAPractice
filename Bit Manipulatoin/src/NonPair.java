import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonPair
{
	public static void solution(int[] arr)
	{
		int xor = 0;
		for(int i=0; i<arr.length; i++)
		{
			xor=xor^arr[i];
		}
		int rsb = xor & -xor;
		int x=0;
		int y=0;
		for(int i=0; i<arr.length; i++)
		{
			if((rsb & i) == 0)
				x = x^i;
			else
				y=y^i;
		}
		System.out.println(x+"  "+y);
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers");
		String inp[] = (in.readLine().trim().split(" "));
		int arr[] = new int[inp.length];
		int i=0;
		for(String s: inp)
		{
			arr[i] = Integer.parseInt(inp[i]);
		}
		solution(arr);
	}
}
