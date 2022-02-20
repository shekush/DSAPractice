package graphs2;

import java.util.LinkedList;
import java.util.Queue;

public class FarFromLand 
{
	public class Pair
	{
		int x;
		int y;
		Pair(){}
		Pair(int x, int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	public static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public int maxDistanceFromLand(int arr[][])
	{
		Queue<Pair> q = new LinkedList<>();
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<arr[0].length; j++)
			{
				if(arr[i][j]==1)
					q.add(new Pair(i,j));
			}
		}
		if(q.size()==0 || q.size()==arr.length*arr[0].length)
			return -1;
		
		int lev=0, size=0;
		while(!q.isEmpty())
		{
			size=q.size();
			
			while(size-->0)
			{
				Pair p = q.poll();
				for(int i=0;i<4; i++)
				{
					int row = p.x + dir[i][0];
					int col = p.y + dir[i][1];
					if(row<0 || col<0 || row>arr.length || col>arr[0].length || arr[row][col]==1)
						continue;
					q.add(new Pair(row,col));
					arr[row][col] = 1;
				}
			}
			lev++;
		}
		return lev;
	}
}
