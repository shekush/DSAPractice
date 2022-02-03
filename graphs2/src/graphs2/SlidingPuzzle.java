package graphs2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle 
{
	public String swapChars(String str, int i, int j)
	{
		StringBuilder s = new StringBuilder(str);
		s.setCharAt(i, str.charAt(j));
		s.setCharAt(j, str.charAt(i));
		return s.toString();
	}
	public int findSwaps(int[][] a)
	{
		Queue<String> q = new LinkedList<>();
		HashSet<String> vis = new HashSet<>();
		String target = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<a[0].length; j++)
			{
				sb.append(a[i][j]);
			}
		}
		String init = sb.toString();
		int[][] swap = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{4,2}};
		q.add(init);
		int lev = 0;
		while(!q.isEmpty())
		{
			int size = q.size();
			while(size-->0)
			{
				String tmp = q.poll();
				if(tmp.equals(target))
					return lev;
				
				int ind = tmp.indexOf('0');
				for(int i=0; i<swap[ind].length; i++)
				{
					String s = swapChars(tmp,ind,swap[ind][i]);
					if(vis.contains(s))
						continue;
					q.add(s);
					vis.add(s);
				}
			}
			lev++;
		}
		
		return -1;
	}

}
