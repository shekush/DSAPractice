import java.util.Scanner;
//infinte number of transactions are allowed
//no two transactions can overlap
//a cool down time of 1 day is needed
public class Stocks4 
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
		
		int buyState = -prices[0], newBuyState;
		int sellState = 0, newSellState;
		int cooledState = 0, newCooledState;
		
		for(int i=1; i<n; i++)
		{
			
			if(cooledState - prices[i] > buyState)
				newBuyState = cooledState - prices[i];
			else
				newBuyState = buyState;
			
			//logic to be written
			//if(prices[i]-buyState > sellState)
				//newSellState = prices[i] - buyState;
			//else
				//newSellState = sellState;
			
			if(sellState > cooledState)
				newCooledState = sellState;
			else
				newCooledState = cooledState;
			
			buyState = newBuyState;
			sellState = newSellState;
			cooledState = newCooledState;
		}
		
		System.out.println(sellState);
		sc.close();
		
	}
}