import java.util.Scanner;

public class Stocks1 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of stocks:");
		int n = sc.nextInt();
		int prices[] = new int[n];
		System.out.println("Enter the prices:");
		for(int i=0; i<n; i++)
		{
			prices[i]=sc.nextInt();
		}
		
		int minPrice = Integer.MAX_VALUE;
		int overallProfit = Integer.MIN_VALUE, currentProfit;
		
		for(int i=0; i<n; i++)
		{
			if(prices[i]<minPrice)
				minPrice = prices[i];
			
			currentProfit = prices[i] - minPrice;
			if(currentProfit>overallProfit)
				overallProfit = currentProfit;
		}
		
		System.out.println(overallProfit);
		sc.close();
	}

}
