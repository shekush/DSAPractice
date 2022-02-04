package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class ZeroOneBFS 
{
	public static class Pair implements Comparable<Pair>
	{
		int v,w;
		Pair(){}
		Pair(int v, int w)
		{
			this.v=v;
			this.w=w;
		}
		public int compareTo(Pair o)
		{
			return this.w-o.w;
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices");
		int v = Integer.parseInt(in.readLine());
		System.out.println("Enter the number of edges");
		int e = Integer.parseInt(in.readLine());
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<v; i++)
			adj.add(new ArrayList<Pair>());
		
		System.out.println("Enter the edges: ");
		for(int i=0; i<e; i++)
		{
			String[] inp = (in.readLine()).trim().split(" ");
			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[0]);
			adj.get(x).add(new Pair(y,0));
			adj.get(y).add(new Pair(x,1));
		}
		
		LinkedList<Pair> p = new LinkedList<>();
		boolean vis[] = new boolean[v];
		p.addFirst(new Pair(0,0));
		
		while(!p.isEmpty())
		{
			Pair tmp = p.removeFirst();
			vis[tmp.v]=true;
			
			if(tmp.v == v-1)
			{
				System.out.println(tmp.w);
				return;
			}
			for(Pair pairs:adj.get(tmp.v))
			{
				if(vis[pairs.v])
					continue;
				if(pairs.w==0)
					p.addFirst(new Pair(pairs.v, tmp.w));
				else
					p.addLast(new Pair(pairs.v, tmp.w + 1));
			}
		}
		System.out.println("-1");
	}
}
