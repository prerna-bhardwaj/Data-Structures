import java.util.*;

public class LuckyNumbers {

	// O(n*m) time | O(n+m) space
	public static List<Integer> luckyNumbers (int[][] mat){
        int m = mat.length, n = mat[0].length, min = 0;
        int row[] = new int[m], col[] = new int[n];
        for(int i = 0; i < m; i++) {
            min = 0;
            for(int j = 0;j < n; j++) {
                if(mat[i][j] < mat[i][min])
                    min = j;
            }
            row[i] = min;
        }
        
        for(int i =0; i< n; i++) {
            int max = 0;
            for(int j = 0;j < m; j++) {
                if(mat[j][i] > mat[max][i])
                    max = j;
            }
            col[i] = max;
        }
        
        List<Integer>ans = new ArrayList();
        for(int i = 0; i< m; i++) {
            int index = row[i];
            if(i == col[index])
                ans.add(mat[i][index]);
        }
        return ans;
    }

    // O(n*(n+m)) time | O(1) space
    public static List<Integer> luckyNumbersOptimized (int[][] mat){
        int m = mat.length, n = mat[0].length, min = 0;
        List<Integer>ans = new ArrayList();
       
        for(int i = 0; i < m; i++) {
            int minIndex = 0;
            for(int j = 0;j < n; j++) {
                if(mat[i][j] < mat[i][minIndex]) {
                    minIndex = j;
                }
            }
            
            int max = 0;
            for(int k = 0; k < m; k++) {
                if(mat[k][minIndex] > mat[max][minIndex])
                    max = k;
            }
            if(i == max)
                ans.add(mat[i][minIndex]);
        }
        return ans;
    }

    public static void main(String[] args) {
    	int a[][] = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
    	System.out.println(luckyNumbers(a));
    	int b[][] = {{3,7,8}, {9,11,13}, {15,16,17}};
    	System.out.println(luckyNumbersOptimized(b));
    	
    }
}