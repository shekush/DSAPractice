import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations 
{
	public static void printPermutations(String s, String ans)
	{
		if(s.length()==0)
		{
			System.out.println(ans);
			return;
		}
		
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			String left = s.substring(0,i);
			String right = s.substring(i+1);
			String rem = left+right;
			printPermutations(rem, ans+c);
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the String: ");
		String s = in.readLine().trim();
		
		printPermutations(s,"");
	}

}
