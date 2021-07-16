import java.util.Arrays;

public class NumberOfIslands {
    static int row[] = {0, 1, 0, -1, 1, -1, 1, -1};
    static int col[] = {1, 0, -1, 0, -1, -1, 1, 1}; 
    
    //Function to find the number of islands.
    public static int numIslands(char[][] grid)
    {
        int count = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i =0 ; i < grid.length; i++) {
            for(int j =0 ; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    
    public static void dfs(char[][]grid, boolean[][]visited, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return ;
        if(visited[r][c])   return ;
        if(grid[r][c] == '0')   return ;
        visited[r][c] = true;
        for(int i =0 ; i < 8; i++) {
            dfs(grid, visited, r + row[i], c + col[i]);
        }
    }
    
    
	public static void main(String args[]) {
		/*
		 	0 1
			1 0
			1 1
			1 0
		 */
		char[][]grid = {{'1', '0'}, {'0', '1'}, {'1', '1'}, {'0', '1'}};
        int ans = numIslands(grid);
        System.out.println(Arrays.deepToString(grid) + " - " + ans);
    
        /*
            0 1 1 1 0 0 0
			0 0 1 1 0 1 0 
         */
        grid = new char[][] {{'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'}};
        ans = numIslands(grid);
        System.out.println(Arrays.deepToString(grid) + " - " + ans);
	
	}
}
