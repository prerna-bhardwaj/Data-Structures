/*
 * Draw an Incidence List for a directed graph.
 * 
 * O(V*E) instead of O(V^2)
 */

import java.util.ArrayList;

public class IncidenceList {

	static class Edge {
		int V, E;

		// Array of list of edges
		ArrayList<Integer> graph[];
		
		// can also make an array of list of pairs of <edge,endvertex>
		
		@SuppressWarnings("unchecked")
		Edge(int v, int e) {
			this.V = v;
			this.E = e;
			graph = new ArrayList[V];		// NOTE : initializing array of arraylist	
			for(int i = 0; i < V; i++)
				graph[i] = new ArrayList<Integer>();
		}
		
		void addEdge(int u, int edge) {
			graph[u].add(edge);
		}
		
		void printGraph() {
			for(int i = 0; i < V; i++) {
				System.out.print(i + " - ");
				for(int ele : graph[i])
					System.out.print(ele + " ");
				System.out.println();				
			}
		}
	}
	
	public static void main(String[] args) {
		Edge e = new Edge(5, 8);
				
		// start, end, edge
	    e.addEdge(0, 0);
	    e.addEdge(0, 1);
	    e.addEdge(1, 2);
	    e.addEdge(1, 3);
	    e.addEdge(1, 5);
	    e.addEdge(1, 6);
	    e.addEdge(3, 4);
	    e.addEdge(3, 7);

	    e.printGraph();
	}
 	
}
