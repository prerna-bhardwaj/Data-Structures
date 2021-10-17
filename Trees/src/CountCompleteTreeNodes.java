/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

*/

class CountCompleteTreeNodes {

	// O((logn)^2) time | O((logn)^2) space
	public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == right) 
            return (int)Math.pow(2, left) + countNodes(root.right);
        return (int)Math.pow(2, right) + countNodes(root.left); 
    }
    
    public static int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + getHeight(root.left);
    }

    public static void main(String[] args) {
    	
    }
}