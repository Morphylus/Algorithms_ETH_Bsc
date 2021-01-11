import graphs.*;
import java.util.ArrayDeque;
import java.util.Arrays;


public class ShortestPathBFS {
	Graph g;
	int[] predecessor;
	
	public ShortestPathBFS(Graph g) {
		this.g = g;
		this.predecessor = new int[g.V];
	}
	
	
	public void shortestPath(Graph g, int startPoint, int endPoint) {
		/* Initialization of Queue, array that stores the length from startPoint to each endPoint
		 * and predecessor array that stores the predecessors of each vertex*/
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		int[] length = new int[g.V];
		for (int i = 0; i < predecessor.length; i++) {
			predecessor[i] = -1;
		}
		
		Q.add(startPoint);
		
		/* While loop continues until each vertex has been visited*/
		while(!Q.isEmpty()) {
			int current = Q.poll();
			
			/* For each successor of the currently active vertex, check if the predecessor has been stored,
			 * if it has been stored, it means the successor has already been visited,
			 * if not, set the predecessor of the successor to the current vertex (Line 1),
			 * set the length to get to the successor to the length to get to the current vertex + 1 (Line 2)
			 * and add the successor of the current vertex to the Queue (Line 3)*/
			for (int i = 0; i < g.L.get(current).size(); i++) {
				if (predecessor[g.L.get(current).get(i).dest] == -1) {
					//Line 1
					predecessor[g.L.get(current).get(i).dest] = current;
					//Line 2
					length[g.L.get(current).get(i).dest] = length[current] + 1;
					//Line 3
					Q.add(g.L.get(current).get(i).dest);
				}
			}
		}
		
		/* If a SP has been found, the program will print the length to get to the endPoint, otherwise
		 * it will print that there is no SP and return*/
		if (length[endPoint] != 0) {
			System.out.println("Shortest path length: " + length[endPoint]);			
		} else {
			System.out.println("No Path found from '" + startPoint + "' to '" + endPoint + "'!");
			return;
		}
		
		/* Reads the predecessor from the endPoint backwards in order to find the path and prints its*/
		String s = "";
		int a = endPoint;
		while(a != -1) {
			s = a + " " + s;
			a = predecessor[a];
		}
		
		System.out.println(s);
	}
	
	/* Note: The reason why this algorithm works is because the graph is unweighted, this means, if
	 * there is an edge (u,v), there is no other way (u,i) (i,v) s.t. the cost is smaller, this is why
	 * we can use BFS to find the SP on unweighted graphs*/
}
