import java.util.ArrayList;

public class CloneAGraph {
	static class Node {
		int val;
		ArrayList<Node> neighbors;
		
		public Node() {
			this.val = 0;
			this.neighbors = new ArrayList<>();
		}
		
		public Node(int val){
			this.val = val;
			this.neighbors = new ArrayList<>();
		}
		
		public Node(int val, ArrayList<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}

		@Override
		public String toString() {
			return val + " - " + neighbors;
		}
		
		
	}
	
	public Node buildGraph() {
		 /*
	        Note : All the edges are Undirected
	        Given Graph:
	        1--2
	        |  |
	        4--3
	    */
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		ArrayList<Node> a = new ArrayList<Node>();
	    a.add(node2);
	    a.add(node4);
	    node1.neighbors = a;
	    a = new ArrayList<Node>();
	    a.add(node1);
	    a.add(node3);
	    node2.neighbors = a;
	    a = new ArrayList<Node>();
	    a.add(node2);
	    a.add(node4);
	    node3.neighbors = a;
	    a = new ArrayList<Node>();
	    a.add(node3);
	    a.add(node1);
	    node4.neighbors = a;

	    return node1;

	}
	
	public static void main(String args[]) {
		CloneAGraph obj = new CloneAGraph();
		Node first = obj.buildGraph();
//		Node result = cloneGraph(first);
		
	}
	
}
