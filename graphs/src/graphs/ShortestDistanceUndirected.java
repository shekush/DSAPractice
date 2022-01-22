package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUndirected {
	
	//time complexity is O(N+E)
	
	public int[] shortest(ArrayList<ArrayList<Integer>> adj, int v, int src)
	{
		int dis[] = new int[v+1];
		Queue<Integer> q = new LinkedList<>();
		dis[src] = 0;
		q.add(src);
		while(!q.isEmpty())
		{
			Integer tmp = q.poll();
			for(Integer item:adj.get(tmp))
			{
				if(item!=src)
				{
					if((dis[tmp]+1 < dis[item]) || dis[item]==0)
					{
						dis[item]=dis[tmp]+1;
						q.add(item);
					}
				}
			}
		}
		return dis;
	}

}
