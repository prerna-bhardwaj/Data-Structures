/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has 
exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. 
More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.
*/


public class SecondMinimumNode {

	static int first = -1;
    
    static long second = Long.MAX_VALUE;
    
    public static int findSecondMinimumValue(TreeNode root) {
        first = root.val;
        findMin(root);
        return second < Long.MAX_VALUE ? (int)second : -1;
    }
    
    public static void findMin(TreeNode root) {
        if(root != null) {
            if(first < root.val && root.val < second) {
                second = root.val;
            }
            else if(root.val == first) {
                findMin(root.left);
                findMin(root.right);
            }
        }
    }

    public static void main(String[] args) {
    	
    }
}

/*
Brute Force : 

Traverse the tree with a depth-first search, and record every unique value in the tree using a Set structure uniques.

Then, we'll look through the recorded values for the second minimum. The first minimum must be root.val.
Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node exactly once, and scan 
through the O(N) values in unique once.

Space Complexity: O(N), the information stored in uniques.


Optimal : 

Let min1 = root.val. When traversing the tree at some node, node, 
if node.val > min1, we know all values in the subtree at node are at least node.val, 
so there cannot be a better candidate for the second minimum in this subtree. Thus, we do not need to search this subtree.

Also, as we only care about the second minimum ans, we do not need to record any values that are larger than our current candidate 
for the second minimum, so unlike Approach #1 we can skip maintaining a Set of values(uniques) entirely.

Complexity Analysis

Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node at most once.

Space Complexity: O(N) The information stored in ans and min1 is O(1), but our depth-first search may store up to 
O(h) = O(N) information in the call stack, where hh is the height of the tree.

*/