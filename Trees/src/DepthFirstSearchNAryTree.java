import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearchNAryTree {

	static class Node {
		String name;
		List<Node>children;
		
		Node(String name) {
			this.name = name;
			children = new LinkedList<>();
		}
		
		public void addChild(Node child) {
			this.children.add(child);
		}
	}
	
	private static ArrayList<String> dfs(Node root, ArrayList<String> ar) {
		// Add current node to array
		ar.add(root.name);
		// Traverse all adjacent nodes of current node
		for(Node child : root.children) {
			dfs(child, ar);
		}
		return ar;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		Node k = new Node("K");
	
		root.addChild(b);
		root.addChild(c);
		root.addChild(d);
		b.addChild(e);
		b.addChild(f);
		d.addChild(g);
		d.addChild(h);
		f.addChild(i);
		f.addChild(j);
		g.addChild(k);
		
		ArrayList<String>ar = new ArrayList<>();
		System.out.println(dfs(root, ar));
	}
}
