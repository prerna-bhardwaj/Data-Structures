/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum 
of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

class MinimumPathSum {

	// O(n^2) time | O(n^2) space
	public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if(i != 0 && j != 0)
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                else if(i == 0 && j > 0)
                    dp[i][j] += dp[i][j-1];
                else if(i > 0 && j == 0)
                    dp[i][j] += dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		// Answer = 7
		int mat[][] = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(mat));
	}
}