package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightsTour
{
	
	public void printBoard(int i, int j, int m, int n, int arr[][], int move)
	{
		if(i<0 || j<0 || i>=m || j>=n || )
		
		arr[i][j]=move;
		
		printBoard(i-2,j-1,m,n,arr,move+1);
		printBoard(i-2,j+1,m,n,arr,move+1);
		printBoard(i+2,j-1,m,n,arr,move+1);
		printBoard(i+2,j+1,m,n,arr,move+1);
		printBoard(i-1,j-2,m,n,arr,move+1);
		printBoard(i-1,j+2,m,n,arr,move+1);
		printBoard(i,j,m,n,arr,move+1);
		printBoard(i,j,m,n,arr,move+1);
		
		arr[i][j]=0;
	}

	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of m and n: ");
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		
		int arr[][] = new int[m][n];
		System.out.println("Enter the elements: ");
		for(int i=0; i<m; i++)
		{
			String inp[] = in.readLine().trim().split(" ");
			for(int j=0; j<n; j++)
			{
				arr[i][j] = Integer.parseInt(inp[j]);
			}
		}
		System.out.println("Enter the Row and Column of starting point: ");
		int i = Integer.parseInt(in.readLine());
		int j = Integer.parseInt(in.readLine());
		
		KnightsTour obj = new KnightsTour();
		obj.printBoard(i,j,m,n,arr, 1);
	}
}
