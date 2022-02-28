import java.util.Scanner;

public class KernighanAlhorithm
{
	//This Algorithm counts the number of 1s in a Bit Pattern
	
	public static int numberOfOne(int n)
	{
		int count=0;
		while(n!=0)
		{
			int rsb = n & -n;
			n-=rsb;
			count++;
		}
		return count;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();

		int count = numberOfOne(n);
		
		System.out.println("The number of One in this number is: "+count);
	}

}
