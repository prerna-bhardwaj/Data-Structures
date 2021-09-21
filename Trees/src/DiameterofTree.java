import java.util.HashMap;

/*
 * The diameter of a tree is the number of nodes on the longest path between two end 
 * nodes in the tree. 
 * Naive - O(n^2), SC = O(1)
 * Efficient - Store ht of all nodes in Hashmap <Node, int> and fetch in O(1)
 * 			- TC = O(n)
 * 			- SC = O(n)
 */

public class DiameterofTree {
	static HashMap<Node, Integer>hm = new HashMap<>();
	
	// TC - O(n)
	public static int saveHeight(Node root) {
		if(root == null)	return 0;
		int ht = 1 + Math.max(saveHeight(root.left), saveHeight(root.right));
		hm.put(root, ht);
		return ht;
	}
	
	// TC - O(n) | O(n) space
	public static int diameterEfficient(Node root) {
		if(root == null)	return 0;
		int sum = 0;
		if(hm.containsKey(root.left))
			sum += hm.get(root.left);
		if(hm.containsKey(root.right))
			sum += hm.get(root.right);
		int curr = 1 + sum;
		return Math.max(curr, Math.max(diameterEfficient(root.left),
										diameterEfficient(root.right)));
	}
	
	// TC - O(n^2)
	public static int diameter(Node root) {
		if(root == null)	return 0;
		int curr = 1 + height(root.left) + height(root.right);
		return Math.max(curr,  Math.max(diameter(root.left), diameter(root.right)));
	}
	
	public static int height(Node root) {
		if(root == null)	return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	

	// O(n) time | O(1) space
	// Diameter = left path length + right path length
	static int max = 0;
    public static  int diameterOfBinaryTree(Node root) {
        max = 0;
        solve(root);
        return max;
    }
    
    public static  int solve(Node root){
        if(root == null)
            return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }

	public static void main(String args[]) {
		
		Node root = Node.createTree();
		System.out.println("Diameter : " + diameter(root));	
		saveHeight(root);
		System.out.println("Diameter Efficient : " + diameterEfficient(root));	
		System.out.println("Diameter Optimal  : " + diameterOfBinaryTree(root));	
	}
}
