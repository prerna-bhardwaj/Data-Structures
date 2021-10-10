/*

You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.

*/

import java.util.*;

class MakeUniValuedGrid {
	
	public static int minOperations(int[][] grid, int x) {
        int mod = grid[0][0] % x;
        int m = grid.length, n = grid[0].length;
        int arr[] = new int[m*n];
        int index = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] % x != mod)
                    return -1;
                grid[i][j] -= mod;
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        if(arr.length == 1)
            return 0;
        int len = m*n;
        int mid1 = arr[len/2];
        int mid2 = arr[(len/2)-1];
        int res1 = 0, res2 = 0;
        for(int num : arr) {
            res1 += Math.abs(num - mid1)/x;
            res2 += Math.abs(num - mid2)/x;
        }
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
    	int mat[][] = {{2,4},{6,8}};
    	System.out.println(minOperations(mat, 2));
    }
}