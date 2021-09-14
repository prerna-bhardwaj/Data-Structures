/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 

BFS Solution : O(n) time | O(m) space.  m = max number of nodes on a level
*/	

public class AverageOfLevels {

	static List<List<Integer>>level;
    
    // Depth first solution
    // O(n) time | O(h) space - h = ht of tree
    public static  List<Double> averageOfLevels(TreeNode root) {
        level = new ArrayList<List<Integer>>();
        List<Double>ans = new ArrayList();
        solve(root, 0);
        for(List<Integer> ar : level) {
            double sum = 0;
            for(int num : ar)
                sum += (double)num;
            ans.add(sum / (double)ar.size());
        }
        return ans;
    }
    
    public static  void solve(TreeNode root, int ht) {
        if(root != null) {
            if(level.size() < ht+1) {
                level.add(new ArrayList<Integer>());                
            }
            level.get(ht).add(root.val);
            solve(root.left, ht + 1);
            solve(root.right, ht + 1);
        }
    }

    public static void main(String[] args) {
    	
    }
}
/*
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
*/