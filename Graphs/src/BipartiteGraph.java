/*
 * Check whether given graph is bipartite of not.
 * 
 * Bipartite/bigraph - you can divide the vertices into 2 disjoint sets such that :
 * 	a. each vertex belongs to exactly 1 of the sets
 *  b. each edge connects vertices that belong to 2 different sets
 */

import java.util.*;

class BipartiteGraph {
	public static void main (String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-- != 0) {
		    int n, m;
    		n = sc.nextInt();
    	    m = sc.nextInt();
    	    ArrayList<Integer>adj[] = new ArrayList[n];
    	    for(int i = 0; i < n; i++)
    	        adj[i] = new ArrayList<Integer>();
    	        
    	    for(int i = 0; i < m ; i++) {
    	        int u = sc.nextInt() - 1;
    	        int v = sc.nextInt() - 1;
    	        adj[u].add(v);
    	        adj[v].add(u);
     	    }
    	    printGraph(adj);
     	    System.out.println(isBipartite(n, adj) ? "yes" : "no");
		}
	}
	
	private static void printGraph(ArrayList<Integer>[] adj) {
		for(int i = 0; i < adj.length; i++)
			System.out.println(adj[i]);
	}
	
	private static boolean isBipartite(int numEdges, ArrayList<Integer>[] adj) {
		int[] color = new int[numEdges];
 	    boolean[] visited = new boolean[numEdges];
 	    // Used for disconnected graphs
 	    for(int i = 0; i < adj.length; i++) {
 	    	boolean[] onPath = new boolean[numEdges];	
			if(visited[i] == false && dfs(adj, color, visited, onPath, i, 0) == false)
				return false;
		}
		return true;
	}

	public static boolean dfs(ArrayList<Integer> adj[], int[]color,
	            boolean[] visited, boolean[] onPath, int vertex, int C) {
	    visited[vertex] = true;
	    color[vertex] = C;
	    onPath[vertex] = true;
	    System.out.println(vertex + " " + C);
	    
	    for(int ele : adj[vertex]) {
	        if(visited[ele] == false) {
	            if(dfs(adj, color, visited, onPath, ele, C^1) == false)
	                return false;
	        }
	        else if(onPath[vertex]){
	            if(color[ele] == color[vertex]) 
	                return false;
	        }
	    }
	    onPath[vertex] = false;
	    return true;
	}
	
}