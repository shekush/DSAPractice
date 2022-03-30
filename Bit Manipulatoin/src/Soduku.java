import java.util.Scanner;

public class Soduku 
{
	public static void display(int[][] arr)
	{
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void solveSoduku(int arr[][], int row[], int col[], int grid[][], int i, int j) 
	{
		if(arr.length==i)
		{
			display(arr);
			return;
		}
		
		if(arr[i][j]>0)
			solveSoduku(arr, row, col, grid, j==arr[0].length-1?i+1:i, j==arr[0].length-1?0:j+1);
		else
		{
			for(int n=1; n<=9; n++)
			{
				if(((row[i]&(1 << n))==0) && ((col[j]&(1 << n))==0) && ((grid[i/3][j/3]&(1 << n))==0))
				{
					arr[i][j]=n;
					row[i]=row[i]^(1 << n);
					col[j]=col[j]^(1 << n);
					grid[i/3][j/3]=grid[i/3][j/3]^(1 << n);
					solveSoduku(arr, row, col, grid, j==arr[0].length-1?i+1:i, j==arr[0].length-1?0:j+1);
					arr[i][j]=0;
					row[i]=row[i]^(1 << n);
					col[j]=col[j]^(1 << n);
					grid[i/3][j/3]=grid[i/3][j/3]^(1 << n);
				}
					
			}
		}
			
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[9][9];
		int row[] = new int[9];
		int col[] = new int[9];
		int grid[][] = new int[3][3];
		System.out.println("Enter the sudoku: ");
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				int n = sc.nextInt();
				arr[i][j]=n;
				row[i]=row[i]|(1 << n);
				col[j]=col[j]|(1 << n);
				grid[i/3][j/3]=grid[i/3][j/3]|(1 << n);
			}
		}
		solveSoduku(arr, row, col, grid, 0, 0);
	}
}
