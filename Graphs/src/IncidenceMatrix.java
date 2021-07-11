/*
 * Draw an Incidence Matrix for a directed graph
 * 
 * O(V*E) instead of O(V^2)
 */


public class IncidenceMatrix {

	static class Edge {
		int V, E;
		// Rows - Vertices are listed
		// Columns - Edges are listed from 1 to E
		int[][] graph;
		
		Edge(int v, int e) {
			this.V = v;
			this.E = e;
			graph = new int[V][E];
		}
		
		// In each column only 2 values are set to 1
		// 1 - Outgoing Edge
		// -1 - Incoming Edge
		// 0 - No edge
		void addEdge(int u, int v, int edge) {
			graph[u][edge] = 1;
			// Save 1 for self loops
			if(u != v)
				graph[v][edge] = -1;
		}
		
		void printGraph() {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < E; j++)
					System.out.print(graph[i][j] + " ");
				System.out.println();				
			}
		}
	}
	
	public static void main(String[] args) {
		Edge e = new Edge(5, 8);
				
		// start, end, edge
	    e.addEdge(0, 1, 0);
	    e.addEdge(0, 4, 1);
	    e.addEdge(1, 4, 2);
	    e.addEdge(1, 3, 3);
	    e.addEdge(1, 1, 5);
	    e.addEdge(1, 2, 6);
	    e.addEdge(3, 4, 4);
	    e.addEdge(3, 2, 7);

	    e.printGraph();
	}
 	
}
