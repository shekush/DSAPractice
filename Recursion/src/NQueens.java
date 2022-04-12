import java.util.Scanner;

public class NQueens 
{
	public static void printBoard(boolean[][] board)
	{
		int n = board.length;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(board[i][j])
					System.out.print("1  ");
				else
					System.out.print("0  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	public static void solve(int row, boolean[][] board, boolean[] cols, boolean[] dia1, boolean[] dia2)
	{
		if(row==board.length)
		{
			printBoard(board);
			return;
		}
		for(int col=0; col<board.length; col++)
		{
			if(board[row][col]==false && cols[col]==false && dia1[row+col]==false && dia2[row-col+board.length-1]==false)
			{
				board[row][col]=true;
				cols[col]=true; 
				dia1[row+col]=true;
				dia2[row-col+board.length-1]=true;
				solve(row+1,board, cols, dia1, dia2);
				board[row][col]=false;
				cols[col]=false; 
				dia1[row+col]=false;
				dia2[row-col+board.length-1]=false;
			}
		}
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns");
		int n = sc.nextInt();
		boolean board[][] = new boolean[n][n];
		boolean cols[] = new boolean[n];
		boolean dia1[] = new boolean[2*n-1];
		boolean dia2[] = new boolean[2*n-1];
		
		solve(0,board,cols,dia1,dia2);
	}

}
