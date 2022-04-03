import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetSubsequence 
{
	public static ArrayList<String> findAllSubsequence(String s)
	{
		if(s.length()==0)
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		
		char ch = s.charAt(0);
		String sub = s.substring(1);
		ArrayList<String> res = findAllSubsequence(sub);
		int l = res.size();
		for(int i=0;i<l;i++)
		{
			res.add(ch+res.get(i));
		}
		return res;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String: ");
		String s = in.readLine().trim();
		
		ArrayList<String> res = findAllSubsequence(s);
		System.out.println(res);
	}

}
