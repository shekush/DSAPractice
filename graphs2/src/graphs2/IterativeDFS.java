package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS 
{
	public void getDFS(ArrayList<Edge>[] adj, boolean vis[], Stack<Integer> s)
	{
		while(!s.isEmpty())
		{
			int i = s.pop();
			if(vis[i]==true)
				continue;
			vis[i]=true;
			System.out.print(i+"  ");
			for(Edge e:adj[i])
			{
				if(vis[e.getVertex()]==false)
					s.push(e.getVertex());
			}
		}
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
		
		System.out.println("Enter the time: ");
		
		boolean vis[] = new boolean[v];
		Stack<Integer> s = new Stack<Integer>();
		IterativeDFS ob = new IterativeDFS();
		s.add(0);
		for(int i=0; i<v; i++)
		{
			if(vis[i]==false)
				ob.getDFS(adj, vis, s);
		}

	}

}
