/*
1026. Maximum Difference Between Node and Ancestor

Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| 
and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

*/

class DiffBteNodeAncestor {

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode() {}

		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
 	}

	static int ans = 0;
    
    // Approach - For each subtree, find the minimum value and maximum value of its descendants.

    public static int maxAncestorDiff(TreeNode root) {
        ans = 0;
        traverse(root, root.val, root.val);
        return ans;
    }
	
	// O(n) time | O(logn) space - Worst case space = O(n)     
    public static void traverse(TreeNode root, int maxPar, int minPar) {
        if(root != null) {
            int diff1 = Math.abs(maxPar - root.val);
            int diff2 = Math.abs(minPar - root.val);
            ans = Math.max(ans, Math.max(diff1, diff2));

            maxPar = Math.max(maxPar, root.val);
            minPar = Math.min(minPar, root.val);
            traverse(root.left, maxPar, minPar);
            traverse(root.right, maxPar, minPar);
        }
    }

    public static void main(String[] args) {
    	
    }
}