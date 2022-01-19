package graphs;
import java.util.*;

public class DFTraversal {
	
	//time complexity is O(N+E) and Space Complexity is O(N+E)+O(N)+O(N)
	
	public void dftHelper(int tmp, boolean[] vis, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj)
	{
		res.add(tmp);
		vis[tmp]=true;
		for(Integer i: adj.get(tmp))
		{
			if(vis[i]==false)
				dftHelper(i, vis, res, adj);
		}
	}
	
	public ArrayList<Integer> dft(int v, ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList<Integer> res = new ArrayList<>();
		boolean vis[] = new boolean[v+1]; //we have one-based indexing
		
		for(int i=1; i<=v; i++)
		{
			if(vis[i]==false)
			{
				dftHelper(i, vis, res, adj);
			}
		}
		
		return res;
	}
}
