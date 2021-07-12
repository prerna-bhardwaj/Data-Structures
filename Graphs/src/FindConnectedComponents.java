import java.util.ArrayList;

public class FindConnectedComponents {

	static class Edge {
	    int from, to, cost;
	
	    public Edge(int from, int to, int cost) {
	    	this.from = from;
	    	this.cost = cost;
	    	this.to = to;
	    }
	}

	int V, count;		// # of vertices, count of components
	boolean visited[];
	int components[];
	ArrayList<Edge>[] graph;
		
	FindConnectedComponents() {
		V = 7;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++)
			graph[i] = new ArrayList<Edge>();
		visited = new boolean[V];
		components = new int[V];
	}
	
	public void addEdge(Edge e) {
		graph[e.from].add(e);
	}
	
	public int findComponents() {
		for(int i = 0; i < V; i++) 
			if(visited[i] == false) {
				count++;
				dfs(i);				
			}
		for(int i = 0; i < components.length; i++)
			System.out.println(i + " " + components[i]);
		return count;
	}
	
	private void dfs(int node) {
		visited[node] = true;
		components[node] = count;
		
		for(Edge e : graph[node]) {
			if(visited[e.to] == false) 
				dfs(e.to);
		}
	}

	public static void main(String args[]) {
		FindConnectedComponents obj = new FindConnectedComponents();
		
	    // Create a fully connected graph
	    //           (0)
	    //           / \
	    //        5 /   \ 4
	    //         /     \
	    // 10     <   -2  >
	    //   +->(2)<------(1)      (4)
	    //   +--- \       /
	    //         \     /
	    //        1 \   / 6
	    //           > <
	    //           (3)
		
		obj.addEdge(new Edge(0, 1, 4));
		obj.addEdge(new Edge(0, 2, 5));
		obj.addEdge(new Edge(1, 2, -2));
		obj.addEdge(new Edge(1, 3, 6));
		obj.addEdge(new Edge(2, 3, 1));
		obj.addEdge(new Edge(2, 2, 10)); // Self loop;
		
		int count = obj.findComponents();
		System.out.println("\n# of Connected Components : " + count);
	}
}
