/*
In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while 
in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.

Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

 */

import java.util.*;

class PathInZigZagTree{
	
	// O(logn) time | O(logn) space - for answer
	public static List<Integer> pathInZigZagTree(int label) {
        List<Integer>ans = new ArrayList();
        int pow = 1;
        while(pow <= label) 
            pow *= 2;
        pow /= 2;
        while(label != 1) {
            ans.add(0, label);
            int diff = (label-pow)/2 + 1;
            label = pow - diff;
            pow /= 2;
        }
        ans.add(0, 1);
        return ans;
    }

    public static void main(String[] args) {
    	System.out.println(pathInZigZagTree(260));
    }
}