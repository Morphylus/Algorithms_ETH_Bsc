package graphs;

public class Edge {
	public int weight;
	public int dest;
	
	public Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
	
	public String printEdge() {
		return "(" + dest + ", " + weight + ")"; 
	}
	
	public boolean equals(Object o) {
		return o instanceof Edge && ((Edge)o).dest == dest;
	}
}
