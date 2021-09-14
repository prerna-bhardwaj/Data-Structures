/*
Given a biredictional graph, find if there exists a valid path from start to end vertex.
*/

import java.util.*;

public class PathExistsInGraph {

    static List<Integer>list;
    static boolean visited[];
    static ArrayList<Integer>[] graph;
        
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        list = new ArrayList();
        visited = new boolean[n];
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] ar : edges) {
            graph[ar[0]].add(ar[1]);
            graph[ar[1]].add(ar[0]);
        }
        dfs(start, end);
        return visited[end];
    }
    
    public static void dfs(int start, int end) {
        if(visited[end])
            return;
        visited[start] = true;
        list.add(start);
        for(Integer child : graph[start]) {
            if(visited[child] == false)
                dfs(child, end);
        }
    }

    public static void main(String[] args) {
    	int edges[][] = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
    	int start = 0, end = 5, n = 6;
    	System.out.println(validPath(n, edges, start, end));
    }
}