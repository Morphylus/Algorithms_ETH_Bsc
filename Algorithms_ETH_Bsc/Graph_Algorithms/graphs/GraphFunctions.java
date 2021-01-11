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
	
	/* Generate an unweighted/weighted random acyclic graph*/
	public static Graph createAcyclicGraph(int V, int E, boolean weighted, int[] perm) {
		if (E > (V*(V-1)) || E < V) {
			throw new IllegalArgumentException("To many/few edges");
		}
		
		Random rand = new Random();
		ArrayList<Integer> permutation = new ArrayList<Integer>();
		
		Graph g = new Graph(V);
		
		/* Create a random permutation if the user did not specify a permutation, otherwise it uses
		 * the permutation of the user as permutation*/
		if (perm == null) {
			for (int i = 0; i < V; i++) {
				permutation.add(i);
			}		
			Collections.shuffle(permutation);			
		} else {
			for (int i = 0; i < V; i++) {
				permutation.add(perm[i]);
			}
		}
		
		System.out.println(permutation.toString());
		
		/* This will create an unweighted graph*/
		if (weighted == false) {
			for (int i = 0; i < V-1; i++) {
				int pos = i;
				if (!g.addRandomEdge(permutation.get(pos), permutation.get(rand.nextInt(V - pos) + pos), 1)) {i--;} 
				else {E--;}
			}
			
			while (E > 0) {
				int srcIndex = rand.nextInt(V-1);
				int destIndex = rand.nextInt((V-1) - srcIndex) + srcIndex;
				
				if (g.addRandomEdge(permutation.get(srcIndex), permutation.get(destIndex), 1)) {E--;}
			}
			
			
		/* This will create a weighted graph*/
		} else {
			for (int i = 0; i < V-1; i++) {
				int pos = i;
				if (!g.addRandomEdge(permutation.get(pos), permutation.get(rand.nextInt(V - pos) + pos), rand.nextInt(20))) {i--;} 
				else {E--;}
			}
			
			while (E > 0) {
				int srcIndex = rand.nextInt(V-1);
				int destIndex = rand.nextInt((V-1) - srcIndex) + srcIndex;
				
				if (g.addRandomEdge(permutation.get(srcIndex), permutation.get(destIndex), rand.nextInt(20))) {E--;}
			}
		}
		
		return g;
		
	}
}
