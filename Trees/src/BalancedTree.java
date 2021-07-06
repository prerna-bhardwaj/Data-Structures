
public class BalancedTree {
	
	/*
	 * APPROACH 1 : O(n^2)
	 * Use separate function for calculating height of left and right subtrees
	 * of a given node.
	 */
	private static boolean isBalanced(Node root) {
		if(root == null)	return true;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		System.out.println(root.data + " " + left + " " + right);

		return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
	}
	
	
	private static int getHeight(Node root) {
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	/*
	 * APPROACH 2 : O(n)
	 * Use modified getHeight function to return ht when tree is balanced 
	 * and -1 when tree is not.
	 */
	public static int isBalancedEfficient(Node root) {
		if(root == null)	return 0;
		int left = isBalancedEfficient(root.left);
		int right = isBalancedEfficient(root.right);
		System.out.println(root.data + " " + left + " " + right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1)	return -1;
		return 1 + Math.max(isBalancedEfficient(root.left), 
							isBalancedEfficient(root.right));
	}
	
	
	public static void main(String args[]) {	
		Node root = Node.createTree();
		System.out.println(isBalanced(root));
		System.out.println();
		System.out.println(isBalancedEfficient(root));
	}

	
}
