package graphs2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Khans 
{
	//this algorithm is an iterative way to write topological sort
	//topological sort is valid only for acyclic directed graph
	
	
	public int[] topo(int n, ArrayList<ArrayList<Integer>> adj)
	{
		int res[] = new int[n];
		int inDeg[] = new int[n];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++)
		{
			for(int v: adj.get(i))
			{
				inDeg[v]++;
			}
		}
		for(int i=0; i<n; i++)
		{
			if(inDeg[i]==0)
				q.add(i);
		}
		int ind = 0;
		while(!q.isEmpty())
		{
			int tmp = q.poll();
			res[ind++] = tmp;
			for(int v:adj.get(tmp))
			{
				inDeg[v]--;
				if(inDeg[v]==0)
					q.add(v);
			}
		}
		if(ind==n)
			return res;
		
		else
			return new int[]{-1};
	}
}
