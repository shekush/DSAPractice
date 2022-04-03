import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TowerOfHanoi 
{
	public static void toh(int n, int t1, int t2, int t3)
	{
		if(n==0)
			return ;
		
		toh(n-1, t1, t3, t2);
		System.out.println(n+"["+t1+" -> "+t2+"]");
		toh(n-1, t3, t2, t1);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of disks: ");
		int n = Integer.parseInt(in.readLine().trim());
		System.out.println("Enter the names of the towers: ");
		int t1 = Integer.parseInt(in.readLine().trim());
		int t2 = Integer.parseInt(in.readLine().trim());
		int t3 = Integer.parseInt(in.readLine().trim());
		toh(n, t1, t2, t3);
	}

}
