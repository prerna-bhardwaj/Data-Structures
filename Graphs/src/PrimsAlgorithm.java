import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// GREEDY - Find MST

public class PrimsAlgorithm {
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
	
	static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			return e1.cost - e2.cost;
		}	
	}
	
	static int N, E;
	static int[] parent, weight;
	static boolean[] visited;
	static ArrayList<Edge> adj[];
	
	PrimsAlgorithm(int n, int e) {
		N = n;
		E = e;
		weight = new int[N];
		parent = new int[N];
		visited = new boolean[N];
		adj = new ArrayList[N];
		for(int i = 0 ;i < N; i++)
			adj[i] = new ArrayList<Edge>();
	}
	
	static void addEdge(int u, int v, int wt) {
		adj[u].add(new Edge(u, v, wt));
		adj[v].add(new Edge(v, u, wt));
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
	
	private static int getMinVertex() {
		int minValue = Integer.MAX_VALUE, minIndex = -1;
		for(int i = 0; i < N; i++) {
			if(visited[i] == false && minValue > weight[i]) {
				minValue = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	// TC - O(ElogE + ElogV)
	static void prims() {
		// Starting from vertex 0
		Arrays.fill(weight,	Integer.MAX_VALUE);
		weight[0] = 0;
		parent[0] = -1;
		
		for(int i = 0; i < N; i++) {
			// get unvisited vertex with minimum weight
			int minVertex = getMinVertex();
			visited[minVertex] = true;
			
			for(Edge e : adj[minVertex]) {
				if(visited[e.end] == false && weight[e.end] > e.cost) {
					weight[e.end] = e.cost;
					parent[e.end] = e.start;
				}
			}
		}
		// NOTE - # of edges printed is V-1
		// Start the loop from 1, since parent of 0 is -1.
		for(int i = 1; i < N; i++) {
			if(parent[i] > i)
				System.out.printf("%d %d %d\n", i, parent[i], weight[i]);
			else
				System.out.printf("%d %d %d\n", parent[i], i, weight[i]);
		}
	}
	
	public static void main(String args[]) {

		PrimsAlgorithm obj = new PrimsAlgorithm(6, 10);
		addEdge(0, 1, 1);
		addEdge(0, 2, 3);
		addEdge(0, 3, 13);
		addEdge(1, 2, 4);
		addEdge(1, 3, 8);
		addEdge(2, 3, 9);
		addEdge(2, 4, 7);
		addEdge(2, 5, 5);
		addEdge(3, 4, 10);
		addEdge(3, 5, 6);
		addEdge(4, 5, 2);
		
//		PrimsAlgorithm obj = new PrimsAlgorithm(4, 4);	
//		addEdge(0, 1, 3);
//		addEdge(0, 3, 5);
//		addEdge(1, 2, 1);
//		addEdge(2, 3, 8);
		
		printGraph();
		obj.prims();
	}	
}
/*
1 0 1
2 0 3
3 5 6
4 5 2
5 2 5
*/

/*
0 1 3
1 2 1
0 3 5
 */
