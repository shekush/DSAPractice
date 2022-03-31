import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MinXOR_Pairs 
{
	public static ArrayList<String> solve(int[] arr)
	{
		Arrays.sort(arr);
		int min=Integer.MAX_VALUE;
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i=0; i<arr.length-1; i++)
		{
			int xor = arr[i]^arr[i+1];
			if(xor<min)
			{
				min=xor;
				res = new ArrayList<String>();
				res.add(arr[i]+" , "+arr[i+1]);
			}
			else if(xor==min)
			{
				res.add(arr[i]+" , "+arr[i+1]);
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements: ");
		int n = Integer.parseInt(in.readLine().trim());
		int arr[]=new int [n];
		String inp[] = (in.readLine().trim()).split(" ");
		for(int i=0; i<n; i++)
		{
			arr[i] = Integer.parseInt(inp[i]);
		}
		
		ArrayList<String> res = solve(arr);
		System.out.println(res);
	}

}
