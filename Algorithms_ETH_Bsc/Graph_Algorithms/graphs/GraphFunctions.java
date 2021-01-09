package graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.LinkedList;
import java.util.Collections;


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
	
	/* Generates an unweighted/weighted random graph*/
	public static Graph createGraph(int V, int E, boolean weighted) throws IllegalArgumentException {
		Random rand = new Random();
		if (E < V || E > (V*(V-1))) {
			throw new IllegalArgumentException("To many/few edges!");
		}
		
		Graph g = new Graph(V);
		
		/* Unweighted graph*/
		if (weighted == false) {
			for (int i = 0; i < g.V; i++) {
				if(!g.addRandomEdge(i, rand.nextInt(V), 1)) {i--;} 
				else {E--;}
			}
			
			while (E > 0) {
				if(g.addRandomEdge(rand.nextInt(V), rand.nextInt(V), 1)) {E--;}
			}
		/* Weighted graph*/	
		} else {
			for (int i = 0; i < g.V; i++) {
				if(!g.addRandomEdge(i, rand.nextInt(V), rand.nextInt(20))) {i--;} 
				else {E--;}
			}
			
			while (E > 0) {
				if (g.addRandomEdge(rand.nextInt(V), rand.nextInt(V), rand.nextInt(20))) {E--;}
			}
		}
		return g;
	}
	
	//TODO Implement Acyclic graph generation
	/* Generate an unweighted/weighted random acyclic graph*/
	public static Graph createAcyclicGraph(int V, boolean weighted) {
		Random rand = new Random();
		ArrayList<Integer> permutation = new ArrayList<Integer>();
		
		Graph g = new Graph(V);
		
		// Creates random permutation to use as topological sort
		for (int i = 0; i < V; i++) {
			permutation.add(i);
		}
		Collections.shuffle(permutation);
		
		System.out.println(permutation.toString());
		
		if (weighted == false) {
			int E = rand.nextInt((V*(V-1))-V) + V;
			
			for (int i = 0; i < V-1; i++) {
				int pos = i;
				if (!g.addRandomEdge(permutation.get(pos), permutation.get(rand.nextInt(V - pos) + pos), 1)) {
					i--;
				} else {
					E--;
				}
			}
			
			
			
		}
		
		return g;
		
	}
}
