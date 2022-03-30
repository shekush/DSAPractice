//given two numbers a and b and a range x,y
//take the range in a and turn the bits on in b with is on in a
//Eg: A=1001 1011 0001 and B=1101 0010 1001 the range is 4,7
//output: 1101 1011 1001 (changing the bits in B from therange in A)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TurnBitsOnInRange 
{
	public static int changeNumber(int a, int b, int x, int y)
	{
		int m1 = (1 << (y-x+1));
		m1--;
		int mask = (m1 << (x-1));
		mask = mask & a;
		b = b | mask;
		return b;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the two numbers: ");
		int a=Integer.parseInt(in.readLine());
		int b=Integer.parseInt(in.readLine());
		
		System.out.println("Enter the range: ");
		int x=Integer.parseInt(in.readLine());
		int y=Integer.parseInt(in.readLine());
		
		int n = changeNumber(a,b,x,y);
		System.out.println("The number of bits to flip to make two numbers same is  :  "+n);
	}

}
