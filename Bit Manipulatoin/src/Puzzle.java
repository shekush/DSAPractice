import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle 
{
	public static ArrayList<Integer> solution(String[] words, String[] puzzles)
	{
		HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
		for(String word : words)
		{
			int mask = 0;
			int len = word.length();
			for(int i=0; i<len; i++)
			{
				int bit = word.charAt(i) - 'a';
				mask = mask | (1 << bit);
			}
			for(int i=0; i<len; i++)
			{
				char c = word.charAt(i);
				if(hm.containsKey(c))
				{
					if(!hm.get(c).contains(mask))
						hm.get(c).add(mask);
				}
				else
				{
					hm.put(word.charAt(i), new ArrayList<Integer>());
					hm.get(word.charAt(i)).add(mask);
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(String puzzle : puzzles)
		{
			int mask = 0;
			int len = puzzle.length();
			for(int i=0; i<len; i++)
			{
				int bit = puzzle.charAt(i) - 'a';
				mask = mask | (1 << bit);
			}
			
			char first = puzzle.charAt(0);
			ArrayList<Integer> wordsToCheck = hm.get(first);
			int count = 0;
			for(int check : wordsToCheck)
			{
				if((check & mask)==check)
					count++;
			}
			res.add(count);
		}
		return res;
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the words");
		String words[] = (in.readLine().trim().split(" "));
		System.out.println("Enter the puzzle");
		String puzzles[] = (in.readLine().trim().split(" "));
		
		ArrayList<Integer> res = solution(words,puzzles);
		
		System.out.println(res);
	}

}
