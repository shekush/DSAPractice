package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgo {
	
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
	
	public void spanning(ArrayList<ArrayList<Pair>> adj, int v)
	{
		int parent[] = new int[v+1];
		int key[] = new int[v+1];
		boolean mst[] = new boolean[v+1];
		
		for(int i=1; i<=v; i++)
		{
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(v, new Pair());
		key[1] = 0;
		parent[1] = -1;
		
		pq.add(new Pair(key[0], 0));
		
		while(!pq.isEmpty())
		{
			int u = pq.poll().getV();
			mst[u] = true;
			for(Pair i: adj.get(u))
			{
				if(mst[i.getV()]==false && i.getW() < key[i.getV()])
				{
					key[i.getV()] = i.getW();
					parent[i.getV()] = u;
					pq.add(new Pair(i.getV(), key[i.getV()]));
				}
			}
		}
		for(int i=1; i<=v; i++)
		{
			System.out.println(parent[i]+"-----"+i);
		}
	}

}
