import graphs.*;

public class BellmannFord {
	Graph g;
	int[] d;
	int[] p;
	
	public BellmannFord(Graph g) {
		this.g = g;
		this.d = new int[g.V];
		this.p = new int[g.V];
	}
	
	public void shortestPath(int start) {
		/* Initialization of array distance and predecessor*/
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		
		/* Initialization of starting point*/
		d[start] = 0;
		
		/* For each vertex...*/
		for (int u = 0; u < g.V; u++) {
			/* ...look at the outgoing edge*/
			for(Edge e: g.L.get(u)) {
				int dest = e.dest;
				
				/* If the distance at the successor vertex is bigger than the distance from our position to it
				 * we will update the distance values and the predecessor values*/
				if (d[dest] > d[u] + e.weight) {
					d[dest] = d[u] + e.weight;
					p[dest] = u;
				}
			}
		}
		
		/* After |V| - 1 iterations, our graph has to be correct, if we still can get a lower value, this
		 * means the graph contains a negative cycle*/
		for (int i = 0; i < g.V; i++) {
			for (Edge e : g.L.get(i)) {
				if (d[i] + e.weight < d[e.dest]) {
					System.out.println("Graph contains a negative cycle!");
					return;
				}
			}
		}
		
		/* Prints out the arrays*/
		for (int i = 0; i < p.length; i++) {
			System.out.println("\nVertex " + i + ":\nPredecessor: " + p[i] + "\tSP_Distance: " + d[i]);
		}
		
	}
	
}
