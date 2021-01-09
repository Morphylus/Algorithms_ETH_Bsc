import java.util.ArrayDeque;
import graphs.*;

public class BreathFirstSearch {

	/* 'visited': used to mark which vertex have already been visited
	 * 'active': used to prevend multiple addition of the same vertex to the queue*/
	Graph g;
	boolean[] visited;
	boolean[] active;

	public BreathFirstSearch(Graph g) {
		this.g = g;
		this.visited = new boolean[g.V];
		this.active = new boolean[g.V];

	}

	public void bfs() {
		/* Creates a queue and adds the first vertex as starting point, also marks it
		 * as visited*/
		ArrayDeque Q = new ArrayDeque();
		Q.add(0);
		active[0] = true;
		
		/* While loop continues until every vertex has been visited*/
		while(!Q.isEmpty()) {
			/* Takes out the front element of the queue, prints it and marks it as visited*/
			int w = (int) Q.poll();
			System.out.println(w);
			visited[w] = true;
			
			/* The for loop checks every neighbour of vertex 'w'*/
			for (int i = 0; i < g.L.get(w).size(); i++) {
				/* If the neighbour has not already been visited and is not registred by another
				 * iteration of the loop, it adds them to the queue*/
				if (!active[g.L.get(w).get(i).dest] && !visited[g.L.get(w).get(i).dest]) {
					active[g.L.get(w).get(i).dest] = true;
					Q.add(g.L.get(w).get(i).dest);
				}
			}
			
		}
		
	}

}
