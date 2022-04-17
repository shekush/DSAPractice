import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CryptarithmeticPuzzle 
{
	public static int getNumber(String s, HashMap<Character,Integer> map)
	{
		String n = "";
		for(int i=0; i<s.length(); i++)
		{
			n+=map.get(s.charAt(i));
		}
		return Integer.parseInt(n);
	}
	public static void solution(HashMap<Character,Integer> map, int ind, String unique, String first, String second, String third, boolean[] vis)
	{
		if(ind==unique.length())
		{
			int firstnum = getNumber(first,map);
			int secondnum = getNumber(second,map);
			int thirdnum = getNumber(third,map);
			
			if(firstnum+secondnum==thirdnum)
			{
				for(int i=0; i<26; i++)
				{
					char ch = (char)('a'+i);
					if(map.containsKey(ch))
						System.out.print(ch+" -> "+map.get(ch)+"  ");
				}
				System.out.println();
				System.out.println("---------------------------------------------------------------------");
			}
			return;
		}
		char c = unique.charAt(ind);
		for(int i=0 ;i<=9; i++)
		{
			if(vis[i]==false)
			{
				vis[i]=true;
				map.put(c, i);
				solution(map,ind+1,unique,first,second,third,vis);
				vis[i]=false;
				map.put(c, -1);
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the first word:");
		String first = in.readLine().trim();
		System.out.println("Enter the second word:");
		String second = in.readLine().trim();
		System.out.println("Enter the third word:");
		String third = in.readLine().trim();
		
		HashMap<Character,Integer> map = new HashMap<>();
		String unique="";
		
		for(int i=0; i<first.length(); i++)
		{
			if(!map.containsKey(first.charAt(i)))
			{
				map.put(first.charAt(i), -1);
				unique+=first.charAt(i);
			}
		}
		for(int i=0; i<second.length(); i++)
		{
			if(!map.containsKey(second.charAt(i)))
			{
				map.put(second.charAt(i), -1);	
				unique+=second.charAt(i);
			}
		}
		for(int i=0; i<third.length(); i++)
		{
			if(!map.containsKey(third.charAt(i)))
			{
				map.put(third.charAt(i), -1);
				unique+=third.charAt(i);
			}
		}
		boolean vis[] = new boolean[10];
		solution(map,0,unique,first,second,third,vis);
	}
}