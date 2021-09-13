/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
*/

import java.util.*;

public class BinaryTreePaths {
	
	static List<String> res;
    
    public static List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        findPaths(root, new StringBuffer().append(root.val));
        return res;
    }
    
    public static void findPaths(TreeNode root, StringBuffer path) {
        if(root.left == null && root.right == null) {
            res.add(path.toString());
            return;
        }
        if(root.left != null) {
            findPaths(root.left,new StringBuffer(path).append("->").append(root.left.val));
        }
        if(root.right != null) {
            findPaths(root.right,new StringBuffer(path).append("->").append(root.right.val));
        }
    }

    public static void main(String[] args) {
    	
    }
}