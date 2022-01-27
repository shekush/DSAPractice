package graphs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IsConnected {

	public static void main(String[] args)throws IOException
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of vertices: ");
		int v = Integer.parseInt(in.readLine());
		System.out.println("Enter the number of edges: ");
		int e = Integer.parseInt(in.readLine());
		
		Input obj = new Input();
		ArrayList<Edge>[] adj = obj.input(v,e);
		boolean[] vis = new boolean[v];
		
		ConnectedComponents ob = new ConnectedComponents();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		
		boolean flag=true;
		
		for(int i=0; i<v; i++)
		{
			if(vis[i]==false && i!=0)
			{
				flag=false;
				break;
			}
			if(vis[i]==false)
			{
				ArrayList<Integer> tmp = new ArrayList<>();
				ob.getConnected(adj,i,tmp,vis);
				res.add(tmp);
			}
		}
		System.out.println(flag);
	}
}
