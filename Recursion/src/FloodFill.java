import java.util.Scanner;

public class FloodFill 
{
	public static void findPaths(int[][] arr, int row, int col, boolean[][] vis, String path)
	{
		if(row<0 || col<0 || row>=arr.length || col>=arr[0].length || arr[row][col]==1 || vis[row][col]==true)
		{
			return;
		}
		
		if(row==arr.length-1 && col==arr[0].length-1)
		{
			System.out.println(path);
			return;
		}
		
		vis[row][col]=true;
		findPaths(arr,row-1,col,vis,path+"t");
		findPaths(arr,row,col+1,vis,path+"r");
		findPaths(arr,row+1,col,vis,path+"d");
		findPaths(arr,row,col-1,vis,path+"l");
		vis[row][col]=false;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimentions of an array: ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<n; i++)
		{
			for(int j=0;j<m;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter the source: ");
		int i = sc.nextInt();
		int j = sc.nextInt();
		boolean vis[][] = new boolean[n][m];
		findPaths(arr,i,j,vis,"");
	}

}
