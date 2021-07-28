
public class SpiralTraverse {
	
	public static void main(String[] args) {	
		// Rectangular Matrix
		int ar[][] = {{1, 2, 3, 4},
						{12, 13,14, 5},
						{11, 16, 15, 6},
						{10, 9, 8, 7},
						{21, 22, 23, 24}
					};
		
		// Horizontal Matrix
//		int ar[][] = {{1, 2, 3, 4 , 5, 6}};
		
		// Vertical Matrix
//		int ar[][] = {{1}, {2}, {3}, {4}};
		
		System.out.println("Recursive method : ");
		spiralTraverse(ar, 0, 0, ar.length-1, ar[0].length-1);
		System.out.println();
		System.out.println("Iterative method : ");
		spiralTraverseIterative(ar);
	}

	// O(n) time | O(min(m,n)) space
	private static void spiralTraverse(int[][] ar, int sr, int sc, int er, int ec) {
		if(sr > er || sc > ec)
			return;
		for(int i = sc; i <= ec; i++)
			System.out.print(ar[sr][i] + " ");

		for(int i = sr+1; i <= er; i++)
			System.out.print(ar[i][ec] + " ");

		// Condition is required for rectangular matrices
		if(sr < er) {
			for(int i = ec-1; i >= sc; i--)
				System.out.print(ar[er][i] + " ");				
		}
		
		// Condition is required for rectangular matrices
		if(sc < ec) {
			for(int i = er-1; i > sr; i--)
				System.out.print(ar[i][sc] + " ");				
		}
		System.out.println();
		spiralTraverse(ar, sr+1, sc + 1, er - 1, ec - 1);
	}
	
	// O(n) time | O(1) space
	// space is O(n) is you have to return the values in an array
	private static void spiralTraverseIterative(int[][] ar) {
		int sr = 0, sc = 0, er = ar.length-1, ec = ar[0].length-1;
	
		for( ; sr <= er && sc <= ec; sr++, sc++, er--, ec-- ) {
			for(int i = sc; i <= ec; i++)
				System.out.print(ar[sr][i] + " ");
			
			for(int i = sr+1; i <= er; i++)
				System.out.print(ar[i][ec] + " ");

			// Condition is required for rectangular matrices
			if(sr < er) {
				for(int i = ec-1; i >= sc; i--)
					System.out.print(ar[er][i] + " ");				
			}
			
			// Condition is required for rectangular matrices
			if(sc < ec) {
				for(int i = er-1; i > sr; i--)
					System.out.print(ar[i][sc] + " ");				
			}
			System.out.println();

		}
	}
}
