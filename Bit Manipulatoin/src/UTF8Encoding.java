import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UTF8Encoding 
{
	public static boolean solution(int[] arr)
	{
		int rem=0;
		for(int val:arr)
		{
			if(rem==0)
			{
				if((val >> 7) == 0)
				{
					rem=0;
				}
				else if((val >> 5) == 0b110)
				{
					rem=1;
				}
				else if((val >> 4) == 0b1110)
				{
					rem=2;
				}
				else if((val >> 3) == 0b11110)
				{
					rem=3;
				}
			}
			else
			{
				if((val >> 6) == 0b10)
					rem--;
				else
					return false;
			}
		}
		if(rem==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers:");
		String inp[] = (in.readLine().trim().split(" "));
		int arr[] = new int[inp.length];
		int i=0;
		for(String s: inp)
		{
			arr[i] = Integer.parseInt(s);
			i++;
		}
		System.out.println(solution(arr));
	}
}
