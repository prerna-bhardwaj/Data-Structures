/*
Given the root of a binary tree, construct a string consists of parenthesis and integers from a binary tree with the 
preorder traversing way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original 
binary tree.

Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)"

Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the 
one-to-one mapping relationship between the input and the output.
*/

public class ConstructStringFromBinaryTree {
	
	public static String tree2str(TreeNode root) {
        String ans = treeToString(root, new StringBuffer());
        return ans.substring(1, ans.length()-1);
    }
    
    public static String treeToString(TreeNode root, StringBuffer sb) {
        if(root != null) {
            sb.append('(').append(root.val);
            // Check is current node is a leaf node
            if(root.left != null || root.right != null) {
            	// If its left child is absent, then it means that right child def exists. Thus add '()' to maintain 1-1 relationship.
                if(root.left == null)
                    sb.append("()");
                else
                    treeToString(root.left, sb);
                // Process the right child anyway.
                treeToString(root.right, sb);    
            }
            sb.append(')');
            return sb.toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	
    }
}

/*
[-1,-2,null,-3,null,-4]
