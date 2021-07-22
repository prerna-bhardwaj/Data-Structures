import java.util.ArrayList;
import java.util.Arrays;

public class DetectCyclesUnionFind {
	
	static class Edge {
		int start, end;
		
		Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static int N;
	/*  UNION BY RANK :
	 *  	When path compression is used, then rank is not always equal to height. Therefore a separate matrix
	 *  	for storing rank is used.
	 *  PATH COMPRESSION :
	 *  	Make the topmost node as the parent of x, so next time you dont have to traverse all the
	 *  	intermediate nodes again in order to find its parent.
	 *  Both have TC - O(logV)		where V = # of vertices
	 *  and an Amortized TC - O(small constant) ~ O(1)
	 */
	static int[] parent, rank;
	static ArrayList<Edge> adj[], edges;
	
	DetectCyclesUnionFind(int n) {
		N = n;
		parent = new int[N];
		rank = new int[N];
		edges = new ArrayList<Edge>();
		adj = new ArrayList[N];
		for(int i = 0; i < n; i++)
			adj[i] = new ArrayList<Edge>();
	}
	
	public static void make_set() {
		for(int i = 0; i < N; i++)
			parent[i] = i;
	}
	
	// Path Compression - optimization
	public static int find(int x) {
		if(x != parent[x])
			parent[x] = find(parent[x]);
		return parent[x];
	}
	
	// Union by Rank - optimization
	public static void union_set(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY)
			return;
		if(rank[rootX] > rank[rootY])
			parent[rootY] = rootX;
		else {
			parent[rootX] = rootY;
			if(rank[rootX] == rank[rootY])
				rank[rootY]++;
		}
	}
	
	private static void addEdge(int u, int v) {
		adj[u].add(new Edge(u, v));
		adj[v].add(new Edge(v, u));
		edges.add(new Edge(u, v));
	}

	public static boolean findCycles() {
		make_set();
			
		for(int i = 0; i < edges.size(); i++) {
			Edge curr = edges.get(i);
			int rootX = find(curr.start);
			int rootY = find(curr.end);
			// Comment to see the MST
			if(rootX == rootY) {
				return true;
			}
			union_set(curr.start, curr.end);
			System.out.printf("%d %d %d %d\n", curr.start, curr.end, rootX, rootY);
			System.out.println(Arrays.toString(parent) + " " + Arrays.toString(rank));
		}
		return false;
	}
	
	public static void main(String args[]) {
		DetectCyclesUnionFind obj = new DetectCyclesUnionFind(6);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 3);
		addEdge(2, 3);
		addEdge(3, 4);
		addEdge(4, 5);
		
		System.out.println(findCycles() == true ? "YES" : "NO");
	}
}
