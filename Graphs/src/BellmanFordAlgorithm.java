/*
 * Bellman Ford algorithm is used to find the single source shortest path.
 * It also detects negative cycles and determines where they occur.
 * 
 * Principle : if we have calculated shortest paths with at most i edges, 
 * 				then an iteration over all edges guarantees to give shortest path 
 * 				with at-most (i+1) edges 
 * NOTE : Bellman-Ford does not work with undirected graph with negative edges as it 
 * 		will declare it as negative cycle.
 */

import java.util.Arrays;

public class BellmanFordAlgorithm {

	// Represents a weighted and directed edge 
	static class Edge{
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	/*
	 * Finds the shortest path form the given start node. Also detects negative cycles.
	 * If a node comes in a negative cycle, mon cost for it is then set to -ve infinity.
	 * TC - O(V*E)
	 */
	private static Integer[] bellmanFord(Edge[] edges, int V, int start) {
		Integer[] dist = new Integer[V];
		// Over Estimation
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		// Edge Relaxation
		for(int i = 1; i < V; i++) {
			for(Edge e : edges) {
				int newDist = dist[e.from] + e.cost;
				if(newDist < dist[e.to])
					dist[e.to] = newDist;
			}
		}
		
		/*
		 * Run the algorithm a second to find out if negative cycles are present.
		 * If we are able to find a better path now, then a -ve cycle exists. 
		 * 
		 * Run the loop V-1 to find all the nodes that are affected by the -ve cycle.
		 */
		for(int i = 1; i < V; i++) {
			for(Edge e : edges) {
				int newDist = dist[e.from] + e.cost;
				// You can also return false if a negative cycle has occured, and true at the end of the function.
				if(newDist < dist[e.to])
					dist[e.to] = Integer.MIN_VALUE;
			}
		}
		
		return dist;
	}
	
	public static void main(String args[]) {
		int V = 9, E = 10, start = 0;
		Edge[] edges = new Edge[E];
		
		edges[0] = new Edge(0, 1, 1);
	    edges[1] = new Edge(1, 2, 1);
	    edges[2] = new Edge(2, 4, 1);
	    edges[3] = new Edge(4, 3, -3);
	    edges[4] = new Edge(3, 2, 1);
	    edges[5] = new Edge(1, 5, 4);
	    edges[6] = new Edge(1, 6, 4);
	    edges[7] = new Edge(5, 6, 5);
	    edges[8] = new Edge(6, 7, 4);
	    edges[9] = new Edge(5, 7, 3);

//		int V = 5, E = 8, start = 0;
//		
//		edges[0] = new Edge(0, 1, -1);
//	    edges[1] = new Edge(0, 2, 4);
//	    edges[2] = new Edge(1, 2, 3);
//	    edges[3] = new Edge(1, 3, 2);
//	    edges[4] = new Edge(1, 4, 2);
//	    edges[5] = new Edge(3, 2, 5);
//	    edges[6] = new Edge(3, 1, 1);
//	    edges[7] = new Edge(4, 3, -3);
//	    
		
		Integer[] dist = bellmanFord(edges, V, start);
	    
	    for(int i = 0; i < V; i++) 
	    	System.out.printf("The cost to get from node %d to %d is %d.\n", start, i, dist[i]);   
	}
}
