/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 
0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 
*/

class PathWithMaxSum {
	static int max = 0;

	// O(2^n) time | O(n) space (call stack)
    public static int getMaximumGold(int[][] grid) {
        max = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0 ; i< m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0)
                    solve(i, j, grid, 0);
            }
        } 
        return max;
    }
    
    public static void solve(int row, int col, int[][] grid, int sum) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;
        if(grid[row][col] == 0 || grid[row][col] == -1)
            return;
        sum += grid[row][col];
        int curr = grid[row][col];
        grid[row][col] = -1;
        if(sum > max)
            max = sum;
        solve(row + 1, col, grid, sum);
        solve(row, col + 1, grid, sum);
        solve(row - 1, col, grid, sum);
        solve(row, col - 1, grid, sum);
        grid[row][col] = curr;
        sum -= grid[row][col];
    }

    public static void main(String[] args) {
    	int grid[][] = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
 		// Answer = Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
    	System.out.println(getMaximumGold(grid));
    }
}