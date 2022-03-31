import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthBinaryPalindrome 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of N: ");
		int n = Integer.parseInt(in.readLine().trim());
	}

}
