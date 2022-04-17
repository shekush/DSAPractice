import java.util.Scanner;

public class FriendsPair 
{
	public static void printPairs(int i, int n, boolean[] vis, String ans)
	{
		if(i>n)
		{
			System.out.println(ans);
			return;
		}
		if(vis[i]==true)
		{
			printPairs(i+1,n,vis,ans);
		}
		else
		{
			vis[i]=true;
			printPairs(i+1,n,vis,ans+i+"  ");
			for(int j=i+1; j<=n; j++)
			{
				if(vis[j]==false)
				{
					vis[j]=true;
					printPairs(i+1,n,vis,ans+i+j+"  ");
					vis[j]=false;
				}
			}
			vis[i]=false;
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of friends");
		int n=sc.nextInt();
		boolean[] vis = new boolean[n+1]; //1-based indexing
		printPairs(1,n,vis,"");
		sc.close();
	}

}
