/*

You are given an m x n integer matrix grid, and three integers row, col, and color. 
Each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally 
adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

You should color the border of the connected component that contains the square grid[row][col] with color.

Return the final grid.

*/

import java.util.*;

class BorderColoring {

	static class Cell {
        int row, col;
        Cell() {}
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    // O(n^2) time | O(??) space
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int dir_row[] = {1, -1, 0, 0};
        int dir_col[] = {0, 0, 1, -1};
        Queue<Cell>q = new LinkedList();
        int m = grid.length, n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        // Add start point to queue and mark it as visited
        q.add(new Cell(row, col));
        visit[row][col] = true;
        int curr = grid[row][col];
        
        // Process the current component using BFS
        while(!q.isEmpty()) {
            Cell c = q.poll();
            int i = c.row, j = c.col;
            int temp = 0;
            // Check all adjacent cells for every cell
            for(int k = 0;k < 4; k++) {
                int newRow = i + dir_row[k];
                int newCol = j + dir_col[k];
                // If the adjacent cell also has the same color, or has been processed previously
                if(newRow < m && newRow >= 0 && newCol < n && newCol >= 0 && (grid[newRow][newCol] == curr || grid[newRow][newCol] == -1)) {
                	// This cell is a part of the component, thus increment temp
                    temp++;
                    // If the cell hasn't been visited yet, then add it to the queue
                    if(!visit[newRow][newCol]) {
                        visit[newRow][newCol] = true;
                        q.add(new Cell(newRow, newCol));
                    }
                }
            }
            // For all cells, that are not surrounded by cells belonging to the same component in all 4 directions, 
            // these cells lie on the border. Thus mark then as visited
            if(temp < 4)
                grid[i][j] = -1;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == -1)
                    grid[i][j] = color;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
    	int grid[][] = {{1,2,1,2,1,2}, {2,2,2,2,1,2}, {1,2,2,2,1,2}};
    	int row = 1, col = 3, targetColor = 1;

    	// Output : [[1,1,1,1,1,2],[1,2,1,1,1,2],[1,1,1,1,1,2]]
    	System.out.println(Arrays.deepToString(colorBorder(grid, row, col, targetColor)));
    }
}