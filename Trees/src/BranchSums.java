/*
 * Number of nodes in full binary tree of n nodes = (n+1)/2. The sumArray has size = # of leaf nodes. hence O(n) space complexity
 * The tree has 2b+1 nodes, b internal nodes, and b+1 leaves, where b is the number of branchings.
 * thus, n = 2b+1
 */
import java.util.ArrayList;

public class BranchSums {

	public static void main(String[] args) {
		Node root = Node.createTree();
		System.out.println(getBranchSums(root));
	}

	private static ArrayList<Integer> getBranchSums(Node root) {
		ArrayList<Integer>sumArray = new ArrayList<>();
		getBranchSumsHelper(root, sumArray, 0);
		return sumArray;
	}

	// O(n) time | O(n) space
	private static void getBranchSumsHelper(Node root, ArrayList<Integer> sumArray, int currSum) {
		if(root == null)
			return;
		currSum += root.data;
		if(isLeaveNode(root)) {
			sumArray.add(currSum);
			return;			
		}
		getBranchSumsHelper(root.left, sumArray, currSum);
		getBranchSumsHelper(root.right, sumArray, currSum);
	}

	private static boolean isLeaveNode(Node root) {
		return root.left == null && root.right == null;
	}
}
