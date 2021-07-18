/*
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. 
 * It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can 
 * take to reach from source to destination. The directions in which the rat can move are 'U'(up), 
 * 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked
 * and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it. 
 * 
 * NOTE: In a path, no cell can be visited more than one time.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RatInAMaze {
	static int row[] = {0, 1, 0, -1};
	static int col[] = {1, 0, -1, 0};
	static String dir[] = {"R", "D", "L", "U"};
	static ArrayList<String>result;
	static int mat[][];
	static boolean visited[][];
	static int N;
	
	public static void main(String[] args) {			
		mat = new int[][]{{1, 0, 0, 0},
	         {1, 1, 0, 1}, 
	         {1, 1, 0, 0},
	         {0, 1, 1, 1}};
		visited = new boolean[mat.length][mat.length];
		N = mat.length;
		print(mat);
		result = new ArrayList<>();
		findPath(0, 0, "");
		Collections.sort(result);
		System.out.println(result);
			
	}

	private static void findPath(int sr, int sc, String path) {
		// Check is we are accessing a valid co-ordinate
		if(sc < 0 || sr < 0 || sr >= N || sc >= N) 
			return ;
		// If the pixel is not valid or if it is previously visited, then return
		if(visited[sr][sc] || mat[sr][sc] == 0)		return;
		// If we hv reached the destination, add path to result and return
		if(sr == N-1 && sc == N-1 && mat[sr][sc] == 1) {
			result.add(path);
			return;
		}
		visited[sr][sc] = true;
		// Visit neighboring pixels
		for(int i = 0; i < 4; i++) {
			findPath(sr + row[i], sc + col[i], path + dir[i]);
		}
		visited[sr][sc] = false;
	}

	private static void print(int[][] mat) {
		for(int i = 0; i < mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
		System.out.println();
		
	}
	
	private static void print(boolean[][] mat) {
		for(int i = 0; i < mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
		System.out.println();
		
	}

}
