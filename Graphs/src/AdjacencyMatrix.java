/*
 * Draw an Adjacency Matrix representation for directed weighted graph.
 * 
 * Pros: Representation is easier to implement and follow. 
 * 		Removing an edge takes O(1) time. Queries like whether there is an edge from 
 * 		vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).
 * 
 * Cons: Consumes more space O(V^2). 
 * 		Even if the graph is sparse(contains less number of edges), it consumes the 
 * 		same space. Adding a vertex is O(V^2) time. 
 */

public class AdjacencyMatrix { 
	
	static class Edge {
		int n;
		int[][] graph;

		Edge(int n) {
			this.n = n;
			this.graph = new int[n][n];
		}
		
		// Done keeping directed graph in mind
		// For undirected graph add for both vertices
		void addEdge(int u, int v, int wt) {
			graph[u][v] = wt;
		}
		
		int getEdge(int u, int v) {
			return graph[u][v];
		}
		
		void printGraph() {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					System.out.print(graph[i][j] + " ");
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {
		Edge e = new Edge(5);
		
		e.addEdge(0, 1, 1);
		e.addEdge(0, 4, 5);
		e.addEdge(1, 1, 2);
		e.addEdge(1, 2, 3);
		e.addEdge(1, 3, 4);
		e.addEdge(1, 4, 2);
		e.addEdge(3, 2, 2);
		e.addEdge(3, 4, 3);

		e.printGraph();
	}
}
