import java.util.Scanner;

public class RSB {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		int rsb = (n & -n);
		System.out.println(rsb);
	}
}
