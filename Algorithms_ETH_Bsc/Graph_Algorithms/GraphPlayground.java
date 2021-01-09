import graphs.*;

public class GraphPlayground {

	public static void main(String[] args) {
		
		/* This would create an unweighted graph, since all edgeWeights are equal*/
		Graph g = new Graph(4);

		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		
		Graph h = GraphFunctions.createGraph(5, 6, false);
		
		
		TopoSort t = new TopoSort(h);
		GraphFunctions.printGraph(h);
		t.topoSort();
		
	}

}
