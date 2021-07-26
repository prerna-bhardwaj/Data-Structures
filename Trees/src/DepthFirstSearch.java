import java.util.ArrayList;

public class DepthFirstSearch {
	public static void main(String[] args) {
		Node root = Node.createTree();
		ArrayList<Integer>ar = new ArrayList<>();
		dfs(root, ar);
		System.out.println(ar);
	}

	// O(V) time | O(V) space(worst case)
	private static void dfs(Node root, ArrayList<Integer>ar) {
		if(root == null)
			return;
		ar.add(root.data);
		dfs(root.left, ar);		
		dfs(root.right, ar);
	}
}
