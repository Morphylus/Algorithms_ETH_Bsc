import graphs.*;
import java.util.PriorityQueue;
import java.util.Arrays;


public class Dijkstras {
	Graph g;
	int[] predecessor;
	int[] distance;
	
	public Dijkstras(Graph g) {
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
			for (int i = 0; i < g.L.get(activeVertex).size(); i++) {
				int successor = g.L.get(activeVertex).get(i).dest;
				
				/* If the successor has not been inspected until now, we add the distance to the active vertex
				 * + the weight of the edge from the active vertex to the successor as the distance.*/
				if (predecessor[successor] == -1) {
					/* Sets the distance*/
					distance[successor] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					/* Sets the predecessor of the vertex*/
					predecessor[successor] = activeVertex;
					
					/* Adds the successor to the queue to check it later*/
					Q.add(new Node(successor, distance[successor]));
					
				/* This if sequence gets called if a distance has already been set for the next vertecie, but
				 * the distance over this edge makes the distance shorter, then we overwrite all the data*/
				} else if (distance[activeVertex] + g.L.get(activeVertex).get(i).weight < distance[g.L.get(activeVertex).get(i).dest]) {
					int prio = distance[successor];
					
					/* Updates the distance to the vertex*/
					distance[successor] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					/* Updates the predecessor of the vertex*/
					predecessor[successor] = activeVertex;
					
					/* Adds the vertex to the queue for later inspection*/
					Q.remove(new Node(successor, prio));
					Q.add(new Node(successor, distance[successor]));
				}
			}
		}
		
		/* Prints out the arrays*/
		for (int i = 0; i < predecessor.length; i++) {
			System.out.println("Vertex " + i + ":\nPredecessor: " + predecessor[i] + "\tSP_Distance: " + distance[i]);
		}
		
	}
	
	
	
	
	
}
