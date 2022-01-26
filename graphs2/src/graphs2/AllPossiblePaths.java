package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AllPossiblePaths {
	
	public void possiblePath(int src, int des, ArrayList<Edge>[] adj, boolean[] vis, String psf)
	{
		if(src==des)
		{
			System.out.println(psf);
			return;
		}
		
		vis[src]=true;
		for(Edge e : adj[src])
		{
			if(vis[e.getVertex()]==false)
				possiblePath(e.getVertex(), des, adj, vis, psf+e.getVertex());
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
		
		int src, des;
		System.out.println("Enter the source: ");
		src = Integer.parseInt(in.readLine());
		System.out.println("Enter the destination: ");
		des = Integer.parseInt(in.readLine());
		
		boolean[] vis = new boolean[v];
		AllPossiblePaths ob = new AllPossiblePaths();

		ob.possiblePath(src,des,adj,vis,src+"");

	}
}
