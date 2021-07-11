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
