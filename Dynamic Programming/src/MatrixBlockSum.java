/*
Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.
 
*/

import java.util.*;

class MatrixBlockSum {
	// O(n^2) time | O(n^2) space
	public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <=n ;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + mat[i-1][j-1] - dp[i-1][j-1];
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int row1 = (i-k) >= 0 ? i-k : 0;
                int col1 = (j-k) >= 0 ? j-k : 0;
                int row2 = (i+k+1) <= m ? i+k+1 : m;
                int col2 = (j+k+1) <= n ? j+k+1 : n;
                mat[i][j] = dp[row2][col2] - dp[row1][col2] - dp[row2][col1] + dp[row1][col1];
            }
        }
        return mat;
    }

    public static void main(String[] args) {
    	int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
    	System.out.println(Arrays.deepToString(matrixBlockSum(mat, 1)));
    }
}

/*

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

*/