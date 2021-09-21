/*
Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are 
as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

 */

public class IsCompleteTree {
	public static boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode>q = new LinkedList();
        q.add(root);
        q.add(null);
        int level = 1;
        while(q.size() > 1) {
            int cnt = level;
            while(q.peek() != null) {
                TreeNode temp = q.poll();
                q.add(temp.left);
                q.add(temp.right);
                cnt--;
            }
            q.poll();
            if(cnt > 0) {
                if(containsNull(q))
                    return true;
                else
                    return false;                    
            }
            q.add(null);
            level *= 2;
        }
        return false;
    }
    
    public static boolean containsNull(Queue<TreeNode>q) {
        for(TreeNode root : q) {
            if(root != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	
    }
}