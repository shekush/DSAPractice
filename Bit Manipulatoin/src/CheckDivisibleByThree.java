import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//check if a binary string (boolean number) is divisible by 3 (boolean 11)
public class CheckDivisibleByThree 
{
	public static boolean checkDivisibleBy11(String n)
	{
		int even=0, odd=0;
		int l=n.length();
		for(int i=0; i<l; i++)
		{
			int bit = n.charAt(i)-'0';
			if(i%2==0)
				even+=bit;
			else
				odd+=bit;
		}
		if((even-odd)%11==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		String n=in.readLine().trim();
		
		System.out.println(checkDivisibleBy11(n));
	}

}
