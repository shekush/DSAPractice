import java.util.Scanner;

//Longest Increasing Subsequence

public class LongestIncreasing 
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
		dp[0] = 1;
		int max = 1;
		for(int i=1; i<n; i++)
		{
			int submax = 0;
			for(int j=0; j<i; j++)
			{
				if(arr[j]<arr[i])
				{
					if(submax<dp[j])
						submax = dp[j];
				}
			}
			dp[i] = submax+1;
			if(dp[i]>max)
				max = dp[i];
		}
		System.out.println(max);
		sc.close();
	}
}
