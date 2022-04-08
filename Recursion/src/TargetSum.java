import java.util.Scanner;

public class TargetSum 
{
	public static void findSum(int[] arr, int ind, int tar, int sum, String ans)
	{
		if(ind>arr.length)
			return;
		if(ind==arr.length)
		{
			if(sum==tar)
				System.out.println(ans);
			return;
		}
		
		findSum(arr,ind+1,tar,sum+arr[ind],ans+" "+arr[ind]);
		findSum(arr,ind+1,tar,sum,ans);
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
		System.out.println("Enter the target sum ");
		int tar = sc.nextInt();
		findSum(arr,0,tar,0,"");
	}
}
