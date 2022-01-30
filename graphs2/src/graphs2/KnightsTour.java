package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KnightsTour
{
	
	public void printArray(int arr[][],int n)
	{
		System.out.println("for printing");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	public void printBoard(int i, int j, int n, int arr[][], int move)
	{
		System.out.println("went in method");
		
		if(i<0 || j<0 || i>=n || j>=n || arr[i][j]>0)
		{
			System.out.println("returned");
			return;
		}
			
		else if(move==n*n)
		{
			arr[i][j] = move;
			printArray(arr,n);
			arr[i][j]=0;
			System.out.println("in else");
			return;
		}
		
		arr[i][j]=move;
		System.out.println("value of move  "+move);
		
		printBoard(i-2,j+1,n,arr,move+1);
		printBoard(i-1,j+2,n,arr,move+1);
		printBoard(i+1,j+2,n,arr,move+1);
		printBoard(i+2,j+1,n,arr,move+1);
		printBoard(i+2,j-1,n,arr,move+1);
		printBoard(i+1,j-2,n,arr,move+1);
		printBoard(i-1,j-2,n,arr,move+1);
		printBoard(i-2,j-1,n,arr,move+1);
			
		arr[i][j]=0;
		
		System.out.println("end of method");
	}

	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the dimension n: ");
		int n = Integer.parseInt(in.readLine());
		
		int arr[][] = new int[n][n];
		System.out.println("Enter the Row and Column of starting point: ");
		int i = Integer.parseInt(in.readLine());
		int j = Integer.parseInt(in.readLine());
		
		KnightsTour obj = new KnightsTour();
		System.out.println("method called");
		obj.printBoard(i,j,n,arr, 1);
	}
}
