import graphs.*;
import java.util.PriorityQueue;
import java.util.Arrays;


public class Dijkstra {
	Graph g;
	int[] predecessor;
	int[] distance;
	
	public Dijkstra(Graph g) {
		this.g = g;
		this.predecessor = new int[g.V];
		this.distance = new int[g.V];
	}
	
	
	public void shortestPath(int start) {
		/* Initialization of distance and predecessor arrays*/
		for (int i = 0; i < predecessor.length; i++) {
			predecessor[i] = -1;
			distance[i] = Integer.MAX_VALUE;
		}
		
		/* Initialization of starting point*/
		distance[start] = 0;
		predecessor[start] = -1;
		
		/* Queue Initialization */
		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		Q.add(new Node(start, 0));
		
		/* The while loop continues until all Vertecies have been inspected*/
		while(!Q.isEmpty()) {
			int activeVertex = Q.remove().getValue();
			
			/* This for loop inspects all the successors of the activeVertex*/
			for (Edge e : g.L.get(activeVertex)) {
				int dest = e.dest;
				
				/* If the successor has not been inspected until now, we add the distance to the active vertex
				 * + the weight of the edge from the active vertex to the successor as the distance.*/
				if (predecessor[dest] == -1) {
					/* Sets the distance*/
					distance[dest] = distance[activeVertex] + e.weight;
					/* Sets the predecessor of the vertex*/
					predecessor[dest] = activeVertex;
					
					/* Adds the successor to the queue to check it later*/
					Q.add(new Node(dest, distance[dest]));
					
				/* This if sequence gets called if a distance has already been set for the next vertecie, but
				 * the distance over this edge makes the distance shorter, then we overwrite all the data*/
				} else if (distance[activeVertex] + e.weight < distance[dest]) {
					int prio = distance[dest];
					
					/* Updates the distance to the vertex*/
					distance[dest] = distance[activeVertex] + e.weight;
					/* Updates the predecessor of the vertex*/
					predecessor[dest] = activeVertex;
					
					/* Adds the vertex to the queue for later inspection*/
					Q.remove(new Node(dest, prio));
					Q.add(new Node(dest, distance[dest]));
				}
			}
		}
		
		/* Prints out the arrays*/
		for (int i = 0; i < predecessor.length; i++) {
			System.out.println("\nVertex " + i + ":\nPredecessor: " + predecessor[i] + "\tSP_Distance: " + distance[i]);
		}
		
	}
	
	
	
	
	
}
