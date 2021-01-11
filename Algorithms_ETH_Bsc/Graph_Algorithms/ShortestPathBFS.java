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
	
	public void printSP(int[] a) {
		System.out.println(Arrays.toString(a));
	}
	
	public void shortestPath(Graph g, int startPoint, int endPoint) {
		ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
		int[] length = new int[g.V];
		for (int i = 0; i < predecessor.length; i++) {
			predecessor[i] = -1;
		}
		
		Q.add(startPoint);
		
		while(!Q.isEmpty()) {
			int current = Q.poll();
			
			for (int i = 0; i < g.L.get(current).size(); i++) {
				if (predecessor[g.L.get(current).get(i).dest] == -1) {
					predecessor[g.L.get(current).get(i).dest] = current;
					length[g.L.get(current).get(i).dest] = length[current] + 1;
					Q.add(g.L.get(current).get(i).dest);
				}
			}
		}
		
		if (length[endPoint] != 0) {
			System.out.println("Shortest path length: " + length[endPoint]);			
		} else {
			System.out.println("No Path found from '" + startPoint + "' to '" + endPoint + "'!");
			return;
		}
		
		String s = "";
		int a = endPoint;
		while(a != -1) {
			s = a + " " + s;
			a = predecessor[a];
		}
		
		System.out.println(s);
	}
}
