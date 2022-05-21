import java.util.Scanner;

public class ClimbingStairs 
{
	static int stair[];
	public static void getStairs()
	{
		stair[0]=1;
		stair[1]=1;
		stair[2]=2;
		for(int i=3; i<stair.length; i++)
		{
			stair[i] = stair[i-1]+stair[i-2]+stair[i-3];
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the destination from stair 0:");
		int des = sc.nextInt();
		stair = new int[des+1];
		
		getStairs();
		
		System.out.println(stair[des]);
	}

}
