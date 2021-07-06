
public class isSumTree {

	public static boolean isSumTree(Node root) {
		if(root == null)	return true;
		// Check for leaf node condition
		if(root.left == null && root.right == null)		return true;
		// You can also use a single sum var instead of left and right
		int left = 0, right = 0;
		if(root.left != null)
			left = getSum(root.left);
		if(root.right != null)
			right = getSum(root.right);
		return root.data == left + right && isSumTree(root.left) && isSumTree(root.right);
	}
	
	static int getSum(Node root) {
		if(root == null)	return 0;
		return root.data + getSum(root.left) + getSum(root.right);
	}
	
	public static void main(String[] args) {
//		Node root = Node.createTree();
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(4);
		System.out.println(isSumTree(root));
	}
	
}
