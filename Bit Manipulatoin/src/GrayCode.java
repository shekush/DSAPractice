import java.util.ArrayList;

public class GrayCode 
{
	public static ArrayList<String> solution(int n)
	{
		if(n==1)
		{
			ArrayList<String> res = new ArrayList<>();
			res.add("0");
			res.add("1");
			return res;
		}
		ArrayList<String> tmpres = solution(n-1);
		ArrayList<String> finalres = new ArrayList<>();
		for(int i=0; i<tmpres.size(); i++)
		{
			String str = "0" + tmpres.get(i);
			finalres.add(str);
		}
		for(int i=tmpres.size()-1; i>=0; i--)
		{
			String str = "1" + tmpres.get(i);
			finalres.add(str);
		}
		return finalres;
	}
}
