package graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.LinkedList;


public class GraphFunctions {
	
	/* Prints a graph in LinkedList form*/
	public static void printGraph(Graph g) {
		for (int i = 0; i < g.V; i++) {
			System.out.print("Vertex " + i + ": ");
			
			if (g.L.get(i).size() > 0) {
				System.out.print(g.L.get(i).get(0).printEdge());				
			}
			
			for (int r = 1; r < g.L.get(i).size(); r++) {
				System.out.print(", " + g.L.get(i).get(r).printEdge());
			}
			System.out.println();
		}
	}
	
	//TODO Implement Random weighted/unweighted graph generation
	public static Graph createRandomPosGraph(int V, int E, boolean weighted) throws IllegalArgumentException {
		Random rand = new Random();
		LinkedList<Edge> memory = new LinkedList<Edge>();
		
		if (E > V*(V-1)) {
			throw new IllegalArgumentException("Too many edges");
		}
		
		Graph g = new Graph(V);
		
		if (weighted == false) {
			for (int i = 0; i < E; i++) {
				g.addEdge(rand.nextInt(V), rand.nextInt(V), 1);
			}
		} else {
			for (int i = 0; i < E; i++) {
				g.addEdge(rand.nextInt(V), rand.nextInt(V), rand.nextInt(100));
			}
		}
		
		return g;
		
	}
}
