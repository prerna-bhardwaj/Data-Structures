/*
 * Given the total number of tasks and a list of prerequisite pairs, is it possible for you to finish all tasks?
 * 
 * Approach : If there is a cycle in the graph, then it is not possible to finish all tasks 
 *  (because in that case there is no any topological order of tasks). 
 *  
 *  TC - O(V + E)
 *  SC - O(V)
 */

import java.util.*;

public class PrerequisiteTasks {

	static class Pair {
		int first, second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
		
	public static void main(String[] args) {
		int numTasks = 4;
	     
        Vector<Pair> prerequisites = new Vector<Pair>();
     
        // for prerequisites: [[1, 0], [2, 1], [3, 2]]
     
        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(2, 1));
        prerequisites.add(new Pair(3, 2));
         
        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }
        
        prerequisites = new Vector<Pair>();
        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(0, 1));
        numTasks = 2;
        if (canFinish(numTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        }
        else {
            System.out.println("Impossible to finish all tasks");
        }
        
	}

	/*
	 * Returns true if we can finish the given tasks in required order, else false is returned.
	 */
	private static boolean canFinish(int numTasks, Vector<Pair> prerequisites) {
		ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);
		boolean[] visited = new boolean[numTasks];
		// OnPath is used for the current components DFS tree
	    boolean[] onPath = new boolean[numTasks];
	    // For loop is used for disconnected graphs - O(V)
	    for(int i =0 ; i < graph.size(); i++) {
	    	if(!visited[i] &&  dfs_has_cycle(graph, visited, onPath, i))
	    		return false;	    	
	    }
	    return true;
	}

	/*
	 * Returns true when a cycle is present in the graph, else false
	 */
	private static boolean dfs_has_cycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited,
			boolean[] onPath, int start) {
		if(visited[start])	
			return false;
		visited[start] = onPath[start] = true;
		
		for(int ele : graph.get(start)) {
			// Is element is present in current dfs path or there exists a cycle in ele's subtree, return true
			if(onPath[ele] || dfs_has_cycle(graph, visited, onPath, ele))
				return true;
		}
		onPath[start] = false;
		return false;
	}

	// Converts the prerequisites into a valid representation 
	private static ArrayList<ArrayList<Integer>> make_graph(int n, Vector<Pair> prereq) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++)
			graph.add(new ArrayList<Integer>());
		for(Pair p : prereq) {
			int start = p.first;
			int end = p.second;
			graph.get(start).add(end);
		}
		
		return graph;
	}
}
