/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. 
You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course 
prevCoursej has to be completed before course nextCoursej (prerequisite relationship). 
Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete 
the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.

Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).

*/

import java.util.*;

class ParallelCoursesIII {
	
	static class Node {
        int val, time;
        Node() {}
        Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    
    public static int minimumTime(int n, int[][] rel, int[] time) {        
        // initialize a graph
        ArrayList<Integer>graph[] = new ArrayList[n];
        int []indegree = new int[n];			
		int []max = new int[n];
		for (int i = 0; i < n; i++) 
	    	graph[i] =  new ArrayList<>();

        // Create the graph, update indegrees for all vertices
        for(int i = 0; i < rel.length; i++) {
            int prev = rel[i][0];
            int next = rel[i][1];
            graph[prev-1].add(next-1);
            indegree[next-1]++;
        }
        
        Queue<Node>q = new LinkedList();
        // For all vertices with indegree=0, add them to the queue
        for(int i = 0; i< n; i++) {
            if(indegree[i] == 0)
                q.add(new Node(i, 0));
        }
        
        int total = 0;
        while(q.size() > 0) {
            // Pop a vertex, and find the time at which it has been completed
            Node curr = q.poll();
            int currTime = curr.time + time[curr.val];
        
            //  Update total time if required
            total = Math.max(total, currTime);
        
            // Process adj nodes of a vertex
            for(int ele : graph[curr.val]) {
                indegree[ele]--;
        
                // The time at which the adj node can be processed is updated based on the end time of curr vertex.
                max[ele] = Math.max(max[ele], currTime);
                if(indegree[ele] == 0)
                    q.add(new Node(ele, max[ele]));
            }
        }
        return total;
    }

    public static void main(String[] args) {
    	int n = 5;
    	int time[] = {1,2,3,4,5};
    	int relations[][] = {{1,5},{2,5},{3,5},{3,4},{4,5}};
    	// Output = 12
    	System.out.println(minimumTime(n, relations, time));
    }
}