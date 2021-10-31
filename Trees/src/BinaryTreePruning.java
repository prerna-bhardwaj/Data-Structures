/*
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

 Constraints:

The number of nodes in the tree is in the range [1, 200].
Node.val is either 0 or 1.

*/

class BinaryTreePruning {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
			left = right = null;
		}
	}
	
	/*
		Complexity Analysis

		Time Complexity: O(N), where N is the number of nodes in the tree. We process each node once.

		Space Complexity: O(N), the recursion call stack can be as large as the height H of the tree. 
							In the worst case scenario, H=N, when the tree is skewed.
	*/
	public static TreeNode pruneTree(TreeNode root) {
        boolean val = helper(root);
        return (val == false) ? null : root;
    }
    
    public static boolean helper(TreeNode root) {
        if(root == null)
            return false;
        boolean left = helper(root.left);
        if(left == false)
            root.left = null;
        boolean right = helper(root.right);
        if(right == false)
            root.right = null;
        return root.val == 1 | left | right;
    }

    public static void inOrder(TreeNode root) {
    	if(root != null) {
    		inOrder(root.left);
    		System.out.print(root.val + " " );
    		inOrder(root.right);
    	}
    } 

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.right = new TreeNode(0);
    	root.right.left = new TreeNode(0);
    	root.right.right = new TreeNode(1);

    	/*
	    	Input: root = [1,null,0,0,1]
			Output: [1,null,0,null,1]
		*/

		inOrder(root);
		TreeNode newRoot = pruneTree(root);
		System.out.println();
		inOrder(newRoot);
    }

}