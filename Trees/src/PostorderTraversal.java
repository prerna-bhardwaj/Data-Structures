import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
	static ArrayList<Integer> ar = new ArrayList<>();
    // O(n)
	static ArrayList<Integer> postorderRecursive(Node root) {
        if(root == null)    return ar;
        
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        ar.add(root.data);
        return ar;
	}
	
	static ArrayList<Integer> postorderIterative(Node root) {
		ArrayList<Integer> ar = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		Node curr = root;
		
		while(!st.isEmpty() || curr != null) {
			if(curr != null) {
				st.push(curr);
				if(curr.right != null)	 st.push(curr.right);
				curr = curr.left;
			}
			else {
				curr = st.pop();
				ar.add(curr.data);
//				curr = curr.left;
			}
		}
		return ar;
	}

	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println("Recursive : " + postorderRecursive(root));
		System.out.println("Iterative : " + postorderIterative(root));
	}
}
