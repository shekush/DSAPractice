import java.util.Scanner;

//we are given an array of 3 cols
//each col represent the cost of colors r g b
//find the min cost to paint the house
//no two houses must of the same adjacent color 
public class PaintHouse 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Houses");
		int n = sc.nextInt();
		int[][] vals = new int[n][3];
		System.out.println("Enter the values for red, green, blue: ");
		for(int i=0; i<n; i++)
		{
			vals[i][0]=sc.nextInt();
			vals[i][1]=sc.nextInt();
			vals[i][2]=sc.nextInt();
		}
		
		int[] red = new int[n];
		int[] green = new int[n];
		int[] blue = new int[n];
		
		red[0] = vals[0][0];
		green[0] = vals[0][1];
		blue[0] = vals[0][2];
		
		for(int i=1; i<n; i++)
		{
			red[i] = vals[i][0] + (green[i-1]<blue[i-1]?green[i-1]:blue[i-1]);
			green[i] = vals[i][1] + (red[i-1]<blue[i-1]?red[i-1]:blue[i-1]);
			blue[i] = vals[i][2] + (red[i-1]<green[i-1]?red[i-1]:green[i-1]);
		}
		
		int min = red[n-1]<green[n-1]?(red[n-1]<blue[n-1]?red[n-1]:blue[n-1]):(green[n-1]<blue[n-1]?green[n-1]:blue[n-1]);
		System.out.println(min);
		
		sc.close();
	}

}
