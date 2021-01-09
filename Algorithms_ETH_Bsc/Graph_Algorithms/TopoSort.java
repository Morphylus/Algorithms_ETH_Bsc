import java.util.Arrays;
import java.util.Stack;
import graphs.*;

public class TopoSort {

	Graph g;
	private int[] inDeg;
	private int[] topoOrder;

	public TopoSort(Graph g) {
		this.g = g;
		inDeg = new int[g.V];
		topoOrder = new int[g.V];
	}
	
	public void topoSort() {
		Stack<Integer> S = new Stack<Integer>();

		/* Stores the inDegrees of each vertex*/
		for (int i = 0; i < g.V; i++) {
			for (int r = 0; r < g.L.get(i).size(); r++) {
				inDeg[g.L.get(i).get(r).dest]++;
			}
		}
		
		/* All the vertecies that do not have a predecessor are added to the stack*/
		for (int i = 0; i < g.V; i++) {
			if (inDeg[i] == 0) {
				S.push(i);
			}
		}

		int i = 0;

		/* The while loop continues until every vertex has been checked*/
		while (!S.isEmpty()) {
			/* Takes out a vertex that has no predecessor, puts its index in the topoOrder array at position 'i',
			 * then 'i' gets incremented, where the next vertex will be put in*/
			int v = S.pop();
			topoOrder[v] = i;
			i++;

			/* Each successor of the vertex that was taken out has now one predecessor less, so we
			 * decrement the in degree of each successor of 'v'*/
			for (int k = 0; k < g.L.get(v).size(); k++) {
				inDeg[g.L.get(v).get(k).dest]--;
				if (inDeg[g.L.get(v).get(k).dest] == 0) {
					/* If a vertex has now in degree = 0, it will be added to our Stack, since that one will
					 * come next in the topological order*/
					S.push(g.L.get(v).get(k).dest);
				}
			}
		}

		/* If the amount of vertices in our topologically ordered array is equals to the amount of nodes, the whole
		 * graph has been added successfully to the topological sort and we can print it out
		 * If the amount does not correspond to the amount of vertices, topoSort was unsuccessful(even though it
		 * scanned all the vertices) and the conclusion is that we have a cycle*/
		if (i == g.V) {
			print(topoOrder);
		} else {
			System.out.println("Graph contains a Cycle!");
		}
		
	}
	
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
