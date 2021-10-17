/*
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the 
value target, it should also be deleted (you need to continue doing that until you can't).

*/

class DeleteLeaveWithValue {
	// O(logn) time | O(logn) space - for call stack	
	public static TreeNode removeLeafNodes(TreeNode root, int target) {
        root = solve(root, target);
        return root;
    }
    
    public static TreeNode solve(TreeNode root, int target) {
        if(root != null) {
            root.left = solve(root.left, target);
            root.right = solve(root.right, target);
            if(root.left == null && root.right == null && root.val == target)
                root = null;
        }
        return root;
    }

    public static void main(String[] args) {
    	
    }
}