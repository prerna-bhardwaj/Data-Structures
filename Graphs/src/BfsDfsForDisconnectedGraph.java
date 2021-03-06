import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsDfsForDisconnectedGraph {
	static int V;
	static ArrayList<Integer> adj[];
	static boolean[] visited;
	
	private static void initGraph() {
		V = 8;
		visited = new boolean[V];
		adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();		
	}
	
	private static void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	private static void buildGraph() {
		// Component 1
		addEdge(0, 1);
		addEdge(1, 2);
		addEdge(2, 3);
		addEdge(3, 0);
		
		// Component 2
		addEdge(4, 5);
		
		// Component 3
		addEdge(6, 7);
	}
	
	private static void printGraph() {
		for(int i = 0; i < V; i++)
			System.out.println(adj[i]);
	}
	
	private static void DFS() {
		System.out.print("\nDFS : ");
		visited = new boolean[V];
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < V; i++) {
			if(visited[i] == false) {
				ArrayList<Integer> path = new ArrayList<>();
				path.add(i);
				path = printDFS(i, path);
				result.add(path);
			}
		}
		System.out.println("\n" + result);
	}
	
	private static ArrayList<Integer> printDFS(int node, ArrayList<Integer>path) {
		visited[node] = true;

		System.out.print(node + " ");
		for(int ele : adj[node]) {
			if(visited[ele] == false) {
				path.add(ele);
				printDFS(ele, path);
			}
		}
		return path;
	}

	private static void BFS() {
		visited = new boolean[V];
		System.out.print("\nBFS : ");
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < V; i++) {
			if(visited[i] == false) {
				ArrayList<Integer> path = printBFS(i);
				result.add(path);
			}
		}
		System.out.println("\n" + result);
	}
		
	private static ArrayList<Integer> printBFS(int node) {
		visited[node] = true;
		Queue<Integer>q = new LinkedList<>();
		q.add(node);
		ArrayList<Integer>path = new ArrayList<>();
		while(!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			path.add(curr);
			for(int ele : adj[curr]) {
				if(visited[ele] == false) {
					visited[ele] = true;
					q.add(ele);
				}
			}
		}
		return path;
	}
	
	public static void main(String args[]) {
		initGraph();
		buildGraph();
		printGraph();
		DFS();
		BFS();
	}
}
