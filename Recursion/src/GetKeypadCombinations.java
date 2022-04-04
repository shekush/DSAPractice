import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetKeypadCombinations 
{
	static String[] keypad = {".,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	public static ArrayList<String> findAllWords(String s)
	{
		if(s.length()==0)
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		
		char ch = s.charAt(0);
		String sub = s.substring(1);
		ArrayList<String> res = findAllWords(sub);
		ArrayList<String> myres = new ArrayList<>();
		int l = res.size();
		String str = keypad[ch-'0'];
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<str.length();j++)
			{
				myres.add(str.charAt(j)+res.get(i));
			}
		}
		return myres;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Key Sequence: ");
		String s = in.readLine().trim();
		
		ArrayList<String> res = findAllWords(s);
		System.out.println(res);
	}

}
