import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
	static ArrayList<Integer> ar = new ArrayList<>();
    // O(n)
	static ArrayList<Integer> inorderRecursive(Node root) {
        if(root == null)    return ar;
        
        inorderRecursive(root.left);
        ar.add(root.data);
        inorderRecursive(root.right);
        return ar;
	}
	
	static ArrayList<Integer> inorderIterative(Node root)
    {
		ArrayList<Integer> ar = new ArrayList<>();
		// create an empty stack
		Stack<Node> st = new Stack<>();
		// Start from root node
		Node curr = root;
		
		// if curr node is null or stack is empty, we are done
		while(!st.isEmpty() || curr != null) {
			// if curr node exists, push it into the stack and move to its left child
			if(curr != null) {
				st.push(curr);
				curr = curr.left;
			}	
			// Pop node from stack and add it to result array / print it. 
			// Move to its right subtree
			else {
				curr = st.pop();
				ar.add(curr.data);
				curr = curr.right;
			}
		}	
		return ar;
    }
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println("Recursive : " + inorderRecursive(root));
		System.out.println("Iterative : " + inorderIterative(root));
	}
}
