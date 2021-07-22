import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class NaiveKruskal {
	static class Edge {
		int start, end, cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "(" + start + ", " + end + ", " + cost + ")";
		}
	}
	
	static int N;
	static boolean visited[];
	static ArrayList<Edge>adj[], mst[], edges, tree;

	NaiveKruskal(int n) {
		N = n;
		adj = new ArrayList[N];
		mst = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Edge>();
			mst[i] = new ArrayList<Edge>();			
		}
		edges = new ArrayList<>();
		tree = new ArrayList<>();
	}
	
	static void printGraph(ArrayList<Edge>graph[]) {
		for(int i = 0; i < graph.length; i++) {
			System.out.print("\n" + i + " - ");			
			for(Edge e : graph[i]) 
				System.out.print(e.toString() + ", ");			
		}
	}
	
	static void addEdge(int u, int v, int cost) {
		adj[u].add(new Edge(u, v, cost));
		adj[v].add(new Edge(v, u, cost));
		edges.add(new Edge(u, v, cost));
	}
	
	static void addEdgeToMST(int u, int v, int cost) {
		mst[u].add(new Edge(u, v, cost));
		mst[v].add(new Edge(v, u, cost));
		tree.add(new Edge(u, v, cost));
	}
	
	static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			return e1.cost - e2.cost;
		}
	}
	
	// TC - O(E) or O(V^2)
	// basically check whether both the vertices belong to the same component(observed so far) in the MST.
	// If yes, then they will form a cycle, else they belong to diff components and an edge btw them wont
	// result in a cycle.
	static boolean hasPath(int start, int end) {
		if(start == end)
			return true;
		visited[start] = true;
		for(Edge e : mst[start]) {
			if(visited[e.end] == false && hasPath(e.end, end))
				return true;
		}
		return false;
	}
	
	
	static void kruskal() {
		edges.sort(new EdgeComparator());
		System.out.println("\n\nEdge list : " + edges);
		int count = 0;
		
		for(int i = 0 ; i < edges.size(); i++) {
			Edge curr = edges.get(i);
			visited = new boolean[N];
			if(hasPath(curr.start, curr.end)) 
				continue;
			addEdgeToMST(curr.start, curr.end, curr.cost);
			count++;
			if(count == N-1)
				break;
		}
	}
	
	public static void main(String args[]) {
		NaiveKruskal obj = new NaiveKruskal(6);
		addEdge(0, 1, 1);
		addEdge(0, 2, 3);
		addEdge(1, 3, 8);
		addEdge(0, 3, 13);
		addEdge(1, 2, 4);
		addEdge(2, 3, 9);
		addEdge(2, 4, 7);
		addEdge(2, 5, 5);
		addEdge(3, 5, 6);
		addEdge(3, 4, 10);
		addEdge(4, 5, 2);
		printGraph(adj);
		
		kruskal();
		printGraph(mst);
		System.out.println("\n\nMST is : " + tree);
	}

}
