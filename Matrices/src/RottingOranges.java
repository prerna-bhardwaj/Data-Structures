/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
import java.util.*;

class RottingOranges {

	static class Pair{
        int row, col;
        
        Pair() {}
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
	
	// O(n^2) time | O(n^2) space    
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        Queue<Pair>q = new LinkedList();
        boolean visit[][] = new boolean[m][n];
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    cnt++;
                else if(grid[i][j] == 2) {
                    visit[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }
        // No ripe oranges are present i.e. all are rotten
        if(cnt == 0)
            return 0;
        int time = 0;
        q.add(null);
        while(q.size() > 1) {
            Pair p = q.poll();
            // p = null when we have finished one level of the BFS.
            if(p == null) {
                q.add(null);
                time++;
                continue;
            }
            int row = p.row, col = p.col;
            if(row + 1 < m && grid[row+1][col] == 1 && !visit[row+1][col]) {
                visit[row+1][col] = true;
                q.add(new Pair(row+1, col));
                cnt--;
            }
            if(row - 1 >=0 && grid[row-1][col] == 1 && !visit[row-1][col]) {
                visit[row-1][col] = true;
                q.add(new Pair(row-1, col));
                cnt--;
            }
            if(col + 1 < n && grid[row][col+1] == 1 && !visit[row][col+1]) {
                visit[row][col+1] = true;
                q.add(new Pair(row, col+1));
                cnt--;
            }
            if(col - 1 >=0 && grid[row][col-1] == 1 && !visit[row][col-1]) {
                visit[row][col-1] = true;
                q.add(new Pair(row, col-1));
                cnt--;
            }
        }
        // If cnt>0, then some ripe oranges are present, but not reachable 4-directionally.
        // Thus it is impossible to rot all ripe oranges. Hence, return -1
        // Else return the time taken to rot all oranges.
        return (cnt > 0) ? -1 : time;
    }

    public static void main(String[] args) {
    	int  grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
    	System.out.println(orangesRotting(grid));
    }

}