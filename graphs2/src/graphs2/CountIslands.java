package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountIslands 
{
	
	public void component(int i, int j, int m, int n, boolean[][] vis, int arr[][])
	{
		if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==true || arr[i][j]==1)
			return;
		
		vis[i][j]=true;
		component(i-1,j,m,n,vis,arr);
		component(i,j-1,m,n,vis,arr);
		component(i,j+1,m,n,vis,arr);
		component(i+1,j,m,n,vis,arr);
	}

	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of m and n: ");
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		
		int arr[][] = new int[m][n];
		boolean vis[][] = new boolean[m][n];
		System.out.println("Enter the elements: ");
		for(int i=0; i<m; i++)
		{
			String inp[] = in.readLine().trim().split(" ");
			for(int j=0; j<n; j++)
			{
				arr[i][j] = Integer.parseInt(inp[j]);
			}
		}
		System.out.println("Input Taken");
		CountIslands obj = new CountIslands();
		int count=0;
		for(int i=0; i<m; i++)
		{	
			for(int j=0; j<n; j++)
			{
				if(arr[i][j]==0 && vis[i][j]==false)
				{
					obj.component(i,j,m,n,vis,arr);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
