import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumOfNodeDepths {

	static class Level {
		Node root;
		int depth;
		
		Level(Node root, int depth) {
			this.root = root;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Level [root=" + root.data + ", depth=" + depth + "]";
		}	
	}
	
	// O(n) time | O(h) space   where h = ht of BT
	// Processes nodes in level order fashion
	private static int nodeDepthsIterativeQueue(Node root) {
		Queue<Level>q = new LinkedList<>();
		int result = 0;
		q.add(new Level(root, 0));
		while(!q.isEmpty()) {
			Level curr = q.poll();
			if(curr.root == null)
				continue;
			result += curr.depth;
			System.out.println(curr.toString());
			q.add(new Level(curr.root.left, curr.depth + 1));
			q.add(new Level(curr.root.right, curr.depth + 1));
		}
		return result;
	}
	
	// O(n) time | O(h) space   where h = ht of BT
	// Processes nodes in inorder fashion (only when u push right child before the left).
	private static int nodeDepthsIterativeStack(Node root) {
		Stack<Level>st = new Stack<>();
		st.add(new Level(root, 0));
		int result = 0;
		while(!st.isEmpty()) {
			Level curr = st.pop();
			if(curr.root == null)
				continue;
			System.out.println(curr.toString());
			result += curr.depth;
			// Push right before left to process the nodes in inorder fashion.
			st.push(new Level(curr.root.right, curr.depth+1));
			st.push(new Level(curr.root.left, curr.depth+1));
		}
		return result;
	}
	
	// O(n) time | O(h) space   where h = ht of BT
	private static int calculateNodeDepths(Node root, int depth) {
		if(root == null)
			return 0;
//		System.out.println(root.data);
		return depth + calculateNodeDepths(root.left, depth + 1) + calculateNodeDepths(root.right, depth + 1); 
	}

	public static void main(String[] args) {
		Node root = Node.createTree();
		System.out.println("Recursive function : " + calculateNodeDepths(root, 0) + "\n");
		System.out.println("Iterative with Queue : " +  nodeDepthsIterativeQueue(root) + "\n");
		System.out.println("Iterative with Stack : " + nodeDepthsIterativeStack(root) + "\n");
	}

}
