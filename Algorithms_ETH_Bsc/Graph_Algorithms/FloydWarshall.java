import graphs.*;
import java.util.Arrays;

public class FloydWarshall {
	Graph g;
	int[][] d;
	
	public FloydWarshall(Graph g) {
		this.g = g;
		this.d = new int[g.V][g.V];
	}
	
	
	public void shortestPath() {
		
		/* Initialization of table: First we set all values to infinite except the values
		 * of a vertex to itself, where the SP will have length 0*/
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if (i == j) {d[i][j] = 0;} 
				else {d[i][j] = Integer.MAX_VALUE;}
			}
			
			/* Then we add all edges to the table*/
			for (Edge e : g.L.get(i)) {
				d[i][e.dest] = e.weight;
			}
		}
		
		/* This loop goes over everything and checks whether there is a cheaper way
		 * from vertex 'u' over vertex 'i' to get to 'v', if not, we will keep the value
		 * if yes, we will update the value*/
		for (int i = 0; i < g.V; i++) {
			for (int u = 0; u < g.V; u++) {
				for (int v = 0; v < g.V; v++) {
					if(d[u][i] == Integer.MAX_VALUE || d[i][v] == Integer.MAX_VALUE) {
						continue;
					} else {
						d[u][v] = Math.min(d[u][v], d[u][i] + d[i][v]);						
					}
				}
			}
		}
		
		/* Prints out the matrix*/
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				if (d[i][j] == Integer.MAX_VALUE) {
					System.out.print("  -  ");
				} else if (d[i][j] < 10){
					System.out.print("  " + d[i][j] + "  ");
				} else {
					System.out.print("  " + d[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	
}
