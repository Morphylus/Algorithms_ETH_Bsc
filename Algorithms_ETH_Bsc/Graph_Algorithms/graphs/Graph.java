package graphs;
import java.util.ArrayList;


public class Graph {
	
	public int V;
	public ArrayList<ArrayList<Edge>> L;
	
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
		Edge e = new Edge(dest,weight);

			if (!L.get(src).contains(e) && src != dest) {
				L.get(src).add(e);
			}
		
	}
	
	/* Internal use only*/
	public boolean addRandomEdge(int src, int dest, int weight) {
		Edge e = new Edge(dest,weight);

			//Creates if there is: not a duplicate && not a arrow to itself
			if (!L.get(src).contains(e) && dest != src) {
				L.get(src).add(e);
				return true;
			} else {
				return false;
			}
		
	}
	
	
	
}
