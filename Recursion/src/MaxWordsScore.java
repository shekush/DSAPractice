import java.util.Scanner;

public class MaxWordsScore 
{
	public static int solution(String[] words, int[] score, int[] freq, int i)
	{
		if(i==words.length)
			return 0;
		
		int temp = solution(words,score,freq,i+1);
		
		int scoreWord = 0;
		String word = words[i];
		boolean flag=true;
		for(int j=0; j<word.length(); j++)
		{
			char c = word.charAt(j);
			if(freq[c-'a']==0)
				flag=false;
			
			freq[c-'a']--;
			scoreWord += score[c-'a'];
		}
		
		int sc = 0;
		if(flag)
			sc = scoreWord + solution(words,score,freq,i+1);
		
		return(Math.max(sc, temp));
		
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of words");
		int n = sc.nextInt();
		String words[] = new String[n];
		System.out.println("Enter the words");
		for(int i=0; i<n; i++)
		{
			words[i]=sc.next();
		}
		
		System.out.println("Enter the number of character frequency");
		int m = sc.nextInt();
		char alpha[] = new char[m];
		System.out.println("Enter the characters");
		for(int i=0; i<m; i++)
		{
			alpha[i]=sc.nextLine().charAt(0);
		}
		
		int score[] = new int[26];
		System.out.println("Enter the score of each alphabets:");
		for(int i=0; i<26; i++)
		{
			score[i]=sc.nextInt();
		}
		
		if(n==0 || m==0 || alpha==null || words==null || score==null)
		{
			System.out.println(0);
			return;
		}
		
		int freq[] = new int[26];
		for(char c: alpha)
		{
			freq[c-'a']++;
		}
		
		int max_score = solution(words,score,freq,0);
		System.out.println(max_score);
	}
}
