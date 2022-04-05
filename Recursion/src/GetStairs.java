import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//from the nth floor return all the possible paths to the ground(0th) floor
//you can take 1,2 or 3 Steps at the same time
public class GetStairs 
{
	public static ArrayList<String> findAllPaths(int n)
	{
		if(n==0)
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		if(n<0)
			return null;
		
		ArrayList<String> res1 = findAllPaths(n-1);
		ArrayList<String> res2 = findAllPaths(n-2);
		ArrayList<String> res3 = findAllPaths(n-3);
		
		ArrayList<String> res = new ArrayList<>();
		
		for(String path : res1)
		{
			res.add(n+" "+path);
		}
		for(String path : res2)
		{
			res.add(n+" "+path);
		}
		for(String path : res3)
		{
			res.add(n+" "+path);
		}
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Source: ");
		int n = Integer.parseInt(in.readLine().trim());
		
		ArrayList<String> res = findAllPaths(n);
		System.out.println(res);
	}

}
