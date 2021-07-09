
public class TreeIsomorphism {
	
	public static void main(String[] args) {
//		Node root1 = Node.createTree();
		Node root1 = new Node(19);
		Node root2 = Node.createTree();
		
		System.out.println("Trees are isomorphic : " + isIsomorphic(root1, root2));
	}

	private static boolean isIsomorphic(Node root1, Node root2) {
		// When both are null
		if(root1 == null && root2 == null)	return true;
		// When any (and only) 1 of them is null
		if(root1 == null || root2 == null)	return false;
		if(root1.data != root2.data )	return false;
		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right))
				|| (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
	}
	
	
}
