import java.util.Scanner;

public class MaxSumIncreasingSubsequence 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array:");
		for(int i=0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		Integer[] dp = new Integer[n];
		dp[0] = arr[0];
		Integer max = arr[0];
		for(int i=1; i<n; i++)
		{
			Integer submax = null;
			for(int j=0; j<i; j++)
			{
				if(arr[j]<=arr[i])
				{
					if(submax==null || submax<dp[j])
						submax = dp[j];
				}
			}
			if(submax==null)
				dp[i] = arr[i];
			else
				dp[i] = submax+arr[i];
			
			if(dp[i]>max)
				max = dp[i];
		}
		System.out.println(max);
		sc.close();
	}
}
