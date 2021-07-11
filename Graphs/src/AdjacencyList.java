/*
 * Draw an Adjacency List representation for an undirected unweighted graph.
 * 
 * Pros: Saves space O(|V|+|E|) . 
 * 		In the worst case, there can be C(V, 2) number of edges in a graph 
 * 		thus consuming O(V^2) space. Adding a vertex is easier.
 * 
 * Cons: Queries like whether there is an edge from vertex u to vertex v are not
 * 		 efficient and can be done O(V).
 */


import java.util.ArrayList;

public class AdjacencyList {

	static class Edge {
		int n;
		ArrayList<ArrayList<Integer>>adj;
		
		Edge(int n) {
			this.n = n;
			adj = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < n; i++)
				adj.add(new ArrayList<Integer>());
		}
		
		// For undirected graph(here), add edge for both vertices
		// For undirected graph, add only for starting vertex.
		void addEdge(int u, int v) {
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		void printGraph() {
			for(int i = 0; i < adj.size(); i++) {
				System.out.print(i + " - " + adj.get(i));
				System.out.println();
			}
		}
		
	}
	
	public static void main(String args[]) {
		Edge e = new Edge(5);
		
		e.addEdge(0, 1);
		e.addEdge(0, 4);
		e.addEdge(1, 2);
		e.addEdge(1, 3);
		e.addEdge(1, 4);
		e.addEdge(3, 2);
		e.addEdge(3, 4);

		e.printGraph();
	}
}
