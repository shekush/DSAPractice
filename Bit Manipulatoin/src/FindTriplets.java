import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//in this question we are given an array containing numbers
// we need to find a triplet of i, j, k where there three numbers are defined as
// 0 <= x < j < k <= arr.l   where,
// x = arr[i]^arr[i+1]^.....^arr[j-1]
// y = arr[j]^arr[j+1]^.....^arr[k]
// such that: X = Y


public class FindTriplets 
{
	public static void solution(int[] arr)
	{
		int c = 0;
		for(int i=0; i<arr.length; i++)
		{
			int val = arr[i];
			for(int k = i+1; k<arr.length; k++)
			{
				val = val ^ arr[k];
				if(val==0)
				{
					c+=k-i;
				}
			}
		}
		System.out.println(c);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers");
		String inp[] = (in.readLine().trim().split(" "));
		int arr[] = new int[inp.length];
		int i=0;
		for(String s: inp)
		{
			arr[i] = Integer.parseInt(inp[i]);
			i++;
		}
		solution(arr);
	}
}
