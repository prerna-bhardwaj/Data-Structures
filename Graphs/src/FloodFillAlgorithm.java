import java.util.Arrays;

/*
 * An image is represented by an m x n integer grid image where image[i][j] 
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and newColor. 
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 */

public class FloodFillAlgorithm {
	static int row[] = {0, 1, 0, -1};
	static int col[] = {1, 0, -1, 0};
	
	public static void main(String[] args) {			
		int image[][] = {{0, 0, 0}, {0, 0, 0}};
		int sr = 0, sc = 0;
		int newColor = 2;
		
		print(image);
		int result[][] = floodFill(image, sr, sc, newColor);
		print(result);
		
		image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		print(image);
		sr = 1;
		sc = 1;
		newColor = 4;
		result = floodFill(image, sr, sc, newColor);
		print(result);
		
	}

	private static void print(int[][] mat) {
		for(int i = 0; i < mat.length; i++)
			System.out.println(Arrays.toString(mat[i]));
		System.out.println();
		
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		return floodFillUtil(image, sr, sc, image[sr][sc], newColor);
	}

	private static int[][] floodFillUtil(int[][] image, int sr, int sc, int orgColor, int newColor) {
		// Check is we are accessing a valid co-ordinate
		if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
			return image;
		// If the pixel is not valid or if it is previously visited, then return
		if(image[sr][sc] != orgColor || image[sr][sc] == newColor)
			return image;
		image[sr][sc] = newColor;
		// Visit neighboring pixels
		for(int i =0 ; i < 4; i++) 
			floodFillUtil(image, sr + row[i], sc + col[i], orgColor, newColor);
		return image;
	}
}
