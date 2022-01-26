package graphs2;

public class Edge {
	
	private int p, v, w;
	
	//constructor to create objects without any parameters
	Edge(){}
	
	//constructor to create objects with parameters
	Edge(int p, int v, int w)
	{
		this.p=p;
		this.v=v;
		this.w=w;
	}
	
	public int getParent(){ return p; }
	
	public int getVertex(){ return v; }
	
	public int getWeight(){ return w; }
}
