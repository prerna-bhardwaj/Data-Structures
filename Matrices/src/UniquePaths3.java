/*
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.
*/

class UniquePaths3 {
	static int count = 0;
    static int m, n;
    static int row[] = {0, -1, 0, 1};
    static int col[] = {1, 0, -1, 0};
    
    public static int uniquePathsIII(int[][] grid) {
        count = 0;
        int startX = -1, startY = -1, endX = -1, endY = -1, total = 0;
        m = grid.length;
        n = grid[0].length;
        boolean visit[][] = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0;j < n; j++) {
                if(grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                else if(grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
                else if(grid[i][j] == 0)
                    total++;
            }
        }
        solve(startX, startY ,endX, endY, total+1, visit, grid);
        return count;
    }
    
    public static void solve(int currX, int currY, int endX, int endY, int total, boolean visit[][], int grid[][]) {
        
        if(currX < 0 || currY < 0 || currX >= m || currY >= n)
            return;
        if(visit[currX][currY] || grid[currX][currY] == -1)
            return;
        if(currX == endX && currY == endY && total == 0) {
            count++;
            return;
        }
        visit[currX][currY] = true;
        for(int i =0 ; i < 4; i++) {
            solve(currX + row[i], currY + col[i], endX, endY, total-1, visit, grid);
        }
        visit[currX][currY] = false;
    }

    public static void main(String[] args) {
    	int grid[][] = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
    	System.out.println(uniquePathsIII(grid));
    }
}

/*

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2

Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

*/