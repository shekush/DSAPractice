package graphs2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HasPath {
	
	public boolean hasPath(int src, int des, ArrayList<Edge>[] adj, boolean[] vis)
	{
		if(src==des)
			return true;
		
		vis[src]=true;
		for(Edge e : adj[src])
		{
			if(vis[e.getVertex()]==false)
			{
				boolean check = hasPath(e.getVertex(), des, adj, vis);
				if(check == true)
					return true;
			}
		}
		
		return false;
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
		HasPath ob = new HasPath();
		
		boolean check=false;
		
		for(int i=0; i<e; i++)
		{
			if(vis[i]==false)
				check = ob.hasPath(src,des,adj,vis);
			
			if(check==true)
				break;
		}
		
		if(check==true)
			System.out.println("Path exists");
		else
			System.out.println("Path does not exist");
	}

}
