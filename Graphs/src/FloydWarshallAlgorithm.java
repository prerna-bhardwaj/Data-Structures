import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

import java.util.ArrayList;
import java.util.Arrays;;

public class FloydWarshallAlgorithm {
	static class Edge {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	int V;
	double[][] dp, mat;
	Integer[][] next;

	FloydWarshallAlgorithm(int V) {
		this.V = V;
		mat=  new double[V][V];
		for(int i = 0; i < V; i++) {
			Arrays.fill(mat[i], POSITIVE_INFINITY);
		}
		dp = new double[V][V];
		next = new Integer[V][V];
	}
	
	public void addEdge(int u, int v, int cost) {
		mat[u][v] = cost;
	}
	
	public static final int REACHED_NEGATIVE_CYCLE = -1;
	
	public void populateMatrices() {
		for(int i = 0;i < V; i++) {
			for(int j = 0; j < V; j++) {
				dp[i][j] = mat[i][j];
				if(mat[i][j] != POSITIVE_INFINITY)
					next[i][j] = j;
			}
		}
	}
	
	public void floydWarshall() {
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if((dp[i][k] + dp[k][j]) < dp[i][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
						if(i == 0 && j == 0)
							System.out.printf("%d %d %d %f %f %f", i, j ,k , dp[i][j], dp[i][k], dp[k][j]);
						
						next[i][j] = next[i][k];
					}
				}
			}
//			printDist();
//			printNext();
		}
	}
	
	private void printMat() {
		System.out.println("Input Adjacency Matrix : ");
		for(int i = 0; i < V; i++)
			System.out.println(Arrays.toString(mat[i]));
		System.out.println();
	}
	
	private void printNext() {
		System.out.println("Next Node in Shortest Path : ");
		for(int i = 0; i < V; i++)
			System.out.println(Arrays.toString(next[i]));
		System.out.println();
	}
	
	private void printDist() {
		System.out.println("Shortest Distance btw All Pairs : ");
		for(int i = 0; i < V; i++)
			System.out.println(Arrays.toString(dp[i]));
		System.out.println();
	}

	private ArrayList<Integer> reconstructPath(int start, int end) {
		ArrayList<Integer> path = new ArrayList<>();
		
		// Node not reachable
		if(dp[start][end] == POSITIVE_INFINITY)		return path;
		// Negative edge weight cycle
		if(dp[start][end] == -1)	return null;
		// Find actual path
		for(int at = start; at != end; at = (int) next[at][end]) {
			path.add(at);
		}
		
		return path;
	}
	
	public static void main(String args[]) {
		int V = 4;
		FloydWarshallAlgorithm obj = new FloydWarshallAlgorithm(V);
//		obj.addEdge(0, 1, 3);
//		obj.addEdge(0, 4, -4);
//		obj.addEdge(0, 2, 8);
//		obj.addEdge(1, 3, 1);
//		obj.addEdge(1, 4, 7);
//		obj.addEdge(2, 1, 4);
//		obj.addEdge(3, 0, 2);
//		obj.addEdge(3, 2, -5);
//		obj.addEdge(4, 3, 6);
		
		obj.addEdge(0, 1, 2);
		obj.addEdge(0, 3, 8);
		obj.addEdge(1, 2, 3);
		obj.addEdge(2, 3, 1);

		obj.printMat();
				
		// Populate dp and next matrices
		obj.populateMatrices();
		obj.floydWarshall();
	
		// Print Shortest Paths
		obj.printDist();
		
		// Print next occurring node in Shortest Path
		obj.printNext();
				
		// Reconstruct Path from A-D
		System.out.println("Path followed to get to Node D from Node A : " + obj.reconstructPath(0,3));
	}
	
}
