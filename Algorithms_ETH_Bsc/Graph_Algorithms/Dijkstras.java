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
			predecessor[i] = Integer.MAX_VALUE;
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
			int activeVertex = Q.poll().getValue();
			
			/* This for loop inspects all the successors of the activeVertex*/
			for (int i = 0; i < g.L.get(activeVertex).size(); i++) {
				
				if (predecessor[g.L.get(activeVertex).get(i).dest] == Integer.MAX_VALUE) {
					distance[g.L.get(activeVertex).get(i).dest] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					predecessor[g.L.get(activeVertex).get(i).dest] = activeVertex;
					
					Q.add(new Node(i, distance[g.L.get(activeVertex).get(i).dest]));
					
				} else if (distance[activeVertex] + g.L.get(activeVertex).get(i).weight < distance[g.L.get(activeVertex).get(i).dest]) {
					int prio = distance[g.L.get(activeVertex).get(i).dest];
					
					distance[g.L.get(activeVertex).get(i).dest] = distance[activeVertex] + g.L.get(activeVertex).get(i).weight;
					predecessor[g.L.get(activeVertex).get(i).dest] = activeVertex;
					
					Q.remove(new Node(i, prio));
					Q.add(new Node(i, distance[g.L.get(activeVertex).get(i).dest]));
				}
			}
		}
		
		for (int i = 0; i < predecessor.length; i++) {
			System.out.println("Vertex " + i + ":\nPredecessor: " + predecessor[i] + "\tSP_Distance: " + distance[i]);
		}
		
	}
	
	
	
	
	
}
