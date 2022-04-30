import java.util.Scanner;

public class GoldMine 
{
	public static void printArr(int[][] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static int findMaxGoldPath(int[][] dp)
	{
		int max=Integer.MIN_VALUE;
		for(int i=0; i<dp.length; i++)
		{
			if(dp[i][0]>max)
				max=dp[i][0];
		}
		return max;
	}
	public static void storeMaxGold(int[][] dp, int[][] mine)
	{
		int n=dp.length;
		int m=dp[0].length;
		
		for(int j=m-2; j>=0; j--)
		{
			for(int i=0; i<n; i++)
			{
				if(i==0)
				{
					dp[i][j] = mine[i][j]+(dp[i][j+1] > dp[i+1][j+1] ? dp[i][j+1] : dp[i+1][j+1]);
				}
				else if(i==(n-1))
				{
					dp[i][j] = mine[i][j]+(dp[i][j+1] > dp[i-1][j+1] ? dp[i][j+1] : dp[i-1][j+1]);
				}
				else
				{
					int tmp = dp[i][j+1] > dp[i-1][j+1] ? dp[i][j+1] : dp[i-1][j+1];
					dp[i][j] = mine[i][j]+(tmp > dp[i+1][j+1] ? tmp : dp[i+1][j+1]);
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimentions");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] mine = new int[n][m];
		System.out.println("Enter the elements: ");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				mine[i][j]=sc.nextInt();
			}
		}
		int[][] dp = new int[n][m];
		for(int i=0; i<n; i++)
		{
			dp[i][m-1] = mine[i][m-1];
		}
		storeMaxGold(dp,mine);
		printArr(dp);
		int maxGold = findMaxGoldPath(dp);
		System.out.println(maxGold);
	}
}
