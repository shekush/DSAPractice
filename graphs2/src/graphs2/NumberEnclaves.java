package graphs2;

public class NumberEnclaves 
{
	public void printEnclaves(int[][] arr)
	{
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<arr[0].length; j++)
			{
				if(i==0 || j==0 || i==arr.length-1 || j==arr[0].length-1 || arr[i][j]==1)
					travelDFS(arr,i,j);
			}
		}
		int count=0;
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<arr[0].length; j++)
			{
				if(arr[i][j]==1)
					count++;
			}
		}
		System.out.println(count);
	}
	
	public void travelDFS(int[][] arr, int i, int j)
	{
		if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0)
			return;
		
		arr[i][j] = 0;
		travelDFS(arr,i-1,j);
		travelDFS(arr,i+1,j);
		travelDFS(arr,i,j+1);
		travelDFS(arr,i,j-1);
	}
}
