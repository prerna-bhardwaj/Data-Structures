/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
*/


public class SortedArrayToBST {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	     this.left = left;
	        this.right = right;
	    }
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = solve(nums, 0, nums.length-1);
        return root;
    }
    
    // O(n) time | O(h) space - ht of tree, here h = log(n) to the base 2.
    public static TreeNode solve(int[] nums, int left, int right) {
        if(left <= right) {
            int mid = (left + right) / 2;
            System.out.println(left + " " + right + " " + mid);
            TreeNode curr = new TreeNode(nums[mid]);
            curr.left = solve(nums, left, mid - 1);
            curr.right = solve(nums, mid + 1, right);
            return curr;
        } 
        return null;
    }

    public static void printTree(TreeNode root) {
    	if(root != null) {
    		printTree(root.left);
    		System.out.print(root.val + " ");
    		printTree(root.right);
    	}
    }

    public static void main(String[] args) {
    	int arr[] = {-10,-3,0,5,9};
    	TreeNode root = sortedArrayToBST(arr);
    	printTree(root);
    }
}