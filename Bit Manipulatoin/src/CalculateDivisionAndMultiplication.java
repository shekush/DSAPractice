//calculate 7n/8 without using division and multiplication operator

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateDivisionAndMultiplication 
{

	public static void main(String[] args)  throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		int n=Integer.parseInt(in.readLine());
		int res = (((n << 3)-n) >> 3);
		System.out.println(res);
	}

}
