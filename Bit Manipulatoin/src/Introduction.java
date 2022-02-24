import java.util.Scanner;

public class Introduction 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the value of i, j, k, m");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		
		int onmask = (1 << i);
		int offmask = ~(1 << j);
		int togg = (1 << k);
		int cmask = (1 << m);
		
		System.out.println(n | onmask);
		System.out.println(n & offmask);
		System.out.println(n ^ togg);
		System.out.println((n&cmask) == 0?false:true);
	}
}
