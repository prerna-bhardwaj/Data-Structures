/*

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a 
closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

*/

class NumberOfClosedIslands {
	
	static int m = 0, n = 0;
    static boolean isClosed = true;
    
    public static int closedIsland(int[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                isClosed = true;
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if(isClosed == true)
                        count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int grid[][], int row, int col) {
        if(row < 0 || col < 0 || row >= m || col >= n)
            return;
        if(grid[row][col] == 1)
            return;
        if(row == 0 || col == 0 || row == m-1 || col == n-1) 
            isClosed = false;
        grid[row][col] = 1;
        
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row+1, col);
    }

    public static void main(String[] args) {
    	int grid[][] = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
    	// Answer = 2
    	System.out.println(closedIsland(grid));
    }
}