import java.util.ArrayList;

public class Graph {
	static int V;
	static ArrayList<Integer>graph[];
	
	@SuppressWarnings("unchecked")
	Graph(int v) {
		V = v;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++)
			graph[i] = new ArrayList<Integer>();
	}
	
	void addDirectedEdge(int u, int v) {
		graph[u].add(v);
		graph[v].add(u);
	}
	
	void addUndirectedEdge(int u, int v) {
		graph[u].add(v);
	}

	static void printGraph(ArrayList<Integer>[]graph) {
		for(int i = 0; i < graph.length; i++) {
			System.out.println(i + " - " + graph[i]);	
		}	
		System.out.println();
	}
	
	@SuppressWarnings("rawtypes")
	static ArrayList[] createDirectedGraph() {
		Graph g = new Graph(7);
		g.addDirectedEdge(0, 1);
		g.addDirectedEdge(0, 3);
		g.addDirectedEdge(1, 2);
		g.addDirectedEdge(2, 3);
		g.addDirectedEdge(2, 6);
		g.addDirectedEdge(3, 4);
		g.addDirectedEdge(4, 5);
		g.addDirectedEdge(5, 6);
	    return graph;
	}
	
	@SuppressWarnings("rawtypes")
	static ArrayList[] createUndirectedGraph() {
		Graph g = new Graph(7);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(2, 6);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(4, 5);
		g.addUndirectedEdge(5, 6);
		return graph;
	}
}
