package graphs2;

import java.util.HashSet;

public class DistinctIslands 
{
	String s="";
	HashSet<String> hs = new HashSet<>();
	
	public void countDistinct(int[][] arr)
	{
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<arr[0].length; j++)
			{
				if(arr[i][j]==1)
				{
					s = "x";
					travelDFS(arr,i,j);
					hs.add(s);
				}
			}
		}
		int count=hs.size();
		
		System.out.println(count);
	}
	
	public void travelDFS(int[][] arr, int i, int j)
	{
		arr[i][j] = 0;
		
		if(i-1>=0 && arr[i-1][j]==1)
		{
			s=s+"u";
			travelDFS(arr,i-1,j);
		}
		if(i+1<arr.length && arr[i+1][j]==1)
		{
			s=s+"d";
			travelDFS(arr,i+1,j);
		}
		if(j+1<arr[0].length && arr[i][j+1]==1)
		{
			s=s+"r";
			travelDFS(arr,i,j+1);
		}
		if(j-1>=0 && arr[i][j-1]==1)
		{
			s=s+"l";
			travelDFS(arr,i,j-1);
		}
		
		s=s+"z";
	}
}
