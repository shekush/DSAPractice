package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriends {
	
	public void getConnected(ArrayList<Edge>[] adj, int src, ArrayList<Integer> tmp, boolean[] vis)
	{
		vis[src] = true;
		tmp.add(src);
		for(Edge e: adj[src])
		{
			if(vis[e.getVertex()]==false)
				getConnected(adj,e.getVertex(),tmp,vis);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices: ");
		int v = Integer.parseInt(in.readLine());
		System.out.println("Enter the number of edges: ");
		int e = Integer.parseInt(in.readLine());
		
		Input obj = new Input();
		ArrayList<Edge>[] adj = obj.input(v,e);
		boolean[] vis = new boolean[v];
		
		PerfectFriends ob = new PerfectFriends();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<v; i++)
		{
			if(vis[i]==false)
			{
				ArrayList<Integer> tmp = new ArrayList<>();
				ob.getConnected(adj,i,tmp,vis);
				res.add(tmp);
			}
		}
		
		int pairs = 0;
		
		for(int i=0; i<res.size(); i++)
		{
			for(int j=i+1; j<res.size(); j++)
			{
				int c = res.get(j).size() * res.get(i).size();
				pairs = pairs + c;
			}
		}
		
		System.out.println(pairs);
	}

}
