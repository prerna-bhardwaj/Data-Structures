/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.
*/

import java.util.*;

class SetMatrixZeros {
	// O(n^2) time | O(1) space
	public static void setZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean row = false, col = false;
        for(int i = 0; i< m; i++) {
            if(mat[i][0] == 0) {
                row = true;
                break;
            }
        }
        for(int i = 0; i< n; i++) {
            if(mat[0][i] == 0) {
                col = true;
                break;
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n ; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }        
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;
            }
        }
        if(row) {
            for(int i = 0; i < m; i++) 
                mat[i][0] = 0;
        }
        if(col) {
            for(int j = 0; j < n; j++)
                mat[0][j] = 0;
        }
    }

    public static void main(String[] args) {
    	// Answer : [[1,0,1],[0,0,0],[1,0,1]]
		int mat[][] = {{1,1,1},{1,0,1},{1,1,1}};
		setZeroes(mat);
		System.out.println(Arrays.deepToString(mat));
	}
}