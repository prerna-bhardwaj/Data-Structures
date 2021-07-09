
public class CountLeavesInTree {

	static int cnt = 0;
    static int countLeaves(Node node) 
    {
         if(node == null)   return cnt;
         if(node.left == null && node.right == null)    cnt += 1;
         countLeaves(node.left);
         countLeaves(node.right);
         return cnt;
    }
    
    public static void main(String[] args) {
    	Node root = Node.createTree();
    	System.out.println("# Leaves : " + countLeaves(root));
    }
}
