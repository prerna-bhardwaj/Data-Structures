import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {

	public static void main(String[] args) {
		Node root = Node.createTree();
		System.out.println(zigzagTraversal(root));
	}

	private static ArrayList<Integer> zigzagTraversal(Node root) {
		ArrayList<Integer>ar = new ArrayList();
		if(root == null)	return ar;
		// Stores the current level
		Stack<Node>curr = new Stack<>();
		// Stores the next level
		Stack<Node>next = new Stack<>();
		
		curr.push(root);
		// Current level traversal is LtoR
		boolean LtoR = true;
		// Check if current level stack is empty
		while(!curr.isEmpty()) {
			// Pop and add the node to result list
			Node node = curr.pop();
			ar.add(node.data);
			
			// If current node is traversed LtoR, then add the elements in the same fashion,
			// so that after popping the next is printed in reverse order i.e. RtoL
			if(LtoR) {
				if(node.left != null)	next.push(node.left);
				if(node.right != null)	next.push(node.right);
			}
			else {
				if(node.right != null)	next.push(node.right);				
				if(node.left != null)	next.push(node.left);
			}
			
			// We are processing 1 node at a time (since only 1 while is being used), 
			// thus, exchange the stacks only when curr level has been completely processed
			// LtoR is also reversed accordingly
			if(curr.isEmpty()) {
				LtoR = !LtoR;
				Stack<Node>temp = curr;
				curr = next;
				next = temp;				
			}
		}
		return ar;
	}
	
	
	
}
