import java.util.ArrayList;
import java.util.Arrays;

public class mColoringProblem {

	ArrayList<Integer>adj[];		// An undirected connected graph
	int C, N;
	boolean[] visited;
	int[] colMat;
	
	mColoringProblem(int c, int n) {
		C = c;
		N = n;
		visited = new boolean[N];
		colMat = new int[N];
		adj = new ArrayList[N];
		for(int i = 0 ;i < N; i++)
			adj[i] = new ArrayList<Integer>();
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	private boolean isPossible(int vertex) {
		if(vertex == adj.length)
			return true;
		for(int col = 1; col <= C; col++ ) {
			if(isValid(vertex, col)) {
				colMat[vertex] = col;
				if(isPossible(vertex+1))
					return true;
				// backtrack to find another arrangement
				colMat[vertex] = 0;
			}
		}
		return false;
	}
	
	private boolean isValid(int vertex, int col) {
		for(int ele : adj[vertex]) 
			if(colMat[ele] == col)
				return false;
		return true;
	}

	public static void main(String args[]) {
		mColoringProblem obj = new mColoringProblem(3, 4);
		
		// Add edges to the graph
		obj.addEdge(0, 1);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.addEdge(3, 0);
		obj.addEdge(0, 2);
		
		System.out.println(obj.isPossible(0) ? "YES" : "NO");
		
	}

}
