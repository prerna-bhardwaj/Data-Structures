import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Level order traversal can also be done by for loop (asc one), and use printKthLevel nodes
 */
public class LevelOrderTraversal {
	public static void levelOrder(Node root) 
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0;i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null)   q.add(curr.left);
                if(curr.right != null)  q.add(curr.right);
            }
            System.out.println();
        }
    }
	
	private static ArrayList<Integer> levelOrderOneLoop(Node root) {
		ArrayList<Integer> ar = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(q.size() > 1) {
			Node curr = q.poll();
			// reached end of a level
			if(curr == null) {
				q.add(null);
				continue;
			}
			ar.add(curr.data);
			if(curr.left != null)	q.add(curr.left);
			if(curr.right != null)	q.add(curr.right);
		}
		return ar;
	}
	
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		levelOrder(root);
	
		ArrayList<Integer> ar = levelOrderOneLoop(root);
		System.out.println(ar);		
	}
	
}

// Queue operations : add, poll, peek, size, isEmpty