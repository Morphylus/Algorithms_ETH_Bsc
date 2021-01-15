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
		
		/* The while loop continues until all Vertevies have been inspected*/
		while(!Q.isEmpty()) {
			int activeVertex = Q.remove().getValue();
			
			/* This for loop inspects all the successors of the activeVertex*/
			for (int i = 0; i < g.L.get(activeVertex).size(); i++) {
				int successor = g.L.get(activeVertex).get(i).dest;
				
				
				if (predecessor[successor] == -1) {
					distance[successor] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					predecessor[successor] = activeVertex;
					
					Q.add(new Node(successor, distance[successor]));
					
				} else if (distance[activeVertex] + g.L.get(activeVertex).get(i).weight < distance[g.L.get(activeVertex).get(i).dest]) {
					int prio = distance[successor];
					
					distance[successor] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					predecessor[successor] = activeVertex;
					
					Q.remove(new Node(successor, prio));
					Q.add(new Node(successor, distance[successor]));
				}
			}
		}
		
		for (int i = 0; i < predecessor.length; i++) {
			System.out.println("Vertex " + i + ":\nPredecessor: " + predecessor[i] + "\tSP_Distance: " + distance[i]);
		}
		
	}
	
	
	
	
	
}
