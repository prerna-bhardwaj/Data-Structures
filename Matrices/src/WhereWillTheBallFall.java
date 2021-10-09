/*

You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.

Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

*/
import java.util.*;

class WhereWillTheBallFall {
	
	// O(mn) time | O(1) space
	public static int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans[] = new int[n];
        
        for(int i = 0 ;i < n; i++) {
            int row = 0, col = i;
            boolean flag = true;
            while(row < m && col < n) {
                if(grid[row][col] == 1) {
                    if(col == n-1 || grid[row][col+1] == -1) {
                        flag = false;
                        break;
                    }
                    col++;
                }
                else {
                    if(col == 0 || grid[row][col-1] == 1) {
                        flag = false;
                        break;
                    }
                    col--;                    
                }
                row++;
            }
            if(flag)
                ans[i] = col;
            else
                ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
    	int mat[][] = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
    	int ans[] = findBall(mat);
    	System.out.println(Arrays.toString(ans));
    }
}