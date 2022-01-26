package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {

	public ArrayList<Edge>[] input()throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices: ");
		int v = Integer.parseInt(in.readLine());
		System.out.println("Enter the number of edges: ");
		int e = Integer.parseInt(in.readLine());
		ArrayList<Edge>[] adj = new ArrayList[v];
		for(int i=0; i<e; i++)
		{
			System.out.println("Enter the edge "+(i+1));
			String inp[] = in.readLine().trim().split(" ");
			int v1 = Integer.parseInt(inp[0]); 
			int v2 = Integer.parseInt(inp[1]); 
			int w = Integer.parseInt(inp[2]); 
			adj[v1].add(new Edge(v1,v2,w));
			adj[v2].add(new Edge(v2,v1,w));
		}
		
		return adj;
	}

}
