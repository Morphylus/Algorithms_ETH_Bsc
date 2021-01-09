import java.util.ArrayList;
import java.util.Stack;
import graphs.*;


public class DepthFirstSearch {
	Graph g;
	boolean[] visited;
	
	public DepthFirstSearch(Graph g) {
		this.g = g;
		visited = new boolean[g.V];
	}
	
	
	public void dfs() {
		Stack<Integer> S = new Stack();
		S.push(0);
		
		while(!S.isEmpty()) {
			int w = S.pop();
			
			if (!visited[w]) {
				System.out.println(w);
				visited[w] = true;
				
				for (int i = 0; i < g.L.get(w).size(); i++) {
					if (!visited[g.L.get(w).get(i).dest]) {
						S.push(g.L.get(w).get(i).dest);
					}
				}
			}
		}
		
	}
}
