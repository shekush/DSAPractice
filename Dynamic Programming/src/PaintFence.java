import java.util.Scanner;

public class PaintFence {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of fence");
		int n = sc.nextInt();
		System.out.println("Enter the number of colors");
		int k = sc.nextInt();
		
		int same = k;
		int diff = k*(k-1);
		int total = same + diff;
		
		for(int i=2; i<n; i++)
		{
			same = diff;
			diff = total*(k-1);
			total = same + diff;
		}
		System.out.println(total);
	}

}
