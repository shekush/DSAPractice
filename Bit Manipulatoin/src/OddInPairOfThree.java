import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddInPairOfThree 
{
	public static void solution(int[] arr)
	{
		int threeN=-1, threeN1=0, threeN2=0;
		int commonThreeN, commonThreeN1, commonThreeN2;
		
		for(int i=0; i<arr.length; i++)
		{
			commonThreeN = arr[i] & threeN;
			commonThreeN1 = arr[i] & threeN1;
			commonThreeN2 = arr[i] & threeN2;
			
			threeN = threeN & (~commonThreeN);
			threeN1 = threeN1 | commonThreeN;
			
			threeN1 = threeN1 & (~commonThreeN1);
			threeN2 = threeN2 | commonThreeN1;
			
			threeN2 = threeN2 & (~commonThreeN2);
			threeN = threeN | commonThreeN2;
		}
		System.out.println(threeN1);
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers");
		String inp[] = (in.readLine().trim().split(" "));
		int arr[] = new int[inp.length];
		int i=0;
		for(String s: inp)
		{
			arr[i] = Integer.parseInt(s);
			i++;
		}
		solution(arr);
	}

}
