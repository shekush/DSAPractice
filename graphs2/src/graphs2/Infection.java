tpackage graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Infection {

	public class Pair
	{
		int v, lev;
		
		public Pair(){}
		public Pair(int v, int lev)
		{
			this.v = v;
			this.lev=lev;
		}
	}
	
	public void getPatients(ArrayList<Edge>[] adj, int src, int t, boolean[] vis)
	{
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(src,1));
		
		int count = 0;
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			if(vis[p.v]==true)
				continue;
			
			vis[p.v] = true;
			
			if(p.lev>t)
				break;
			
			count++;
			for(Edge e: adj[p.v])
			{
				if(vis[e.getVertex()]==false)
					q.add(new Pair(e.getVertex(), p.lev+1));
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices: ");
		int v = Integer.parseInt(in.readLine());
		System.out.println("Enter the number of edges: ");
		int e = Integer.parseInt(in.readLine());
		
		Input obj = new Input();
		ArrayList<Edge>[] adj = obj.input(v,e);
		
		System.out.println("Enter the source: ");
		int src = Integer.parseInt(in.readLine());
		
		System.out.println("Enter the time: ");
		int t = Integer.parseInt(in.readLine());
		
		boolean vis[] = new boolean[v];
		
		Infection ob = new Infection();
		ob.getPatients(adj, src, t, vis);
	}

}
