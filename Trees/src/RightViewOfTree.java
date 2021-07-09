/*
 * We can keep track of level of a node by passing a parameter to all recursive calls. 
 * The idea is to keep track of maximum level also. Whenever we see a node whose level is more than 
 * maximum level so far, we store the node in a list because this is the first node in its level 
 * NOTE : we traverse the RIGHT subtree before LEFT subtree.
 */

import java.util.ArrayList;

public class RightViewOfTree {

	static ArrayList<Integer>ar = new ArrayList<>();
    static int max = 0;
	
    // O(n)
	static void rightViewRecursive(Node root, int level) {
        if(root == null)    return ;
        if(level > max) {
            max = level;
            ar.add(root.data);
        }
        // Following step differs from left view
        rightViewRecursive(root.right, level+1);
        rightViewRecursive(root.left, level+1);
    }
	
	static ArrayList<Integer> rightView(Node root)
    {
		rightViewRecursive(root, 1);
        return ar;
    }
	
	public static void main(String args[]) {
		Node root = Node.createTree();
		System.out.println(rightView(root));
	}
}
