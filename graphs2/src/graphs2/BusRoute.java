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
	}

}
