package graphs;
import java.util.*;

public class CycleDirectedDFS {
	
	public boolean checkHelper(int tmp, boolean[] vis,boolean[] dfsvis, ArrayList<ArrayList<Integer>> adj)
	{
		vis[tmp]=true;
		dfsvis[tmp]=true;
		for(Integer i: adj.get(tmp))
		{
			if(vis[i]==false)
			{
				if(checkHelper(i,vis,dfsvis,adj))
					return true;
			}
			else if(dfsvis[i])
				return true;
		}
		dfsvis[tmp]=false;
		return false;
	}

	public boolean cycle(int v, ArrayList<ArrayList<Integer>> adj)
	{
		boolean vis[] = new boolean[v+1];
		boolean dfsvis[] = new boolean[v+1];
		for(int i=1; i<=v; i++)
		{
			if(vis[i]==false)
			{
				if(checkHelper(i,vis,dfsvis,adj))
					return true;
			}
		}
		return false;
	}
}
