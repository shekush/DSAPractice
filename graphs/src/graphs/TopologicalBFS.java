package graphs;
import java.util.*;
public class TopologicalBFS {

	public int[] topo(int v, ArrayList<ArrayList<Integer>> adj)
	{
		int t[] = new int[v];
		int deg[] = new int[v+1];
		
		for(int i=1; i<=v; i++)
		{
			for(Integer it: adj.get(i))
				deg[it]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=v; i++)
		{
			if(deg[i]==0)
					q.add(i);
		}
		
		int ind=0;
		while(!q.isEmpty())
		{
			int n = q.poll();
			t[ind++] = n;
			
			for(Integer i:adj.get(n))
			{
				deg[i]--;
				if(deg[i]==0)
					q.add(i);
			}
		}
		return t;
	}
}
