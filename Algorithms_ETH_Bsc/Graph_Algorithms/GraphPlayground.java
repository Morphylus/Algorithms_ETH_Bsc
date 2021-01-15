import graphs.*;

public class GraphPlayground {

	public static void main(String[] args) {
		
		/* This would create an unweighted graph, since all edgeWeights are equal*/
		
		int[] perm = {0, 19, 3, 11, 6, 4, 18, 13, 12, 2, 1, 15, 14, 16, 5, 7, 17, 8, 9, 10};
		
		

		Graph g = new Graph(6);
		
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, 5);
		g.addEdge(3, 4, 1);
		g.addEdge(3, 5, -5);
		g.addEdge(5, 4, -3);
		
		Graph h = GraphFunctions.createAcyclicGraph(20, 50, true, perm);
		
		GraphFunctions.printGraph(h);
		
		Dijkstra d = new Dijkstra(h);
		
		d.shortestPath(0);
		
	}

}
