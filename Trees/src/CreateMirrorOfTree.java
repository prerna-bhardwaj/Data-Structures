
public class CreateMirrorOfTree {
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		Node newRoot = createMirror(root);
		inorder(root);
		System.out.println();
		inorder(newRoot);
		createMirrorEfficient(root);
		System.out.println();
		inorder(root);
	}

	/*
	 * Traverse the tree in pre/post order fashion. For every node, swap its left and right child
	 * Recursively mirror the left and right subtrees
	 * TC - O(n)
	 * SC - O(h)
	 */
	private static void createMirrorEfficient(Node root) {
		if(root == null)	return;
		swapSubTrees(root);
		createMirrorEfficient(root.left);
		createMirrorEfficient(root.right);
	}

	private static void swapSubTrees(Node root) {
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	// TC - O(n)
	// SC - O(n+h) ~ O(n)
	private static Node createMirror(Node root) {
		if(root == null)	return null;
		Node curr = new Node(root.data);
		curr.left = createMirror(root.right);
		curr.right = createMirror(root.left);
		return curr;
	}


	private static void inorder(Node root) {
		if(root == null)	return ;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
