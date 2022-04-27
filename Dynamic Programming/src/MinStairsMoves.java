import java.util.Scanner;

//in this program we are given an array of moves for every i-th stair
//we return the min moves to reach N from 0
//0-based indexing
public class MinStairsMoves 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the N-th Stair:");
		int n = sc.nextInt();
		int moves[] = new int[n];
		System.out.println("Enter the moves for each stair: ");
		for(int i=0; i<n; i++)
		{
			moves[i]=sc.nextInt();
		}
		Integer dp[] = new Integer[n+1]; 
		dp[n]=0;
		
		for(int i=n-1; i>=0; i--)
		{
			int min=Integer.MAX_VALUE;
			for(int j=1; j<=moves[i]; j++)
			{
				if(i+j<=n)
				{
					if(dp[i+j]!=null && dp[i+j]<min)
					{
						min=dp[i+j];
					}
				}
			}
			if(min!=Integer.MAX_VALUE)
				dp[i]=1+min;
		}
		System.out.println(dp[0]);
		sc.close();
	}

}
