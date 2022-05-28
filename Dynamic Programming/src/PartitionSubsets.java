import java.util.Scanner;

//Partition Into Subsets Problem
public class PartitionSubsets 
{
	public static int getResult(int n, int k)
	{
		if(n==0 || k==0 || n<k)
			return 0;
		
		int dp[][] = new int[k+1][n+1];
		
		for(int i=1; i<=k; i++)
		{
			for(int j=i; j<=n; j++)
			{
				if(i==1)
					dp[i][j]=1;
				else if(i==j)
					dp[i][j]=1;
				else
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1]*i; 
			}
		}
		
		return dp[k][n];
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of people:");
		int n = sc.nextInt();
		System.out.println("Enter the number of teams:");
		int k = sc.nextInt();
		
		int res = getResult(n,k);
		System.out.println(res);
		
		sc.close();
	}

}
