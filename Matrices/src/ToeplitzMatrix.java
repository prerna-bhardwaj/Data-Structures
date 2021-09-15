/*

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

*/

public class ToeplitzMatrix {

	// O(nm) time | O(1) space
	public static boolean isToeplitzMatrix(int[][] mat) {
        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i-1][j-1] != mat[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	int arr[] = {{1, 3}, {2, 2}};
    	System.out.println(isToeplitzMatrix(arr));
    }
}