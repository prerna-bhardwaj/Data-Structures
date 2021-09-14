/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

NOTE : Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Link : https://leetcode.com/problems/cousins-in-binary-tree/
*/

public class CousinsInBinaryTree {

	static int depth_x = -1, depth_y = -1;
    static TreeNode par_x = null, par_y = null;

    public static boolean isCousins(TreeNode root, int x, int y) {
        getDepth(root, x, y, null, 0);
        return depth_x == depth_y && par_x != par_y;
    }
    
    public static void getDepth(TreeNode root, int x, int y, TreeNode parent, int level) {
        if(root != null) {
            if(root.val == x) {
                depth_x = level;
                par_x = parent;
            }
            if(root.val == y) {
                depth_y = level;
                par_y = parent;
            }
            getDepth(root.left, x, y, root, level+1);
            getDepth(root.right, x, y, root, level+1);
        }
    }
}