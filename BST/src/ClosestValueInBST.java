
public class ClosestValueInBST {
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	// Minimize abs value of currNode.data - target - return corresponding currNode.data
	// Avg - O(log(N)) time | O(1) space
	// Worst - O(n) time | O(1) space		- skewed tree
	private static int findClosestValueIterative(int target, Node root) {
		int value = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
		Node curr = root;
		while(curr != null) {
			int temp = Math.abs(curr.data - target);
			if(temp < diff)	{
				value = curr.data;
				diff = temp;
			}
			if(curr.data == target)
				break;
			else if(curr.data > target)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return value;
	}
	
	// Avg - O(log(N)) time | O(log(N)) space
	// Worst - O(n) time | O(n) space		- skewed tree
	// O(d) memory for recursive solution, where d is depth of tree
	private static int findClosestValueRecursive(int target, Node root) {
//		int value =
		return findClosestValueHelper(target, root, Integer.MAX_VALUE);
	}
	
	private static int findClosestValueHelper(int target, Node currNode, int closest) {
		if(currNode == null)
			return closest;
		if(Math.abs(target - closest) > Math.abs(target-currNode.data))
			closest = currNode.data;
		if(target > currNode.data)
			return findClosestValueHelper(target, currNode.right, closest);
		else if(target < currNode.data)
			return findClosestValueHelper(target, currNode.left, closest);
		return closest;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		/*
		 		10
		      /   \
		     /     \
		   	5       15
		   /\      /  \
		  /  \    /    \
		 2    5  13     22
		/ 		  \
	   /           \
      1            14
		 */
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.right.left = new Node(13);
		root.right.right = new Node(22);
		root.left.left.left = new Node(1);
		root.right.left.right = new Node(14);	
		
		System.out.println(findClosestValueIterative(11, root));
		System.out.println(findClosestValueRecursive(15, root));
	}
}
