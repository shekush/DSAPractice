import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Abbreviations 
{
	public static void solution(String s)
	{
		for(int i=0; i<(1 << s.length()); i++)
		{
			StringBuilder sb = new StringBuilder();
			int count=0;
			for(int j=0; j<s.length(); j++)
			{
				char c = s.charAt(j);
				int b = s.length()-1-j;
				
				if((i & (1 << b))==0)
				{
					if(count==0)
					{
						sb.append(c);
					}
					else
					{
						sb.append(count);
						sb.append(c);
						count=0;
					}
				}
				else
					count++;
			}
			if(count>0)
				sb.append(count);
			
			System.out.println(sb);
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string: ");
		String s = in.readLine().trim();
		solution(s);
	}

}
