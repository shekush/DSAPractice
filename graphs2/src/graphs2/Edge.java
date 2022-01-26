package graphs2;

public class Edge {
	
	private int s, v, w;
	
	//constructor to create objects without any parameters
	Edge(){}
	
	//constructor to create objects with parameters
	Edge(int s, int v, int w)
	{
		this.s=s;
		this.v=v;
		this.w=w;
	}
	
	public int getSource(){ return s; }
	
	public int getVertex(){ return v; }
	
	public int getWeight(){ return w; }
}
