package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPaths {
	
	public void hamiltonianPath(ArrayList<Edge>[] adj, HashSet<Integer> vis, int src, int osrc, String psf)
	{
		if(vis.size()==adj.length-1)
		{
			boolean flag=false;
			for(Edge e:adj[src])
			{
				if(e.getVertex()==osrc)
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
				System.out.println("Hamiltonian Cycle: "+psf);
			
			else
				System.out.println("Hamiltonian Path: "+psf);
			
			return;
		}
		
		vis.add(src);
		for(Edge e: adj[src])
		{
			if(vis.contains(e.getVertex())==false)
				hamiltonianPath(adj,vis,e.getVertex(),osrc,psf+e.getVertex());
		}
		
		vis.remove(src);
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
		HashSet<Integer> vis = new HashSet<>();
		
		System.out.println("Enter the source vertex: ");
		int src = Integer.parseInt(in.readLine());
		
		HamiltonianPaths ob = new HamiltonianPaths();
		ob.hamiltonianPath(adj,vis,src, src, src+"");

	}
}
