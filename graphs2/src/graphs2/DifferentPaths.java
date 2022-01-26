package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

//this class finds the smallest and the largest path
//it also finds the ceil and floor path for a given criteria
//it also returns the kth largest path
public class DifferentPaths {
	
	public class Pair implements Comparable<Pair>
	{
		int wt;
		String path;
		Pair(){}
		Pair(int wt, String path)
		{
			this.wt=wt;
			this.path=path;
		}
		
		@Override
		public int compareTo(Pair o)
		{
			return this.wt-o.wt;
		}
	}
	
	String smallest, largest, ceil, floor;
	int swt=Integer.MAX_VALUE, lwt=Integer.MIN_VALUE;
	int ceilwt=Integer.MAX_VALUE, floorwt=Integer.MIN_VALUE;
	PriorityQueue<Pair> pq = new PriorityQueue<>();

	public void findDetails(int src, int des, ArrayList<Edge>[] adj, boolean[] vis, String psf, int wsf, int criteria, int k)
	{
		if(src==des)
		{
			if(wsf < swt)
			{
				swt = wsf;
				smallest = psf;
			}
			if(wsf > lwt)
			{
				lwt=wsf;
				largest = psf;
			}
			if(wsf>criteria && wsf<ceilwt)
			{
				ceilwt = wsf;
				ceil = psf;
			}
			if(wsf<criteria && wsf>floorwt)
			{
				floorwt = wsf;
				floor = psf;
			}
			
			if(pq.size()<k)
				pq.add(new Pair(wsf,psf));
			else
			{
				if(wsf>pq.peek().wt)
				{
					pq.remove();
					pq.add(new Pair(wsf,psf));
				}
			}
			return;
		}	
		vis[src]=true;
		for(Edge e : adj[src])
		{
			if(vis[e.getVertex()]==false)
				findDetails(e.getVertex(), des, adj, vis, psf+e.getVertex(), wsf+e.getWeight(), criteria, k);
		}
		vis[src]=false;
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
		
		int src, des, criteria, k, wsf=0;
		System.out.println("Enter the source: ");
		src = Integer.parseInt(in.readLine());
		System.out.println("Enter the destination: ");
		des = Integer.parseInt(in.readLine());
		System.out.println("Enter the criteria: ");
		criteria = Integer.parseInt(in.readLine());
		System.out.println("Enter k: ");
		k = Integer.parseInt(in.readLine());
		
		boolean[] vis = new boolean[v];
		DifferentPaths ob = new DifferentPaths();

		ob.findDetails(src,des,adj,vis,src+"", wsf, criteria, k);

	}
}
