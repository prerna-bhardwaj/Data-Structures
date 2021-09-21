public class IslandPerimeter {
	
	// Bascktracking solution
	static int count = 0;
    static int rowDir[] = {0, 1, 0, -1};
    static int colDir[] = {1, 0, -1, 0};
    
    public static int islandPerimeter(int[][] grid) {
        count = 0;
        boolean flag = false;
        int row = 0, col = 0;
        boolean visit[][] = new boolean[grid.length][grid[0].length];
        for(row = 0; row < grid.length; row++) {
            for(col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        islandHelper(grid, row, col, visit);
        return count;
    }
    
    public static void islandHelper(int[][]grid, int row, int col, boolean[][]visit) {
        if(!isValid(row, col, grid) || grid[row][col] == 0) {
            count++;
            return;
        }
        if(visit[row][col])
            return;
        visit[row][col] = true;
        for(int i = 0; i < 4; i++) {
            islandHelper(grid, row + rowDir[i], col + colDir[i], visit);
        }       
    }
    
    public static boolean isValid(int row, int col, int[][]grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;
        return true;
    }


    // O(rc) time | O(1) space
    // Optimal solution
	public int islandPerimeter(int[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0 ; i< n ; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    count += 4;
                    if(i-1 >= 0 && grid[i-1][j] == 1)
                        count--;
                    if(j-1 >= 0 && grid[i][j-1] == 1)
                        count--;
                    if(i+1 < n && grid[i+1][j] == 1)
                        count--;
                    if(j+1 < m && grid[i][j+1] == 1)
                        count--;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
    	int grid[][] = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    	System.out.println(islandPerimeter(grid));

    }
}