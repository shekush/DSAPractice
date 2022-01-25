package graphs;

import java.util.Comparator;

public class Pairs implements Comparator<Pairs> {
    private int v, w;
    public Pairs(int v, int w) {
        this.v = v;
        this.w = w; 
    }
    public Pairs() {
	}
	public int getV()
    {
    	return v;
    }
    public int getW()
    {
    	return w;
    }
    public int compare(Pairs first, Pairs second)
    {
    	if(first.getW()<second.getW())
    		return -1;
    	else if(first.getW()>second.getW())
    		return 1;
    	else
    		return 0;
    }
}