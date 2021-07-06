import java.util.*;

public class ReverseLevelOrderTraversal {

	public static void reverseLevelOrderNaive(Node root){
        int ht = height(root);
        for(int i = ht; i >= 1; i--)
        	printKthLevel(root, i);
    }

	// Root is at level 1
    public static void printKthLevel(Node root, int k) {
    	if(root == null)	return;
        if(k == 1)   System.out.print(root.data + " ");
        printKthLevel(root.left, k - 1);
        printKthLevel(root.right, k - 1);        
    }

    public static int height(Node root) {
        if(root == null)    return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
	
	/*
	 * TC - O(n) , where n = # nodes in BT
	 * Diff from normal level order traversal in foll ways :
	 * 1. Push nodes in stack instead of printing them
	 * 2. Process right child before left child, since stack is being used
	 */
	public static ArrayList<Integer> reverseLevelOrderEfficient(Node root) {
		ArrayList<Integer>ar = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		Stack<Node> st = new Stack<>();
		
		q.add(root);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			st.push(curr);
			
            // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
			if(curr.right != null)	q.add(curr.right);
			if(curr.left != null)	q.add(curr.left);
		}
		while(!st.isEmpty())
			ar.add(st.pop().data);
		return ar;
	}
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		reverseLevelOrderNaive(root);
		System.out.println();
		ArrayList<Integer> ar = reverseLevelOrderEfficient(root);
		System.out.println(ar);
	}
}	
