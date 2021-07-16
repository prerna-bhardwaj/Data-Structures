import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.Comparator;

public class DijkstrasAlgorithm {

	public static class Edge {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static class Node {
		int id, value;
		/*
		 * id = index of a node
		 * value = min dist to get to that node
		 */
		Node(int id, int value) {
			this.id = id;
			this.value = value;
		}
	}
	
	int V;
	boolean[] visited;
	Integer[] dist, prev;
	ArrayList<Edge>graph[];
	Comparator<Node> comparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return (n1.value - n2.value) > 0 ? 1 : -1;
		}
	};
	
	
	DijkstrasAlgorithm(int v) {
		V = v;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++)
			graph[i] = new ArrayList<Edge>();
		visited = new boolean[V];
		dist = new Integer[V];
		prev = new Integer[V];
	}
	
	void addEdge(int u, int v, int cost) {
		graph[u].add(new Edge(u, v, cost));
		graph[v].add(new Edge(v, u, cost));
	}
	
	void printGraph() {
		for(int i = 0; i < V; i++) 
			for(int j = 0;j < graph[i].size(); i++) {
				Edge e = graph[i].get(j);
				System.out.println(e.from + " -> " + e.to + " = " + e.cost);
			}
	}
	
	// Finds the shortest path from given start node to all nodes present in the graph
	Integer[] dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>(2 * V, comparator);
		pq.add(new Node(start, 0));
		
		while(pq.size() > 0) {
			Node curr = pq.poll();
			visited[curr.id] = true;
			if(dist[curr.id] < curr.value) 
				continue;
			
			for(Edge e : graph[curr.id]) {
				// For ignoring duplicates from 
				if(visited[e.to])	continue;
				int newDist = dist[curr.id] + e.cost;
				if(newDist < dist[e.to]) {
					dist[e.to] = newDist;
					pq.add(new Node(e.to, newDist));
				}
			}
		}
		return dist;
	}
	
	// Finds the shortest path from given start node to end node. 
	// If there is no such path, then Integer.MAX_VALUE is returned.
	Integer dijkstraStartToEnd(int start, int end) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Node>pq = new PriorityQueue<>(2 * V, comparator);
		pq.add(new Node(start, 0));
		visited = new boolean[V];
		
		while(pq.size() > 0) {
			Node curr = pq.poll();
			if(dist[curr.id] < curr.value) 	
				continue;
			visited[curr.id] = true;
			
			for(Edge e : graph[curr.id]) {
				// For ignoring duplicates from PQ
				if(visited[e.to] == true) 	continue;
				int newDist = dist[curr.id] + e.cost;
				if(newDist < dist[e.to]) {
					dist[e.to] = newDist;
					prev[e.to] = curr.id;
					pq.add(new Node(e.to, newDist));
				}	
			}
			if(curr.id == end)
				return dist[end];
		}
		return Integer.MAX_VALUE;
	}
	
	public ArrayList<Integer> reconstructPath(int start, int end) {
		dijkstraStartToEnd(start, end);
		ArrayList<Integer>path = new ArrayList<>();
		if(dist[end] == Integer.MAX_VALUE)	return path;
		System.out.println(Arrays.toString(dist));
		for(int at = end; at != start ; at = prev[at]) {
			path.add(0, at);
			System.out.println(at);
		}
		return path;
	}
	
	
	public static void main(String[] args) {
		DijkstrasAlgorithm obj = new DijkstrasAlgorithm(5);
		obj.addEdge(0, 1, 3);
		obj.addEdge(0, 2, 1);
		obj.addEdge(1, 2, 7);
		obj.addEdge(1, 3, 5);
		obj.addEdge(1, 4, 1);
		obj.addEdge(2, 3, 2);
		obj.addEdge(3, 4, 7);
		
		Integer[] result = obj.dijkstra(2);
		System.out.println("Shortest path from node 2(C) : " + Arrays.toString(result));

		System.out.println("Shortest path from node 2(C) to 4(E) : " + obj.dijkstraStartToEnd(2, 4));

		System.out.println("Reconstruct path from node 2(C) to 4(E) : " + obj.reconstructPath(2, 4));
	}	
}

/*
 * Dijkstra's Algorithm basically starts at the node that you choose (the source node) and it 
 * analyzes the graph to find the shortest path between that node and all the other nodes in the graph.
 * 
 * The algorithm keeps track of the currently known shortest distance from each node to the source node 
 * and it updates these values if it finds a shorter path.
 * 
 * Once the algorithm has found the shortest path between the source node and another node, that node is
 * marked as "visited" and added to the path.
 * 
 * The process continues until all the nodes in the graph have been added to the path. This way, we have 
 * a path that connects the source node to all other nodes following the shortest path possible to reach 
 * each node.
 * 
 * 
 * Dijkstra's Algorithm can only work with graphs that have positive weights. 
 * This is because, during the process, the weights of the edges have to be added to find the shortest path.
 * Once a node has been marked as "visited", the current path to that node is marked as the shortest path to
 * reach that node. And negative weights can alter this if the total weight can be decremented after this 
 * step has occurred.
 */
