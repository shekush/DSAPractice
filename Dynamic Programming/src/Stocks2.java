import java.util.Scanner;

//infinte number of transactions are allowed
//no two transactions can overlap
public class Stocks2 
{

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
		
		int buy=0, sell=0;
		int overallProfit=0;
		
		for(int i=1; i<n; i++)
		{
			if(prices[i]>=prices[i-1])
			{
				sell++;
			}
			else
			{
				overallProfit = prices[buy]-prices[sell];
				buy = sell = i;
			}
		}
		overallProfit = prices[sell]-prices[buy];
		System.out.println(overallProfit);
		sc.close();

	}
}
