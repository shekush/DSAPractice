package graphs2;

public class BorderColoring 
{
	
	int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		
	
	public void coloring(int[][] adj, int r, int c, int color)
	{
		colorBorder(adj,r,c,adj[r][c]);
		for(int i=0; i<adj.length; i++)
		{
			for(int j=0; j<adj[0].length; j++)
			{
				if(adj[i][j]<0)
					System.out.print(color);
				else
					System.out.print(adj[i][j]+"  ");
			}
			System.out.println();
		}
	}
		
	public void colorBorder(int[][] adj, int r, int c, int color)
	{
		adj[r][c] = -color;
		int count=0;
		
		for(int i=0; i<4; i++)
		{
			int row = r + dir[i][0];
			int col = c + dir[i][1];
			if(row<0 || col<0 || row>adj.length || col>adj[0].length || Math.abs(adj[row][col])!=color)
				continue;
			
			count++;
			
			if(adj[row][col]==color)
				colorBorder(adj, row, col, color);
			
			if(count==4)
				adj[row][col] = color;
		}
		
	}

}
