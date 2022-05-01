import java.util.Scanner;

public class CoinChange 
{
	public static void storeCoinCombinations(int[] dp, int[] coins)
	{
		int n=coins.length;
		int sum=dp.length;
		for(int i=1; i<sum; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(coins[j]<=i)
				{
					int rem = i-coins[j];
					if(rem>=0)
					{
						dp[i]+=dp[rem];
					}
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of coins");
		int n = sc.nextInt();
		int[] coins = new int[n];
		System.out.println("Enter the coins: ");
		for(int i=0; i<n; i++)
		{
			coins[i]=sc.nextInt();
		}
		System.out.println("Enter the sum:");
		int sum = sc.nextInt();
		int[] dp = new int[sum+1];
		dp[0]=1;
		storeCoinCombinations(dp,coins);

		System.out.println(dp[sum]);
	}
}
