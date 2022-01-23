package graphs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
	public class Pair implements Comparator<Pair> {
	    private int v, w;
	    public Pair(int v, int w) {
	        this.v = v;
	        this.w = w; 
	    }
	    public Pair() {
		}
		public int getV()
	    {
	    	return v;
	    }
	    public int getW()
	    {
	    	return w;
	    }
	    public int compare(Pair first, Pair second)
	    {
	    	if(first.getW()<second.getW())
	    		return -1;
	    	else if(first.getW()>second.getW())
	    		return 1;
	    	else
	    		return 0;
	    }
	}
	
	public int[] distance(ArrayList<ArrayList<Pair>> adj, int v, int src)
	{
		int dis[] = new int[v+1];
		
		for(int i=1; i<=v; i++)
			dis[i] = Integer.MAX_VALUE;
		
		dis[src] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v, new Pair());
		pq.add(new Pair(src,0));
		
		while(!pq.isEmpty())
		{
			Pair tmp = pq.poll();
			for(Pair i: adj.get(tmp.getV()))
			{
				if(dis[tmp.getV()]+i.getW() < dis[i.getV()])
					dis[i.getV()] = dis[tmp.getV()] + i.getW();
			}
		}
		return dis;
	}
}
