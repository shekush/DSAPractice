package graphs;
import java.util.*;

public class TopologicalDFS {
	
	public void topoHelper(int tmp, Stack<Integer> s, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
	{
		vis[tmp] = true;
		for(Integer i: adj.get(tmp))
		{
			if(vis[i]==false)
				topoHelper(i,s,vis,adj);
		}
		s.push(tmp);
	}
	
	public int[] topo(int v, ArrayList<ArrayList<Integer>> adj)
	{
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[v+1];
		for(int i=1; i<=v; i++)
		{
			if(vis[i]==false)
			{
				topoHelper(i,s,vis,adj);
			}
		}
		int res[] = new int[v];
		int i=0;
		while(!s.isEmpty())
		{
			res[i++]=s.pop();
		}
		
		return res;
	}

}
