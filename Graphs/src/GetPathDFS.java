/*
 * Print the path from the start node to end node. Use DFS for traversing the path. Of all the possible paths
 * print only the first one obtained from DFS.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GetPathDFS {
	static int V;
	static ArrayList<Integer> adj[];
	static boolean[] visited;
	static String path;
	
	private static void initGraph() {
		V = 5;
		path = "";
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
		addEdge(0, 1);
		addEdge(1, 3);
		addEdge(0, 2);
		addEdge(2, 3);
		addEdge(1, 4);
	}
	
	private static void printGraph() {
		for(int i = 0; i < V; i++)
			System.out.println(adj[i]);
	}
	
	private static boolean getPath(int start, int end) {
		if(start == end)	return true;
		visited[start] = true;
		for(int ele : adj[start]) {
			path = path + ele;
			if(visited[ele] == false && getPath(ele, end))
				return true;
			path = path.substring(0, path.length() - 1);
		}
		return false;
	}
	
	public static void main(String args[]) {
		initGraph();
		buildGraph();
		printGraph();
		visited = new boolean[V];
		path = "0";
		getPath(0, 4);
		System.out.println("Path from node 0 to node 4 : " + path);
	}
}
