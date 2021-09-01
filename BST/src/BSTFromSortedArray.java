/*
 * Input : Sorted array with all unique values
 */

public class BSTFromSortedArray {
	
	static class Node {
		int value;
		Node left, right;
		
		Node(int value) {
			this.value = value;
			this.left = this.right = null;
		}
	}
	
	public static Node insert(Node root, int value) {
		if(root == null)
			return new Node(value);
		if(value < root.value)
			root.left = insert(root.left, value);
		else if(value > root.value)
			root.right = insert(root.right, value);
		return root;
	}
	
	public static Node minHeightBST(int[] arr) {
		return minHeightHelper(arr, null, 0, arr.length - 1);
	}

	private static Node minHeightHelper(int[] arr, Node root, int start, int end) {
		if(end < start)
			return null;
		int midIndex = start + (end - start) / 2;
		int midValue = arr[midIndex];
		insert(root, midValue);
		return root;
	}
	
	private static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 5, 7, 10, 15, 27, 54};
		Node root = minHeightBST(arr);
	
		inOrder(root);
	}
}
