/*
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed 
to the original key plus sum of all keys greater than the original key in BST.
*/

public class BSTtoGreaterSumTree {
	int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;
        inOrder(root);
        traversal(root);
        return root;
    }
    
    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            sum += root.val;
            inOrder(root.right);
        }
    }
    
    public static void traversal(TreeNode root) {
        if(root == null)
            return ;
        traversal(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        traversal(root.right);
    }

    public TreeNode convertBSTOptimal(TreeNode root) {
        if(root != null) {
            convertBST(root.right);
            int temp = root.val;
            root.val += sum;
            sum += temp;
            convertBST(root.left);
        }    
        return root;
    }

    public static void main(String[] args) {
    	
    }
}
