import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintPathsMinJump 
{
	class Pair
	{
		int ind;
		StringBuilder psf;
		Pair(int ind, StringBuilder psf)
		{
			this.ind = ind;
			this.psf = psf;
		}
	}
	public void printPaths(int jumps[], Integer dp[], int n)
	{
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, new StringBuilder("0")));
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			StringBuilder currPath = p.psf;
			if(p.ind==n-1)
			{
				System.out.println(currPath);
				continue;
			}
			for(int i=1; i<=jumps[p.ind] && (p.ind+i<n); i++)
			{
				System.out.println(currPath);
				if(dp[p.ind+i]!=null && dp[p.ind]-1==dp[p.ind+i])
				{
					q.add(new Pair(p.ind+i, new StringBuilder(currPath.append(Integer.toString(p.ind+i)))));
					currPath.deleteCharAt(currPath.length()-1);
				}
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array of jumps:");
		int n = sc.nextInt();
		int jumps[] = new int[n];
		System.out.println("Enter the jumps:");
		for(int i=0; i<n; i++)
		{
			jumps[i] = sc.nextInt();
		}
		Integer dp[] = new Integer[n];
		dp[n-1]=0;
		for(int i=n-2; i>=0; i--)
		{
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=jumps[i]; j++)
			{
				if(i+j>=n)
					break;
				if(dp[i+j]!=null && min>dp[i+j])
					min=dp[i+j];
			}
			if(min!=Integer.MAX_VALUE)
				dp[i] = 1 + min;
		}
		System.out.println("Min Jumps Required is : "+dp[0]);
		PrintPathsMinJump obj = new PrintPathsMinJump();
		obj.printPaths(jumps,dp,n);
		sc.close();

	}
}
