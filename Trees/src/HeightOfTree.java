
public class HeightOfTree {
	
	public static int height(Node root) {
		if(root == null)	return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	
	public static void main(String args[]) {
		
		Node root = Node.createTree();
		System.out.println(height(root));	
	}
}
