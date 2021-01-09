import graphs.*;

public class GraphPlayground {

	public static void main(String[] args) {
		
		/* This would create an unweighted graph, since all edgeWeights are equal*/
		
		
		
		Graph g = GraphFunctions.createAcyclicGraph(10, false);
		GraphFunctions.printGraph(g);
		
	}

}
