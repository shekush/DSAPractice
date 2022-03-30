import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOf4 {

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number: ");
		int a=Integer.parseInt(in.readLine());
		int fac = 0b01010101010101010101010101010101;
		int res = (a & (a-1));
		if(res==0 && a>0 && (fac&a)>0)
			System.out.println("True");
		else
			System.out.println("False");

	}

}
