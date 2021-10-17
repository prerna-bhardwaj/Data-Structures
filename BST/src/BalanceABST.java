/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values. 
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
*/

class BalanceABST {

	static List<TreeNode>list;
    
    // O(n) time | O(n) space
    public static TreeNode balanceBST(TreeNode root) {
        list = new ArrayList();
        // Convert the tree to a sorted array using an in-order traversal.
        inOrder(root);
        // Construct a new balanced tree from the sorted array recursively.
        TreeNode head = createTree(0, list.size()-1);
        return head;
    }
    
    public static void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            list.add(root);
            inOrder(root.right);
        }
    }
    
    public static TreeNode createTree(int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = createTree(start, mid-1);
        root.right = createTree(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
    	
    }
}