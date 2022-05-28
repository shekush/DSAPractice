import java.util.Scanner;
//size of dominoes is m X 1
//size of floor is m X n
public class TilingWithDominoes 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n,m;
		System.out.println("Enter the value of n amd m");
		n = sc.nextInt();
		m = sc.nextInt();
		
		int dp[] = new int[n+1];

		for(int i=3; i<=n; i++)
		{
			if(i<m)
				dp[i]=1;
			else if(i==m)
				dp[i]=2;
			else
				dp[i] = dp[i-1]+dp[i-m];
		}
		
	}

}
