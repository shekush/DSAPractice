import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MinDevelopers 
{
	static ArrayList<Integer> sol = new ArrayList<>();
	
	public static void solution(int[] people, int n, int currPerson, ArrayList<Integer> tmpSol, int currSkillMask)
	{
		if(currPerson==people.length)
		{
			if(currSkillMask == ((1 << n)-1))
			{
				if(sol.size()==0 || sol.size()>tmpSol.size())
					sol = new ArrayList<>(tmpSol);
			}
			return;
		}
		
		//no mask takes place
		solution(people, n, currPerson+1, tmpSol, currSkillMask); 
		
		//mask takes place
		tmpSol.add(currPerson);
		solution(people, n, currPerson+1, tmpSol, currSkillMask | people[currPerson]);
		tmpSol.remove(tmpSol.size()-1);
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of skills: ");
		int n = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		System.out.println("Enter the skills");
		for(int i=0; i<n; i++)
		{
			hm.put(sc.next(), i);
		}
		System.out.println("Enter the number of people");
		int p = sc.nextInt();
		int[] people = new int[p];
		for(int i=0; i<p; i++)
		{
			System.out.println("Enter the number of skills of Person "+i);
			int numOfSkills = sc.nextInt();
			System.out.println("Enter the skills of Person "+i);
			for(int j=0; j<numOfSkills; j++)
			{
				String str = sc.next();
				int tmp = hm.get(str);
				people[i] = people[i] | (1 << tmp);
			}
		}
		
		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
	}

}
