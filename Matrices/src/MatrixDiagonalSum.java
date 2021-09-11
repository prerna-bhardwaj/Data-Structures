public class MatrixDiagonalSum {
	
	// O(n) time | O(1) space
	// NOTE : 2 vars are used as for loop counters.
	public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0, j=n-1; i < n && j>= 0; i++,j--) {
            sum += (i==j) ? mat[i][i] : mat[i][i] + mat[i][j];
        }
        return sum;
    }

    public static void main(String[] args) {
    	int mat[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    	System.out.println(diagonalSum(mat));	
    }
}