
public class LowestCommonAncestor {
	public static void main(String args[]) {
		Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int n1 = 10, n2 = 14;
        Node t = findLCA(root, n1, n2);  // 12
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
 
        n1 = 14;
        n2 = 8;
        t = findLCA(root, n1, n2);		// 8
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
 
        n1 = 10;
        n2 = 22;	
        t = findLCA(root, n1, n2);		// 20
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	}

	/*
	 * Below function assumes that both nodes are present in the tree. 
	 * Done for BST
	 */
	private static Node findLCA(Node root, int n1, int n2) {
		if(root == null)	return null;
		
		if(root.data > n1 && root.data > n2)
			return findLCA(root.left, n1, n2);
		else if(root.data < n1 && root.data < n2)
			return findLCA(root.right, n1, n2);
		return root;
	}

	// Done for Binary Tree
	// U can also store paths to both nodes from root.
	// OR 
	// Store parent-child in hashmap till both nodes are added.
	// Then add all ancestors of p to a set
	// Now process all ancestors of q to see if there is a match in the set.
	// If yes, u have found the LCA 
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        return (left == null) ? right : left;
    }
}
