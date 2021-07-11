import java.util.ArrayList;

public class Graph {
	static int V;
	static ArrayList<Integer>graph[];
	
	Graph(int V) {
		this.V = V;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++)
			graph[i] = new ArrayList<Integer>();
	}
	
	static void addDirectedEdge(int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}
	
	static void addUndirectedEdge(int u, int v) {
		graph[u].add(v);
	}

	static void printGraph() {
		for(int i = 0; i < V; i++) {
			System.out.print(i + " - ");
			for(int ele : graph[i])
				System.out.print(ele + " ");
			System.out.println();				
		}
	}
	
	static ArrayList[] createDirectedGraph() {
		V = 7;		// Vertices
		addDirectedEdge(0, 1);
		addDirectedEdge(0, 3);
		addDirectedEdge(1, 2);
		addDirectedEdge(2, 3);
		addDirectedEdge(2, 6);
		addDirectedEdge(3, 4);
	    addDirectedEdge(4, 5);
	    addDirectedEdge(5, 6);
	    return graph;
	}
	
	static ArrayList[] createUndirectedGraph() {
		V = 7;		// Vertices
		addUndirectedEdge(0, 1);
		addUndirectedEdge(0, 3);
		addUndirectedEdge(1, 2);
		addUndirectedEdge(2, 3);
		addUndirectedEdge(2, 6);
		addUndirectedEdge(3, 4);
		addUndirectedEdge(4, 5);
		addUndirectedEdge(5, 6);
		return graph;
	}
}
