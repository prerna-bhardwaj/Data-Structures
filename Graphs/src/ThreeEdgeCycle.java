/*
 * Calculate the number of 3-edge cycles in an undirected graph
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeEdgeCycle {
	static int N;
	static ArrayList<Integer> adj[];
	static int count;
	static HashSet<ArrayList<Integer>>cycles;
	
	ThreeEdgeCycle(int n){
		N = n;
		adj = new ArrayList[N];
		for(int i = 0; i < N; i++)
			adj[i] = new ArrayList<Integer>();
		cycles = new HashSet<ArrayList<Integer>>();
	}
	
	static void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	private static void findCycles() {
		count = 0;
		
		for(int i = 0 ; i < N; i++) {
			for(int one : adj[i]) {
				for(int two : adj[one]) {
					if(isAdjacentNode(i, two)) {
						System.out.println(i + " - " + one + " - " + two);
						count++;
						ArrayList<Integer>temp = new ArrayList(Arrays.asList(i, one,two)) ;
						Collections.sort(temp);
						cycles.add(temp);
					}
				}
			}
		}
		// For directed graph, divide count by 3 and return.
		count /= 6;
	}
	
	private static boolean isAdjacentNode(int start, int adjNode) {
		for(int ele : adj[start]) {
			if(ele == adjNode)
				return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		ThreeEdgeCycle obj = new ThreeEdgeCycle(5);
		addEdge(0, 1);
		addEdge(1, 2);
		addEdge(2, 3);
		addEdge(0, 3);
		addEdge(0, 2);
		addEdge(1, 4);
		addEdge(2, 4);
		
		findCycles();
		System.out.println("# of 3 edge cycles : " + count);
		System.out.println("Cycles are : " + cycles);
	}
}
