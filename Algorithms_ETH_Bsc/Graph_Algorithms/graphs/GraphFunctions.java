package graphs;
import java.util.ArrayList;
import java.util.Arrays;


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
}
