import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//swap even and odd position bits
public class SwapBits 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		int n=Integer.parseInt(in.readLine());
		
		int oddMask = 0x55555555;
		int evenMask = 0xAAAAAAAA;
		
		int odds = (n & oddMask);
		int evens = (n & evenMask);
		
		odds<<=1;
		evens>>=1;
		
		n = (odds | evens);
		
		System.out.println(n);
	}

}
