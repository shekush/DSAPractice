package graphs2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoute 
{
	public int getNumberOrBuses(int src, int des, int[][] route)
	{
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		int n=route.length;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<route[i].length; j++)
			{
				int busstop = route[i][j];
				ArrayList<Integer> busno = map.getOrDefault(busstop, new ArrayList<>());
				busno.add(i);
				map.put(busstop, busno);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visBus = new HashSet<>();
		HashSet<Integer> visStop = new HashSet<>();
		int lev = 0;
		q.add(src);
		visStop.add(src);
		
		while(!q.isEmpty())
		{
			int size = q.size();
			while(size-->0)
			{
				int tmp = q.poll();
				if(tmp==des)
					return lev;
				
				ArrayList<Integer> buses = map.get(tmp);
				for(int bus:buses)
				{
					if(visBus.contains(bus))
						continue;
					
					int arr[] = route[bus];
					for(int stop:arr)
					{
						if(visStop.contains(stop))
							continue;
						
						q.add(stop);
						visStop.add(stop);
					}
					visBus.add(bus);
				}
			}
			lev++;
		}
		return -1;
	}
}