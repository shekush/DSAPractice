import java.util.Scanner;

public class MaxInArray 
{
	public static int findMax(int[] arr, int i)
	{
		if(i==arr.length)
			return Integer.MIN_VALUE;
		
		int max = findMax(arr, i+1);
		if(max>arr[i])
			return max;
		else
			return arr[i];
			
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of an array: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<n; i++)
		{
			arr[i]=sc.nextInt();
		}
		int max = findMax(arr,0);
		System.out.println(max);
	}
}
