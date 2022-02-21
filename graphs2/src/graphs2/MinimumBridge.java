package graphs2;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBridge 
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
	
	public int minBridgeDistance(int arr[][])
	{
		Queue<Pair> q = new LinkedList<>();
		boolean[][] vis = new boolean[arr.length][arr[0].length];
		boolean flag=false;
		for(int i=0;i<arr.length && !flag; i++)
		{
			for(int j=0;j<arr[0].length && !flag; j++)
			{
				if(arr[i][j]==1)
				{
					dfs(arr,vis,q,i,j);
					flag=true;
				}
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
					if(row<0 || col<0 || row>arr.length || col>arr[0].length || vis[row][col]==true)
						continue;
					
					if(arr[row][col]==1)
						return lev;
					
					q.add(new Pair(row,col));
				}
			}
			lev++;
		}
		
		return -1;
	}
	
	public void dfs(int arr[][], boolean[][] vis, Queue<Pair> q, int i, int j)
	{
		vis[i][j]=true;
		q.add(new Pair(i,j));
		for(int k=0; k<4; k++)
		{
			int r = i + dir[k][0];
			int c = j + dir[k][1];
			if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]==0 || vis[r][c]==true)
				continue;
			dfs(arr,vis,q,r,c);
		}
	}

}
