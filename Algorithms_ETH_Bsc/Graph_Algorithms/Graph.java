import java.util.ArrayList;


public class Graph {
	
	int V;
	ArrayList<ArrayList<Edge>> L;
	
	/* Creates a Graph with V vertices*/
	public Graph(int v) {
		this.V = v;
		/* Each index of the ArrayList is a Vertex which contains all the edges of the vertex */
		L = new ArrayList<ArrayList<Edge>>();
		
		/* Adds a list to each vertex containing a list of edges*/
		for (int i = 0; i < v; i++) {
			L.add(new ArrayList<Edge>());
		}
	}
	
	/* Function to add an Edge with weight 'weight' connecting two Vertices 'src' and 'dest'*/
	public void addEdge(int src, int dest, int weight) {
		L.get(src).add(new Edge(dest,weight));
	}
	
	
	
}
