package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestDistanceDirected {
	class Pair {
	    private int v, w;
	    public Pair(int v, int w) {
	        this.v = v;
	        this.w = w; 
	    }
	    public int getV()
	    {
	    	return v;
	    }
	    public int getW()
	    {
	    	return w;
	    }
	}
	public void topoHelper(int tmp, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<Pair>> adj)
	{
		vis[tmp] = true;
		for(Pair i: adj.get(tmp))
		{
			if(vis[i.getV()]==false)
				topoHelper(i.getV(),s,vis,adj);
		}
		s.push(tmp);
	}
	
	public int[] shortestPath(int v, ArrayList<ArrayList<Pair>> adj, int src)
	{
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[v+1];
		int dis[] = new int[v+1];
		
		for(int i=1; i<=v; i++)
		{
			if(vis[i]==false)
			{
				topoHelper(i,s,vis,adj);
			}
			dis[i] = Integer.MAX_VALUE;
		}
		dis[src] = 0;
		while(!s.isEmpty())
		{
			int tmp=s.pop();
			if(dis[tmp]!=Integer.MAX_VALUE)
			{
				for(Pair i:adj.get(tmp))
				{
					if(dis[tmp] + i.getW() < dis[i.getV()])
					{
						dis[i.getV()] = dis[tmp]+i.getW();
					}
				}
			}
		}
		
		return dis;
	}

}
