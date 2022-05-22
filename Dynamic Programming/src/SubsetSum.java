import java.util.Scanner;
//here we assume that the given set is sorted 
public class SubsetSum 
{
	public static void fillDP(boolean[][] dp, int[] set)
	{
		for(int i=0; i<dp.length; i++)
		{
			dp[i][0]=true;
		}
		
		for(int i=1; i<dp.length; i++)
		{
			for(int j=1; j<dp[0].length; j++)
			{
				if( (dp[i-1][j]==true) || ( (j-set[i]>=0) && (dp[i][j-set[i]]==true) ))
				{
					dp[i][j]=true;
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the set: ");
		int n = sc.nextInt();
		System.out.println("Enter the elements in the set: ");
		int set[] = new int[n];
		for(int i=0; i<n; i++)
		{
			set[i]=sc.nextInt();
		}
		System.out.println("Enter the target sum: ");
		int target = sc.nextInt();
		
		boolean dp[][] = new boolean[n+1][target+1];
		
		fillDP(dp,set);
		System.out.println(dp[n][target]);
	}

}
