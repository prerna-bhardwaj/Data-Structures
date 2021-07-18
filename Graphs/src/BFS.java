import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	int V;
	ArrayList<Integer>[] graph;
	
	BFS() {
		this.V = Graph.V;
		graph = Graph.createUndirectedGraph();		
	}
	
	public static void main(String args[]) {
		BFS obj = new BFS();
		Graph.printGraph(obj.graph);
		obj.bfs();		
	}

	private void bfs() {
		Queue<Integer>q = new LinkedList<>();
		boolean[] visited = new boolean[Graph.V];
		q.add(0);
		visited[0] = true;
		
		// Or q.size() > 0
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for(int ele : graph[node])
				if(visited[ele] == false) {
					q.add(ele);
					// mark vertex as visited while pushing in the queue
					visited[ele] = true;
				}
		}
	}
}
