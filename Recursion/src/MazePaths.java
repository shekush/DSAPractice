import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MazePaths 
{
	public static ArrayList<String> getPaths(int i, int j, int desi, int desj)
	{
		if(desi==i && desj==j)
		{
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		
		ArrayList<String> h = new ArrayList<>();
		ArrayList<String> v = new ArrayList<>();
		
		if(i<desi)
			h=getPaths(i+1,j,desi,desj);
		
		if(j<desj)
			v=getPaths(i,j+1,desi,desj);
		
		ArrayList<String> res = new ArrayList<>();
		
		for(String paths: h)
		{
			res.add("h"+paths);
		}
		for(String paths: v)
		{
			res.add("v"+paths);
		}
		
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Source: ");
		int i = Integer.parseInt(in.readLine().trim());
		int j = Integer.parseInt(in.readLine().trim());
		
		System.out.println("Enter the Destination: ");
		int di = Integer.parseInt(in.readLine().trim());
		int dj = Integer.parseInt(in.readLine().trim());
		
		ArrayList<String> res = getPaths(i,j,di,dj);
		System.out.println(res);
	}

}
