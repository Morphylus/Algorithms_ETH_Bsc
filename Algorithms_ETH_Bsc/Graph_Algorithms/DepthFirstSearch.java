import java.util.ArrayList;
import java.util.Stack;
import graphs.*;


public class DepthFirstSearch {
	Graph g;
	boolean[] visited;
	
	/* Initialization of graph 'g' and visited array of size 'V' (Amount of vertecies in g)*/
	public DepthFirstSearch(Graph g) {
		this.g = g;
		visited = new boolean[g.V];
	}
	
	
	public void dfs() {
		/* Creates the Stack for DFS and pushed the first node to the stack*/
		Stack<Integer> S = new Stack();
		S.push(0);
		
		/* Execute while loop until every vertex has been checked*/
		while(!S.isEmpty()) {
			/* Pop the vertex an assign it to 'w'*/
			int w = S.pop();
			
			/* Check if 'w' hasn't been visited before*/
			if (!visited[w]) {
				/* Print vertex 'w' and marks it as visited*/
				System.out.println(w);
				visited[w] = true;
				
				/* Adds each neighbour of 'w' that hasn't been visited before to the stack*/
				for (int i = 0; i < g.L.get(w).size(); i++) {
					if (!visited[g.L.get(w).get(i).dest]) {
						S.push(g.L.get(w).get(i).dest);
					}
				}
			}
		}
		
	}
}
