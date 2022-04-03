import java.util.Scanner;

public class FindLastIndex 
{
	public static int findInd(int[] arr, int i, int x)
	{
		if(i==arr.length)
			return -1;
		
		int indLast = findInd(arr,i+1,x);
		if(indLast==-1)
		{
			if(arr[i]==x)
				return i;
			else
				return -1;
		}
		else
			return indLast;
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
		System.out.println("Enter the element to find its last index: ");
		int x = sc.nextInt();
		int ind = findInd(arr,0,x);
		System.out.println(ind);
	}
}
