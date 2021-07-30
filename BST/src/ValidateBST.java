
public class ValidateBST {

	static class Node{
		Integer value;
		Node left, right;
		
		Node() {
			value = null;
			left = right = null;
		}
		
		Node(int value) {
			this.value = value;
			left = right = null;
		}
	}
	
	public static Node insert(Node root, int value) {
		if(root == null)
			return new Node(value);
		Node curr = root, parent = root;
		while(curr != null) {
			parent = curr;
			if(curr.value > value)
				curr = curr.left;
			else
				curr = curr.right;
		}
		if(parent.value > value)
			parent.left = new Node(value);
		else
			parent.right = new Node(value);
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
	
	/*
	 * null is passed, bcz there might a node with value = to Int.max or min_value
	 * Use Integer instead of int as the data type for min and max params as it can have null value
	 * as opposed to int.
	 * 
	 * TC - O(n) - since every node is processed once
	 * SC - O(h), req for call stack 
	 */
	public static boolean isValid(Node root, Integer min, Integer max) {
		if(root == null)
			return true;
		// min <= root < max
		if(min != null && root.value < min)
			return false;
		if(max != null && root.value >= max)
			return false;
		return isValid(root.left, min, root.value) && isValid(root.right, root.value, max);		
	}
  	
	public static void main(String[] args) {
		Node root = new Node(5);

		// False
//		root.left = new Node(4);
//		root.right = new Node(6);
//		root.right.left = new Node(3);
//		root.right.right = new Node(7);
		
		// False
//		root.left = new Node(20);
//		root.right = new Node(30);
		
		// True
		root = insert(root, 5);
		root = insert(root, 5);
		root = insert(root, 2);
		root = insert(root, 1);
		root = insert(root, 15);
		root = insert(root, 13);
		root = insert(root, 14);
		root = insert(root, 22);

		System.out.println("Tree created");
		inOrder(root);
		System.out.println("\n\nIs Valid BST : " + isValid(root, null, null));
	}
}
