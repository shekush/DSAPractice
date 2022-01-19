package graphs;
import java.util.*;

public class CycleDetectionDFS {
	
	//time complexity is O(N+E) and Space Complexity is O(N+E)+O(N)+O(N)
	
	public boolean cycleDFS(int tmp, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
	{
		vis[tmp] = true;
			for(Integer i:adj.get(tmp))
			{
				if(vis[i]==false)
				{
					if(cycleDFS(i,tmp,vis,adj))
						return true;
				}
				else if(par!=i)
					return true;
			}
		return false;
	}
	
	
	public boolean cycle(int v, ArrayList<ArrayList<Integer>> adj)
	{
		boolean vis[] = new boolean[v+1];
		Arrays.fill(vis, false);
		for(int i=1; i<=v; i++) 
		{
			if(vis[i]==false)
			{
				if(cycleDFS(i, -1, vis, adj))
					return true;
			}
		}
		return false;
	}

}
