import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a Binary Tree, check if all leaves are at same level or not.
 */

public class LeafNodesOnSameLevel {

	
	
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println("Leaves on same level : " + check(root));
	}

	private static boolean check(Node root) {
		if(root == null)	return true;
		// Assuming that root node is on level 1
		int max = -1, currLevel = 1;
		Queue<Node>q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) { 
			int size = q.size();
			for(int i =0 ; i < size; i++) {
				Node curr = q.poll();
//		        System.out.println(curr.data + " " + isLeaf(curr) + " " + currLevel + " " + max);

				if(isLeaf(curr)) {
					if(max == -1)	max = currLevel;
					else if(max != currLevel)	return false;
				}
				else {
					if(curr.left != null)	q.add(curr.left);
					if(curr.right != null)	q.add(curr.right);
				}
			}
			currLevel++;
		}
		return true;
	}

	private static boolean isLeaf(Node curr) {
		return curr.left == null && curr.right == null;
	}
	
	
}
