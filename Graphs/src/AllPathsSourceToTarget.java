import java.util.*;

public class AllPathsSourceToTarget {
	static List<List<Integer>>res;

	static void findPaths(int[][] graph, int n) {
		res = new ArrayList<List<Integer>>(	);
		pathHelper(graph, new LinkedList<Integer>(), n, 0);
		System.out.print(res);
	}

	static void pathHelper(int[][] mat, LinkedList<Integer> path, int n, int curr) {

		if(curr == (n-1)) {
			path.add(curr);
			res.add(new ArrayList<Integer>(path));
			path.removeLast();
			return;
		}
		for(int i = 0; i < mat[curr].length; i++) {
			path.addLast(curr);
			pathHelper(mat, path, n, mat[curr][i]);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] graph = {{1, 2, 3}, {2}, {3}, {}};
		findPaths(graph, n);
	}
}