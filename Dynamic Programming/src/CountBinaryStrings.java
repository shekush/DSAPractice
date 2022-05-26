import java.util.Scanner;

//you are given a number n 
//find the total number of binary strings possible
//Note that there should be no consecutive zeroes 
public class CountBinaryStrings 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int zeroes=1; // number of numbers ending with zeroes and not having consecutive 00
		int ones=1; // number of numbers ending with ones and not having consecutive00
		for(int i=1; i<n; i++)
		{
			int oldzeroes = zeroes;
			zeroes=ones;
			ones+=oldzeroes;
		}
		System.out.println(ones+zeroes);
		sc.close();
	}

}
