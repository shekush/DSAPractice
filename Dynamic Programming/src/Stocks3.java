import java.util.Scanner;
//infinte number of transactions are allowed
//no two transactions can overlap
//there is a trasction fee
public class Stocks3 
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
		System.out.println("Enter the trasaction fee:");
		int fee = sc.nextInt();
		
		int buyState = -prices[0], newBuyState;
		int sellState = 0, newSellState;
		
		for(int i=1; i<n; i++)
		{
			if((sellState-prices[i])>buyState)
				newBuyState = sellState-prices[i];
			else
				newBuyState = buyState;
			
			if((buyState+prices[i]-fee)>sellState)
				newSellState = buyState+prices[i]-fee;
			else
				newSellState = sellState;
			
			buyState = newBuyState;
			sellState = newSellState;
		}
		
		System.out.println(sellState);
		sc.close();
		
	}
}
