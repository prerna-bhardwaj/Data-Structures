/*
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the 
root of the tree, and every node has no left child and only one right child.

Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
*/

public class InOrderSearchTree {
	// O(n) time | O(h) space
	// h - height of tree
	static TreeNode curr;
    public static TreeNode increasingBSTOptimal(TreeNode root) {
        TreeNode head = new TreeNode(0);
        curr = head;
        inOrder(root);
        return head.right;
    }
    
    public void inOrderInPlace(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            root.left = null;
            curr.right = root;
            curr = curr.right;
            inOrder(root.right);
        }
    }

    // O(n) time | O(n) space
	static ArrayList<Integer> res;
    public static TreeNode increasingBST(TreeNode root) {
        res = new ArrayList<Integer>();
        inOrder(root);
        TreeNode head = new TreeNode(0);
        TreeNode temp = head;
        for(int num : res) {
            temp.right = new TreeNode(num);
            temp = temp.right;
        }
        return head.right;
    }
    
    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
    	
    }
}