
public class HeightOfTree {
	
	public static int height(Node root) {
		if(root == null)	return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	// get depth of given node int a Binary Tree
	public int getDepth(TreeNode root, int val) {
        if(root == null)
            return 0;
        if(root.val == val)
            return 1;
        int left = getDepth(root.left, val);
        int right = getDepth(root.right, val);
        // If node exists in left OR right subtree, then return height
        if(left > 0 || right > 0)
            return 1 + Math.max(left, right);
        // Else return 0, since node is node found
        return 0;
    }
	
	
	public static void main(String args[]) {
		
		Node root = Node.createTree();
		System.out.println(height(root));	
	}
}
