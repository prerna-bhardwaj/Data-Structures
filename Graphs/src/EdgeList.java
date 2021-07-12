import java.util.ArrayList;

public class EdgeList {
	static class Edge {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	ArrayList<Edge> graph;
	
	EdgeList() {
		graph = new ArrayList<Edge>();
	}
	
	void addEdge(int u, int v, int wt) {
		graph.add(new Edge(u, v, wt));
	}
	
	void printEdge(Edge e) {
		System.out.println(e.from + " -> " + e.to + " = " + e.cost);
	}
	
	void printGraph() {
		for(Edge ele : graph)
			printEdge(ele);
	}
	
	public static void main(String args[]) {
		EdgeList e = new EdgeList();
		
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
