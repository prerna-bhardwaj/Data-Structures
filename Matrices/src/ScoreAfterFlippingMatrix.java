/*
You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's,
 and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).
*/

import java.util.*;

class ScoreAfterFlippingMatrix {
	
	// O(n^2) time | O(1) space
	public static int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m ; i++) {
            if(grid[i][0] == 0) 
                toggleRow(i, grid);
        }
        for(int col = 0; col < n ; col++) {
            int cnt = 0;
            for(int row = 0; row < m; row++)
                cnt += grid[row][col];
            if(cnt*2 < m)
                toggleColumn(col, grid);
        }
        int sum = 0;
        for(int i = 0; i < m; i++) {
            int val = 0;
            for(int j = 0; j < n; j++)
                val = 2*val + grid[i][j];
            sum += val;
        }
        return sum;
    }
    
    public static void toggleRow(int row, int grid[][]) {
        for(int i = 0; i < grid[0].length ; i++)
            grid[row][i] = (grid[row][i] == 0) ? 1 : 0;
    }

    public static void toggleColumn(int col, int grid[][]) {
        for(int i = 0; i < grid.length ; i++)
            grid[i][col] = (grid[i][col] == 0) ? 1 : 0;
    }
 

 	public static void main(String[] args) {
 		int mat[][] = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};   	
 		System.out.println(Arrays.deepToString(mat));
 		System.out.println(matrixScore(mat));
 		System.out.println(Arrays.deepToString(mat));
 	}   
}


/*

Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

*/