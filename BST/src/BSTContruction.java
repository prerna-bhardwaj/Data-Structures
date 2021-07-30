/*
 * Average : O(log(N)) time | O(log(N)) space - space is required for the call stack
 * Worst   : O(N) time | O(N) space - required for recursive call stack
 * 
 * Space = O(1) in both average and worst case for iterative solutions.
 */

public class BSTContruction {
	
	static class Node {
		int value;
		Node left, right;
		
		Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}
	
	private static Node insertNode(Node root, int value) {
		if(root == null)
			return new Node(value);
		if(value < root.value)
			root.left = insertNode(root.left, value);
		else
			root.right = insertNode(root.right, value);
		return root;
	}
	
	// Average : O(logN) time | O(1) space
	// Worst : O(N) time | O(1) space
	private static Node insertIterative(Node root, int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		Node curr = root;
		while(true) {
			if(value < curr.value) {
				if(curr.left == null) {
					curr.left = new Node(value);
					break;
				}
				else 
					curr = curr.left;
			}
			else {
				if(curr.right == null) {
					curr.right = new Node(value);
					break;
				}
				else
					curr = curr.right;
			}
		}
		return root;
	}
	
	// Average : O(logN) time | O(logN) space
	// Worst : O(N) time | O(N) space
	private static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
	
	// Average : O(logN) time | O(logN) space
	// Worst : O(N) time | O(N) space
	private static boolean contains(Node root, int target) {
		if(root ==  null)
			return false;
		return (root.value == target) || (contains(root.left, target)) || (contains(root.right, target));
	}
	
	// Average : O(logN) time | O(1) space
	// Worst : O(N) time | O(1) space
	private static boolean containsIterative(Node root, int target) {
		Node curr = root;
		while(curr != null) {
			if(target < curr.value)
				curr = curr.left;
			else if(target > curr.value)
				curr = curr.right;
			else 
				return true;
		}
		return false;
	}
	
	// Average : O(logN) time | O(logN) space
	// Worst : O(N) time | O(N) space
	private static Node removeRecursive(Node root, int value) {
		if(root == null)
			return root;
		System.out.println("todo:" + root.value);
		if(root.value > value)
			root.left = removeRecursive(root.left, value);
		else if(root.value < value)
			root.right = removeRecursive(root.right, value);
		// Node to be deleted has been found
		else {
			// Node has only right child/no child
			if(root.left == null)
				return root.right;
			// Node has only left child
			else if(root.right == null)
				return root.left;

			// Node to be deleted has 2 non-null children.
			// Replace it with the min value from its right subtree
			root.value = getMinValue(root.right);
			// Recursively delete the min val from right 
			// NOTE : root.right = rec call and not root.
			root.right = removeRecursive(root.right, root.value);
		}
		return root;
	}
	
	private static int getMinValue(Node root) {
		Node curr = root;
		while(curr.left != null) 
			curr = curr.left;
		return curr.value;
	}
	
	public static void main(String[] args) {
		Node root = null;
//		
//		root = insertIterative(root, 3);
//		System.out.println();
//		inOrder(root);
//		
//		root = insertIterative(root, 30);
//		System.out.println();
//		inOrder(root);
//			
//		root = insertIterative(root, 0);
//		System.out.println();
//		inOrder(root);
//		
//		root = insertIterative(root, 2);
//		System.out.println();
//		inOrder(root);
//
//		root = insertIterative(root, 10);
//		System.out.println();
//		inOrder(root);
		
		root = insertIterative(root, 5);
		root = insertIterative(root, 3);
		root = insertIterative(root, 2);
		root = insertIterative(root, 4);
		root = insertIterative(root, 6);
		root = insertIterative(root, 7);
		
//		System.out.println("\nSearching for 10 : " + contains(root, 10));
//		System.out.println("\nSearching for 11 : " + containsIterative(root, 11));
		
		root = removeRecursive(root, 3);
		System.out.println();
		inOrder(root);
	}
}
