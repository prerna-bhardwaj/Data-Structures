/*
 * Topological Sort for Directed Acyclic Graph (DAG).
 */

import java.util.*;

public class TopologicalSortKahnsAlgorithm {

	 int V;
	 int[] indegree, timeTaken;
	 ArrayList<Integer> topOrder;
	 ArrayList<Integer>graph[];
	 
	 TopologicalSortKahnsAlgorithm(int v) {
		V = v;
		graph = new ArrayList[V];
	    for (int i = 0; i < V; i++) 
	    	graph[i] =  new ArrayList<>();
		indegree = new int[V];						// Stores the in-degree of each node
		timeTaken = new int[V];						// Stores the time taken to reach reach this node (considering dependencies).
		topOrder = new ArrayList<>();
	}
	 
	public void addEdge(int u, int v) {
		graph[u].add(v);
	}
	 
	public void topologicalSort() {
		// Calculate indegrees for all nodes
		for(int i = 0; i < V; i++) {
			for(int ele : graph[i]) 
				indegree[ele]++;
		}
		System.out.println("Indegree : " + Arrays.toString(indegree));
		
		Queue<Integer>q = new LinkedList<>();
		// Add nodes with indegree 0 to the queue
		for(int i = 0; i < indegree.length; i++) {
			if(indegree[i] == 0) {
				q.add(i);
				timeTaken[i] = 1;
			}			
		}
		while(!q.isEmpty()) {
			int curr = q.poll();
			topOrder.add(curr);
			
			// Decrement the indegrees of neighbouring nodes
			for(int ele : graph[curr]) {
				indegree[ele] --;
				if(indegree[ele] == 0) {
					q.add(ele);
					timeTaken[ele] = 1 + timeTaken[curr];
				}
			}
		}
	}

	public static void main(String args[]) {
		TopologicalSortKahnsAlgorithm obj =  new TopologicalSortKahnsAlgorithm(7);
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(0, 5);
		obj.addEdge(1, 3);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		obj.addEdge(5, 4);
		// Uncomment below line to test for cycles. Self loop is a cycle too :)
//		obj.addEdge(1, 1); 
		Graph.printGraph(obj.graph);
		
		obj.topologicalSort();
		
		/*
		 * Algorithm is able to find if cycle exists in the graph.
		 * Nodes will have non-zero indegree in case of cycle, thus no node will be added to the queue.
		 * As a result of which the size of topOrder < V, thus proving that cycles exist in the graph.
		 */
		if(obj.topOrder.size() != obj.V)
			System.out.println("Topological Ordering is not possible.");
		else {
			System.out.println("Topological Order : " + obj.topOrder);
			for(int i = 0 ;i < obj.V; i++)
				System.out.println(i + " - " + obj.timeTaken[i]);
		}
	}
}
