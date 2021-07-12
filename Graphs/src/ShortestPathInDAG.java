import java.util.ArrayList;
import java.util.Arrays;

// TC - O(V + E)
// A useful application of the topological sort is to find the shortest path
// between two nodes in a Directed Acyclic Graph (DAG). Given an adjacency list
// this method finds the shortest path to all nodes starting at 'start'

/*
 * For longest path in DAG :
 *  O(V + E)
 * 	-> Multiply all edges by -1
 *  -> Find the shortest path by the method given below
 *  -> Multiply edges by -1 again 
 */

public class ShortestPathInDAG {
	static class Edge {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	 int V;
	 boolean[] visited;
	 Integer[] dist;						// Use Integer[] instead of int[], since it initializes all elements to null, unlike int[] (init to 0)
	 ArrayList<Integer> topOrder;
	 ArrayList<Edge>graph[];
	 
	 ShortestPathInDAG(int v) {
		V = v;
		graph = new ArrayList[V];
	    for (int i = 0; i < V; i++) 
	    	graph[i] =  new ArrayList<>();
		visited = new boolean[V];
		dist = new Integer[V];
		topOrder = new ArrayList<>();
	}
	 
	public void addEdge(int start, Edge edge) {
		graph[start].add(edge);
	}
	
	public static void main(String args[]) {
		ShortestPathInDAG obj =  new ShortestPathInDAG(7);
		
		obj.addEdge(0, new Edge(0, 1, 3));
		obj.addEdge(0, new Edge(0, 2, 2));
		obj.addEdge(0, new Edge(0, 5, 3));
		obj.addEdge(1, new Edge(1, 3, 1));
		obj.addEdge(1, new Edge(1, 2, 6));
		obj.addEdge(2, new Edge(2, 3, 1));
		obj.addEdge(2, new Edge(2, 4, 10));
		obj.addEdge(3, new Edge(3, 4, 5));
		obj.addEdge(5, new Edge(5, 4, 7));		
		
		obj.printGraph();
		
		obj.topologicalSort();
		System.out.println(obj.topOrder);
		
		int start = 0;
		obj.findShortestPath(start);
		System.out.println("Shortest Path from 0 : " + Arrays.toString(obj.dist));

		// Find the shortest path from 0 to 4 which is 8.0
	    System.out.println(obj.dist[4]);

	    // Find the shortest path from 0 to 6 which
	    // is null since 6 is not reachable!
	    System.out.println(obj.dist[6]);
		
	}

	private void printGraph() {
		for(int i = 0; i < V; i++) {
			for(Edge e : graph[i])
				System.out.println(e.from + " -> " + e.to + " = " + e.cost);
		}
	}

	private void findShortestPath(int start) {
//		for(int i = 0; i < V; i++)
//			dist[i] = Integer.MAX_VALUE;
		dist[start] = 0;
		
		// Process all the nodes from topOrder sequentially
		for(int i = 0; i < topOrder.size(); i++) {
			// Process neighbours of ith node from topSort
			for(Edge ele : graph[i]) {
				int newDist = dist[i] + ele.cost;
				if(dist[ele.to] == null)
					dist[ele.to] = newDist;
				else
					dist[ele.to] = Math.min(newDist, dist[ele.to]);
			}
		}
	}

	private void topologicalSort() {
		for(int i = 0; i < V; i++)
			if(visited[i] == false)
				dfs(i);	
	}

	private void dfs(int node) {
		visited[node] = true;
//		topOrder.add(node);   -- Adding this line here produces incorrect results

		for(Edge ele : graph[node])
			if(!visited[ele.to])
				dfs(ele.to);
		topOrder.add(0, node);		
	}
	
}
