// GREEDY
import java.util.ArrayList;
import java.util.Comparator;

public class KruskalsAlgorithm {
	
	static class Edge {
		int start, end, cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + ", " + cost + "]";
		}		
	}
	
	// TC - O(nlogn)
	static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			return e1.cost - e2.cost;
		}	
	}	
	
	static int N, E;
	static int[] parent, rank;
	static ArrayList<Edge> adj[], edges, mst;
	
	KruskalsAlgorithm(int n, int e) {
		N = n;
		E = e;
		rank = new int[N];
		parent = new int[N];
		edges = new ArrayList<Edge>();
		mst = new ArrayList<Edge>();
		adj = new ArrayList[N];
		for(int i = 0 ;i < N; i++)
			adj[i] = new ArrayList<Edge>();
	}
	
	
	static void addEdge(int u, int v, int wt) {
		adj[u].add(new Edge(u, v, wt));
		adj[v].add(new Edge(v, u, wt));
		edges.add(new Edge(u, v, wt));
	}
	
	static void printGraph() {
		System.out.print("GRAPH : ");
		for(int i = 0; i < N; i++) {
			System.out.print("\n" + i + " : ");
			for(Edge e : adj[i])
				System.out.print(e.toString() + ", ");
		}
		System.out.println("\n");
	}
	
	static void printEdgeList(ArrayList<Edge> list) {
		System.out.println("\nMST : ");
		for(Edge e : list)
			System.out.print(e.toString() + " ");
		System.out.println("\n");
	}
	
	static void make_set() {
		for(int i = 0; i < N; i++) 
			parent[i] = i;
	}
	
	// TC - O(logV)
	static int find(int x) {
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}
	
	// TC - O(logV)
	static void union_set(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rank[rootX] > rank[rootY])
			parent[rootY] = rootX;
		else {
			parent[rootX] = rootY;
			if(rank[rootX] == rank[rootY])
				rank[rootY]++;
		}
	}
	
	// TC - O(ElogE + ElogV)
	static void kruskal() { 
		int count = 0;
		// TC - O(ElogE)
		edges.sort(new EdgeComparator());
		make_set();

		// TC - O(ElogV)
		for(Edge e : edges) {
			int rootX = find(e.start);
			int rootY = find(e.end);
			if(rootX == rootY)
				continue;
			System.out.println("Adding : " + e.toString());
			mst.add(e);
			count++;
			union_set(e.start, e.end);
		}
	}
	
	public static void main(String args[]) {

//		KruskalsAlgorithm obj = new KruskalsAlgorithm(6, 10);
//	
//		addEdge(0, 1, 1);
//		addEdge(0, 2, 3);
//		addEdge(0, 3, 13);
//		addEdge(1, 2, 4);
//		addEdge(1, 3, 8);
//		addEdge(2, 3, 9);
//		addEdge(2, 4, 7);
//		addEdge(2, 5, 5);
//		addEdge(3, 4, 10);
//		addEdge(3, 5, 6);
//		addEdge(4, 5, 2);

		KruskalsAlgorithm obj = new KruskalsAlgorithm(4, 4);
	
		addEdge(0, 1, 3);
		addEdge(0, 3, 5);
		addEdge(1, 2, 1);
		addEdge(2, 3, 8);
		
		printGraph();
		obj.kruskal();
	
		// NOTE - # of edges printed is V-1
		printEdgeList(mst);
	}
}
