import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
	static ArrayList<Integer> ar = new ArrayList<>();
    // O(n)
	static ArrayList<Integer> preorderRecursive(Node root) {
        if(root == null)    return ar;
        
        ar.add(root.data);
        preorderRecursive(root.left);
        preorderRecursive(root.right);
        return ar;
	}
	
	static ArrayList<Integer> preorderIterative(Node root)
    {
		ArrayList<Integer> ar = new ArrayList<>();
		// create an empty stack
		Stack<Node> st = new Stack<>();
		// Start from root node
		Node curr = root;
		
		// if curr node is null or stack is empty, we are done
		while(!st.isEmpty() || curr != null) {
			/*
			 *  if curr node exists, process it, push it into the stack and move to its left child
			 *  Curr is pushed into stack for easy retrieval of its right child after complete processing 
			 *  of left subtree.
			 */
			if(curr != null) {
				ar.add(curr.data);
				st.push(curr);
				curr = curr.left;
			}	
			// Pop node from stack and move to its right subtree
			else {
				curr = st.pop();
				curr = curr.right;
			}
		}	
		return ar;
    }
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println("Recursive : " + preorderRecursive(root));
		System.out.println("Iterative : " + preorderIterative(root));
	}

}
