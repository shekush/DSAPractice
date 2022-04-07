import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encoding 
{
	public static void encode(String s, String ans)
	{
		if(s.length()==0)
		{
			System.out.println(ans);
			return;
		}
		else if(s.length()==1)
		{
			if(s.charAt(0)=='0')
				return;
			else
			{
				int c = s.charAt(0) - '0';
				char ch = (char) ('a'+c-1);
				System.out.println(ans+ch);
			}
			return;
		}
		char c = s.charAt(0);
		String sub = s.substring(1);
		
		if(c=='0')
			return;
		else
		{
			int cc = s.charAt(0) - '0';
			char ch = (char) ('a'+cc-1);
			encode(sub, ans+ch);
		}
		
		String s12 = s.substring(0,2);
		String sub12 = s.substring(2);;
		
		int c12 = Integer.parseInt(s12);
		if(c12<=26)
		{
			char ch = (char) ('a'+c12-1);
			encode(sub12, ans+ch);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number: ");
		String s = in.readLine().trim();
		
		encode(s,"");
	}
}
