/*
You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the 
coordinates (rCenter, cCenter).

Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance 
to the largest distance. You may return the answer in any order that satisfies this condition.

The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
*/

import java.util.*;

public class CellsInDistanceOrder {
	// O(nlogn) time | O(n) space
    // n = rows * col 
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int ans[][] = new int[rows*cols][2];
        int index = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                ans[index][0] = i;
                ans[index++][1] = j;
            }
        }
        
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int i = Math.abs(rCenter - a[0]);
                int j = Math.abs(cCenter - a[1]);                
                int u = i + j;
                
                i = Math.abs(rCenter - b[0]);
                j = Math.abs(cCenter - b[1]);                
                int v = i + j;
                
                return u-v;
            }
        });
        return ans;
    }

    // O(n) time | O(n) space
    // n = rows * cols
     public int[][] allCellsDistOrderBFS(int rows, int cols, int rCenter, int cCenter) {
        int res[][] = new int[rows*cols][2];
        Queue<int[]> q = new LinkedList();
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        int[] pos = {rCenter, cCenter};
        boolean[][] visited = new boolean[rows][cols];
        q.add(pos);
        // Mark center as visited
        visited[rCenter][cCenter] = true;
        int i = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            // For all nodes in the queue
            for(int j = 0; j < size; j++) {
                int[] p = q.remove();
                // Add curr element to result array
                res[i][0] = p[0];
                res[i][1] = p[1];
                i++; 
                // Process all VALID adjacent nodes of current node (adj nodes should not visited before).
                for(int k = 0; k < x.length; k++) {
                    int nX = p[0] + x[k];
                    int nY = p[1] + y[k];
                    if(nX >= 0 && nY >= 0 && nX < rows && nY < cols && !visited[nX][nY]) {
                        visited[nX][nY] = true;
                        int nP[] = {nX, nY};
                        q.add(nP);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	System.out.println(Arrays.deepToString(allCellsDistOrder(3, 5, 2, 3)));
    }
}