/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

*/


import java.util.*;

class SurroundedRegions {
	static class Cell{
        int x, y;
        Cell() {}
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // O(m + n + m*n + m*n) time = ~O(m*n) time | O(m+n) space
    public static void solve(char[][] grid) {
        Queue<Cell>q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        // Add all Os from the boundary
        for(int i = 0; i < n; i++) {
            if(grid[0][i] == 'O')
                q.add(new Cell(0, i));
            if(grid[m-1][i] == 'O')
                q.add(new Cell(m-1, i));
        }
        for(int i = 1; i < m-1; i++) {
            if(grid[i][0] == 'O')
                q.add(new Cell(i, 0));
            if(grid[i][n-1] == 'O')
                q.add(new Cell(i, n-1));
        }
        // Now perform bfs on all those cells
        while(!q.isEmpty()) {
            Cell c = q.poll();
            grid[c.x][c.y] = 'Y';

            // top
            if(c.x > 0 && grid[c.x-1][c.y] == 'O')
                q.add(new Cell(c.x-1, c.y));
            // left
            if(c.y > 0 && grid[c.x][c.y-1] == 'O')
                q.add(new Cell(c.x, c.y-1));
            // down
            if(c.x < m-1 && grid[c.x+1][c.y] == 'O')
                q.add(new Cell(c.x+1, c.y));
            // right
            if(c.y < n-1 && grid[c.x][c.y+1] == 'O')
                q.add(new Cell(c.x, c.y+1));                
        }
        // The remaining Os are the ones that are completely surrounded by Xs and aren't reachable from the boundary.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'Y')
                    grid[i][j] = 'O';
                else if(grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
    	char mat[][] = {{'X', 'X', 'X'}, {'X', 'X', 'O'}, {'X', 'O', 'X'}, {'X', 'X', 'O'}};
    	solve(mat);
    	System.out.println(Arrays.deepToString(mat));
    }
}