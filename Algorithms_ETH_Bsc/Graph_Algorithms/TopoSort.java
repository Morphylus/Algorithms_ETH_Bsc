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

		for (int i = 0; i < g.V; i++) {
			for (int r = 0; r < g.L.get(i).size(); r++) {
				inDeg[g.L.get(i).get(r).dest]++;
			}
		}

		for (int i = 0; i < g.V; i++) {
			if (inDeg[i] == 0) {
				S.push(i);
			}
		}

		int i = 0;

		while (!S.isEmpty()) {
			int v = S.pop();
			topoOrder[v] = i;
			i++;

			for (int k = 0; k < g.L.get(v).size(); k++) {
				inDeg[g.L.get(v).get(k).dest]--;
				if (inDeg[g.L.get(v).get(k).dest] == 0) {
					S.push(g.L.get(v).get(k).dest);
				}
			}
		}

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
