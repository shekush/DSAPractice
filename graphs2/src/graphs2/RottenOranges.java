package graphs2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges 
{
	//the matrix consists of 0,1,2
	//0 is nothing, 1 is fresh orange and 2 is rotten orange
	//we return the minimum time in which all the oranges rots
	//print -1 if all oranges do not rot
	
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
	
	public int rotOrange(int arr[][])
	{
		Queue<Pair> q = new LinkedList<>();
		int fresh=0;
		for(int i=0;i<arr.length; i++)
		{
			for(int j=0;j<arr[0].length; j++)
			{
				if(arr[i][j]==1)
					fresh++;
				else if(arr[i][j]==2)
				{
					q.add(new Pair(i,j));
				}
			}
		}
		if(fresh==0)
			return 0;
		
		int level=0;
		while(!q.isEmpty())
		{
			int size=q.size();
			level++;
			while(size-->0)
			{
				Pair p = q.poll();
				for(int i=0;i<4; i++)
				{
					int row = p.x + dir[i][0];
					int col = p.y + dir[i][1];
					if(row<0 || col<0 || row>arr.length || col>arr[0].length || arr[row][col]!=1)
						continue;
					q.add(new Pair(row,col));
					arr[row][col] = 2;
					fresh--;
				}
			}
		}
		if(fresh==0)
			return level;
		else
			return -1;
	}
}
