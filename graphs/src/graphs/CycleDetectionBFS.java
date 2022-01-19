package graphs;
import java.util.*;


public class CycleDetectionBFS {
	
	class Node
	{
		int elem;
		int parent;
		Node(int elem, int parent)
		{
			this.elem = elem;
			this.parent = parent;
		}
	}
	
	//time complexity is O(N+E) and Space Complexity is O(N+E)+O(N)+O(N)
	
	public boolean cycleBFS(int tmp, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(tmp,-1)); //-1 means no previous node or no parent node
		vis[tmp] = true;
		
		while(!q.isEmpty())
		{
			int node = q.peek().elem;
			int par = q.peek().parent;
			q.remove();
			for(Integer i:adj.get(node))
			{
				if(vis[i]==false)
				{
					q.add(new Node(i,node));
					vis[i]=true;
				}
				else if(par!=i)
					return true;
			}
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
				if(cycleBFS(i, vis, adj))
					return true;
			}
		}
		
		return false;

	}
}
