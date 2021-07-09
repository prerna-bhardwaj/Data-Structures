import java.util.ArrayList;

public class TopViewOfTree {
	static ArrayList<Integer>ar = new ArrayList<>();
	
    // O(n)
	static void leftSide(Node root) {
        if(root == null)    return ;
        leftSide(root.left);
        ar.add(root.data);
    }

    // O(n)
    static void rightSide(Node root) {
        if(root == null)    return ;
        rightSide(root.right);
        ar.add(root.data);
    }
	
	static ArrayList<Integer> topView(Node root)
    {
		if(root == null)    return ar;
        leftSide(root.left);
        ar.add(root.data);
        rightSide(root.right);
        return ar;
    }
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println(topView(root));
	}
}
