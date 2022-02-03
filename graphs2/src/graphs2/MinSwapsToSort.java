package graphs2;

import java.util.Arrays;

public class MinSwapsToSort 
{
	
	class Pair implements Comparable<Pair>
	{
		int ele, ind;
		Pair(){}
		Pair(int ele, int ind)
		{
			this.ele = ele;
			this.ind = ind;
		}
		public int compareTo(Pair o)
		{
			return this.ele-o.ele;
		}
	}
	public int minSwaps(int[] arr)
	{
		int n=arr.length;
		Pair[] p = new Pair[n];
		for(int i=0; i<n; i++)
		{
			p[i] = new Pair(arr[i],i);
		}
		Arrays.sort(p);
		int res=0;
		boolean vis[] = new boolean[n];
		for(int i=0; i<n; i++)
		{
			if(vis[i]==true || p[i].ele == i)
				continue;
			
			int len = 0;
			int j = i;
			while(vis[j]==false)
			{
				vis[j]=true;
				len++;
				j=p[j].ind;
			}
			res += len-1;
		}
		return res;
	}
}
