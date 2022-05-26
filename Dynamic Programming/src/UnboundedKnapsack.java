import java.util.Scanner;

public class UnboundedKnapsack 
{

	public static void storeMaxWeights(int[] dp, int[] val, int[] weight)
	{
		dp[0]=0;
		for(int i=1; i<dp.length; i++)
		{
			int max = Integer.MIN_VALUE;
			for(int j=0; j<val.length; j++)
			{
				if(val[j]<=i)
				{
					int rem = dp[i-val[j]];
					int newVal = weight[j] + rem;
					if(newVal>max)
						max=newVal;
				}
			}
			dp[i]=max;
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of items");
		int n = sc.nextInt();
		int[] val = new int[n];
		int[] weights = new int[n];
		System.out.println("Enter the values: ");
		for(int i=0; i<n; i++)
		{
			val[i]=sc.nextInt();
		}
		System.out.println("Enter the wights: ");
		for(int i=0; i<n; i++)
		{
			weights[i]=sc.nextInt();
		}
		System.out.println("Enter the max value:");
		int maxValue = sc.nextInt();
		int[] dp = new int[maxValue+1];
		storeMaxWeights(dp,val,weights);

		System.out.println(dp[maxValue]);

	}

}
