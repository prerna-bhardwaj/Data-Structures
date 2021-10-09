/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either 
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be 
(row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

*/

class MinFallingPathSum {

	public static int minFallingPathSum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int MAX = 1000000;
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int one = (j == 0) ? MAX : mat[i-1][j-1];
                int two = mat[i-1][j];
                int three = (j >= n-1) ? MAX : mat[i-1][j+1];
                mat[i][j] += Math.min(one, Math.min(two, three));
            }
        }
        int ans = mat[m-1][0];
        for(int i = 0; i < n; i++)
            ans = Math.min(ans, mat[m-1][i]);
        return ans;
    }

    public static void main(String[] args) {
    	int mat[][] =  {{2,1,3},{6,5,4},{7,8,9}};
    	System.out.println(minFallingPathSum(mat));
    }
}

/*

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13

Explanation: There are two falling paths with a minimum sum underlined below:
[[2,1,3],      [[2,1,3],
 [6,5,4],       [6,5,4],
 [7,8,9]]       [7,8,9]]

*/