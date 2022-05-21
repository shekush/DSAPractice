import java.util.Scanner;

public class StairsMin 
{
	static Integer stair[];
	public static void getStairs(int[] steps)
	{
		stair[stair.length-1]=0;
		for(int i=stair.length-2; i>=0; i--)
		{
			if(steps[i]>0)
			{
				int min = Integer.MAX_VALUE;
				for(int j=1; j<=steps[i]; j++)
				{
					if((i+j)>=stair.length)
						break;
					if(stair[i+j]!=null && min>stair[i+j])
						min=stair[i+j];
				}
				if(min!=Integer.MAX_VALUE)
					stair[i]=min+1;
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the destination from stair 0:");
		int des = sc.nextInt();
		stair = new Integer[des+1];
		int steps[] = new int[des+1];
		System.out.println("Enter the steps possible to take from each stair:");
		for(int i=0; i<steps.length-1; i++)
		{
			steps[i] = sc.nextInt();
		}
		
		getStairs(steps);
		
		System.out.println(stair[0]);
	}
}
