/*
 * Topological Sort for Directed Acyclic Graph (DAG).
 */
import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSortDFS {

	 int V;
	 boolean visited[];
	 ArrayList<Integer> topOrder;
	 ArrayList<Integer> graph[];
	 
	TopologicalSortDFS(int v) {
		V = v;
		graph = new ArrayList[v];
		for (int i = 0; i < V; i++)
	    	graph[i] =  new ArrayList<>();
		System.out.println(graph.length);
		visited = new boolean[V];
		topOrder = new ArrayList<>();
	}
	 
	public void addEdge(int u, int v) {
		graph[u].add(v);
	}
	 
	public void topologicalSort() {
		for(int i = 0; i < V; i++)
			if(visited[i] == false)
				dfs(i);
	}
	
	public void dfs(int node) {
		visited[node] = true;
		for(int ele : graph[node]) 
			if(visited[ele] == false)
				dfs(ele);
		topOrder.add(0, node);
	}

	public static void main(String args[]) {
		 TopologicalSortDFS obj =  new TopologicalSortDFS(5);
		 
		 obj.addEdge(0, 1);
		 obj.addEdge(0, 2);
		 obj.addEdge(1, 0);
		 obj.addEdge(1, 2);
		 obj.addEdge(1, 3);
		 obj.addEdge(2, 3);
		 obj.addEdge(2, 4);

		 
		 Graph.printGraph(obj.graph);
		 obj.topologicalSort();
		 System.out.println(obj.topOrder);
	}
	
}
