package graphs;
import java.util.*;

public class BFTraversal {
	
	//time complexity is O(N+E) and Space Complexity is O(N+E)+O(N)+O(N)
	
	public ArrayList<Integer> bft(ArrayList<ArrayList<Integer>> adj, int v)
	{
		ArrayList<Integer> bfs = new ArrayList<>();
		boolean vis[] = new boolean[v+1];
		for(int i=1; i<=v; i++)
		{
			if(vis[i]==false)
			{
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				vis[i]=true;
				while(!q.isEmpty())
				{
					Integer tmp = q.poll();
					bfs.add(tmp);
					for(Integer item:adj.get(tmp))
					{
						if(vis[item]==false)
						{
							vis[item]=true;
							bfs.add(item);
						}
					}
				}
			}
		}
		
		return bfs;
	}
}
