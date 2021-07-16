/*
 * ADJACENCY LIST :
 * For a directed graph, the sum of the sizes of the adjacency lists of all the nodes is E. 
 * So, the time complexity in this case is O(V) + O(E) = O(V + E).
 * For an undirected graph, each edge appears twice. Once in the adjacency list of either end of the edge. The time complexity for this case will be O(V) + O (2E) ~ O(V + E).
 *	
 * ADJACENCY MATRIX : 
 * Time Complexity = O(V^2)
 * 
 * 4 types of edges in graph :
 * 1. Forward edge - descendant is not part of dfs tree
 * 2. Backward edge - ancestor is not part of dfs tree. Indicates cycle in graph
 * 3. Tree edge - present in the dfs tree
 * 4. Cross edge - no ancestor or descendant relationship
 */
import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	int V;
	ArrayList<Integer>graph[];
	boolean[] visited;
	
	DFS() {
		graph = Graph.createUndirectedGraph();
		V = graph.length;
		visited = new boolean[V];
	}
	
	private void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for(int ele : graph[node]) 
			if(visited[ele] == false)
				dfs(ele);		
	}
	
	private void dfsIterative(int i) {
		Stack<Integer>st = new Stack<>();
		st.push(i);
		visited = new boolean[V];
		visited[i] = true;
		
		while(!st.isEmpty()) {
			int node = st.pop();
			System.out.print(node + " ");
			
			for(int ele : graph[node])
				if(visited[ele] == false) {
					st.push(ele);
					visited[ele] = true;
				}
		}		
	}
	
	public static void main(String[] args) {
		DFS obj = new DFS();
		Graph.printGraph(obj.graph);
		
		System.out.println("DFS traversal iterative starting from node 0 : ");
		obj.dfs(0);	
		
		System.out.println("\n\nDFS traversal recursive starting from node 0 : ");
		obj.dfsIterative(0);
	}

	
}
