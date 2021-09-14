/*

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different 
nodes in the tree.

*/

import java.util*;

public class MinAbsDiffInBST {

	// Basically, inorder traversal store karo. Since its a BST, inorder traversal will add elements in sorted order itself.
	// No need for any external sort. Now linearly iterate to find the min abs diff.
	static ArrayList<Integer>ar;
    public static int getMinimumDifference(TreeNode root) {
        ar = new ArrayList();
        inOrder(root);
        int diff = 10005;
        for(int i = 1; i < ar.size(); i++)
            diff = Math.min(Math.abs(ar.get(i-1) - ar.get(i)), diff);
        return diff;
    }
    
    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            ar.add(root.val);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
    	
    }
}