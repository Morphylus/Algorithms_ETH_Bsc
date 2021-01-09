import graphs.*;

public class GraphPlayground {

	public static void main(String[] args) {
		
		/* This would create an unweighted graph, since all edgeWeights are equal*/
		Graph g = new Graph(7);

		g.addEdge(0, 1, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 6, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(4, 3, 1);
		g.addEdge(4, 5, 1);
		g.addEdge(5, 2, 1);
		g.addEdge(6, 4, 1);
		
		Graph h = GraphFunctions.createGraph(6, 10, true);
		GraphFunctions.printGraph(h);
		
	}

}
