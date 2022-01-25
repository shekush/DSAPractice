package graphs;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {	
	public int[] distance(ArrayList<ArrayList<Pairs>> adj, int v, int src)
	{
		int dis[] = new int[v];
		
		for(int i=0; i<v; i++)
			dis[i] = Integer.MAX_VALUE;
		
		dis[src] = 0;
		
		PriorityQueue<Pairs> pq = new PriorityQueue<Pairs>(v, new Pairs());
		pq.add(new Pairs(src,0));
		
		while(!pq.isEmpty())
		{
			Pairs tmp = pq.poll();
			for(Pairs i: adj.get(tmp.getV()))
			{
				if(dis[tmp.getV()]+i.getW() < dis[i.getV()])
					dis[i.getV()] = dis[tmp.getV()] + i.getW();
			}
		}
		return dis;
	}
	public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Pairs> > adj = new ArrayList<ArrayList<Pairs>>();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Pairs>());
			
		adj.get(0).add(new Pairs(1, 2));
		adj.get(1).add(new Pairs(0, 2));
		
		adj.get(1).add(new Pairs(2, 4));
		adj.get(2).add(new Pairs(1, 4));
		
		adj.get(0).add(new Pairs(3, 1));
		adj.get(3).add(new Pairs(0, 1));
		
		adj.get(3).add(new Pairs(2, 3));
		adj.get(2).add(new Pairs(3, 3));
		
		adj.get(1).add(new Pairs(4, 5));
		adj.get(4).add(new Pairs(1, 5));
		
		adj.get(2).add(new Pairs(4, 1));
		adj.get(4).add(new Pairs(2, 1));
		
		DijkstraAlgo obj = new DijkstraAlgo(); 
		int res[] = obj.distance(adj, n, 0); 
		
		for (int i = 0; i < n; i++) 
			System.out.println(res[i]);
		
    }
}
