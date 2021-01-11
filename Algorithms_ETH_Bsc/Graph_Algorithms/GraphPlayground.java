import graphs.*;

public class GraphPlayground {

	public static void main(String[] args) {
		
		/* This would create an unweighted graph, since all edgeWeights are equal*/
		
		int[] perm = {0, 19, 3, 11, 6, 4, 18, 13, 12, 2, 1, 15, 14, 16, 5, 7, 17, 8, 9, 10};
		
		
		Graph g = GraphFunctions.createAcyclicGraph(20, 50, false, perm);
		GraphFunctions.printGraph(g);
		
		ShortestPathBFS sp = new ShortestPathBFS(g);
		
		sp.shortestPath(g, 0, 15);
		
	}

}
