/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class MaxDepthNaryTree {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	// Method 1
	public static int maxDepth(Node root) {
        if(root == null) 
            return 0;
        if(root.children.isEmpty())
            return 1;
        int max = 0;
        for(Node child : root.children)
            max = Math.max(max, 1 + maxDepth(child));
        return max;
    }

    // Method 2
    int max = 0;
    public int maxDepth2(Node root) {
        solve(root, 1);
        return max;
    }
    
    public void solve(Node root, int level) {
        if(root != null) {
            max = Math.max(max, level);
            for(Node child : root.children)
                solve(child, level+1);
        }
    }

    public static void main(String[] args) {
    	
    }
}