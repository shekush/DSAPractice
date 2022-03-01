import java.util.Scanner;

public class JosephusProblem 
{
	public static int calcPower(int n)
	{
		int i=1;
		while(i*2<=n)
		{
			i=i*2;
		}
		return i;
	}
	
	public static int solve(int n)
	{
		int highestPower = calcPower(n);
		int l = n-highestPower;
		return 2*l+1;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		
		int ans = solve(n);
		
		System.out.println(ans);
	}
}
